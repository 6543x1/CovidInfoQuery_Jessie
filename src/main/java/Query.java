import com.alibaba.fastjson.JSONObject;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Query
{
    private String JDBC_URL = "jdbc:mysql://localhost:3306/covid?useSSL=false&characterEncoding=utf8";
    private String JDBC_USER = "qcovid";//不要随便给root权限，小心删库跑路
    private String JDBC_PASSWORD = "123456";
    private Connection conn;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss+00");

    public Query()
    {
        try
        {
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (SQLException throwable)
        {
            throwable.printStackTrace();
        }
    }

    public void insertCountry(String name, int confirmed, int recovered, int deaths)
    {
        try
        {
            try (PreparedStatement ps = conn.prepareStatement(
                    "REPLACE INTO countries (name, confirmed, recovered,deaths,updated) VALUES (?,?,?,?,?)"))
            {

                ps.setObject(1, name);
                ps.setObject(2, confirmed);
                ps.setObject(3, recovered);
                ps.setObject(4, deaths);
                ps.setObject(5, LocalDateTime.now());
                ps.executeUpdate();
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void insertAreas(JSONObject json)
    {
        String country = "Unknown";
        //(返回数据中，只有all里面有country（避免冗余）
        //（返回数据中，如果一个国家只有All没有具体地区情况，那么updated会在all中
        //但是由于要求只有4个国家，所以这个bug就懒得修复了
        for (Map.Entry<String, Object> entry : json.entrySet())
        {
            if (entry.getKey().equals("All"))
            {
                country = ((JSONObject) entry.getValue()).getString("country");
                continue;
            }
            int confirmed = ((JSONObject) entry.getValue()).getInteger("confirmed");
            int recovered = ((JSONObject) entry.getValue()).getInteger("recovered");
            int deaths = ((JSONObject) entry.getValue()).getInteger("deaths");
            String tempDate = ((JSONObject) entry.getValue()).getString("updated");
            LocalDateTime date = LocalDateTime.parse(tempDate, formatter);
            try
            {
                PreparedStatement ps = conn.prepareStatement(
                        "REPLACE INTO areas(name,country,confirmed,recovered,deaths,updated) VALUES (?,?,?,?,?,?)");
                {
                    ps.setObject(1, entry.getKey()); // 注意：索引从1开始
                    ps.setObject(2, country);
                    ps.setObject(3, confirmed);
                    ps.setObject(4, recovered);
                    ps.setObject(5, deaths);
                    ps.setObject(6, date);
                    ps.executeUpdate();
                }
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void PrintAllNation()
    {
        try
        {
            try (PreparedStatement ps = conn.prepareStatement("SELECT name, confirmed, recovered, deaths ,updated FROM countries"))
            {
                try (ResultSet rs = ps.executeQuery())
                {
                    while (rs.next())
                    {
                        System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " " + rs.getObject(5));
                    }
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void PrintAllAreas(String co)
    {
        try
        {
            try (PreparedStatement ps = conn.prepareStatement("SELECT name, confirmed, recovered, deaths, updated FROM areas WHERE country=?"))
            {
                ps.setObject(1, co);
                try (ResultSet rs = ps.executeQuery())
                {
                    while (rs.next())
                    {
                        System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " " + rs.getObject(5));
                    }
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void PrintAnArea(String na)
    {
        try
        {
            try (PreparedStatement ps = conn.prepareStatement("SELECT name, confirmed, recovered, deaths ,updated FROM areas WHERE name=?"))
            {
                ps.setObject(1, na);
                try (ResultSet rs = ps.executeQuery())
                {
                    while (rs.next())
                    {
                        System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " " + rs.getObject(5));
                    }
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void PrintANation(String name)
    {
        try
        {
            try (PreparedStatement ps = conn.prepareStatement("SELECT name, confirmed, recovered, deaths, updated FROM countries WHERE name=?"))
            {
                ps.setObject(1, name);
                try (ResultSet rs = ps.executeQuery())
                {
                    if (rs.next())
                    {
                        System.out.println(rs.getString(1) + " " + rs.getInt(2) + " " + rs.getInt(3) + " " + rs.getInt(4) + " " + rs.getObject(5));
                    } else
                    {
                        System.out.println("ERROR:NOT EXISTED.");
                    }
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public void CloseConn()
    {
        try
        {
            conn.close();
        } catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
    }
}


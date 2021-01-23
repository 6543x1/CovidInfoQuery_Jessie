import com.alibaba.fastjson.JSONObject;

import java.util.InputMismatchException;
import java.util.Scanner;


public class CovidQuery
{
    public static void main(String[] args)
    {
        String q_URL = "https://covid-api.mmediagroup.fr/v1/cases?country=";
        String[] nations = {"China", "US", "United%20Kingdom", "Japan"};
        String[] names = {"China", "US", "United Kingdom", "Japan"};

        Scanner in = new Scanner(System.in);
        System.out.println("欢迎访问，目前有");
        for (String x : names)
        {
            System.out.print(x + " ");
        }
        System.out.println("几个国家");
        System.out.println("输入1以更新全部数据");
        System.out.println("输入2查询国家数据，请跟上国家名字，若名字=All为全部国家");
        System.out.println("输入3查询地区数据，请跟上国家和地区名字，若地区名字=All为全部地区");
        System.out.println("输入4退出程序");

        Query myQuery = new Query();
        HttpComponents http = new HttpComponents();
        //myQuery.TestDATETIME();
        int command;
        while (true)
        {
            System.out.println("请输入指令");
            try
            {
                command = in.nextInt();
            } catch (InputMismatchException e)
            {
                System.out.println("Retry again");
                continue;
            }
            if (command == 1)
            {
                    for (int i = 0; i < 4; i++)
                    {
                        try
                        {
                            JSONObject json = http.getFromUrl(q_URL + nations[i]);
                            String name = json.getJSONObject("All").getString("country");
                            int confirmed = json.getJSONObject("All").getInteger("confirmed");
                            int recovered = json.getJSONObject("All").getInteger("recovered");
                            int deaths = json.getJSONObject("All").getInteger("deaths");
                            myQuery.insertCountry(name, confirmed, recovered, deaths);
                            System.out.println("获得数据： " + name + " " + confirmed + " " + recovered + " " + deaths);
                            System.out.println("成功更新国家：" + name);
                            //为了偷懒，主键就直接设置为国家名字了，其实设置为iso代码或者abbr会更好，不过懒得管了233
                            if (nations[i] == "China")
                            {
                                JSONObject json2 = http.getFromUrl(q_URL + "Taiwan*");
                                json.put("Taiwan", json2.getJSONObject("All"));
                                //原数据源中China下不包括这个地方，Taiwan是一个另外的area
                                //为什么是area呢，因为Taiwan这个属性下没有country，和省啊州啊是一样的
                                //其实还有很多国家有争议地区，因此也要做特别的处理，不过本程序不涉及就是了
                            }
                            myQuery.insertAreas(json);
                            System.out.println("成功更新当前国家下的全部地区");
                        } catch (Exception e)
                        {
                            e.printStackTrace();
                            System.out.println("更新" + nations[i] + "数据时失败，请重试。");
                        }
                    }
            } else if (command == 4)
            {
                System.out.println("Bye");
                break;
            } else if (command == 2)
            {
                String country = in.next();
                if (country.equals("All"))
                {
                    myQuery.PrintAllNation();
                } else
                {
                    myQuery.PrintANation(country);
                }
            } else if (command == 3)
            {
                String country = in.next();
                String areas = in.next();
                //北京在China下的首都里是Peking，后面又变成Beijing,就说查不到数据......
                if (areas.equals("All"))
                {
                    myQuery.PrintAllAreas(country);
                } else
                {
                    myQuery.PrintAnArea(areas);
                }
            }
        }
        myQuery.CloseConn();
    }

}


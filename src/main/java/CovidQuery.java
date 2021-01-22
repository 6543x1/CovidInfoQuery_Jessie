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
        //myQuery.TestDATETIME();
        int command;
        while (true)
        {
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
                try
                {
                    for (int i = 0; i < 4; i++)
                    {
                        try
                        {
                            JSONObject json = ReadFromRemote.readJsonFromUrl(q_URL + nations[i]);
                            String name = json.getJSONObject("All").getString("country");
                            int confirmed = json.getJSONObject("All").getInteger("confirmed");
                            int recovered = json.getJSONObject("All").getInteger("recovered");
                            int deaths = json.getJSONObject("All").getInteger("deaths");
                            myQuery.insertCountry(name, confirmed, recovered, deaths);
                            System.out.println("成功更新国家：" + name);
                            //原本还去判断是否已经存在本数据，因为主键设置的一个自增的id,没有规律
                            //为了用REPLACE语句，主键就得改成别的
                            //为了偷懒，主键就直接设置为国家名字了，其实设置为iso代码或者abbr会更好，不过懒得管了233
                            if (nations[i] == "China")
                            {
                                JSONObject json2 = ReadFromRemote.readJsonFromUrl(q_URL + "Taiwan*");
                                json.put("Taiwan", json2.getJSONObject("All"));
                                //原数据源中China下不包括这个地方，Taiwan是一个另外的area
                                //为什么是area呢，因为Taiwan这个属性下没有country，和省啊州啊是一样的
                                //除非开发者有自己特别的主见，否则多少都要有点嗅觉，避免出现这种政治错误
                                //其实还有很多国家有争议地区，因此也要做特别的处理，不过本程序不涉及就懒得写了
                            }
                            myQuery.insertAreas(json);
                            System.out.println("成功更新当前国家下的全部地区");
                        } catch (Exception e)
                        {
                            e.printStackTrace();
                            System.out.println("更新失败，请重试。");
                        }
                    }
                } catch (Exception e)
                {
                    e.printStackTrace();
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
                //北京在China下的首都里是Peking，后面又变成Beijing......
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


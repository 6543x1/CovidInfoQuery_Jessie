import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class FileWriteTest
{
    public static void main(String[] args)
    {
        String q_URL = "https://covid-api.mmediagroup.fr/v1/cases?country=";
        String[] nations = {"China", "US", "United%20Kingdom", "Japan"};
        String path3 = Temporary.class.getClassLoader().getResource("Four.json").getPath();
        String path4 = Temporary.class.getClassLoader().getResource("French.json").getPath();
        System.out.println(path3);
        String s = readJsonFile(path4);
// 获取连接:
        try
        {
            JSONObject jsonall = JSON.parseObject(readJsonFile(path3));
            jsonall.put("US", s);
            System.out.println(jsonall.getJSONObject("US").getJSONObject("All").get("confirmed"));
            System.out.println(jsonall.get("Japan"));
            saveJsonFile(path3, formatJson(jsonall.toString()));
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void saveJsonFile(String fileName, String data)
    {
        //System.out.println(data);
        if (data == null) System.out.println("NULL DATA");
        BufferedWriter writer = null;
        File file = new File(fileName);
        //如果文件不存在，则新建一个
        if (!file.exists())
        {
            try
            {
                file.createNewFile();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        //写入
        try
        {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, false), "UTF-8"), 1024);
            writer.write(data);
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (writer != null)
                {
                    writer.flush();
                    writer.close();
                } else
                {
                    System.out.println("NULL WRITER");
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("更新数据成功！");

    }

    private static String indent(int number)
    {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < number; i++)
        {
            result.append(" ");
        }
        return result.toString();
    }

    public static String formatJson(String json)
    {
        StringBuffer result = new StringBuffer();

        int length = json.length();
        int number = 0;
        char key = 0;

        // 遍历输入字符串。
        for (int i = 0; i < length; i++)
        {
            // 1、获取当前字符。
            key = json.charAt(i);

            // 2、如果当前字符是前方括号、前花括号做如下处理：
            if ((key == '[') || (key == '{'))
            {
                // （1）如果前面还有字符，并且字符为“：”，打印：换行和缩进字符字符串。
                if ((i - 1 > 0) && (json.charAt(i - 1) == ':'))
                {
                    result.append('\n');
                    result.append(indent(number));
                }

                // （2）打印：当前字符。
                result.append(key);

                // （3）前方括号、前花括号，的后面必须换行。打印：换行。
                result.append('\n');

                // （4）每出现一次前方括号、前花括号；缩进次数增加一次。打印：新行缩进。
                number++;
                result.append(indent(number));

                // （5）进行下一次循环。
                continue;
            }

            // 3、如果当前字符是后方括号、后花括号做如下处理：
            if ((key == ']') || (key == '}'))
            {
                // （1）后方括号、后花括号，的前面必须换行。打印：换行。
                result.append('\n');

                // （2）每出现一次后方括号、后花括号；缩进次数减少一次。打印：缩进。
                number--;
                result.append(indent(number));

                // （3）打印：当前字符。
                result.append(key);

                // （4）如果当前字符后面还有字符，并且字符不为“，”，打印：换行。
                if (((i + 1) < length) && (json.charAt(i + 1) != ','))
                {
                    result.append('\n');
                }

                // （5）继续下一次循环。
                continue;
            }

            // 4、如果当前字符是逗号。逗号后面换行，并缩进，不改变缩进次数。
            if ((key == ','))
            {
                result.append(key);
                result.append('\n');
                result.append(indent(number));
                continue;
            }

            // 5、打印：当前字符。
            result.append(key);
        }

        return result.toString();
    }

    public static String readJsonFile(String fileName)
    {
        String jsonStr = "";
        try
        {
            File jsonFile = new File(fileName);
            FileReader fileReader = new FileReader(jsonFile);
            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1)
            {
                sb.append((char) ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        } catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}

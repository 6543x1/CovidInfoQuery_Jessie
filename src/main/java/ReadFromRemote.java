import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

public class ReadFromRemote
{
    //咳咳这个代码也是现成学（借）来（鉴）的，只是用来读取内容足够，http的还在研究
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException
    {
        try (InputStream is = new URL(url).openStream())
        {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1)
            {
                sb.append((char) cp);
            }
            String jsonText = sb.toString();
            JSONObject json = JSONObject.parseObject(jsonText);
            return json;
        }
    }
}

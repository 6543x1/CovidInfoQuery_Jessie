import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ReadFromRemote
{
    //咳咳这个代码也是现成学（借）来（鉴）的，感觉比http写起来更简洁？
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException
    {
        try (InputStream is = new URL(url).openStream())
        {
            Gson gson=new Gson();

            BufferedReader rd = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.JsrInstruction;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import sun.net.www.http.HttpClient;

import java.io.Closeable;
import java.io.IOException;

public class HttpComponents
{
    CloseableHttpClient http;

    public HttpComponents()
    {
        http = HttpClients.createDefault();
    }

    public JSONObject getFromUrl(String url)
    {
        JSONObject result = null;
        CloseableHttpResponse response = null;
        HttpGet httpget = new HttpGet(url);
        try
        {
            response = http.execute(httpget);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        // 读取返回结果
        if (response.getCode() == 200)
        {
            HttpEntity entity = response.getEntity();
            String content = null;
            try
            {
                content = EntityUtils.toString(entity, "UTF-8");
            } catch (Exception e)
            {
                e.printStackTrace();
            }
            if (content != null)
                result = JSONObject.parseObject(content);
        } else
        {
            throw new NullPointerException();
        }
        return result;
    }

}

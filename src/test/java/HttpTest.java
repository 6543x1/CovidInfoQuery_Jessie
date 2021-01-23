import com.alibaba.fastjson.JSONObject;

public class HttpTest
{
    public static void main(String[] args)
    {
        HttpComponents http = new HttpComponents();
        String q_URL = "https://covid-api.mmediagroup.fr/v1/cases?country=";
        String[] nations = {"China", "US", "United%20Kingdom", "Japan"};
        JSONObject json = http.getFromUrl(q_URL + nations[0]);
        if (json != null)
            System.out.println(json.toString());
        else
        {
            System.out.println("ERROR");
        }
    }
}

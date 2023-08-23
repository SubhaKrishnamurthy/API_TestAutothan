package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.*;
import java.util.*;

public class Utils {

    public static RequestSpecification req;
    static JsonPath js;
    protected static Response response;

    public static RequestSpecification requestSpecification() throws IOException {

        if (req == null) {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

            req = new RequestSpecBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("User-Agent", "PostmanRuntime/7.29.2")
                    .addHeader("Accept", "*/*")
                    .addHeader("Accept-Encoding", "gzip, deflate, br")
                    .addHeader("Connection", "keep-alive")
                    .build();
            return req;
        }
        return req;
    }

    public static String getGlobalValue(String key) throws IOException
    {
        File file = new File("src/test/java/resources/global.properties");
        Properties prop = new Properties();
        InputStream input = null;
        try{
        input = new FileInputStream(file);
        prop.load(input);
     }
     catch(IOException ex)
    {
        ex.printStackTrace();
    }
        finally {
            if(input!=null) {
                try{
                    input.close();
                }catch (IOException ex){
                    ex.printStackTrace();
                }
            }
            if(prop.getProperty(key)==null){
                try{
                    throw new Exception("Property ["+key+"] value is null in file "+file.getName());
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return prop.getProperty(key).trim();

}
    public static String getJSONPath(Response response, String key)
    {
        String resp = response.asString();
        js = new JsonPath(resp);
        return js.get(key).toString();
    }

    public static String getJSONPathArray(String response, String key) {
       // String resp = response.asString();
        js = new JsonPath(response);
       return js.get(key).toString();
    }

    public static String getJSONPath1(Response response, String key)
    {
        String resp = response.asString();
        js = new JsonPath(resp);
        return js.get(key).toString();
    }

    public String getJSONPath_id(Response response, String key)
    {
        String resp = response.asString();
        js = new JsonPath(resp);
        //return  js[0];
        return js.get(key).toString();
    }

    public static void StatusCode_Assertion(int code){
        Assert.assertEquals( response.getStatusCode(),code);
    }

    public static void JSONAssertion(String key,String value)
    {
        Assert.assertEquals(getJSONPath(response,key),value);
    }

    public static void JSONAssertion1(String key,String value)
    {
        Assert.assertEquals(getJSONPath1(response,key),value);
    }

    public static void JSONAssertionContains(String key,String value)
    {
        String fromAPI = getJSONPath(response,key);
        fromAPI.contains(value);
    }
}

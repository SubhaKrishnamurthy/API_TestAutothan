package stepDefinition.SD_AuthenticationOnPremIP_OSDAccounts_UAT;

import com.google.gson.JsonObject;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.runner.RunWith;
import resources.TestDataBiuld;
import resources.Utils;
import java.io.IOException;

public class SD_AuthenticationOnPremIP extends Utils
{

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response_ADA;
    TestDataBiuld data = new TestDataBiuld();
    static String  request_id_value_G;
   public static String access_token_G;
   static String id_G;
    //String baseURL = "http://10.51.1.203:8085";


    @And("store the {string} from the response body")
    public void xstoreTheFromTheResponseBody(String request_id) {
        String request_id_value = getJSONPath(response,request_id);
        System.out.println("request_id_value = "+ request_id_value);
        request_id_value_G = request_id_value;
    }

    //@OTP
    @Given("API request {string} {string} {string} along with headers in POST method")
    public void apiRequestAlongWithHeadersInPOSTMethod(String user_id, String password, String udid) throws IOException {

        JsonObject bodyvalue = new JsonObject();

        bodyvalue.addProperty("user_id",user_id);
        bodyvalue.addProperty("password",password);
        bodyvalue.addProperty("udid",udid);

        response_ADA = RestAssured.given()
                //spec(requestSpecification())
                .header("Content-Type","application/json")
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .header("X-Client-Id","57b0976e-dd59-48cc-a020-58ad1ff72167")
                .header("X-Client-Secret","xlher5laEUdvtH3a457aLiJui3k9irppbZ1y6BhbvrOUTvwrOXbcEGKzDBNhxY3s")
                .body(bodyvalue.toString())
                .when().post(Utils.getGlobalValue("core_base_url")+"/ucore/api/v1.17/login")
                .then().using().extract().response();
        System.out.println("Response from api = " + response_ADA.getBody().asString());
        response = response_ADA;
    }

    //@LoginOTP
    @Given("API request {string} and {string} in POST method")
    public void apiRequestAndInPOSTMethod(String request_id, String code) throws IOException {

        JsonObject bodyvalue = new JsonObject();
        bodyvalue.addProperty("request_id",request_id_value_G);
        bodyvalue.addProperty("code",code);

        response = RestAssured.given()
                //spec(requestSpecification())
                .header("Content-Type","application/json")
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .header("X-Client-Id","57b0976e-dd59-48cc-a020-58ad1ff72167")
                .header("X-Client-Secret","xlher5laEUdvtH3a457aLiJui3k9irppbZ1y6BhbvrOUTvwrOXbcEGKzDBNhxY3s")
                .body(bodyvalue.toString())
                .when().post(Utils.getGlobalValue("core_base_url")+"/ucore/api/v1.17/login/otp")
                .then().using().extract().response();

        System.out.println("Response from api = " + response.getBody().asString());

    }

    //@LoginOTP
    @And("store the accessToken {string} from the response body")
    public void storeTheAccessTokenFromTheResponseBody(String access_token) {
        String access_token1 =getJSONPath(response,access_token);
        System.out.println("access_token Scenario 2 = "+ access_token1);
        access_token_G = access_token1;
    }

    @Given("API request accessToken in POST method")
    public void apiRequestAccessTokeInPOSTMethod() throws IOException {

        JsonObject bodyvalue = new JsonObject();
        bodyvalue.addProperty("access_token",access_token_G);

        response = RestAssured.given()
                //spec(requestSpecification())
                .header("Content-Type","application/json")
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .header("X-Client-Id","57b0976e-dd59-48cc-a020-58ad1ff72167")
                .header("X-Client-Secret","xlher5laEUdvtH3a457aLiJui3k9irppbZ1y6BhbvrOUTvwrOXbcEGKzDBNhxY3s")
                .body(bodyvalue.toString())
                .when().post(Utils.getGlobalValue("core_base_url")+"/ucore-auth/api/legacy/authorize")
                .then().using().extract().response();

        System.out.println("Response from api = " + response.getBody().asString());
    }

    // @GetUserID
    @Given("API for GetUserID in Get method")
    public void api_for_get_user_id_in_get_method() throws IOException {

        JsonObject bodyvalue = new JsonObject();
        bodyvalue.addProperty("access_token",access_token_G);

        response = RestAssured.given()
                //spec(requestSpecification())
                .header("Content-Type","application/json")
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .header("X-Client-Id","515d7e08-7127-45e3-9854-ebdf1c6bd7f3")
                .header("X-Client-Secret","fjSi1S0J8XbnN3qg8hi1I05CajczhJAlhwTz8FuOlHvEMgxUs9YlRKUTKlQgGn0fw9VQzvYcKm9gpS9c4d8dJKRXvB9iOh6u2B24DYuCFjK9JChKMrzwjMMZlWMUidEB")
                .body(bodyvalue.toString())
                .when().post(Utils.getGlobalValue("core_base_url")+"/ucore-auth/api/legacy/authorize")
                .then().using().extract().response();

        System.out.println("Response from api = " + response.getBody().asString());
        System.out.println("accesss_Token for Scenario 3 " + access_token_G);

    }

}



package stepDefinition.ADAService;

import com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import resources.TestDataBiuld;
import resources.Utils;
import stepDefinition.SD_AuthenticationOnPremIP_OSDAccounts_UAT.SD_AuthenticationOnPremIP;
import java.io.IOException;

public class SD_TS04_ValidateADA extends Utils {

    static String access_token_G = SD_AuthenticationOnPremIP.access_token_G;
    static String  request_id_value_G = SD_TS03_CreateADA.request_id_value_G;
    //@TC4.1_ValidADA
    @Given("API for ValidADA in POST method")
    public void api_for_valid_ada_in_post_method() throws IOException {

        JsonObject bodyvalue = new JsonObject();
        bodyvalue.addProperty("request_id",request_id_value_G);
        bodyvalue.addProperty("code","222222");

        response = RestAssured.given()
                //spec(requestSpecification())
                .header("Content-Type","application/json")
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .header("Authorization",access_token_G)
                .body(bodyvalue.toString())
                .when()
                .post(Utils.getGlobalValue("ADA_SERVICE_URL")+"/ada/validation")
                .then().using().extract().response();

        System.out.println("3. Response from api = " + response.getBody().asString());
    }


}

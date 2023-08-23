package stepDefinition.ADAService;
import com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import resources.TestDataBiuld;
import resources.Utils;
import stepDefinition.SD_AuthenticationOnPremIP_OSDAccounts_UAT.SD_AuthenticationOnPremIP;
import java.io.IOException;

public class SD_TS03_CreateADA extends Utils {

    static String access_token_G = SD_AuthenticationOnPremIP.access_token_G;
    static String  request_id_value_G;
    static String source_token_G =  SD_TS01_GetAccountsByType.SourceToken_id_G;
    static String target_token_G = SD_TS01_GetAccountsByType.TargetToken_id_G;

    //@TC3.1_CreateADAusingValidTargetToken
    @Given("API for CreateADA for CreateADAusingValidTargetToken in POST method")
    public void api_for_create_ada_for_create_ad_ausing_valid_target_token_in_post_method() throws IOException {

        JsonObject bodyvalue = new JsonObject();
        bodyvalue.addProperty("payment_type","MINIMUM_AMOUNT");
        bodyvalue.addProperty("frequency","MONTHLY");
        bodyvalue.addProperty("source_token",source_token_G);
        bodyvalue.addProperty("target_token",target_token_G);
        bodyvalue.addProperty("start_date","20-OCT-2022");

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
                .post(Utils.getGlobalValue("ADA_SERVICE_URL")+"/ada")
                .then().using().extract().response();

        System.out.println("3. Response from api = " + response.getBody().asString());
    }

    //@TC3.1_CreateADAusingValidTargetToken
    @Then("store the {string} from the response body of CreateADA")
    public void store_the_from_the_response_body_of_create_ada(String request_id) {
        String request_id_value =getJSONPath(response,request_id);
        System.out.println("request_id_value = "+ request_id_value);
        request_id_value_G = request_id_value;
    }

}

package stepDefinition.ADAService;

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

public class SD_TS02_GetADA extends Utils  {

    static String access_token_G = SD_AuthenticationOnPremIP.access_token_G;
    static String targetToken_G = SD_TS01_GetAccountsByType.TargetToken_id_G;

    //@TC2.1_CreditAccountWithNoADA
    @Given("API for GetADA for CreditAccountWithNoADA in Get method")
    public void api_for_get_ada_for_credit_account_with_no_ada_in_get_method() throws IOException {
        response = RestAssured.given()
                //spec(requestSpecification())
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .header("Authorization",access_token_G)
                .when()
                .get(Utils.getGlobalValue("ADA_SERVICE_URL")+"/ada/")
                .then().using().extract().response();

        System.out.println("3. Response from api = " + response.getBody().asString());
    }

    //@TC2.2_CreditAccountWithADA
    @Given("API for GetADA for CreditAccountWithADA in Get method")
    public void api_for_get_ada_for_credit_account_with_ada_in_get_method() throws IOException {
        response = RestAssured.given()
                //spec(requestSpecification())
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .header("Authorization",access_token_G)
                .when()
                .get(Utils.getGlobalValue("OSD_base_url")+"/ada/"+targetToken_G)
                .then().using().extract().response();

        System.out.println("target token = "+ targetToken_G);
        System.out.println("3. Response from api = " + response.getBody().asString());

    }
}

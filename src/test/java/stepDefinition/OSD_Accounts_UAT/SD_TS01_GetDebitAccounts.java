package stepDefinition.OSD_Accounts_UAT;

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

public class SD_TS01_GetDebitAccounts extends Utils  {

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response_ADA;
    TestDataBiuld data = new TestDataBiuld();
    static String  request_id_value_G;
    static String access_token_G = SD_AuthenticationOnPremIP.access_token_G;

    //@TC1.1_WithValidAccessToken
    @Given("API for GetDebitAccounts with valid access token in Get method")
    public void api_for_get_debit_accounts_with_valid_access_token_in_get_method() throws IOException {
        response = RestAssured.given()
                //spec(requestSpecification())
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .header("Access-Token",access_token_G)
                .when()
                .get(Utils.getGlobalValue("OSD_base_url")+"/api/v1/accounts/type/debit")
                .then().using().extract().response();

        System.out.println("3. Response from api = " + response.getBody().asString());
        System.out.println("access token _Global = "+access_token_G);

    }

  //@TC1.2_WithInvalidAccessToken
    @Given("API for GetDebitAccounts With invalid access token in Get method")
    public void api_for_get_debit_accounts_with_invalid_access_token_in_get_method() throws IOException {
        response = RestAssured.given()
                //spec(requestSpecification())
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .header("Access-Token","0973a388-ba70-4f8a-b10c")
                .when()
                .get(Utils.getGlobalValue("OSD_base_url")+"/api/v1/accounts/type/debit")
                .then().using().extract().response();;

        System.out.println("3. Response from api = " + response.getBody().asString());

    }

    //@TC1.3_WithNoAccessToken
    @Given("API for GetDebitAccounts With no access token in Get method")
    public void api_for_get_debit_accounts_with_no_access_token_in_get_method() throws IOException {
        response = RestAssured.given()
                //spec(requestSpecification())
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .header("Access-Token","")
                .when()
                .get(Utils.getGlobalValue("OSD_base_url")+"/api/v1/accounts/type/debit")
                 .then().using().extract().response();;

        System.out.println("3. Response from api = " + response.getBody().asString());
    }



}

package stepDefinition.ADAService;

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

public class SD_TS01_GetAccountsByType extends Utils  {


    RequestSpecification res;
    ResponseSpecification resspec;
    Response response_ADA;
    TestDataBiuld data = new TestDataBiuld();
    static String  request_id_value_G;
    static String access_token_G = SD_AuthenticationOnPremIP.access_token_G;
    public static String TargetToken_id_G;
    public static String SourceToken_id_G;

    //@TC1.1_ValidAccounType_credit_withValidAccessToken
    @Given("API for GetAccountsByType for Valid account type \\(credit) with valid access token in Get method")
    public void api_for_get_accounts_by_type_for_valid_account_type_credit_with_valid_access_token_in_get_method() throws IOException {
        response = RestAssured.given()
                //spec(requestSpecification())
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .header("Authorization",access_token_G)
                .when()
                .get(Utils.getGlobalValue("ADA_SERVICE_URL")+"/ada/accounts/type/credit")
                .then().using().extract().response();

        System.out.println("3. Response from api = " + response.getBody().asString());
    }

    //@TC1.2_ValidAccountType_debit_withValidAccessToken
    @Given("API for GetAccountsByType for Valid account type \\(debit) with valid access token in Get method")
    public void api_for_get_accounts_by_type_for_valid_account_type_debit_with_valid_access_token_in_get_method() throws IOException {
        response = RestAssured.given()
                //spec(requestSpecification())
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .header("Authorization",access_token_G)
                .when()
                .get(Utils.getGlobalValue("ADA_SERVICE_URL")+"/ada/accounts/type/debit")
                .then().using().extract().response();

        System.out.println("3. Response from api = " + response.getBody().asString());
    }

    //@TC1.3_ValidAccountTypeWithInvalidToken
    @Given("API for GetAccountsByType for Valid account type with invalid token in Get method")
    public void api_for_get_accounts_by_type_for_valid_account_type_with_invalid_token_in_get_method() throws IOException {
        response = RestAssured.given()
                //spec(requestSpecification())
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .header("Authorization","0973a388-ba70-4f8a-b10c")
                .when()
                .get(Utils.getGlobalValue("ADA_SERVICE_URL")+"/ada/accounts/type/debit")
                .then().using().extract().response();

        System.out.println("3. Response from api = " + response.getBody().asString());
    }

   //@TC1.4_NoAccessToken
    @Given("API for GetAccountsByType with No access token in Get method")
    public void api_for_get_accounts_by_type_with_no_access_token_in_get_method() throws IOException {
        response = RestAssured.given()
                //spec(requestSpecification())
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .header("Authorization","")
                .when()
                .get(Utils.getGlobalValue("ADA_SERVICE_URL")+"/ada/accounts/type/debit")
                .then().using().extract().response();

        System.out.println("3. Response from api = " + response.getBody().asString());
    }


    //@TC1.1_ValidAccounType_credit_withValidAccessToken
    @Then("I store the {string} from the response body of ValidCreditAccount as {string}")
    public void i_store_the_from_the_response_body_of_valid_credit_account_as(String id, String target_token) {
        String target_token_id =getJSONPath(response,id);
        System.out.println("access_token Scenario 2 = "+ target_token_id);
        TargetToken_id_G = target_token_id;
    }

    //@TC1.2_ValidAccountType_debit_withValidAccessToken
    @Then("I store the {string} from the response body of ValidDebitAccount as {string}")
    public void i_store_the_from_the_response_body_of_valid_debit_account_as(String id, String source_token) {
        String source_token_id =getJSONPath(response,id);
        System.out.println("access_token Scenario 2 = "+ source_token_id);
        SourceToken_id_G = source_token_id;
    }

}

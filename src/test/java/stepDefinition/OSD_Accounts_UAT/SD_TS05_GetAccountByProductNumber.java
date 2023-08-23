package stepDefinition.OSD_Accounts_UAT;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBiuld;
import resources.Utils;
import stepDefinition.SD_AuthenticationOnPremIP_OSDAccounts_UAT.SD_AuthenticationOnPremIP;
import java.io.IOException;

public class SD_TS05_GetAccountByProductNumber extends Utils{

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response_ADA;
    TestDataBiuld data = new TestDataBiuld();
    static String  request_id_value_G;
    static String access_token_G = SD_AuthenticationOnPremIP.access_token_G ;

    //@TC5.1_Valid_Debit_product_token_with_valid_access_token
    @Given("API for getAccountByProductNumber Debit with valid access token in Get method")
    public void api_for_get_account_by_product_number_debit_with_valid_access_token_in_get_method() throws IOException {
        response = RestAssured.given()
                //spec(requestSpecification())
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .queryParam("Access-Token",access_token_G)
                .when()
                .get(Utils.getGlobalValue("OSD_base_url")+"/api/v1/accounts/ubp-z8gHe_8OXkUAzl4OtJJW5A")
                .then().using().extract().response();;

        System.out.println("3. Response from api = " + response.getBody().asString());
    }

    //@TC5.2_Valid_Credit_product_token_with_valid_access_token
    @Given("API for getAccountByProductNumber Credit with valid access token in Get method")
    public void api_for_get_account_by_product_number_credit_with_valid_access_token_in_get_method() throws IOException {
        response = RestAssured.given()
                //spec(requestSpecification())
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .queryParam("Access-Token",access_token_G)
                .when()
                .get(Utils.getGlobalValue("OSD_base_url")+"/api/v1/accounts/ubp-YQPq0FlVCuefwYVgZN63R2kYMdmvFh9RYMelpOFl4Xw")
                .then().using().extract().response();;

        System.out.println("3. Response from api = " + response.getBody().asString());
    }

    //@TC5.3_Valid_Product_token_with_invalid_access_token
    @Given("API for getAccountByProductNumber Credit with invalid access token in Get method")
    public void api_for_get_account_by_product_number_credit_with_invalid_access_token_in_get_method() throws IOException {
        response = RestAssured.given()
                //spec(requestSpecification())
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .queryParam("Access-Token","0973a388-ba70-4f8a-b10c")
                .when()
                .get(Utils.getGlobalValue("OSD_base_url")+"/api/v1/accounts/ubp-YQPq0FlVCuefwYVgZN63R2kYMdmvFh9RYMelpOFl4Xw")
                .then().using().extract().response();;

        System.out.println("3. Response from api = " + response.getBody().asString());
    }

    //@TC5.4_Invalid_Product_token_with_valid_access_token
    @Given("API for getAccountByProductNumber Credit with invalid productToken and valid access token in Get method")
    public void api_for_get_account_by_product_number_credit_with_invalid_product_token_and_valid_access_token_in_get_method() throws IOException {
        response = RestAssured.given()
                //spec(requestSpecification())
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .queryParam("Access-Token",access_token_G)
                .when()
                .get(Utils.getGlobalValue("OSD_base_url")+"/api/v1/accounts/ubp-YQPq0FlVCuefwYVgZN63R2kYMdmvFh9RYMelp")
                .then().using().extract().response();;

        System.out.println("3. Response from api = " + response.getBody().asString());

    }

    //@TC5.5_No_access_token
    @Given("API for getAccountByProductNumber Credit with no access token in Get method")
    public void api_for_get_account_by_product_number_credit_with_no_access_token_in_get_method() throws IOException {
        response = RestAssured.given()
                //spec(requestSpecification())
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .queryParam("Access-Token","")
                .when()
                .get(Utils.getGlobalValue("OSD_base_url")+"/api/v1/accounts/ubp-YQPq0FlVCuefwYVgZN63R2kYMdmvFh9RYMelp")
                .then().using().extract().response();;

        System.out.println("3. Response from api = " + response.getBody().asString());

    }

}

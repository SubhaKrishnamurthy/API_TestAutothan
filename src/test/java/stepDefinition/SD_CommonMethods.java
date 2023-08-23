package stepDefinition;

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

public class SD_CommonMethods extends Utils
{

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response_ADA;
    TestDataBiuld data = new TestDataBiuld();
    static String  request_id_value_G;
   static String access_token_G;
   static String id_G;
    //String baseURL = "http://10.51.1.203:8085";

    @Then("^The API call is success with status code (\\d+)$")
    public void the_API_call_is_success_with_status_code(int code) throws Throwable {
        Utils.StatusCode_Assertion(code);
    }

    @And("I verify {string} in response body is {string}")
    public void iVerifyInResponseBodyIs(String key, String value) {
        Utils.JSONAssertion(key,value);
    }

    @Then("I verify {string} in response body contains {string}")
    public void i_verify_in_response_body_contains(String key, String value) {
        Utils.JSONAssertionContains(key,value);
    }

    @Then("I verify {string} in response body[] is {string}")
    public void i_verify_in_response_body_is(String key, String value) {
        Utils.JSONAssertion1(key,value);
    }



}



package stepDefinition.SD_RedHat_OSP_POC;

import com.google.gson.JsonObject;
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

public class SD_TS01_Encryption extends Utils
{

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response;
    TestDataBiuld data = new TestDataBiuld();

    @Given("API request {string} {string} {string} {string} along with headers in POST method for Hash Encrypt")
    public void api_request_along_with_headers_in_post_method_for_hash_encrypt(String key, String stringToHash, String algo, String encoding) throws IOException {
        JsonObject bodyvalue = new JsonObject();

        bodyvalue.addProperty("key",key);
        bodyvalue.addProperty("stringToHash",stringToHash);
        bodyvalue.addProperty("algo",algo);
        bodyvalue.addProperty("encoding",encoding);

        response = RestAssured.given()
                //spec(requestSpecification())
                .header("Content-Type","application/json")
                .header("User-Agent","PostmanRuntime/7.29.2")
                .header("Accept","*/*")
                .header("Accept-Encoding","gzip, deflate, br")
                .header("Connection","keep-alive")
                .body(bodyvalue.toString())
               // .when().post(Utils.getGlobalValue("baseURLEncryption")+"/v1/hash/encrypt")
                .when().post("https://ubp-microservice-encryptions-ubp-uat-microservice-encryptions.apps.osdnp.l6a4.p1.openshiftapps.com/v1/hash/encrypt")
                .then().using().extract().response();

    }

    @Then("I see the response")
    public void i_see_the_response() {
        System.out.println("Response = "+response);
    }




}

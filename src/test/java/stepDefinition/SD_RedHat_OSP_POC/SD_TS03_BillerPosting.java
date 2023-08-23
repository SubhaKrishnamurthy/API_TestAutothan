package stepDefinition.SD_RedHat_OSP_POC;

import io.cucumber.java.en.Given;
import io.cucumber.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.runner.RunWith;
import resources.TestDataBiuld;
import resources.Utils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SD_TS03_BillerPosting extends Utils
{

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response_BillerPosting;
    TestDataBiuld data = new TestDataBiuld();

    //TC3.1_BillerPosting
    @Given("API request along with headers in POST method for BillerPosting Normal Biller with Cipher Encryption")
    public void api_request_along_with_headers_in_post_method_for_biller_posting_normal_biller_with_cipher_encryption() throws IOException {
        //read data from local JSON file then store in byte array
        byte[] b = Files.readAllBytes(Paths.get("src/test/java/resources/Payload_RedHatOSPPOC/TC3.1_BillerPosting_NormalBiller_CipherEncryption.json"));
        //convert byte array to string
        String body = new String(b);

        response_BillerPosting = RestAssured.given()
                .spec(requestSpecification())
                .header("x-ibm-client-id","1262a40d-c298-40c3-a8b1-61952de3ccc0")
                .header("x-ibm-client-secret","eT0nI5pM4tL4lE3mX8gT3lY5eI6uJ5iY0fN1bW4pB4pG0iH0bW")
                .header("Reference-Id","jamesTesting1")
                .header("Cookie","BIGipServerpool_api-uat.unionbankph_443=1763062538.47873.0000; TS012dd614=011667ddf0eee92b2a5cc070833fe7d79ed4de81ad9cc62835f52b26cabb2d744c77a7298ae6e18602b783e2dc3ea62f5b244fb88b0a94af92e4c907f120c9f198d0384cb34b3eab879248cc2dba0549e5978af90e; cookiesession1=678B2871F50FB67FA42B2515130C8EB1; BIGipServerpool_api-uat.unionbankph_443=1763062538.47873.0000; TS012dd614=011667ddf09b9dcd5bc13415721d7e08a4fa941b9f36aa1418393fcba404aaa429788c7b3677dc9ad2b0171dcb60a993705eb72878d6780a982a767125eb06bf6589c249cdbf71359b2868073a5e16ca8248d7b0bc; cookiesession1=678B2871278BA90132FB0F2DA6B8C53B")
                .body(body)
                .when().post( Utils.getGlobalValue("baseURLBillsPayment")+"/ubp/uat/payments/v1/transactions")
                .then().using().extract().response();
        System.out.println("response = " +response_BillerPosting.asString());
        response = response_BillerPosting;
    }

    //TC3.2_BillerPosting
    @Given("API request along with headers in POST method for BillerPosting Normal Biller with Hash Encryption")
    public void apiRequestAlongWithHeadersInPOSTMethodForBillerPostingNormalBillerWithHashEncryption() throws IOException {
        //read data from local JSON file then store in byte array
        byte[] b = Files.readAllBytes(Paths.get("src/test/java/resources/Payload_RedHatOSPPOC/TC3.2_BillerPosting_NormalBiller_HashEncryption.json"));
        //convert byte array to string
        String body = new String(b);

        response_BillerPosting = RestAssured.given()
                .spec(requestSpecification())
                .header("x-ibm-client-id","1262a40d-c298-40c3-a8b1-61952de3ccc0")
                .header("x-ibm-client-secret","eT0nI5pM4tL4lE3mX8gT3lY5eI6uJ5iY0fN1bW4pB4pG0iH0bW")
                .header("Reference-Id","jamesTesting1")
                .header("Cookie","BIGipServerpool_api-uat.unionbankph_443=1763062538.47873.0000; TS012dd614=011667ddf0eee92b2a5cc070833fe7d79ed4de81ad9cc62835f52b26cabb2d744c77a7298ae6e18602b783e2dc3ea62f5b244fb88b0a94af92e4c907f120c9f198d0384cb34b3eab879248cc2dba0549e5978af90e; cookiesession1=678B2871F50FB67FA42B2515130C8EB1; BIGipServerpool_api-uat.unionbankph_443=1763062538.47873.0000; TS012dd614=011667ddf09b9dcd5bc13415721d7e08a4fa941b9f36aa1418393fcba404aaa429788c7b3677dc9ad2b0171dcb60a993705eb72878d6780a982a767125eb06bf6589c249cdbf71359b2868073a5e16ca8248d7b0bc; cookiesession1=678B2871278BA90132FB0F2DA6B8C53B")
                .body(body)
                .when().post( Utils.getGlobalValue("baseURLBillsPayment")+"/ubp/uat/payments/v1/transactions")
                .then().using().extract().response();
        System.out.println("response = " +response_BillerPosting.asString());
        response = response_BillerPosting;

    }

    //TC3.3_BillerPosting
    @Given("API request along with headers in POST method for BillerPosting Customized Biller forFailedPostingY SuccessfulTransaction")
    public void api_request_along_with_headers_in_post_method_for_biller_posting_customized_biller_for_failed_posting_y_successful_transaction() throws IOException {
        //read data from local JSON file then store in byte array
        byte[] b = Files.readAllBytes(Paths.get("src/test/java/resources/Payload_RedHatOSPPOC/TC3.3_BillerPosting_CustomizedBiller_forFailedPostingY_SuccessfulTransaction.json"));
        //convert byte array to string
        String body = new String(b);

        response_BillerPosting = RestAssured.given()
                .spec(requestSpecification())
                .header("x-ibm-client-id","1262a40d-c298-40c3-a8b1-61952de3ccc0")
                .header("x-ibm-client-secret","eT0nI5pM4tL4lE3mX8gT3lY5eI6uJ5iY0fN1bW4pB4pG0iH0bW")
                .header("Reference-Id","jamesTesting1")
                .header("Cookie","BIGipServerpool_api-uat.unionbankph_443=1763062538.47873.0000; TS012dd614=011667ddf0eee92b2a5cc070833fe7d79ed4de81ad9cc62835f52b26cabb2d744c77a7298ae6e18602b783e2dc3ea62f5b244fb88b0a94af92e4c907f120c9f198d0384cb34b3eab879248cc2dba0549e5978af90e; cookiesession1=678B2871F50FB67FA42B2515130C8EB1; BIGipServerpool_api-uat.unionbankph_443=1763062538.47873.0000; TS012dd614=011667ddf09b9dcd5bc13415721d7e08a4fa941b9f36aa1418393fcba404aaa429788c7b3677dc9ad2b0171dcb60a993705eb72878d6780a982a767125eb06bf6589c249cdbf71359b2868073a5e16ca8248d7b0bc; cookiesession1=678B2871278BA90132FB0F2DA6B8C53B")
                .body(body)
                .when().post( Utils.getGlobalValue("baseURLBillsPayment")+"/ubp/uat/payments/v1/transactions")
                .then().using().extract().response();
        System.out.println("response = " +response_BillerPosting.asString());
        response = response_BillerPosting;
    }

    //TC3.4_BillerPosting
    @Given("API request along with headers in POST method for BillerPosting Customized Biller forFailedPostingN SuccessfulTransaction")
    public void api_request_along_with_headers_in_post_method_for_biller_posting_customized_biller_for_failed_posting_n_successful_transaction() throws IOException {
        //read data from local JSON file then store in byte array
        byte[] b = Files.readAllBytes(Paths.get("src/test/java/resources/Payload_RedHatOSPPOC/TC3.4_BillerPosting_CustomizedBiller_forFailedPostingN_SuccesfulTransaction.json"));
        //convert byte array to string
        String body = new String(b);

        response_BillerPosting = RestAssured.given()
                .spec(requestSpecification())
                .header("x-ibm-client-id","1262a40d-c298-40c3-a8b1-61952de3ccc0")
                .header("x-ibm-client-secret","eT0nI5pM4tL4lE3mX8gT3lY5eI6uJ5iY0fN1bW4pB4pG0iH0bW")
                .header("Reference-Id","jamesTesting1")
                .header("Cookie","BIGipServerpool_api-uat.unionbankph_443=1763062538.47873.0000; TS012dd614=011667ddf0eee92b2a5cc070833fe7d79ed4de81ad9cc62835f52b26cabb2d744c77a7298ae6e18602b783e2dc3ea62f5b244fb88b0a94af92e4c907f120c9f198d0384cb34b3eab879248cc2dba0549e5978af90e; cookiesession1=678B2871F50FB67FA42B2515130C8EB1; BIGipServerpool_api-uat.unionbankph_443=1763062538.47873.0000; TS012dd614=011667ddf09b9dcd5bc13415721d7e08a4fa941b9f36aa1418393fcba404aaa429788c7b3677dc9ad2b0171dcb60a993705eb72878d6780a982a767125eb06bf6589c249cdbf71359b2868073a5e16ca8248d7b0bc; cookiesession1=678B2871278BA90132FB0F2DA6B8C53B")
                .body(body)
                .when().post( Utils.getGlobalValue("baseURLBillsPayment")+"/ubp/uat/payments/v1/transactions")
                .then().using().extract().response();
        System.out.println("response = " +response_BillerPosting.asString());
        response = response_BillerPosting;
    }



}

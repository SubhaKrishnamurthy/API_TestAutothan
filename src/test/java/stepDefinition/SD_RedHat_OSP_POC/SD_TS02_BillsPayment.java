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

public class SD_TS02_BillsPayment extends Utils
{

    RequestSpecification res;
    ResponseSpecification resspec;
    Response response_BillsPayment;
    TestDataBiuld data = new TestDataBiuld();

    //TC2.1_BillsPayment
    @Given("API request  along with headers in POST method for BillsPayment AutoPosting biller")
    public void api_request_along_with_headers_in_post_method_for_bills_payment_auto_posting_biller() throws IOException {

        //read data from local JSON file then store in byte array
        byte[] b = Files.readAllBytes(Paths.get("src/test/java/resources/Payload_RedHatOSPPOC/TC2.1_BillsPayment_autopostingBiller.json"));
        //convert byte array to string
        String body = new String(b);

        response_BillsPayment = RestAssured.given()
                .spec(requestSpecification())
                .header("x-ibm-client-id","1262a40d-c298-40c3-a8b1-61952de3ccc0")
                .header("x-ibm-client-secret","eT0nI5pM4tL4lE3mX8gT3lY5eI6uJ5iY0fN1bW4pB4pG0iH0bW")
                .header("Reference-Id","jamesTesting")
                .header("Cookie","BIGipServerpool_api-uat.unionbankph_443=1763062538.47873.0000; TS012dd614=011667ddf0eee92b2a5cc070833fe7d79ed4de81ad9cc62835f52b26cabb2d744c77a7298ae6e18602b783e2dc3ea62f5b244fb88b0a94af92e4c907f120c9f198d0384cb34b3eab879248cc2dba0549e5978af90e; cookiesession1=678B2871F50FB67FA42B2515130C8EB1")
                .body(body)
                .when().
                post( Utils.getGlobalValue("baseURLBillsPayment")+"/ubp/uat/payments/v1/transactions")
                .then().using().extract().response();
        System.out.println("response = " +response_BillsPayment.asString());
        response = response_BillsPayment;

    }

    //TC2.2_BillsPayment
    @Given("API request along with headers in POST method for BillsPayment NoAutoPosting biller")
    public void api_request_along_with_headers_in_post_method_for_bills_payment_no_auto_posting_biller() throws IOException {
        //read data from local JSON file then store in byte array
        byte[] b = Files.readAllBytes(Paths.get("src/test/java/resources/Payload_RedHatOSPPOC/TC2.2_BillsPayment_NoautopostingBiller.json"));
        //convert byte array to string
        String body = new String(b);

        response_BillsPayment = RestAssured.given()
                .spec(requestSpecification())
                .header("x-ibm-client-id","1262a40d-c298-40c3-a8b1-61952de3ccc0")
                .header("x-ibm-client-secret","eT0nI5pM4tL4lE3mX8gT3lY5eI6uJ5iY0fN1bW4pB4pG0iH0bW")
                .header("Reference-Id","jamesTesting")
                .header("Cookie","BIGipServerpool_api-uat.unionbankph_443=1763062538.47873.0000; TS012dd614=011667ddf0eee92b2a5cc070833fe7d79ed4de81ad9cc62835f52b26cabb2d744c77a7298ae6e18602b783e2dc3ea62f5b244fb88b0a94af92e4c907f120c9f198d0384cb34b3eab879248cc2dba0549e5978af90e; cookiesession1=678B2871F50FB67FA42B2515130C8EB1")
                .body(body)
                .when().
                post( Utils.getGlobalValue("baseURLBillsPayment")+"/ubp/uat/payments/v1/transactions")
                .then().using().extract().response();
        System.out.println("response = " +response_BillsPayment.asString());
        response = response_BillsPayment;
    }

    //TC2.3_BillsPayment
    @Given("API request along with headers in POST method for BillsPayment forFailedPostingY and successful transaction")
    public void api_request_along_with_headers_in_post_method_for_bills_payment_for_failed_posting_y_and_successful_transaction() throws IOException {
        //read data from local JSON file then store in byte array
        byte[] b = Files.readAllBytes(Paths.get("src/test/java/resources/Payload_RedHatOSPPOC/TC2.3_BillsPayment_customizedBiller_FailedPostingY_SuccessfulTransaction.json"));
        //convert byte array to string
        String body = new String(b);

        response_BillsPayment = RestAssured.given()
                .spec(requestSpecification())
                .header("x-ibm-client-id","1262a40d-c298-40c3-a8b1-61952de3ccc0")
                .header("x-ibm-client-secret","eT0nI5pM4tL4lE3mX8gT3lY5eI6uJ5iY0fN1bW4pB4pG0iH0bW")
                .header("Reference-Id","jamesTesting")
                .header("Cookie","BIGipServerpool_api-uat.unionbankph_443=1763062538.47873.0000; TS012dd614=011667ddf0eee92b2a5cc070833fe7d79ed4de81ad9cc62835f52b26cabb2d744c77a7298ae6e18602b783e2dc3ea62f5b244fb88b0a94af92e4c907f120c9f198d0384cb34b3eab879248cc2dba0549e5978af90e; cookiesession1=678B2871F50FB67FA42B2515130C8EB1")
                .body(body)
                .when().
                post( Utils.getGlobalValue("baseURLBillsPayment")+"/ubp/uat/payments/v1/transactions")
                .then().using().extract().response();
        System.out.println("response = " +response_BillsPayment.asString());
        response = response_BillsPayment;
    }

    //TC2.4_BillsPayment
    @Given("API request along with headers in POST method for BillsPayment forFailedPostingY and failed transaction")
    public void api_request_along_with_headers_in_post_method_for_bills_payment_for_failed_posting_y_and_failed_transaction() throws IOException {

        //read data from local JSON file then store in byte array
        byte[] b = Files.readAllBytes(Paths.get("src/test/java/resources/Payload_RedHatOSPPOC/TC2.4_BillsPayment_customizedBiller_FailedPostingY_failedTransaction (invalid account number).json"));
        //convert byte array to string
        String body = new String(b);

        response_BillsPayment = RestAssured.given()
                .spec(requestSpecification())
                .header("x-ibm-client-id","1262a40d-c298-40c3-a8b1-61952de3ccc0")
                .header("x-ibm-client-secret","eT0nI5pM4tL4lE3mX8gT3lY5eI6uJ5iY0fN1bW4pB4pG0iH0bW")
                .header("Reference-Id","jamesTesting")
                .header("Cookie","BIGipServerpool_api-uat.unionbankph_443=1763062538.47873.0000; TS012dd614=011667ddf0eee92b2a5cc070833fe7d79ed4de81ad9cc62835f52b26cabb2d744c77a7298ae6e18602b783e2dc3ea62f5b244fb88b0a94af92e4c907f120c9f198d0384cb34b3eab879248cc2dba0549e5978af90e; cookiesession1=678B2871F50FB67FA42B2515130C8EB1")
                .body(body)
                .when().
                post( Utils.getGlobalValue("baseURLBillsPayment")+"/ubp/uat/payments/v1/transactions")
                .then().using().extract().response();
        System.out.println("response = " +response_BillsPayment.asString());
        response = response_BillsPayment;
    }

    //TC2.5_BillsPayment
    @Given("API request along with headers in POST method for BillsPayment for Failed PostingN and successful transaction")
    public void apiRequestAlongWithHeadersInPOSTMethodForBillsPaymentForFailedPostingNAndSuccessfulTransaction() throws IOException {

        //read data from local JSON file then store in byte array
        byte[] b = Files.readAllBytes(Paths.get("src/test/java/resources/Payload_RedHatOSPPOC/TC2.5_BillsPayment_customizedBiller_FailedPostingN_SuccessfulTransaction.json"));
        //convert byte array to string
        String body = new String(b);

        response_BillsPayment = RestAssured.given()
                .spec(requestSpecification())
                .header("x-ibm-client-id","1262a40d-c298-40c3-a8b1-61952de3ccc0")
                .header("x-ibm-client-secret","eT0nI5pM4tL4lE3mX8gT3lY5eI6uJ5iY0fN1bW4pB4pG0iH0bW")
                .header("Reference-Id","jamesTesting")
                .header("Cookie","BIGipServerpool_api-uat.unionbankph_443=1763062538.47873.0000; TS012dd614=011667ddf0eee92b2a5cc070833fe7d79ed4de81ad9cc62835f52b26cabb2d744c77a7298ae6e18602b783e2dc3ea62f5b244fb88b0a94af92e4c907f120c9f198d0384cb34b3eab879248cc2dba0549e5978af90e; cookiesession1=678B2871F50FB67FA42B2515130C8EB1")
                .body(body)
                .when().
                post( Utils.getGlobalValue("baseURLBillsPayment")+"/ubp/uat/payments/v1/transactions")
                .then().using().extract().response();
        System.out.println("response = " +response_BillsPayment.asString());
        response = response_BillsPayment;
    }

    //TC2.6_BillsPayment
    @Given("API request along with headers in POST method for BillsPayment CustomizedBiller forFailedPostingN failedTransaction with NoBillerPosting")
    public void api_request_along_with_headers_in_post_method_for_bills_payment_customized_biller_for_failed_posting_n_failed_transaction_with_no_biller_posting() throws IOException {

        //read data from local JSON file then store in byte array
        byte[] b = Files.readAllBytes(Paths.get("src/test/java/resources/Payload_RedHatOSPPOC/TC2.6_BillsPayment_customizedBiller_forFailedPostingN_FailedTransaction_NoBillerPosting.json"));
        //convert byte array to string
        String body = new String(b);

        response_BillsPayment = RestAssured.given()
                .spec(requestSpecification())
                .header("x-ibm-client-id","1262a40d-c298-40c3-a8b1-61952de3ccc0")
                .header("x-ibm-client-secret","eT0nI5pM4tL4lE3mX8gT3lY5eI6uJ5iY0fN1bW4pB4pG0iH0bW")
                .header("Reference-Id","jamesTesting")
                .header("Cookie","BIGipServerpool_api-uat.unionbankph_443=1763062538.47873.0000; TS012dd614=011667ddf0eee92b2a5cc070833fe7d79ed4de81ad9cc62835f52b26cabb2d744c77a7298ae6e18602b783e2dc3ea62f5b244fb88b0a94af92e4c907f120c9f198d0384cb34b3eab879248cc2dba0549e5978af90e; cookiesession1=678B2871F50FB67FA42B2515130C8EB1")
                .body(body)
                .when().
                post( Utils.getGlobalValue("baseURLBillsPayment")+"/ubp/uat/payments/v1/transactions")
                .then().using().extract().response();
        System.out.println("response = " +response_BillsPayment.asString());
        response = response_BillsPayment;

    }

    //TC2.7_BillsPayment
    @Given("API request along with headers in POST method for BillsPayment autopostingBiller XPower CiperEncryption")
    public void api_request_along_with_headers_in_post_method_for_bills_payment_autoposting_biller_x_power_ciper_encryption() throws IOException {

        //read data from local JSON file then store in byte array
        byte[] b = Files.readAllBytes(Paths.get("src/test/java/resources/Payload_RedHatOSPPOC/TC2.7_BillsPayment_autopostingBiller_XPower_CipherEncryption.json"));
        //convert byte array to string
        String body = new String(b);

        response_BillsPayment = RestAssured.given()
                .spec(requestSpecification())
                .header("x-ibm-client-id","1262a40d-c298-40c3-a8b1-61952de3ccc0")
                .header("x-ibm-client-secret","eT0nI5pM4tL4lE3mX8gT3lY5eI6uJ5iY0fN1bW4pB4pG0iH0bW")
                .header("Reference-Id","jamesTesting")
                .header("Cookie","BIGipServerpool_api-uat.unionbankph_443=1763062538.47873.0000; TS012dd614=011667ddf0eee92b2a5cc070833fe7d79ed4de81ad9cc62835f52b26cabb2d744c77a7298ae6e18602b783e2dc3ea62f5b244fb88b0a94af92e4c907f120c9f198d0384cb34b3eab879248cc2dba0549e5978af90e; cookiesession1=678B2871F50FB67FA42B2515130C8EB1")
                .body(body)
                .when().
                post( Utils.getGlobalValue("baseURLBillsPayment")+"/ubp/uat/payments/v1/transactions")
                .then().using().extract().response();
        System.out.println("response = " +response_BillsPayment.asString());
        response = response_BillsPayment;

    }

    //TC2.8_BillsPayment
    @Given("API request along with headers in POST method for BillsPayment for InvalidClientID")
    public void api_request_along_with_headers_in_post_method_for_bills_payment_for_invalid_client_id() throws IOException {

        //read data from local JSON file then store in byte array
        byte[] b = Files.readAllBytes(Paths.get("src/test/java/resources/Payload_RedHatOSPPOC/TC2.8_BillsPayment_InvalidClient-ID.json"));
        //convert byte array to string
        String body = new String(b);

        response_BillsPayment = RestAssured.given()
                .spec(requestSpecification())
                .header("x-ibm-client-id","")
                .header("x-ibm-client-secret","eT0nI5pM4tL4lE3mX8gT3lY5eI6uJ5iY0fN1bW4pB4pG0iH0bW")
                .header("Reference-Id","jamesTesting")
                .header("Cookie","BIGipServerpool_api-uat.unionbankph_443=1763062538.47873.0000; TS012dd614=011667ddf0eee92b2a5cc070833fe7d79ed4de81ad9cc62835f52b26cabb2d744c77a7298ae6e18602b783e2dc3ea62f5b244fb88b0a94af92e4c907f120c9f198d0384cb34b3eab879248cc2dba0549e5978af90e; cookiesession1=678B2871F50FB67FA42B2515130C8EB1")
                .body(body)
                .when().
                post( Utils.getGlobalValue("baseURLBillsPayment")+"/ubp/uat/payments/v1/transactions")
                .then().using().extract().response();
        System.out.println("response = " +response_BillsPayment.asString());
        response = response_BillsPayment;

    }

    //TC2.9_BillsPayment
    @Given("API request along with headers in POST method for BillsPayment InvalidClientSecret")
    public void api_request_along_with_headers_in_post_method_for_bills_payment_invalid_client_secret() throws IOException {
        //read data from local JSON file then store in byte array
        byte[] b = Files.readAllBytes(Paths.get("src/test/java/resources/Payload_RedHatOSPPOC/TC2.9_BillsPayment-InvalidClient-secret.json"));
        //convert byte array to string
        String body = new String(b);

        response_BillsPayment = RestAssured.given()
                .spec(requestSpecification())
                .header("x-ibm-client-id","1262a40d-c298-40c3-a8b1-61952de3ccc0")
                .header("x-ibm-client-secret","")
                .header("Reference-Id","jamesTesting")
                .header("Cookie","BIGipServerpool_api-uat.unionbankph_443=1763062538.47873.0000; TS012dd614=011667ddf0eee92b2a5cc070833fe7d79ed4de81ad9cc62835f52b26cabb2d744c77a7298ae6e18602b783e2dc3ea62f5b244fb88b0a94af92e4c907f120c9f198d0384cb34b3eab879248cc2dba0549e5978af90e; cookiesession1=678B2871F50FB67FA42B2515130C8EB1")
                .body(body)
                .when().
                post( Utils.getGlobalValue("baseURLBillsPayment")+"/ubp/uat/payments/v1/transactions")
                .then().using().extract().response();
        System.out.println("response = " +response_BillsPayment.asString());
        response = response_BillsPayment;
    }

}

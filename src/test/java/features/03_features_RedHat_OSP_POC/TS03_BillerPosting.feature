@OSP
@BillerPosting
Feature: TS03_BillerPosting

@TC3.1_BillerPosting
Scenario: TC3.1 -  Biller Posting -  Normal Biller with Cipher Encryption (X Power)
  Given API request along with headers in POST method for BillerPosting Normal Biller with Cipher Encryption
  Then The API call is success with status code 200
  And I verify "message" in response body is "Successfully posted to biller."
  And I verify "details.msg" in response body is "Success"
  And I verify "details.code" in response body is "1"

  @TC3.2_BillerPosting
  Scenario: TC3.2 - Biller Posting -  Normal Biller with Hash Encryption (Fyintegrate)
    Given API request along with headers in POST method for BillerPosting Normal Biller with Hash Encryption
    Then The API call is success with status code 200
    And I verify "message" in response body is "Successfully posted to biller."
    And I verify "details.status" in response body is "success"
    And I verify "details.message" in response body is "Transaction marked as processed"

  @TC3.3_BillerPosting
   Scenario: TC3.3 - Biller Posting -  Customized Biller -  forFailedPosting Y - successful transaction with biller posting
    Given API request along with headers in POST method for BillerPosting Customized Biller forFailedPostingY SuccessfulTransaction
    Then The API call is success with status code 200
    And I verify "message" in response body is "Successfully posted to biller."
    And I verify "details.status" in response body is "success"
    And I verify "details.message" in response body is "Transaction marked as processed"

  @TC3.4_BillerPosting
Scenario: TC3.4 - Biller Posting -  Customized Biller -  forFailedPosting N - succesful transaction with biller posting
  Given API request along with headers in POST method for BillerPosting Customized Biller forFailedPostingN SuccessfulTransaction
  Then The API call is success with status code 200
  And I verify "message" in response body is "Successfully posted to biller."
  And I verify "details.status" in response body is "success"
  And I verify "details.message" in response body is "Transaction marked as processed"
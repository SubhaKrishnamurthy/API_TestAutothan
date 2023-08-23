@OSP
@BillsPayment
Feature: TS02_BillsPayment

@TC2.1_BillsPayment
Scenario: TC2.1 Bills Payment - with autoposting biller ( Fyintegrate) with Hash Encryption
  Given API request  along with headers in POST method for BillsPayment AutoPosting biller
  Then The API call is success with status code 200
  And I verify "forPosting" in response body is "11B"
  And I verify "billerPosting" in response body is "success"
  And I verify "details.status" in response body is "success"
  And I verify "details.message" in response body is "Transaction marked as processed"

@TC2.2_BillsPayment
Scenario: TC2.2  Bills Payment -  with no autoposting biller
  Given API request along with headers in POST method for BillsPayment NoAutoPosting biller
  Then The API call is success with status code 200
  And I verify "forPosting" in response body is "10B"
  And I verify "billerPosting" in response body is "N/A"

  @TC2.3_BillsPayment
  Scenario: TC2.3  Bills Payment - customized biller - forFailedPosting Y - successful transaction with biller posting
   Given API request along with headers in POST method for BillsPayment forFailedPostingY and successful transaction
    Then The API call is success with status code 200
    And I verify "status" in response body is "S"
    And I verify "message" in response body is "Transaction Posted."
    And I verify "forPosting" in response body is "11B"
    And I verify "billerPosting" in response body is "success"
    And I verify "details.status" in response body is "success"
    And I verify "details.message" in response body is "Transaction marked as processed"

  @TC2.4_BillsPayment
    Scenario: TC2.4  Bills Payment - customized biller - forFailedPosting Y -  failed transaction (invalid account number) with biller posting
    Given API request along with headers in POST method for BillsPayment forFailedPostingY and failed transaction
    Then The API call is success with status code 400
    And I verify "errors.status" in response body[] is "[[F]]"
    And I verify "autopost.billerPosting" in response body is "[success]"
    And I verify "autopost.forPosting" in response body is "[11B]"
    And I verify "autopost.details.status" in response body is "[success]"
    And I verify "autopost.details.message" in response body is "[Transaction marked as processed]"

  @TC2.5_BillsPayment
  Scenario: TC2.5  Biller Payment - customized biller -forFailedPosting N -  successful transaction with biller posting
  Given API request along with headers in POST method for BillsPayment for Failed PostingN and successful transaction
    Then The API call is success with status code 200
    And I verify "status" in response body is "S"
    And I verify "message" in response body is "Transaction Posted."
    And I verify "forPosting" in response body is "11B"
    And I verify "billerPosting" in response body is "success"
    And I verify "details.status" in response body is "success"
    And I verify "details.message" in response body is "Transaction marked as processed"

  @TC2.6_BillsPayment
  Scenario: TC2.6  Biller Payment - customized biller -forFailedPosting N -  failed transaction with no biller posting
   Given API request along with headers in POST method for BillsPayment CustomizedBiller forFailedPostingN failedTransaction with NoBillerPosting
    Then The API call is success with status code 400
    And I verify "errors.code" in response body is "[F]"

  @TC2.7_BillsPayment
  Scenario: TC2.7  Biller Payment - with autoposting biller (X Power) with Cipher Encryption
    Given API request along with headers in POST method for BillsPayment autopostingBiller XPower CiperEncryption
    Then The API call is success with status code 200
    And I verify "status" in response body is "S"
    And I verify "message" in response body is "Transaction Posted."
    And I verify "forPosting" in response body is "11B"
    And I verify "billerPosting" in response body is "success"
    And I verify "details.msg" in response body is "Success"

  @TC2.8_BillsPayment
  Scenario: TC2.8 Biller Payment - invalid client-id
    Given API request along with headers in POST method for BillsPayment for InvalidClientID
    Then The API call is success with status code 401
    And I verify "httpCode" in response body is "401"
    And I verify "httpMessage" in response body is "Unauthorized"
    And I verify "moreInformation" in response body is "Invalid client id or secret."


  @TC2.9_BillsPayment
   Scenario: TC2.9 Bills Payment - invalid client-secret
     Given API request along with headers in POST method for BillsPayment InvalidClientSecret
    Then The API call is success with status code 401
    And I verify "httpCode" in response body is "401"
    And I verify "httpMessage" in response body is "Unauthorized"
    And I verify "moreInformation" in response body is "Invalid client id or secret."
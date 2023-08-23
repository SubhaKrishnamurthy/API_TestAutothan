@OSDAccounts
@OSD
@GetAccountByProductNumber
Feature: TS05_GetAccountByProductNumber

@TC5.1_Valid_Debit_product_token_with_valid_access_token
Scenario: TC5.1 Valid Debit product token with valid access token
  Given API for getAccountByProductNumber Debit with valid access token in Get method
  Then The API call is success with status code 200

@TC5.2_Valid_Credit_product_token_with_valid_access_token
Scenario: TC5.2 Valid Credit product token with valid access token
  Given API for getAccountByProductNumber Credit with valid access token in Get method
  Then The API call is success with status code 200

@TC5.3_Valid_Product_token_with_invalid_access_token
Scenario: TC5.3 Valid Product token with invalid access token
  Given API for getAccountByProductNumber Credit with invalid access token in Get method
  Then The API call is success with status code 403

@TC5.4_Invalid_Product_token_with_valid_access_token
Scenario: TC5.4 Invalid Product token with valid access token
  Given API for getAccountByProductNumber Credit with invalid productToken and valid access token in Get method
  Then The API call is success with status code 404

@TC5.5_No_access_token
Scenario: TC5.5 No access token
  Given API for getAccountByProductNumber Credit with no access token in Get method
  Then The API call is success with status code 500
  Then I verify "details" in response body contains "Error id "
  Then I verify "stack" in response body is ""

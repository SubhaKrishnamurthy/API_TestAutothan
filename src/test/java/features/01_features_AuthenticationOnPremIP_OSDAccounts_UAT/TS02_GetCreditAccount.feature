@OSDAccounts
@OSD
@GetCreditAccounts
Feature: TS02_Get Credit Accounts

@TC2.1_WithValidAccessToken
Scenario: TC2.1 With valid access token
  Given API for GetCreditAccounts with valid access token in Get method
  Then The API call is success with status code 200

  @TC2.2_WithInvalidAccessToken
  Scenario: TC1.2 With invalid access token
    Given API for GetCreditAccounts With invalid access token in Get method
    Then The API call is success with status code 200

  @TC2.3_WithNoAccessToken
  Scenario: TC1.3 With no access token
    Given API for GetCreditAccounts With no access token in Get method
    Then The API call is success with status code 500
    Then I verify "details" in response body contains "Error id "
    Then I verify "stack" in response body is ""

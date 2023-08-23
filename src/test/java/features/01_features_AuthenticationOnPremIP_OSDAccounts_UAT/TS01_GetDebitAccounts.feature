@OSDAccounts
@OSD
@GetDebitAccounts
Feature: TS01_Get Debit Accounts

@TC1.1_WithValidAccessToken
Scenario: TC1.1  With valid access token
Given API for GetDebitAccounts with valid access token in Get method
Then The API call is success with status code 200

@TC1.2_WithInvalidAccessToken
Scenario: TC1.2 With invalid access token
Given API for GetDebitAccounts With invalid access token in Get method
Then The API call is success with status code 200

@TC1.3_WithNoAccessToken
Scenario: TC1.3 With no access token
Given API for GetDebitAccounts With no access token in Get method
Then The API call is success with status code 500
Then I verify "details" in response body contains "Error id "
Then I verify "stack" in response body is ""







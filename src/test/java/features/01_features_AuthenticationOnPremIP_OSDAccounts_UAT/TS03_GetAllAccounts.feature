@OSDAccounts
@OSD
@GetAllAccounts
Feature: TS03_GetAllAccounts

@TC3.1_WithValidAccessToken
  Scenario: TC3.1_WithValidAccessToken
Given API for getAllAccounts with valid access token in Get method
  Then The API call is success with status code 200

@TC3.2_WithInvalidAccessToken
  Scenario: C3.2_WithInvalidAccessToken
Given API for getAllAccounts with invalid access token in Get method
  Then The API call is success with status code 200

@TC3.3_WithNoAccessToken
  Scenario: TC3.3_WithNoAccessToken
Given API for getAllAccounts with no access token in Get method
  Then The API call is success with status code 400
  Then I verify "Error" in response body is "Access-Token in header can't be null"


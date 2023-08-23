@OSDAccounts
@OSD
@GetAccountBalance
Feature: TS04_GetAccountBalance

@TC4.1_Valid_Debit_account_with_valid_access_token
Scenario: TC4.1 Valid Debit account with valid access token
  Given API for getAccountBalanceDebit with valid access token in Get method
  Then The API call is success with status code 200

@TC4.2_Valid_Credit_account_with_valid_access_token
  Scenario: TC4.2_Valid_Credit_account_with_valid_access_token
 Given API for getAccountBalanceCredit with valid access token in Get method
  Then The API call is success with status code 200

@TC4.3_Valid_Credit_Account_with_invalid_access_token
  Scenario: TC4.3_Valid_Credit_Account_with_invalid_access_token
 Given API for getAccountBalanceCredit with valid credit account and invalid access token in Get method
  Then The API call is success with status code 403

@TC4.4_Invalid_Credit_account_with_valid_access_token
  Scenario: TC4.4 Invalid account with valid access token
  Given API for getAccountBalanceCredit with invalid credit account and valid access token in Get method
  Then The API call is success with status code 404

@TC4.5_Invalid_credit_account_with_invalid_access_token
Scenario: TC4.5 Invalid account with invalid access token
  Given API for getAccountBalanceCredit with invalid credit account and invalid access token in Get method
  Then The API call is success with status code 403

@TC4.6_No_Account_with_valid_access_token
Scenario: TC4.6 No account with valid access token
  Given API for getAccountBalanceCredit with no account and valid access token
  Then The API call is success with status code 404

@TC4.7_No_account_with_no_access_token
  Scenario: TC4.7 No account with no access token
  Given API for getAccountBalanceCredit with no account and no access token
  Then The API call is success with status code 500
  Then I verify "details" in response body contains "Error id "
  Then I verify "stack" in response body is ""




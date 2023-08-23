@ADAService
@GetAccountsByType
@ADA1
Feature: Get accounts by Type


@TC1.1_ValidAccounType_credit_withValidAccessToken
  Scenario: TC1.1 Valid account type (credit) with valid access token
  Given API for GetAccountsByType for Valid account type (credit) with valid access token in Get method
  Then The API call is success with status code 200
  And I store the "id[1]" from the response body of ValidCreditAccount as "target_token"


@TC1.2_ValidAccountType_debit_withValidAccessToken
  Scenario: TC1.2 Valid account type (debit) with valid access token
  Given API for GetAccountsByType for Valid account type (debit) with valid access token in Get method
  Then The API call is success with status code 200
  And I store the "id[1]" from the response body of ValidDebitAccount as "source_token"

@TC1.3_ValidAccountTypeWithInvalidToken
  Scenario: TC1.3 Valid account type with invalid token
  Given API for GetAccountsByType for Valid account type with invalid token in Get method
  Then The API call is success with status code 422


@TC1.4_NoAccessToken
  Scenario: TC1.4 No access token
  Given API for GetAccountsByType with No access token in Get method
  Then The API call is success with status code 400


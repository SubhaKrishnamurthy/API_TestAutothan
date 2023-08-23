@ADAService
@GetADA
@ADA1
Feature: Get ADA

  @TC2.2_CreditAccountWithADA
  Scenario: TC2.2 Credit account with ADA:
    Given API for GetADA for CreditAccountWithADA in Get method
    Then The API call is success with status code 200

@TC2.1_CreditAccountWithNoADA
Scenario: TC2.1 Credit account with no ADA
  Given API for GetADA for CreditAccountWithNoADA in Get method
  Then The API call is success with status code 200



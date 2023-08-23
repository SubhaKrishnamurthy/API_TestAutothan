@ADAService
@ValidateADA
  @ADA1
Feature: ValidateADA

  @TC4.1_ValidADA
Scenario: TC4.1 Valid ADA
  Given API for ValidADA in POST method
  Then The API call is success with status code 200

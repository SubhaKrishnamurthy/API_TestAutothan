@ADAService
@CreateADA
@ADA1
Feature: Create ADA

  @TC3.1_CreateADAusingValidTargetToken
Scenario: TC3.1 Create ADA using valid target token
    Given API for CreateADA for CreateADAusingValidTargetToken in POST method
    Then The API call is success with status code 201
    And store the "request_id" from the response body of CreateADA


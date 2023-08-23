@Authentication
@OSD
@ADA1
Feature:Authentication - Monolith (API to get Access Token)

  #Monolith (API to get Access Token)
@OTP
Scenario Outline: 1. OTP
  Given API request "<user_id>" "<password>" "<udid>" along with headers in POST method
  Then The API call is success with status code 202
  And I verify "otp_type" in response body is "2"
  And store the "request_id" from the response body
Examples:
  | user_id   |  |  |  | password  | udid |  |
  | teameight |  |  |  | p@55w0rd1 | 123  |  |


  @LoginOTP
  Scenario Outline: 2. OTP Login
    Given API request "request_id" and "<code>" in POST method
    Then The API call is success with status code 200
    And store the accessToken "access_token" from the response body
    Examples:
      | code   |
      | 222222 |


    @GetUserID
Scenario: 3. GetUserID
      Given API for GetUserID in Get method
      Then The API call is success with status code 200
      And I verify "response_code" in response body is "SUCCESS"
      And I verify "message" in response body is "access token is valid."
      And I store the "user.id" from the response body of ValidCreditAccount as "target_token"





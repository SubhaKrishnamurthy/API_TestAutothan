
@Encryption
Feature: TS01_Encryption

@HashEncrypt
Scenario Outline: TC1.1 Hash Encrypt - Fyintegrate (PDAX)
  Given API request "<key>" "<stringToHash>" "<algo>" "<encoding>" along with headers in POST method for Hash Encrypt
  Then The API call is success with status code 200
  #And I verify "otp_type" in response body is "2"
  #And store the "request_id" from the response body
  And I see the response

Examples:
  | key                      | stringToHash                              | algo   | encoding |  |  |
  | j5HeTziURQkcQbN57CUHnyPm | 1663738856.26POSTapi/UPay/PostUPayDeposit | sha256 | hex      |  |  |


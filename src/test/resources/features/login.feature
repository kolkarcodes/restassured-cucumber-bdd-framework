Feature: Login API Testing

  @smoke @login
  Scenario: Verify the user is able to login successfully

    When user sends login request with username "customer3@practicesoftwaretesting.com" and password "pass123"
    Then response status code should be 200
    And response should contain access token

   @smoke @login
  Scenario: Verify the admin is able to login successfully

    When user sends login request with username "admin@practicesoftwaretesting.com" and password "welcome01"
    Then response status code should be 200
    And response should contain access token

  @negative @login
  Scenario: Verify invalid login

    When user sends login request with username "121@practicesoftwaretesting.com" and password "wrong123"
    Then response status code should be 401
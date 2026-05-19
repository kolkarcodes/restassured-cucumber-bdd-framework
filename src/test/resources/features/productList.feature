Feature: Product List API

@smoke
  Scenario: Verify all products are returned successfully

    Given user sets product list API endpoint
    When user sends GET request for product list
    Then response status code should be 200
    And response should contain products
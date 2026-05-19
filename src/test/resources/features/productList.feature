Feature: Product List API

@smoke @product
  Scenario: Verify all products are returned successfully

    When user sends GET request for product list
    Then response status code should be 200
    And response should contain products
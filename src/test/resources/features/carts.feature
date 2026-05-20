

Feature: Cart API Testing

  @carts  @smoke
  Scenario: Verify user can add product to cart successfully
    When user adds product "01KS2D8G8F7Y32SXJJD3M0TPHT" with quantity 1 to cart
    Then response status code should be 201
    And response should contain cart id


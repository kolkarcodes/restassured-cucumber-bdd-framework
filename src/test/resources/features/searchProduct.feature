

Feature: Search Product API Testing

  @searchProduct
  Scenario Outline: Verify products are returned successfully for different search keyword

    When user searches product with keyword "<searchKeyword>"
    Then response status code should be 200
    And response should contain searched product "<searchKeyword>"
    Examples:
    | searchKeyword |
    |Thor           |
    | Hammer        |
    |Pliers         |
    |Wrench         |
    | Screwdriver |
    | Saw         |
    | Drill       |


@authentication
Feature: Add to cart
  Scenario: Add one quantity to the cart
    Given I am on the store Page
    When I add "Blue Shoes" to the cart
    Then I should see 1 "Blue Shoes" in the cart

  Scenario Outline: Add one quantity from Store - examples
    Given I am on the store Page
    When I add "<product_name>" to the cart
    Then I should see 1 "<product_name>" in the cart
    Examples:
      | product_name                    |
      | Blue Shoes |
      | Anchor Bracelet                 |



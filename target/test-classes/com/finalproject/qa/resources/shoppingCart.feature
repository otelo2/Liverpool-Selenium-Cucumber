@ShoppingCart
Feature: Shopping cart feature File

  Background: Logged in with standard_user
    Given navigate to Saucedemo login page in <browser>
    And login with the standard_user credentials

  Scenario Outline: Add product to cart and check the name of the product in the cart
    Given i am in the home page
    When i add the <number> product to the cart
    And i go to the shopping cart page
    Then the name of the product in the cart should match the <expected> name

    Examples: 
      | number | expected                |
      |      1 | Sauce Labs Backpack     |
      |      2 | Sauce Labs Bike Light   |
      |      3 | Sauce Labs Bolt T-Shirt |

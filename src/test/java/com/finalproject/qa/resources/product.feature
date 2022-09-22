@Product
Feature: Product feature File

  Background: Logged in with standard_user
    Given navigate to Saucedemo login page in <browser>
    And login with the standard_user credentials

  Scenario Outline: Verify the price of the products
    Given i am in the home page
    When i check the price of the <number> product
    Then the actual price should match the <expected> price

    Examples: 
      | number | expected |
      |      1 | $29.99   |
      |      2 | $9.99    |
      |      3 | $15.99   |
      |      4 | $49.99   |
      |      5 | $7.99    |
      |      6 | $15.99   |

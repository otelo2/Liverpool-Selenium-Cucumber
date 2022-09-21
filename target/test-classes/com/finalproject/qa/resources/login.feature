Feature: Login Feature File

  @Login
  Scenario Outline: Go to the login page and fail to log in because the user doesn't exist
    Given navigate to Luma home page in <browser>
    When click on sign in button
    And type the non existing email <email>
    And type the non existing password <password>
    And click on the sign in button
    Then an error message should appear

    Examples: 
      | browser | email   | password |
      | chrome  | a@a.com | a        |

Feature: Login Feature File

  @Login
  Scenario Outline: Go to the login page and fail to log in because the user doesn't exist
    Given navigate to Saucedemo login page in <browser>
    When type the non existing username <username>
    And type the non existing password <password>
    And click on the login button
    Then an error message should appear

    Examples: 
      | browser | username | password |
      | chrome  | John     | a        |

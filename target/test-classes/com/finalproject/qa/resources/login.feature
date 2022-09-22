@Login
Feature: Login Feature File

  @Negative
  Scenario Outline: Go to the login page and fail to log in because the user doesn't exist
    Given navigate to Saucedemo login page in <browser>
    When type the non existing username <username>
    And type the non existing password <password>
    And click on the login button
    Then an error message should appear

    Examples: 
      | browser | username | password |
      | chrome  | John     | a        |

  @Positive
  Scenario Outline: Login with the standard_user username
    Given navigate to Saucedemo login page in <browser>
    When login with the standard_user credentials
    Then i should log in to the store home page

    Examples: 
      | browser |
      | chrome  |

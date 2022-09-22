@Login
Feature: Login Feature File

  @Negative
  Scenario Outline: Fail to log in because the user doesn't exist
    Given navigate to Saucedemo login page in <browser>
    When type the non existing username <username>
    And type the non existing password <password>
    And click on the login button
    Then an error message should appear <error>

    Examples: 
      | browser | username | password | error                                                                     |
      | chrome  | John     | a        | Epic sadface: Username and password do not match any user in this service |

  @Negative
  Scenario Outline: Fail to log in because user is locked out
    Given navigate to Saucedemo login page in <browser>
    When type the non existing username <username>
    And type the non existing password <password>
    And click on the login button
    Then an error message should appear <error>

    Examples: 
      | browser | username        | password     | error                                               |
      | chrome  | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out. |

  @Positive
  Scenario Outline: Login with the standard_user username
    Given navigate to Saucedemo login page in <browser>
    When login with the standard_user credentials
    Then i should log in to the store home page

    Examples: 
      | browser |
      | chrome  |

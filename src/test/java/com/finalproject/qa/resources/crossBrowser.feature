Feature: Login Feature File

  @selenium
  Scenario Outline: Go to google and make a search on multiple browsers
    Given navigate to Google frontpage in <browser>
    When perform a search of <term>
    Then search result should be displayed of <term>

    Examples: 
      | browser | term       |
      | chrome  | sushi      |
      | firefox | nvidia     |
      | edge    | gta 6 leak |

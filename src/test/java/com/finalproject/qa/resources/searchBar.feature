@SearchBar
Feature: Search Bar Feature File

Scenario Outline: Find one or more articles of my interest
  Given navigate to Liverpool home page in <browser>
   When locate the search bar on the top of the screen and click on it
    And type the name of an <article> in the search bar
   Then the search results page is displayed

  Examples: 
    | browser | article | 
    | firefox | Lámpara |

Scenario Outline: Perform search without anything written in the search box
  Given navigate to Liverpool home page in <browser>
   When locate the search bar on the top of the screen and click on it
    And type the name of an <article> in the search bar
   Then all the products of the store are displayed

  Examples: 
    | browser | article | 
    | firefox | ""      | 

Scenario Outline: Be notified if there are no articles
  Given navigate to Liverpool home page in <browser>
   When locate the search bar on the top of the screen and click on it
    And type the name of an <article> in the search bar
   Then a screen states that there are no matches for the input data is displayed

  Examples: 
    | browser | article                                  | 
    | firefox | jsdfasdjkfkasdfjkasdfjksdfjkjklsdfjklasf | 

Scenario Outline: Search the articles by brand with a special page
  Given navigate to Liverpool home page in <browser>
   When locate the search bar on the top of the screen and click on it
    And type the name of an <brand> in the search bar
   Then a special screen with products of that <brand> shows up

  Examples: 
    | browser | brand | 
    | firefox | GAP   |
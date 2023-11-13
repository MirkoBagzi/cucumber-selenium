Feature: Google Search

  Scenario: Search Google via inputting value inside Search field
    Given user is on homepage
    When user inputs QStation
    And user clicks search button
    Then user is shown search results that contains QStation
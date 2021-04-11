Feature: Login tests

  Scenario Outline: Basic login
    Given I open the site url "<url>"
    When I enter credentials and click login
    Then I'm logged in

    Examples:
      | url                        |
      | https://www.saucedemo.com/ |

  Scenario: Test 2
    Given I open the site url "<string>"
     
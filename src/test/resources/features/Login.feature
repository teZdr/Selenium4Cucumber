Feature: All

  Scenario Outline: Basic login
    Given I open the site url "<url>"
    When I enter credentials and click login
    Then I'm logged in

    Examples:
      | url                        |
      | https://www.saucedemo.com/ |

  Scenario Outline: Basic login2
    Given I open the site url "<url>"
    When I enter credentials and click login
    Then I'm logged in

    Examples:
      | url                        |
      | https://www.saucedemo.com/ |
      | https://www.saucedemo.com/ |
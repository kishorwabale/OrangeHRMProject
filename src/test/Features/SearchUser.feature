Feature: Search user

  @ACV-Test002
  Scenario: Search user with valid data
    Given login to orangehrm web
    When user navigate to admin section
    And  user enter valid data
    Then verify record found for valid data
    And logout from orangehrm
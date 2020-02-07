Feature: Application login

  Scenario: Check if user is able to featch details from openweathermap API
    Given I want to execute openweathermap API
    When  User want to check the Response Code is 200
    Then  User should be able to see the Weather Details
    And  User should be able to see the Weather Description

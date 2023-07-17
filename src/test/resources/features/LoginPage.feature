Feature: Login to sauceLabsDemo Application

  Background: 
    Given User is on sauceLabsDemo page "https://www.saucedemo.com/"

  @ValidCredentials
  Scenario: Login with valid credentials
    When User enters username as "standard_user" and password as "secret_sauce"
    Then User should be able to login sucessfully and new page open

  @InvalidCredentials
  Scenario Outline: Login with invalid credentials
    When User enters username as "<username>" and password as "<password>"
    Then User should be able to see error message "<errorMessage>"

    Examples: 
      | username | password  | errorMessage                                                              |
      | Admin    | admin12$$ | Epic sadface: Username and password do not match any user in this service |
      | admin$$  | admin123  | Epic sadface: Username and password do not match any user in this service |
      | abc123   | xyz$$     | Epic sadface: Username and password do not match any user in this service |

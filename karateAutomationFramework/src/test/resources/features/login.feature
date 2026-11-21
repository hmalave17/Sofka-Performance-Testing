@regression
Feature: User authentication

  Background:
    * url baseUrl
    * path 'login'
    * header Content-Type = 'application/json'
    * def users = read('classpath:data/users.json')
    * def errorSchema = read('classpath:schemas/error-response.json')

  @login @positive @regression
  Scenario: Successfully login with valid credentials
    Given request users.existingUser
    When method post
    Then status 200
    And match response contains 'Auth_token:'

  @login @negative @regression
  Scenario: Attempt to login with invalid credentials
    Given request users.invalidLogin
    When method post
    Then status 200
    And match response == errorSchema
    And match response.errorMessage == 'Wrong password.'

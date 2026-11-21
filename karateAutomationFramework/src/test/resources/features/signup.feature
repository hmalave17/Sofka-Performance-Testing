@regression
Feature: User registration

  Background:
    * url baseUrl
    * path 'signup'
    * header Content-Type = 'application/json'
    * def users = read('classpath:data/users.json')
    * def errorSchema = read('classpath:schemas/error-response.json')

  @signup @positive
  Scenario: Successfully register a new user
    * def username = generateUsername()
    * def password = users.newUser.password
    * def requestBody = read('classpath:data/requests/signup-request.json')
    Given request requestBody
    When method post
    Then status 200
    And match response.trim() == '""'

  @signup @negative
  Scenario: Attempt to register an existing user
    Given request users.existingUser
    When method post
    Then status 200
    And match response == errorSchema
    And match response.errorMessage == 'This user already exist.'

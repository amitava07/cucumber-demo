Feature: The Login Page
  As a returning customer
  I want to login to the application
  So that I can view my account balance

Background:
  Given the user is on login page

@ignore
Scenario: The user should be able to login with valid credentials
  When the user enters valid credentials
  Then the user should be able to see their account balance

@ignore
Scenario: The user should not be able to login with bad credentials
  When the user enters bad credentials
  Then the user should not be able to login
  And the user should get an invalid login message

  @ignore
Scenario: the user should be able to login
  When user enters username as "tim@testemail.com"
  And user enters password as "trpass"
  And user clicks on login button
  Then the user should be able to see their account balance

Scenario Outline: the user should be able to login
  When the user enters username as "<username>" and password as "<password>"
  Then the user should be able to see their account balance

Examples:
  | username | password |
  | tim@testemail.com | trpass |
  | lisa@testemail.com | lpass |

Scenario: after a failed attempt, the user should be able to login again
  When the user enters a set of "<username>" and "<password>"
  | username | password |
  | lisa@testemail.com | lpass |
  | tim@testemail.com | trpass |
  Then the user should be able to see their account balance

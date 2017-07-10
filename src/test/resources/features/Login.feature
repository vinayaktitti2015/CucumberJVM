#Author: vinayak@iproperty.com
@login
Feature: Login Feature
  As a consumer I login to iproperty website 
  And search for property

  Background: Open Irealtor and Login
    Given I open Iproperty Website
    And I implicitly wait for "2" seconds
    And I delete all cookies
    And I refresh page

  @positivescenario
  Scenario Outline: Verify Successfull Sign-In
    #Then I should see "Find Malaysia Property & Real Estate"
    When I click on login button
    Then I should see "Sign-In"
    And I enter Username "<username>"
    And I enter Password "<password>"
    And I click submit button
    And I sleep for few seconds
    Then I should see account name "Hello, iproperty !"
    And I Logout as user

    Examples: 
      | username                | password  |
      | ipropertytest@gmail.com | Test@1234 |

  @negativescenario
  Scenario Outline: Verify Invalid Username
    When I click on login button
    And I enter Username "<username>"
    And I enter Password "<password>"
    And I click submit button
    And I sleep for few seconds
    Then I should see alert text as "<message>"
    And I accept alert

    Examples: 
      | username          | password  | message                     |
      | ipropertytest@com | Test@1234 | Please enter a valid Email. |

  @negativescenario
  Scenario Outline: Verify Invalid Password
    When I click on login button
    And I enter Username "<username>"
    Then I enter Password "<password>"
    And I click submit button
    And I sleep for few seconds
    Then I should see alert text as "<message>"
    And I accept alert

    Examples: 
      | username                | password | message                     |
      | ipropertytest@gmail.com |          | Please enter Your Password. |

  @deletecookies
  Scenario: verify Delete Cookies
    When I login as Consumer
    Then I should see account name "Hello, iproperty !"
    And I delete all cookies
    When I refresh page
    Then I should not see "Hello, iproperty !"

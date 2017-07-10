@appscan
#noinspection CucumberUndefinedStep
Feature: Automated Security Scanning
  Run automated application level security tests using ZAP

  Background:
    Given a new scanning session
    And a scanner with all policies disabled
    And all existing alerts are deleted
    And the application is navigated
    And the application is spidered

  Scenario: The application should not contain SQL Injection vulnerabilities
    And the SQL-Injection policy is enabled
    And the attack strength is set to High
    And the alert threshold is set to low
    When the scanner is run
    Then no medium or higher risk vulnerabilities should be present

  Scenario: The application should not contain XSS vulnerabilities
    And the CrossSiteScripting policy is enabled
    And the attack strength is set to High
    And the alert threshold is set to low
    When the scanner is run
    Then no medium or higher risk vulnerabilities should be present

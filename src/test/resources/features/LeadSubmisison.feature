@leadsubmission
Feature: Lead Submission Malaysia
  In order to contact the developer
  As a user
  I need to be able to complete an application form

  Background: 
    Given I open Iproperty Website
    And I navigate to newlaunch sub-page
    Then I implicitly wait for few seconds

  @datatable
  Scenario: Verify Lead submission with Valid data
    When I search for "Iproperty Test"
    And I click search button
    Then I should see listing as "Iproperty Test Listing Production(for test purpose"
    And I click on view details button
    And I implicitly wait for few seconds
    And I submit the lead submisison form with valid data
      | Fields  | Value                   |
      | Name    | Rex                     |
      | Email   | Morg123@bing.com        |
      | Phone   |             65334832323 |
      | Country | Singapore               |
      | Remarks | For Test - Purpose Only |
    And I hit submit button
    Then I check that the form has been succesfully submitted
    And I check that the lead parsing to database succesfully

  @datadriven
  Scenario Outline: Open iproperty website and fill multiple lead submissions
    When I search for "Iproperty Test"
    And I click search button
    Then I should see listing as "Iproperty Test Listing Production(for test purpose"
    And I click on view details button
    And I fill "<firstname>" "<email>" "<phone>" "<country>" "<remarks>"
    And I hit submit button
    Then I should see thankyou message

    Examples: 
      | firstname | email                | phone         | country   | remarks                   |
      | Pradeep   | kumar.test@gmail.com | 60-29203232   | Indonesia | For Test Purpose Only     |
      | Greg      | Mont_test@yahoo.com  | +60-223423222 | Japan     | For Test Purpose Only 123 |

  # Lead Submission Module
  Scenario: Complete the Lead Submisison form
    When I navigate to detailspage
    And I fill all fields on the form and submit
    Then I should see Thankyou page

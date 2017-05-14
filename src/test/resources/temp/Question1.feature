#Author: vinayak.selenium@gmail.com
@tag
Feature: Develop Sitecore Automation scripts
  In order to add sample item 
  As a user 
  I need to go to Sitecore website

  @tag1
  Scenario: Add Sample Item in Content Editor
    Given I open sitecore website
    When I enter username "Admin"
    Then I enter Password "P@ssw0rd1"
    And I click on Login button
    Then I should see text "Sitecore Experience Platform"
    And I should see text "Content Editing"
    And I click on content editor link
    Then I implicitly wait for "2" seconds
    Then I should see text "Home"
    And I should see text "Welcome to Sitecore."
    And I mouse hover to Home button
    And I right click on home button
    Then I click on sample item
    And I implicitly wait for "3" seconds
    And I switch to main content
    And I switch to frame having id "jqueryModalDialogsFrame"
    And I switch to frame having id "scContentIframeId0"
    And I implicitly wait for "2" seconds
    When I enter name "Test" in the editbox
    And I click on OK button
    And I switch parent frame
    When I switch to main content
    And I click on Review Button
    Then I click on submit button
    And I implicitly wait for "2" seconds
    And I switch to frame having id "jqueryModalDialogsFrame"
    And I switch to frame having id "scContentIframeId0"
    Then I enter "Test" in comments section
    And I click on OK ON COMMENTS button
    And I click on Publish button
    Then I click on Approve button

  @tag2
  Scenario: Clone git repo
   Given I open github website
    Then I click on repositories 
    And I click on EACourse APP
    And I implicitly wait for "3" seconds
    And I click on clone or downlaod
    And I implicitly wait for "3" seconds
    And I clone repo
    
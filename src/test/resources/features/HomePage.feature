@homepage
Feature: Search Property
  As a consumer I go to Iproperty Website
  And search properties in Malaysia

  Background:
    Given I open Iproperty Website
    And I navigate to newlaunch sub-page

  @searchPropType
  Scenario: search PropertyType to check correct results on SERP
    When I select "Condo/Serviced Residence" as propType
    And I click search button
    And I implicitly wait for few seconds
    Then The propType should contain "Serviced Residence, Serviced Apartment, Condominium, Soho"
    And I should see "Serviced Residence"
    And I should see "Serviced Apartment"
    And I should see "Condominium"
    And I should not see "Terrace/Link House"
    Then The parsing URL should be like "/listing/condo__serviced-residence/all-state/"
    And The breadcrumb should be like "Properties > New Property Launch > New Condo/Serviced Residence for Sale"
    And The header should be like "New Condo/Serviced Residence For Sale"

  @searchPropType
  Scenario Outline: search PropertyType to check correct results on SERP
    When I select "<propType>" as propType
    And I click search button
    And I implicitly wait for few seconds
    Then The propType should contain "<expectedpropType>"
    Then The parsing URL should be like "<URL>"
    And The breadcrumb should be like "<breadcrumb>"
    And The header should be like "<header>"

    Examples:
      | propType                 | expectedpropType                                                                                            | URL                                           | breadcrumb                                                               | header                                |
      | Condo/Serviced Residence | Serviced Residence, Serviced Apartment, Condominium, Soho                                                   | /listing/condo__serviced-residence/all-state/ | Properties > New Property Launch > New Condo/Serviced Residence for Sale | New Condo/Serviced Residence For Sale |
      | Semi-D/Bungalow          | Semi-D/Bungalow, Bungalow House, Twin Courtyard Villa,Semi-detached House, Cluster Homes, Zero-Lot Bungalow | /listing/semi_d__bungalow/all-state/          | Properties > New Property Launch > New Semi-D/Bungalow for Sale          | New Semi-D/Bungalow For Sale          |

  @autocompletion
  Scenario Outline: Verify auto-completion
    When I Type "<keyword>"
    And select autosuggestoption "<autosuggest>"
    And I click search button
    Then The header should be like "<header>"

    Examples:
      | keyword  | autosuggest             | header                           |
      | Mah Sing | Mah Sing Group Berhad   | mah sing group berhad For Sale   |
      | Cheras   | Cheras, Kuala Lumpur    | cheras, kuala lumpur For Sale    |
      | park     | johor halal park, johor | johor halal park, johor For Sale |

Feature: distance feature
As a user I want to test the functionality of the calculation of the distance between two points.

  Scenario Outline: Check site main functions

    Given Open '<homePage>' of website
    When user clicks on the search button
    And user enters '<startPoint>' and '<finishPoint>'
    And user select '<vehicle>'
    And user clicks on the submit button
    Then check that distance between two point is 2423km.

    Examples:
      | homePage                      |vehicle         |startPoint    |finishPoint|
      | https://www.openstreetmap.org/|Велосипед (OSRM)|Радищева, Київ|  Кембридж |


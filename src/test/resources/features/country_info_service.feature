Feature: Get information of different countries

  Scenario: Get currency of specific country
    When I call the get currency for country endpoint
    Then I should see valid currency for country in response

  Scenario: Get phone code of specific country
    When I call the get phone code for country endpoint
    Then I should see valid phone code for country in response

  Scenario: Get capital city of specific country
    When I call the get capital city for country endpoint
    Then I should see valid capital city for country in response
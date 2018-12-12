Feature: home page search functionality 

Scenario: Verify search term 
Given the user is on the home page
When the user enters a search term
Then the search box should contaion the search term 

Scenario: Verify home page title
Given the user is on the home page
When the user gets the title of the page 
Then title should be Search - My Store  
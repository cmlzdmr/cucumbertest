Feature: login
	
	
	Scenario: verify user name and last name 
		Given the user is on the login page
		When  the user login username "testpom@test.com" and password "abc123"
		Then users full name "test" "test" should be displayed
		
	@login
	Scenario: verify user name and last name 
		Given the user is on the login page
		When  the user login username "testpom@test.com" and password "abc123"
		Then users full name "test" "test" should be displayed
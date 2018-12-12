Feature: Users should be able to login 

Scenario: User Registration 
	Given the user is on the login page
	And the user enters a random email
	And the user enters personal information
	|First Name	|Kunnka		|
	|Last Name	|Admiral	|
	|Address	|123 Main st|
	|City		|Anytown	|
	|Company	|CT			|
	
	
Scenario: Custom User Registration 
	Given the user is on the login page
	And the user enters a random email
	And the user enters user information
	|First Name	|Last Name	|Address 	|City	|Company|email|password|zipcode|state|phone|
	|Admiral	|Kunnka		|123 Main st|Anytown|CT		|asd@asd.com|abc123|22101|VA|2027808832|
	|Aasdasd	|Kunnka		|123 Main st|Anytown|CT		|asd@asd.com|abc123|22101|VA|2027808832|
	
	
	
	
	
	
	

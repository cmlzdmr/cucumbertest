@product	
Feature: Product Information

Background:
		Given the user is on the home page

	Scenario: Display the correct product name 
		When the user selects Printed Summer Dress
		Then product information page should be displayed
		And product name should be Printed Summer Dress
		

	Scenario: Default count and size information
		When the user selects Printed Summer Dress
		Then correct feault count size should be displayed
		
		
	Scenario: Display the correct product name by name
		When the user selects "Printed Summer Dress"
		Then product information page title should contain "Printed Summer Dress"
		And product name should be "Printed Summer Dress"
		
		
			
	Scenario: Change item count 
		When the user selects "Printed Chiffon Dress"
		Then correct default count should be 1 
		And the user should be able to toggle the count 
		
		
		
		
Feature: Product details
	
	Scenario: Verify products on home page
		Given the user is on the home page
		Then the user should be able to see "Printed Summer Dress"
	
	
	Scenario: Verify products on home page
		Given the user is on the home page
		Then the user should be able to see following products
		
		|Printed Summer Dress		|
		|Blouse						|
		|Printed Chiffon Dress 		|
		|Faded Short Sleeve T-shirts|
		|Printed Dress				|
	
	
	Scenario: Verify all sizes 
		Given the user is on the home page
		When the user selects "Printed Summer Dress"
		Then the product be available in the following sizes:
		|S|
		|M|
		|L|
		And correct feault count size should be displayed
		
		 
		
		
		
		
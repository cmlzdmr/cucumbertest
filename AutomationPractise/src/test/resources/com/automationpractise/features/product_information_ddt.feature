Feature: verify product information
	
	Scenario: Display the correct product name by name
		Given the user is on the home page
		When the user selects "Printed Summer Dress"
		Then product information page title should contain "Printed Summer Dress"
		And product name should be "Printed Summer Dress"
	
	Scenario Outline: Display the correct product name by name
		Given the user is on the home page
		When the user selects "<product>"
		Then product information page title should contain "<product>"
		And product name should be "<product>"
		
		Examples: 
		|product			  |
		|Printed Summer Dress |
		|Printed Chiffon Dress|
		
	Scenario Outline: verify item name 
		Given the user is on the home page
		When the user selects "<product>"
		Then product name should be "<product>"
		And the price should be "<price>"
		
		Examples: 
		|product			  |price |
		|Printed Summer Dress |$28.98|
		|Printed Chiffon Dress|$16.40|
		|Printed Dress		  |$26.00|
	
	Scenario Outline:
		Given the user is on the login page
		When the user login username "<username>" and password "<password>"
		Then users full name "<firstname>" "<lastname>" should be displayed
		
		Examples:
		|username		 |password|firstname|lastname|		
		|testpom@test.com|abc123  |test     |test	 |
	    |nitoyey@dumoac.net|password|John	|Smith	|
	    
	    
    Scenario Outline: Product details with map 
		Given the user is on the home page
		When the user selects "<product>"
		Then the system should display the product information:
		|name	  |<product>			|
		|count 	  |<count>				|
		|condition|<condition>			|
		|size	  |<size>				|
		|price	  |<price>				|
	
		Examples:
	|product			 |count|condition|size|price |
	|Printed Summer Dress|1	   |New		 | S  |$28.98|  	
	|Printed Dress		 |1	   |New		 | S  |$26.00|	
	|Printed Chiffon Dress|1	   |New		 | S  |$16.40|	
	
	
	Scenario Outline: verify <page> title
	When the user is on the <page>
	Then the title and url should be:
		|Title|<title>|
		|Url  |<url>  |
		
	Examples: 
		|page      |title           |url                                    |
		|home page | My Store       |http://automationpractice.com/index.php|
		|login page|Login - My Store|http://automationpractice.com/index.php?controller=authentication&back=my-account|
	
	
	
	
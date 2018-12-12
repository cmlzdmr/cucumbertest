package com.automationpractise.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.automationpractise.pages.HomePage;
import com.automationpractise.pages.ItemPage;

import cucumber.api.java.en.Then;

public class ProductInformationValidationsStepDef {

	HomePage homePage = new HomePage();
	ItemPage itemPage = new ItemPage();

	@Then("the user should be able to see {string}")
	public void the_user_should_be_able_to_see(String productName) {
		
	   assertTrue(homePage.item(productName).isDisplayed());
	
	}
	
	@Then("the user should be able to see following products")
	public void the_user_should_be_able_to_see_following_products(List<String> products) {
	  
	    for(String product:products) {
	 	   assertTrue(homePage.item(product).isDisplayed());
	    }
	}
	
	@Then("the product be available in the following sizes:")
	public void the_product_be_available_in_the_following_sizes(List<String> sizes) {
		
		for(String expectedSize: sizes ) {
			System.out.println(expectedSize);
			
		}
	   
		Select sizeSelect = itemPage.size();
		//will contain the actual sizes
		List<String> actualList = new ArrayList<>();
		//get  the all options from the dropdown and add to the actual list 
		for(WebElement optionElement : sizeSelect.getOptions()) {
			actualList.add(optionElement.getText());
		}
		
		assertEquals(sizes,actualList);
		
	}
	
	@Then("the system should display the product information:")
	public void the_system_should_display_the_product_information(Map<String,String> product) {
		System.out.println(product);
		
		String expectedName = product.get("name");
		assertEquals(expectedName,itemPage.itemName.getText());
		
		String expectedPrice = product.get("price");
		assertEquals(expectedPrice,itemPage.price.getText());

		String expectedSize = product.get("size");
		assertEquals(expectedSize, itemPage.size().getFirstSelectedOption().getText());
		
		String expectedCondition = product.get("condition");
		assertEquals(expectedCondition, itemPage.condition.getText());
		
		String expectedCount = product.get("count");
		assertEquals(expectedCount, itemPage.count.getAttribute("value"));
	}


}

package com.automationpractise.step_definitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import com.automationpractise.pages.HomePage;
import com.automationpractise.pages.ItemPage;
import com.automationpractise.utilities.Driver;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class product_infromatonStepDefs {
	HomePage homePage = new HomePage();
	
	@When("the user selects Printed Summer Dress")
	public void the_user_selects_Printed_Summer_Dress() {
	  homePage.item("Printed Summer Dress").click();
	  
	}

	@Then("product information page should be displayed")
	public void product_information_page_should_be_displayed() {
	   String actual = Driver.getDriver().getTitle();
	   String expected = "Printed Summer Dress";
	   assertTrue("Title should contain: Printed Summer Dress", actual.contains(expected));
	}

	@Then("product name should be Printed Summer Dress")
	public void product_name_should_be_Printed_Summer_Dress() {
		ItemPage itemPage = new ItemPage();
		assertEquals("Printed Summer Dress", itemPage.itemName.getText());
	}
	
	@Then("correct feault count size should be displayed")
	public void correct_feault_count_size_should_be_displayed() {
		ItemPage itemPage = new ItemPage();
		String actual = itemPage.count.getAttribute("value");
		String expected = "1";
		assertEquals("Default count number should be 1:", expected, actual);
		assertEquals("S",itemPage.size().getFirstSelectedOption().getText());
		
	}
	
	@When("the user selects {string}")
	public void the_user_selects(String item) {
	   	homePage.item(item).click();
	}

	@Then("product information page title should contain {string}")
	public void product_information_page_title_should_contain(String item) {
		String actual = Driver.getDriver().getTitle();
		   String expected = item;
		   assertTrue("Title should contain: Printed Summer Dress", actual.contains(expected));
	}

	@Then("product name should be {string}")
	public void product_name_should_be(String item) {
		ItemPage itemPage = new ItemPage();
		assertEquals(item, itemPage.itemName.getText());
	}
	
	@Then("correct default count should be {int}")
	public void correct_default_count_should_be(Integer count) {
		ItemPage itemPage = new ItemPage();
		String actual = itemPage.count.getAttribute("value");
		assertEquals("Default count number should be:"+count, count, Integer.valueOf(actual));
		
	}

	@Then("the user should be able to toggle the count")
	public void the_user_should_be_able_to_toggle_the_count() {
		ItemPage itemPage = new ItemPage();
	int number = new Random().nextInt(48)+2;
	
	for(int i =0; i<=number;i++) {
		itemPage.plus.click();
		assertEquals(i+2+"", itemPage.count.getAttribute("value"));
	}
	
	for(int i =number; i>0; i--) {
		itemPage.minus.click();
		assertEquals(i+1+"", itemPage.count.getAttribute("value"));
	}
	
	
	}
	
	@Then("the price should be {string}")
	public void the_price_should_be(String expectedPrice) {
		ItemPage itemPage = new ItemPage();
		assertEquals(expectedPrice, itemPage.price.getText());
	}





}

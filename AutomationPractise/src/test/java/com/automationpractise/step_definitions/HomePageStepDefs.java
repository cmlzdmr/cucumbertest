package com.automationpractise.step_definitions;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import com.automationpractise.pages.HomePage;
import com.automationpractise.pages.SigninPage;
import com.automationpractise.utilities.ConfigurationReader;
import com.automationpractise.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefs {
	
	@Given("the user is on the home page")
	public void the_user_is_on_the_home_page() {
	
		Driver.getDriver().get(ConfigurationReader.getProperty("url"));
		
		
	
	}

	@When("the user enters a search term")
	public void the_user_enters_a_search_term() {
		HomePage homePage = new HomePage();
		homePage.search.sendKeys("t shirt");
	}

	@Then("the search box should contaion the search term")
	public void the_search_box_should_contaion_the_search_term() {
		HomePage homePage = new HomePage();
		String actual = homePage.search.getAttribute("value");
		assertEquals("t shirt", actual);
		
	}
	
	String title;
	@When("the user gets the title of the page")
	public void the_user_gets_the_title_of_the_page() {
	    
		title = Driver.getDriver().getTitle();
	}
	
	@Then("title should be Search - My Store")
	public void title_should_be_Search_My_Store() {
		assertEquals("My Store", title);
	}

	@When("the user clicks on the Sign in link")
	public void the_user_clicks_on_the_Sign_in_link() {
		HomePage homePage = new HomePage();
		homePage.signin.click();
	}

	@Then("username and password fiels should be displayed")
	public void username_and_password_fiels_should_be_displayed() {
	   SigninPage siginPage = new SigninPage();
	   
	   assertTrue(siginPage.loginEmail.isDisplayed());
	   assertTrue(siginPage.password.isDisplayed());

	}
	
	@Then("the title and url should be:")
	public void the_title_and_url_should_be(Map<String, String> map) {
	   String expectedTitle = map.get("Title");
	   assertEquals(expectedTitle, Driver.getDriver().getTitle());
	   
	   String expectedUrl = map.get("Url");
	   assertEquals(expectedUrl, Driver.getDriver().getCurrentUrl());
	}
}

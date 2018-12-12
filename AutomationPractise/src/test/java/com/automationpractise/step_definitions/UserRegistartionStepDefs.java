package com.automationpractise.step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Keys;

import com.automationpractise.beans.User;
import com.automationpractise.pages.AccountInformationPage;
import com.automationpractise.pages.HomePage;
import com.automationpractise.pages.MyAccountPage;
import com.automationpractise.pages.RegistrationPage;
import com.automationpractise.pages.SigninPage;
import com.automationpractise.utilities.ConfigurationReader;
import com.automationpractise.utilities.Driver;
import com.github.javafaker.Faker;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserRegistartionStepDefs {
	RegistrationPage registrationPage = new RegistrationPage();
	SigninPage signinPage = new SigninPage();
	String email;
	MyAccountPage myAccountPage = new MyAccountPage();
	@Given("the user enters a random email")
	public void the_user_enters_a_random_email() {
	
		Faker fake = new Faker();
		new HomePage().signin.click();
		email = fake.internet().emailAddress();
		System.out.println(email);
		signinPage.signupEmail.sendKeys(email + Keys.ENTER);
	
		
	}

@Given("the user enters personal information")
public void the_user_enters_personal_information(Map<String,String> user) {
	
	registrationPage.firstName.sendKeys(user.get("First Name"));
	registrationPage.lastName.sendKeys(user.get("Last Name"));
	registrationPage.address.sendKeys(user.get("Address"));
	registrationPage.city.sendKeys(user.get("City"));
	registrationPage.company.sendKeys(user.get("Company"));
	
}

	@Given("the user enters user information")
	public void the_user_enters_user_information(List<User> users) {
			for(User user:users) {
				System.out.println(user.getFirstName());
				registrationPage.firstName.sendKeys(user.getFirstName());
				registrationPage.lastName.sendKeys(user.getLastName());
				registrationPage.address.sendKeys(user.getAddress());
				registrationPage.city.sendKeys(user.getCity());
				registrationPage.company.sendKeys(user.getCompany());
				
			}
			
			
	}
	@When("the user clicks on the my personal information button")
	public void the_user_clicks_on_the_my_personal_information_button() {
		myAccountPage.myPersonalInformaiton.click();
	}

	@Then("the system should display the user's account information")
	public void the_system_should_display_the_user_s_account_information(List<User> users) {
		AccountInformationPage accountInformationPage = new AccountInformationPage();
		User user = users.get(0);
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		
		assertEquals(firstName, accountInformationPage.firstName.getAttribute("value"));
		assertEquals(lastName, accountInformationPage.lastName.getAttribute("value"));

	}
		
				

}

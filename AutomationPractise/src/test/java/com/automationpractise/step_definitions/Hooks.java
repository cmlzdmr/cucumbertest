package com.automationpractise.step_definitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automationpractise.utilities.ConfigurationReader;
import com.automationpractise.utilities.Driver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

	
	@Before
	public void setUp() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
	
	}
	
	
	//@Before("@login")
	public void setUpForLogin() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
	
	}
	
	@After
	public void tearDown(Scenario scenario) {
		//only takes a screenshot if the scenario fails 
		if(scenario.isFailed()) {
			//taking screenshot
		final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
		
		scenario.embed(screenshot,  "image/png");
		}
		Driver.closeDriver();
	}
}

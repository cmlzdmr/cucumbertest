package com.automationpractise.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"html:target/default-cucumber-reports",
				  "json:target/cucumber.json",
				  "pretty"
		
		},
		tags = "@login",
		features="src/test/resources/com/automationpractise/features",
		glue="com/automationpractise/step_definitions",
		dryRun=false
		
		)

public class CukesRunner {

}

package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features 			= {"src/test/resources/Features" }, 
		monochrome = true,
		plugin 				= {		"pretty",
				"html:target/cucumber",
				"json:target/cucumber/cucumber.json",
		},
		tags 				= {"@TestScript1"},
		glue 				= {"lmsStepDefinitions","testRunner"}

		)

public class runFeatureTest {

}

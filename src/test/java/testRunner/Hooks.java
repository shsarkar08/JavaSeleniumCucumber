package testRunner;

import java.io.IOException;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import reusableFunctions.CommonUtils;
//import java.net.MalformedURLException;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriverException;
//import org.openqa.selenium.chrome.ChromeDriver;

//public static WebDriver driver;
//@Before
///**
//* Delete all cookies at the start of each scenario to avoid
//* shared state between tests
//*/
//public void openBrowser() throws MalformedURLException {
//System.out.println("Called openBrowser");
//driver = new ChromeDriver();
//driver.manage().deleteAllCookies();
//}
//@After
///**
//* Embed a screenshot in test report if test is marked as failed
//*/
//public void embedScreenshot(Scenario scenario) {
//if(scenario.isFailed()) {
//try {
//scenario.write("Current Page URL is " + driver.getCurrentUrl());
//byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//scenario.embed(screenshot, "image/png");
//} 
//catch (WebDriverException somePlatformsDontSupportScreenshots) {
//System.err.println(somePlatformsDontSupportScreenshots.getMessage());
//} 
//}
//driver.quit();
//}
//}
public class Hooks {

	Scenario scenario;

	@Before
	public void scenarioSetup(Scenario scenario)
	{
		this.scenario=scenario;
		System.out.println("===== Executing Scenario =====");
		System.out.println(scenario.getName());
		System.out.println(" +++++++++++++++++++++++++++++ ");
	}

	public Scenario getScenarioStatus()
	{

		this.scenario.getStatus();
		return this.scenario;
	}


	@After
	public void scenarioEnd() throws IOException
	{
		System.out.println("===== Execution Complete =====");
		System.out.println("Status = "+ scenario.getStatus());
		//scenario.write(scenario.getStatus());
		//CommonUtils.takeSnapshot(scenario);
		//scenario.write("Position ID Generated ~ "+ SuccessFactorRecruitingModule.PID);
		//scenario.write("Job Requisition ID Generated ~ "+ SuccessFactorRecruitingModule.JID);
		CommonUtils.takeFullPageSnapshot(scenario);
		System.out.println("===== Closing Browser =====");
		CommonUtils.killBrowser();

		/*if(scenario.isFailed())
		{

			CommonUtils.takeSnapshot(scenario);
		}*/
	}

}

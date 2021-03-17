package pageActions;


import org.openqa.selenium.WebDriver;

import pageObjects.SF_LMS_loginPage;
import reusableFunctions.CommonUtils;
import reusableFunctions.ReadFiles;

public class SF_LMS_loginActions {
	
	WebDriver driver;
	SF_LMS_loginPage sf;
	
	public SF_LMS_loginActions(WebDriver driver) {
		
		this.driver = driver;
		sf = new SF_LMS_loginPage(driver);
	}
	
	public   void userLogin(String uname, String pwd) throws InterruptedException
	{
		CommonUtils.setTextboxValue(sf.userID, ReadFiles.readPropFile(uname));
		CommonUtils.setTextboxValue(sf.passWord, ReadFiles.readPropFile(pwd));
		CommonUtils.clickButton(sf.loginBtn);
		
		
		System.out.println(" User details Entered and clicked login");
		CommonUtils.waitForElement(25, sf.Home);
		
	}
	
}

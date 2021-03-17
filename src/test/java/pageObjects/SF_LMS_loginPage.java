package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SF_LMS_loginPage {

	WebDriver driver;

	@FindBy(xpath="//input[@name='userName']")
	public WebElement userID;

	@FindBy(xpath="//input[@name='password']")
	public WebElement passWord;

	@FindBy(xpath="//button[@name='submit']")
	public WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(.,'Home')]")
	public WebElement Home;

	public SF_LMS_loginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SF_LMS_CourseRegisterPage {

	WebDriver driver;

	@FindBy(xpath="//div[@class='secondaryActions']//a[contains(.,'Register Now')]")
	public WebElement registerNowLink;

	@FindBy(xpath="//div[@id='availableSchedule']//tr[@class='row']//button[@title='Register Now']")
	public WebElement registerNowBtn;

	@FindBy(xpath="//button[@title='Yes']")
	public WebElement confirmYes;

	@FindBy(xpath="//textarea[@name='comments']")
	public WebElement commentBox;

	@FindBy(xpath="//button[@type='Submit' and contains(@id,'confirm')]")
	public WebElement confirmBtn;

	@FindBy(xpath="//tr[@class='globalLmsDataRow']//td//span[contains(@class,'autoRegistrationStatus')]")
	public WebElement registrationStatus;


	@FindBy(xpath="//select[@name='regionID']")
	public WebElement pRegion;

	@FindBy(xpath="//select[@name='facilityID']")
	public WebElement pLocation;

	@FindBy(xpath="//button[@type='button' and @id='requestBtn']")
	public WebElement requestBtn;

	@FindBy(xpath="//input[@name='requiredDate']")
	public WebElement date;

	@FindBy(xpath="//button[@id='Remove']")
	public WebElement removeBtn;

	@FindBy(xpath="//table//td//tr[@class='row']")
	public WebElement dataGrid;

	@FindBy(xpath="//a[contains(.,'Home')]")
	public WebElement Home;

	public SF_LMS_CourseRegisterPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

}

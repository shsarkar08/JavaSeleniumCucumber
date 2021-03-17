package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SF_LMS_SupervisorPage {
	WebDriver driver;

	@FindBy(xpath="//iframe[@name='internalTrainingApprovalsBuffer']")
	public WebElement iframeInternalTraining;

	@FindBy(xpath="//input[@type='radio' and contains(@aria-label,'Approve')]")
	public WebElement radioApprove;

	@FindBy(xpath="//input[@type='radio' and contains(@aria-label,'Deny')]")
	public WebElement radioDeny;

	@FindBy(xpath="//button[@type='button' and @title='Next']")
	public WebElement btnNext;

	@FindBy(xpath="//button[@type='Submit' and @title='Next']")
	public WebElement btnNextSubmit;

	@FindBy(xpath="//textarea[@name='reasons']")
	public WebElement textAreaCmnt;

	@FindBy(xpath="//button[@type='Submit' and @title='Confirm']")
	public WebElement btnConfirm;

	@FindBy(xpath="//span[@class='InstructionalText']")
	public WebElement textConfirm;

	@FindBy(xpath="//div[@class='tileTodoListItemRenderer']//div[@class='actionButtons']")
	public WebElement confirmationStatus;
	
	@FindBy(xpath="//a[contains(.,'Home')]")
	public WebElement Home;
	
	public SF_LMS_SupervisorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}

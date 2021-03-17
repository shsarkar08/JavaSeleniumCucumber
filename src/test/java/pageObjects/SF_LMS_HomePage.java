package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SF_LMS_HomePage {

	WebDriver driver;

	@FindBy(xpath="//a[contains(.,'Home')]")
	public WebElement Home;

	@FindBy(xpath="//a[@aria-label='Browse all courses']")
	public WebElement BrowseCat;

	@FindBy(xpath="//input[@type='search']")
	public WebElement SearchF;

	@FindBy(xpath="//div[@class='actionButtons']//a")
	public WebElement ActionButtons;

	@FindBy(xpath="//div[contains(@class,'sfDropMenu')]//ul")
	public WebElement ActionsUL;

	@FindBy(xpath="//a[contains(.,'Employees')]")
	public WebElement MyEmpTab;

	// Remove course elements //

	@FindBy(xpath="//button[contains(.,'Yes')]")
	public WebElement WithdrawConfirmationBtn;

	@FindBy(xpath="//button[@id='btn_yes']")
	public WebElement RemoveConfirmationBtn;

	@FindBy(xpath="//select[@id='cancellationReasonID']")
	public WebElement cancelRsndrpDown;

	@FindBy(xpath="//button[@type='submit' and @id='btn_submit']")
	public WebElement btnFinalSubmit;

	@FindBy(xpath="//button[@type='button' and @id='button_yes']")
	public WebElement RemoveApprovalBtn;

	@FindBy(xpath="//button[@type='submit' and @id='button_submit']")
	public WebElement SubmitApprovalBtn;


	public SF_LMS_HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


}

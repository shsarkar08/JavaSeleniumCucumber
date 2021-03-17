package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SF_LMS_MyEmployeesPage {

	WebDriver driver;


	@FindBy(xpath="//button[@name='assignLearningLink']")
	public WebElement AssignLearningBtn;

	@FindBy(xpath="//button[@name='withdrawLearningLink']")
	public WebElement RemoveLearningBtn;

	@FindBy(xpath="(//a[@title='Add Employees'])[2]")
	public WebElement AddEmployees;

	@FindBy(xpath="(//a[contains(@title,'Add Items, Programs and Curricula')])[2]")
	public WebElement AddItems;

	@FindBy(xpath="(//a[contains(@title,'Add Scheduled Offering')])[2]")
	public WebElement AddScheduledOffering;
	
	@FindBy(xpath="//input[@aria-label='Employees']")
	public WebElement EmployeesInput;

	@FindBy(xpath="//div[@class='userCardInfo']")
	public WebElement EmployeeCard;

	@FindBy(xpath="//input[@type='checkbox' and @name='contentCheckbox']")
	public WebElement CheckBox;

	@FindBy(xpath="//button[@type='button' and contains(.,'Add')]")
	public WebElement AddBtn;

	@FindBy(xpath="//input[@type='search']")
	public WebElement SearchField;

	@FindBy(xpath="//div[contains(@id,'catalogSearchField-search')]")
	public WebElement SearchIcon;

	@FindBy(xpath="//div[@class='catalogListItemActionInset']//a[contains(.,'Select')]")
	public WebElement SelectBtn;
	
	@FindBy(xpath="//div[@class='sapMLIBContent']//a[contains(.,'Select')]")
	public WebElement ExpandedSelectBtn;
	
	@FindBy(xpath="//button[@title='Close']")
	public WebElement CloseBtn;

	@FindBy(xpath="//select[contains(@class,'supervisorToolTableDropdown')]")
	public WebElement AssignmentType;

	@FindBy(xpath="//input[@class='sfTextInput' and contains(@name,'RequiredDates')]")
	public WebElement RequiredDate;
	
	@FindBy(xpath="//button[@title='Continue']")
	public WebElement ContinueBtn;

	@FindBy(xpath="//button[@title='Assign Learning']")
	public WebElement AssignLearnBtn;

	@FindBy(xpath="//button[@title='Remove Learning']")
	public WebElement RemoveLearnBtn;
	
	@FindBy(xpath="//div[@class='Overlay_popup_middle']")
	public WebElement AssignData;

	@FindBy(xpath="//div[@class='tileTodoListItemRenderer']")
	public WebElement LearningPlans;
	
	@FindBy(xpath="//div[@class='statusRegion']//div[@class='statusRegionPosDiv']//span[contains(@class,'globalPortletAlertTextColor')]")
	public WebElement getColoredText;
	
	@FindBy(xpath="//div[@class='summaryRegion']//a[@class='globalTileLink']")
	public WebElement getTitle;
	
	
	@FindBy(xpath="//div[@class='userName']//span")
	public WebElement userNames;
	
	@FindBy(xpath="//input[@id='Learners']")
	public WebElement userNotificationCheck;
	
	@FindBy(xpath="//input[@id='RemoveItem']")
	public WebElement removeCheck;
	
	
	@FindBy(xpath="//button[@title='Register Employees']")
	public WebElement registerEmployees;
	
	@FindBy(xpath="//button[@title='Withdraw Employees']")
	public WebElement withdrawEmployees;
	
	@FindBy(xpath="//input[@type='checkbox' and contains(@title,'Withdraw')]")
	public WebElement withdrawEmployeesCheckbox;
	
	public SF_LMS_MyEmployeesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}

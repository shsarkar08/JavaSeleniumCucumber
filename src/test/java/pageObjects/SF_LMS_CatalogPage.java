package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SF_LMS_CatalogPage {
	WebDriver driver;

	@FindBy(xpath="//input[@type='search']")
	public WebElement searchField;

	@FindBy(xpath="//div[contains(@id,'catalogSearchField-search')]")
	public WebElement searchIcon;

	@FindBy(xpath="//div[@class='sapMInputBaseDynamicContent']//input[contains(@id,'categoryComboBox')]")
	public WebElement filterCategoryInput;
	

	@FindBy(xpath="//div[@class='sapMInputBaseIconContainer']//span[@role='button' and contains(@id,'categoryComboBox')]")
	public WebElement filterCategoryDropdownBtn;
	
	@FindBy(xpath="//div[@class='sapMPopoverScroll']/ul[@role='listbox']")
	public WebElement filterCategoryUL;
	
	@FindBy(xpath="//div[contains(@id,'onlineContentCheckBox')]")
	public WebElement onlineContentCheckBox;
	
	@FindBy(xpath="//div[contains(@id,'scheduledCoursesCheckBox')]")
	public WebElement scheduledCoursesCheckBox;
	
	@FindBy(xpath="//div[contains(@class,'catalogListItemBaseContent')]")
	public WebElement courseItemList;

	@FindBy(xpath="//div[@title='Prerequisites']")
	public WebElement prerequisiteTab;

	@FindBy(xpath="//div[@class='prereqPanel sapMPanel']//a[contains(@title,'View prerequisite course')]")
	public WebElement prerequisiteCourseName;

	//div[contains(@class,'catalogListItemBaseContent')]//a[@title='Premium Service Plans'] -- title for course

	//div//a[contains(@title,'View Prerequisites: Premium Service Plans')] -- view prerequisite

	//div[@class='prereqPanel sapMPanel']//a[contains(@title,'Assign to Me')] -- assign to me (prerequisite)

	//div[contains(@class,'availableActions')]//a[contains(.,'Assign to Me')] -- assign to me (Main course)

	public SF_LMS_CatalogPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}

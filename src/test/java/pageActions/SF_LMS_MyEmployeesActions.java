package pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.SF_LMS_MyEmployeesPage;
import reusableFunctions.CommonUtils;

public class SF_LMS_MyEmployeesActions {

	WebDriver driver;
	SF_LMS_MyEmployeesPage sfE;

	public SF_LMS_MyEmployeesActions(WebDriver driver) {
		this.driver = driver;
		sfE = new SF_LMS_MyEmployeesPage(driver);
	}

	public void actions(String action) {

		WebElement actionbtn = driver.findElement(By.xpath("//button[contains(.,'"+action+"')]"));
		actionbtn.click();
		System.out.println("Selected Option ~ "+action);
	}

	public void addEmployee(String emp) throws InterruptedException {
		System.out.println("Into add emp method");

		try {

			boolean empBtn = CommonUtils.isElementDisplayed(sfE.AddEmployees);
			if (empBtn==true) {

				CommonUtils.clickButtonUsingJavaScript(sfE.AddEmployees, driver);

				CommonUtils.waitForElement(10, sfE.EmployeesInput);
				CommonUtils.setTextboxValue(sfE.EmployeesInput, emp);

				CommonUtils.waitForElement(6, sfE.EmployeeCard);
				CommonUtils.clickButton(sfE.EmployeeCard);

				Thread.sleep(1000);

				CommonUtils.clickButton(sfE.CheckBox);
				CommonUtils.waitForElement(10, sfE.AddBtn);
				CommonUtils.clickButton(sfE.AddBtn);
				System.out.println("Employee Added");
			}
			else {
				try {
					CommonUtils.clickButton(sfE.withdrawEmployeesCheckbox);
				}
				catch(NoSuchElementException e) {
					System.out.println("Checkbox Not Visible");
				}
			}
		}
		catch(Exception e) {
			System.out.println("Emp Add Button Not Available");
		}

		//		try {
		//
		//			System.out.println("Employee Add button is not visible");
		//			CommonUtils.clickButton(sfE.withdrawEmployeesCheckbox);
		//			//System.out.println("Checkbox Clicked");
		//
		//		}
		//		catch(Exception e) {
		//			System.out.println("Checkbox Not Visible");
		//		}
	}


	public void addCourse(String item) throws InterruptedException {

		try {

			if(sfE.AddItems.isDisplayed())
				CommonUtils.clickButton(sfE.AddItems);

		}
		catch(NoSuchElementException e) {
			System.out.println("From Catch Block");
			System.out.println(" *************** ");
			e.printStackTrace();
			System.out.println(" *************** ");
		}
		try {

			if(sfE.AddScheduledOffering.isDisplayed())
				CommonUtils.clickButton(sfE.AddScheduledOffering);
		}
		catch(NoSuchElementException e) {
			System.out.println("From Catch Block");
			System.out.println(" *************** ");
			e.printStackTrace();
			System.out.println(" *************** ");
		}

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[contains(@class,'catalogSearchIFrame')]")));

		//Switch to Frame
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@class,'catalogSearchIFrame')]")));

		CommonUtils.waitForElement(30, sfE.SearchField);
		CommonUtils.setTextboxValue(sfE.SearchField, item);
		Thread.sleep(3000);
		CommonUtils.clickButton(sfE.SearchIcon);
		Thread.sleep(4000);

		try {


			List<WebElement> courseResults = driver.findElements(By.xpath("//div[contains(@class,'catalogListItemBaseContent')]"));

			for (int i=0 ; i<courseResults.size() ; i++) {

				List<WebElement> courseTitle = driver.findElements(By.xpath("//div[contains(@class,'catalogListItemBaseContent')]//div[@class='catalogListItemBaseTitle']//span[contains(@id,'titleText')]"));
				String actualCourseTitle = courseTitle.get(i).getText();
				System.out.println("Title ["+(i+1)+"] ~ "+actualCourseTitle);

				if (actualCourseTitle.equals(item)) {
					//CommonUtils.scrollToElement(courseResults, driver);
					courseResults.get(i).click();
					Thread.sleep(2000);
					try {
						if(sfE.ExpandedSelectBtn.isDisplayed())
							CommonUtils.clickButton(sfE.ExpandedSelectBtn);
						break;
					}
					catch(NoSuchElementException e) {

						e.printStackTrace();
					}
					try {
						if(sfE.SelectBtn.isDisplayed())
							CommonUtils.clickButton(sfE.SelectBtn);
						break;
					}
					catch(NoSuchElementException e) {

						e.printStackTrace();
					}

				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		//Switch back from frame
		try {
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			CommonUtils.clickButtonUsingJavaScript(sfE.CloseBtn, driver);
		}
		catch(NoSuchElementException e) {
			//pass
		}

		System.out.println("Course Added ~ "+item);

	}

	public boolean selectAssignmentTytpe(String type) {

		try {
			boolean asn = sfE.AssignmentType.isDisplayed();

			if (asn == true) {

				Select asnType = new Select(sfE.AssignmentType);
				asnType.selectByVisibleText(type);
				System.out.println("Selected Assignment Type ~ "+type);

				CommonUtils.setTextboxValue(sfE.RequiredDate, "24/AUG/2019");
			}


		}	catch(NoSuchElementException e) {
			System.out.println("No Assignment type avaiable for remove courses");
			return false;
		}
		return true;
	}

	public boolean submit() throws InterruptedException {

		CommonUtils.clickButton(sfE.ContinueBtn);

		try {

			boolean assignBtn = sfE.AssignLearnBtn.isDisplayed();

			//boolean removeBtn = sfE.RemoveLearningBtn.isDisplayed();

			if (assignBtn == true) {

				CommonUtils.clickButton(sfE.AssignLearnBtn);
				System.out.println("Learning Assigned");
			}
		}
		catch(NoSuchElementException e) {

			CommonUtils.clickButton(sfE.RemoveLearnBtn);
			return false;
		}
		finally {

			//Get Confirmation Text
			String confData = CommonUtils.getText(sfE.AssignData).trim();

			System.out.println("**** Confirmation Message ****");
			System.out.println(confData);
			System.out.println("******************************");

			CommonUtils.clickButton(sfE.CloseBtn);
			Thread.sleep(3000);
		}
		return true;
	}
	public void submit_scheduled_offering(String notification) throws InterruptedException {

		CommonUtils.clickButton(sfE.ContinueBtn);

		WebElement userNotiCheck = driver.findElement(By.xpath("//input[@id='"+notification+"']"));
		CommonUtils.clickButton(userNotiCheck);

		try {
			if (sfE.removeCheck.isDisplayed()) {
				CommonUtils.clickButton(sfE.removeCheck);
			}
		}
		catch(NoSuchElementException e) {
			System.out.println("From catch block- No check box present for remove learning");
		}

		try {
			if(sfE.registerEmployees.isDisplayed()) {
				CommonUtils.clickButton(sfE.registerEmployees);
			}
		}
		catch(NoSuchElementException e) {
			System.out.println("From Catch Block");
			CommonUtils.clickButton(sfE.withdrawEmployees);
		}
		//Get Confirmation Text
		String confData = CommonUtils.getText(sfE.AssignData).trim();

		System.out.println("**** Confirmation Message ****");
		System.out.println(confData);
		System.out.println("******************************");

		CommonUtils.clickButton(sfE.CloseBtn);
		Thread.sleep(3000);
	}

	public void myEmployeeValidationAdd(String empName, String item ) throws InterruptedException {

		System.out.println("**DEBUG** - Into UserNamevalidation block");

		try {

			List<WebElement> userNames = driver.findElements(By.xpath("//div[@class='userName']//span"));

			for (int i= 0 ; i < userNames.size() ; i++) {

				String name = userNames.get(i).getText().trim();
				System.out.println("Employee Name ["+(i+1)+"] ~ " +name);

				if(name.equals(empName)) {
					System.out.println("Name Matched");
					userNames.get(i).click();
					Thread.sleep(3000);
					myEmployeeAssignmentValidation(item);
					break;
				}
				else {
					System.out.println("Name is not getting Matched");
					continue;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean myEmployeeAssignmentValidation(String item) {

		System.out.println("**DEBUG** - Into Assignment validation block");

		try {


			List<WebElement> todoItems = driver.findElements(By.xpath("//div[@class='tileTodoListItemRenderer']"));
			System.out.println("Size of todolist ~ " + todoItems.size());
			//String atype = "MANAGER REQUIRED";

			for (int i= 0 ; i< todoItems.size() ; i++) {
				System.out.println(" ");
				System.out.println("Iteration ~ "+ (i+1));
				String rTitle = "";
				//,gAssign
				//WebElement assignType = driver.findElement(By.xpath("(//div[@class='statusRegion']//div[@class='statusRegionPosDiv']//span[@class='todoListStatusStyle globalPortletAlertTextColor todoListStatusStyleImportant'])["+(i+1)+"]"));
				WebElement itemTitle = driver.findElement(By.xpath("(//div[@class='summaryRegion']//a[@class='globalTileLink'])["+(i+1)+"]"));

				//boolean visAssignType = assignType.isDisplayed();
				//boolean visItemtitle = itemTitle.isDisplayed();

				//				(visAssignType == true) && 
				//	if ((visItemtitle == true))
				//{
				System.out.println(" ");

				rTitle = itemTitle.getText();
				System.out.println("Item ["+(i+1)+"] Title ~ "+ rTitle);

				//gAssign = assignType.getText();
				//System.out.println("Item ["+(i+1)+"] Assignment Type/Due  ~ "+ gAssign);


				if(rTitle.equals(item)) {
					CommonUtils.scrollToElement(itemTitle, driver);
					System.out.println("Course Title Matched");
					break;
				}

				else {
					System.out.println("Course Title is not getting Matched");
					continue;
				}
				//}
				//				else if(visAssignType == false){
				//
				//					System.out.println(" ");
				//
				//					rTitle = itemTitle.getText();
				//					System.out.println("Item ["+(i+1)+"] Title ~ "+ rTitle);
				//
				//					if(rTitle.equals(item)) {
				//						System.out.println("Title matched");
				//						break;
				//					}
				//					else {
				//						System.out.println("Title and AssignmentType is not getting matched");
				//						continue;
				//}
				//}
			}
		}
		catch(NoSuchElementException e) {
			return false;
		}
		return true;
	}

}

package pageActions;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.SF_LMS_HomePage;
import reusableFunctions.CommonUtils;

public class SF_LMS_HomeActions {

	WebDriver driver;
	SF_LMS_HomePage sfH;

	public SF_LMS_HomeActions(WebDriver driver) {
		this.driver = driver;
		sfH = new SF_LMS_HomePage(driver);

	}

	public void navigate(String link) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(sfH.BrowseCat));
		}
		catch(NoSuchElementException e) {
			System.out.println("From catch block ~ NoSuchElementException");
		}
		catch(TimeoutException e) {
			System.out.println("From catch block ~ TimeoutException");
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(sfH.Home));

			WebElement browseLink = driver.findElement(By.xpath("//a[contains(.,'"+link+"')]"));
			browseLink.click();
		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		//CommonUtils.waitForElement(10, sfH.SearchF);
	}

	public void navigateTab(String tlink) throws InterruptedException {

		Thread.sleep(3000);
		CommonUtils.waitForElement(20, driver.findElement(By.xpath("//a[contains(.,'"+tlink+"')]")));
		boolean b = CommonUtils.isElementEnabled(driver.findElement(By.xpath("//a[contains(.,'"+tlink+"')]")));
		System.out.println("Element Visible ? " +b);
		WebElement tabLink = driver.findElement(By.xpath("//a[contains(.,'"+tlink+"')]"));
		tabLink.click();

	}

	public void courseActions(String action, String title) throws InterruptedException {

		System.out.println("** DEBUG ** Into courseAction Method");
		CommonUtils.waitForElement(20, sfH.ActionButtons);
		List<WebElement> assignTitle = driver.findElements(By.xpath("//div[@class='TilesTodoListContent']//td[@role='gridcell']//div[contains(@class,'titleRegion')]//span[contains(@class,'titleLink')]//a"));

		System.out.println("** DEBUG ** Inside for loop");
		for (int i = 0 ; i < assignTitle.size() ; i++) {

			String hTitle= assignTitle.get(i).getText();	
			//WebElement actionButtons = driver.findElement(By.xpath("(//div[@class='actionButtons']//a)["+(i+1)+"]"));

			System.out.println("Listed Course ["+(i+1)+"] - "+hTitle);

			Thread.sleep(2000);
			if (hTitle.equals(title)) {
				System.out.println("Course Title Matched");
				CommonUtils.clickButton(sfH.ActionButtons);

				List<WebElement> actions = driver.findElements(By.tagName("li"));

				for(WebElement  liaction: actions) {

					if(liaction.getText().equals(action)) {

						liaction.click();
						break;

					}
				}
				break;
			}


		}
	}

	public void assignmentValidation(String title) {

		System.out.println("*** DEBUG - Into the assignmentValidation Block ***");

		try {

			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(sfH.Home));

		}
		catch(Exception e) {
			e.printStackTrace();
		}

		CommonUtils.clickButton(sfH.Home);
		CommonUtils.waitForElement(20, sfH.ActionButtons);

		List<WebElement> assignTitle = driver.findElements(By.xpath("//div[@class='TilesTodoListContent']//td[@role='gridcell']//div[contains(@class,'titleRegion')]//span[contains(@class,'titleLink')]//a"));
		boolean vis = assignTitle.isEmpty();
		System.out.println("Assignment List Empty ? " +vis);

		System.out.println(" ===== Validating Parent Course Title =====");

		for (int i = 0 ; i < assignTitle.size() ; i++) {

			String hTitle= assignTitle.get(i).getText();	
			System.out.println("Listed Course ["+(i+1)+"] - "+hTitle);

			if(hTitle.equals(title)) {
				System.out.println(" ||| Course Found ||| ");
				break;
			}

			else {

				System.out.println("Parent Course Value is Not getting Matched");
				continue;
			}

			//assertEquals(title, hTitle);

		}
	}
	public void testRemove(String action,String reason) {

		CommonUtils.waitForElement(20, sfH.ActionButtons);
		try {

			//List<WebElement> actionName = driver.findElements(By.xpath("//div[@class='TilesTodoListContent']//td[@role='gridcell']//div[contains(@class,'titleRegion')]//span[contains(@class,'titleLink')]//a"));
			WebElement actionName = driver.findElement(By.xpath("//div[@class='actionButtons']//a[contains(@title,'Standards of Ethical')]"));
			actionName.click();
		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		System.out.println("Clicked in the action button");

		WebElement submenu = driver.findElement(By.xpath("//div[@class='sfDropMenu menuDefault']//a[contains(.,'"+action+"')]"));
		if(submenu.isDisplayed()) {
			submenu.click();
		}

		CommonUtils.clickButton(sfH.WithdrawConfirmationBtn);

		CommonUtils.clickButton(sfH.RemoveConfirmationBtn);

		//Select Cancellation Reason

		Select drpdown = new Select(sfH.cancelRsndrpDown);

		drpdown.selectByVisibleText(reason);
		System.out.println("Selected Reason As ~ "+reason);

		CommonUtils.clickButton(sfH.btnFinalSubmit);

		CommonUtils.clickButton(sfH.RemoveApprovalBtn);
		CommonUtils.clickButton(sfH.SubmitApprovalBtn);

		System.out.println("Submitted for Remove Approval");
	}
}

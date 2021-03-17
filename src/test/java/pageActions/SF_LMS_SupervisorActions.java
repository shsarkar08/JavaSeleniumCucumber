package pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.SF_LMS_SupervisorPage;
import reusableFunctions.CommonUtils;

public class SF_LMS_SupervisorActions {

	WebDriver driver;
	SF_LMS_SupervisorPage sfSu;

	public SF_LMS_SupervisorActions(WebDriver driver) {
		this.driver = driver;
		sfSu = new SF_LMS_SupervisorPage(driver);
	}

	public void SupervisorActions(String action) {
		//Switch to iframe
		try {
			driver.switchTo().frame(sfSu.iframeInternalTraining);
		}

		catch(NoSuchFrameException e) {
			e.printStackTrace();
		}

		WebElement actionbtn = driver.findElement(By.xpath("//input[@type='radio' and contains(@aria-label,'"+action+"')]"));
		actionbtn.click();
		System.out.println("Selected Option ~ "+action);
	}

	public void Confirm() {

		CommonUtils.clickButton(sfSu.btnNext);
		CommonUtils.setTextboxValue(sfSu.textAreaCmnt, "Test ~ Approved");
		CommonUtils.clickButton(sfSu.btnNextSubmit);
		CommonUtils.clickButton(sfSu.btnConfirm);

		String confirmationText = sfSu.textConfirm.getText();
		System.out.println(" ********************* ");
		System.out.println(confirmationText);
		System.out.println(" ********************* ");
	}

	public void validateEnrollmentStatus (String course) throws InterruptedException {

		System.out.println("*** Into Validation Block ***");
		Thread.sleep(5000);
		try {
			CommonUtils.waitForElement(10, sfSu.Home);
			List<WebElement> dueCourses = driver.findElements(By.xpath("//div[@class='tileTodoListItemRenderer']"));

			for(int i = 0 ; i < dueCourses.size() ; i++) {

				WebElement courseTitle = driver.findElement(By.xpath("(//div[@class='TilesTodoListContent']//td[@role='gridcell']//div[contains(@class,'titleRegion')]//span[contains(@class,'titleLink')]//a)["+(i+1)+"]"));
				WebElement courseStatus = driver.findElement(By.xpath("(//div[@class='tileTodoListItemRenderer']//div[@class='actionButtons'])["+(i+1)+"]"));
				String Title= courseTitle.getText();
				String status = courseStatus.getText();

				System.out.println("Listed Course ["+(i+1)+"] - "+Title);

				if (Title.equals(course)) {
					System.out.println("Course Found");
					System.out.println("*** Fetched Status As *** ");
					System.out.println(status);;
					System.out.println("************************* ");
				}
				else {
					System.out.println("Course Title is not getting matched");
				}

			}
		}
		catch(NoSuchElementException e) {
			System.out.println("From Catch Block");
		}
	}
}

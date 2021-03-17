package pageActions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.SF_LMS_CourseRegisterPage;
import reusableFunctions.CommonUtils;

public class SF_LMS_CourseRegisterActions {

	WebDriver driver;
	SF_LMS_CourseRegisterPage sfR;

	public SF_LMS_CourseRegisterActions(WebDriver driver) {
		this.driver = driver;
		sfR = new SF_LMS_CourseRegisterPage(driver);
	}

	public void registerCourse() {

		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(sfR.registerNowLink));

		CommonUtils.clickButton(sfR.registerNowLink);
		System.out.println("Clicked On 'Register Now' Link");


		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("No of Frames ~ "+size);

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='availableScheduleBuffer']")));


		CommonUtils.waitForElement(20, sfR.registerNowBtn);
		CommonUtils.clickButton(sfR.registerNowBtn);

		CommonUtils.clickButton(sfR.confirmYes);
		CommonUtils.waitForElement(15, sfR.commentBox);

		CommonUtils.setTextboxValue(sfR.commentBox, "Test Auto Comment");
		CommonUtils.clickButton(sfR.confirmBtn);

		String Status = CommonUtils.getText(sfR.registrationStatus);
		System.out.println("Course Registration Status ~ "+Status);
	}

	public void requestSchedule() {

		try {
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='scheduleRequestBuffer']")));
		}
		catch(NoSuchFrameException e) {
			e.printStackTrace();
		}
		CommonUtils.setTextboxValue(sfR.date,"24/JUL/2019");

		Select region = new Select(sfR.pRegion);
		region.selectByVisibleText("(Manufacturing(MANU))");

		Select location = new Select(sfR.pLocation);
		location.selectByVisibleText("Ballabgarh factory (Ballabgarh factory)");

		CommonUtils.setTextboxValue(sfR.commentBox, "Test Auto Comment");

		CommonUtils.clickButton(sfR.requestBtn);
		System.out.println("Request Schedule done");

	}
}

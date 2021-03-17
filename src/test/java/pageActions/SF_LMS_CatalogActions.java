package pageActions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.SF_LMS_CatalogPage;
import reusableFunctions.CommonUtils;

public class SF_LMS_CatalogActions {

	WebDriver driver;
	SF_LMS_CatalogPage sfC;
	public String Prerequisite_Course_Name = null;

	public SF_LMS_CatalogActions(WebDriver driver) {
		this.driver = driver;
		sfC = new SF_LMS_CatalogPage(driver);

	}

	public void SearchCourse(String course) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(sfC.searchField));

		sfC.searchField.clear();
		CommonUtils.setTextboxValue(sfC.searchField, course);
		CommonUtils.clickButton(sfC.searchIcon);
		System.out.println("Search Button Clicked");
		Thread.sleep(3000);
	}

	public void FilterSearch(String filterOption) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(sfC.searchIcon));

		CommonUtils.clickButton(sfC.searchIcon);
		System.out.println("Search Button Clicked");

		CommonUtils.waitForElement(20, sfC.filterCategoryInput);
		CommonUtils.clickButton(sfC.filterCategoryDropdownBtn);

		List<WebElement> options = driver.findElements(By.tagName("li"));

		for (WebElement option : options) {
			System.out.println(option.getText());
			if(option.getText().equals(filterOption)) {
				option.click();
				System.out.println("Filter Applied");
				break;
			}

		}
	}

	public void filterCheckbox() throws InterruptedException {

		CommonUtils.waitForElement(25, sfC.onlineContentCheckBox);
		CommonUtils.clickButton(sfC.onlineContentCheckBox);
		System.out.println("Online Content CheckBox unchecked");

		CommonUtils.waitForElement(25, sfC.scheduledCoursesCheckBox);
		CommonUtils.clickButton(sfC.scheduledCoursesCheckBox);
		System.out.println("Scheduled Course CheckBox checked");

		CommonUtils.waitForElement(25, sfC.courseItemList);
		Thread.sleep(2000);
	}

	public void selectFilteredCourse(String course) {

		try {

			//WebElement filteredCourse = driver.findElement(By.xpath("//div[contains(@class,'catalogListItemBaseContent')]//a[@title='"+course+"']"));
			CommonUtils.scrollToElement(driver.findElement(By.xpath("//div[contains(@class,'catalogListItemBaseContent')]//a[@title='"+course+"']")), driver);
			//Thread.sleep(1000);
			WebElement filteredCourse = driver.findElement(By.xpath("//div[contains(@class,'catalogListItemBaseContent')]//a[@title='"+course+"']"));

			boolean visFilteredCourse = filteredCourse.isDisplayed();

			System.out.println("CourseTitle Visible ~ "+visFilteredCourse);

			if (visFilteredCourse == true) {
				filteredCourse.click();
				System.out.println("Clicked on the Course");
				Thread.sleep(2000);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void SearchCourseResultsPrerequisite(String course) {
		try {

			WebElement courseTitle = driver.findElement(By.xpath("//div[contains(@class,'catalogListItemBaseContent')]//a[@title='"+course+"']"));
			boolean visCourseTitle = courseTitle.isDisplayed();
			System.out.println("CourseTitle Visible ~ "+visCourseTitle);
			//
			//			if (visCourseTitle == true){
			//
			//				CommonUtils.scrollToElement( driver.findElement(By.xpath("//div//a[contains(@title,'View Prerequisites: "+course+"')]")), driver);
			//				WebElement viewPrerequisite = driver.findElement(By.xpath("//div//a[contains(@title,'View Prerequisites: "+course+"')]"));
			//				Thread.sleep(1000);
			//				viewPrerequisite.click();
			//				System.out.println("View Prerequisite Cliked");
			//				Thread.sleep(3000);
			//			}
			//			else {
			//				System.exit(0);
			//			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void SearchCourseResultsMain(String course) {
		try {

			List<WebElement> results = driver.findElements(By.xpath("//div[contains(@class,'catalogListItemBaseContent')]"));

			for(int i= 0 ; i<results.size(); i++) {

				//results.get(i).click();

				WebElement Title = driver.findElement(By.xpath("//div[contains(@class,'catalogListItemBaseContent')]//a[contains(@id,'titleLink')]"));
				System.out.println("||| Fetching Course Titles from Results |||");
				String actualCourseTitle = Title.getText();
				System.out.println("Title ["+(i+1)+"] ~ "+actualCourseTitle);

				if (actualCourseTitle.equals(course)){
					System.out.println("Title Matched");
					Thread.sleep(1000);
					results.get(i).click();
					System.out.println("Expanded Course With Name ~ "+actualCourseTitle);
					break;
				}

				else {
					System.exit(0);
				}

			}
			//			WebElement courseTitle = driver.findElement(By.xpath("//div[contains(@class,'catalogListItemBaseContent')]//a[@title='"+course+"']"));
			//			boolean visCourseTitle = courseTitle.isDisplayed();
			//			System.out.println("CourseTitle Visible ~ "+visCourseTitle);

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void courseAssignPrerequisite(String assignOption) throws InterruptedException {
		try {
			CommonUtils.clickButton(sfC.prerequisiteTab);

			Prerequisite_Course_Name = CommonUtils.getText(sfC.prerequisiteCourseName);
			System.out.println(" ||| Prerequisites Course Name ||| -> "+Prerequisite_Course_Name);

			WebElement assignPre = driver.findElement(By.xpath("//div[@class='prereqPanel sapMPanel']//a[contains(@title,'"+assignOption+"')]"));
			assignPre.click();
			System.out.println("Prerequisite Course Assigned");
			Thread.sleep(3000);
		}
		catch(NoSuchElementException e) {
			System.out.println("From Catch Block");
		}
	}

	public void courseAssignMain(String assignOption) throws InterruptedException {
		try {
			WebElement assignCourse = driver.findElement(By.xpath("//div[contains(@class,'availableActions')]//a[contains(.,'"+assignOption+"')]"));
			assignCourse.click();
			System.out.println("Main Course is Assigned");
		}
		catch(NoSuchElementException e) {
			e.printStackTrace();
		}


		Thread.sleep(3000);

	}

}

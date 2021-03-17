package lmsStepDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reusableFunctions.CommonUtils;
import reusableFunctions.ReadFiles;

import pageActions.SF_LMS_loginActions;
import pageActions.SF_LMS_HomeActions;
import pageActions.SF_LMS_CatalogActions;
import pageActions.SF_LMS_CourseRegisterActions;
import pageActions.SF_LMS_MyEmployeesActions;
import pageActions.SF_LMS_SupervisorActions;

public class SuccessFactorLMSModule {

	WebDriver driver;
	SF_LMS_loginActions sfLogin;
	SF_LMS_HomeActions sfHome;
	SF_LMS_CatalogActions sfCat;
	SF_LMS_CourseRegisterActions sfReg;
	SF_LMS_MyEmployeesActions sfEmp;
	SF_LMS_SupervisorActions sfSup;

	@Given("^User launches the Success Factor demo URL for LMS$")
	public void user_launches_the_Success_Factor_demo_URL_for_LMS() throws Throwable {

		System.out.println("Opening Browser");
		driver = CommonUtils.fnLaunchBrowser("url_successfactor_lms",ReadFiles.readPropFile("browser"));
		sfLogin= new SF_LMS_loginActions(driver);

	}

	@Given("^User Enters credentials for \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_Enters_credentials_for_and(String arg1, String arg2) throws Throwable {

		if(arg1.equals("lms_user") && arg2.equals("lms_pwd"))
		{
			sfLogin.userLogin("lms_user", "lms_pwd");
			System.out.println("Login as "+arg1+" Successful");
		}
	}

	@Given("^Supervisor Enters credentials for \"([^\"]*)\" and \"([^\"]*)\"$")
	public void supervisor_Enters_credentials_for_and(String arg1, String arg2) throws Throwable {

		if(arg1.equals("lms_supervisor") && arg2.equals("lms_pwd"))
		{
			sfLogin.userLogin("lms_supervisor", "lms_pwd");
			System.out.println("Login as "+arg1+" Successful");
		}
	}
	@Given("^User navigates to a \"([^\"]*)\"$")
	public void user_navigates_to_a(String tlink) throws Throwable {

		sfHome = new SF_LMS_HomeActions(driver);
		sfHome.navigateTab(tlink);
		System.out.println("Navigated");
		Thread.sleep(3000);
	}

	@Given("^User Clicks on \"([^\"]*)\"$")
	public void user_Clicks_on(String link) throws Throwable {

		sfHome = new SF_LMS_HomeActions(driver);
		sfHome.navigate(link);
		Thread.sleep(3000);
	}

	@Given("^User Searches for \"([^\"]*)\" from catalogue$")
	public void user_Searches_for_from_catalogue(String courseName) throws Throwable {

		sfCat = new SF_LMS_CatalogActions(driver);
		sfCat.SearchCourse(courseName);
		Thread.sleep(5000);
	}
	//Use Below if Pre-requisite is available

	//	@Given("^User clicks on the \"([^\"]*)\" to check and \"([^\"]*)\" the prerequisite$")
	//	public void user_clicks_on_the_to_check_and_the_prerequisite(String courseName,String assignOption) throws Throwable {
	//
	//		
	//			sfCat.SearchCourseResultsPrerequisite(courseName);
	//			sfCat.courseAssignPrerequisite(assignOption);
	//
	//	}

	@Given("^User expands the \"([^\"]*)\"$")
	public void user_expands_the(String courseName) throws Throwable {

		sfCat.SearchCourseResultsMain(courseName);
		Thread.sleep(3000);
	}

	@When("^User selects \"([^\"]*)\"$")
	public void user_selects(String assignOption) throws Throwable {

		sfCat.courseAssignMain(assignOption);
		Thread.sleep(1000);
	}

	@Then("^the course should gets added under my learning Assignments with \"([^\"]*)\"$")
	public void the_course_should_gets_added_under_my_learning_plan_with_(String course) throws Throwable {


		sfHome = new SF_LMS_HomeActions(driver);
		sfHome.assignmentValidation(course);
		Thread.sleep(5000);
	}

	@Then("^the course should gets added or removed under \"([^\"]*)\" learning plan with \"([^\"]*)\"$")
	public void the_course_should_gets_added_or_removed_under_learning_plan_with_(String emp, String item) throws Throwable {


		sfEmp = new SF_LMS_MyEmployeesActions(driver);
		sfEmp.myEmployeeValidationAdd(emp,item);

	}
	@When("^User selects option \"([^\"]*)\" on \"([^\"]*)\"$")
	public void user_selects_option_on(String arg1, String arg2) throws Throwable {

		sfHome = new SF_LMS_HomeActions(driver);
		sfHome.courseActions(arg1, arg2);
		Thread.sleep(3000);
	}

	@Given("^User Applies \"([^\"]*)\" category to select \"([^\"]*)\"$")
	public void user_Applies_category(String arg1,String arg2) throws Throwable {


		sfCat = new SF_LMS_CatalogActions(driver);
		sfCat.FilterSearch(arg1);
		sfCat.filterCheckbox();
		sfCat.selectFilteredCourse(arg2);
		Thread.sleep(4000);

	}

	@When("^User Registers on the Course with an available scheduled offering$")
	public void user_Registers_on_the_Course_with_an_available_scheduled_offering() throws Throwable {

		sfReg = new SF_LMS_CourseRegisterActions(driver);
		sfReg.registerCourse();
		Thread.sleep(2000);
	}
	@Then("^User should be able to Request an schedule$")
	public void user_should_be_able_to_Request_an_schedule() throws Throwable {

		sfReg = new SF_LMS_CourseRegisterActions(driver);
		sfReg.requestSchedule();
		Thread.sleep(2000);

	}
	@Given("^User performs an action \"([^\"]*)\"$")
	public void user_performs_an_action(String action) throws Throwable {
		sfEmp = new SF_LMS_MyEmployeesActions(driver);
		sfEmp.actions(action);
		Thread.sleep(1000);
	}

	@When("^User adds or removes \"([^\"]*)\" and add \"([^\"]*)\" with \"([^\"]*)\" to learning plan$")
	public void user_adds_or_removes_and_add_with_to_learning_plan(String arg1, String arg2, String arg3) throws Throwable {

		sfEmp.addEmployee(arg1);
		Thread.sleep(3000);

		sfEmp.addCourse(arg2);
		Thread.sleep(2000);

		sfEmp.selectAssignmentTytpe(arg3);
		Thread.sleep(1000);

		sfEmp.submit();
		Thread.sleep(5000);
	}

	@When("^User registers or withdraws \"([^\"]*)\" and add \"([^\"]*)\" with \"([^\"]*)\" to learning plan$")
	public void user_registers_or_withdraws_and_add_with_to_learning_plan(String arg1, String arg2, String arg3) throws Throwable {

		sfEmp.addCourse(arg2);
		Thread.sleep(3000);

		sfEmp.addEmployee(arg1);
		Thread.sleep(3000);

		sfEmp.submit_scheduled_offering(arg3);
		Thread.sleep(5000);
	}

	@When("^Supervisor selects an action \"([^\"]*)\"$")
	public void supervisor_selects_an_action_(String action) throws Throwable {

		sfSup = new SF_LMS_SupervisorActions(driver);
		sfSup.SupervisorActions(action);
		sfSup.Confirm();
		Thread.sleep(2000);

	}
	@When("^User selects the enrolled course \"([^\"]*)\" to validate status$")
	public void user_selects_the_enrolled_course_to_validate_status(String course) throws Throwable {

		sfSup = new SF_LMS_SupervisorActions(driver);
		sfSup.validateEnrollmentStatus(course);;

	}
	@Given("^user performs withdraw action on the course \"([^\"]*)\" \"([^\"]*)\"$")
	public void performs_withdraw_action_on_the_course(String action,String reason) throws Throwable {

		sfHome = new SF_LMS_HomeActions(driver);
		sfHome.testRemove(action,reason);
		Thread.sleep(3000);

	}

}

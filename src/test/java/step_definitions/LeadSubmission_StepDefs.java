package step_definitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.env.SharedDriver;
import modules.Lead_Submission;
import modules.Lead_Thankyou_Message;
import modules.NavigateTo_DetailsPage;
import pageFactory.Objects.DetailsPage_POM;
import pageFactory.Objects.HomePage_POM;
import pageFactory.Objects.ListingPage_POM;
import utility.Assertion;
import utility.DD_Util;
import wait_util.Wait_Utils;

public class LeadSubmission_StepDefs {

	public WebDriver driver;
	public HomePage_POM homepage;
	public ListingPage_POM listingpage;
	public DetailsPage_POM detailspage;

	public LeadSubmission_StepDefs(SharedDriver driver) {
		this.driver = driver;
		homepage = new HomePage_POM(driver);
		listingpage = new ListingPage_POM(driver);
		detailspage = new DetailsPage_POM(driver);

	}

	@Then("^I submit the lead submisison form with valid data$")
	public void i_submit_the_lead_submisison_form_with_valid_data(DataTable table) throws Throwable {

		List<List<String>> data = table.raw();

		// Enter name
		detailspage.name_field_bottom.clear();
		detailspage.name_field_bottom.sendKeys(data.get(1).get(1));

		// Enter email
		detailspage.email_field_bottom.clear();
		detailspage.email_field_bottom.sendKeys(data.get(2).get(1));

		// Enter phone
		detailspage.phone_field_bottom.clear();
		detailspage.phone_field_bottom.sendKeys(data.get(3).get(1));

		// Select Country
		Wait_Utils.elementtobeVisible(driver, detailspage.country_dropdown_bottom);
		DD_Util.selectByVisibleText(detailspage.country_dropdown_bottom, data.get(4).get(1));

		// Enter Reamrks
		detailspage.remark_field.sendKeys(data.get(5).get(1));

		// Check Updates
		detailspage.recieve_updates_check_bottom.click();
		detailspage.recieve_updates_check_bottom.click();

		// check Terms and conditions
		detailspage.terms_conditions_check_bottom.click();
	}

	@Then("^I check that the form has been succesfully submitted$")
	public void i_check_that_the_form_has_been_succesfully_submitted() throws Throwable {
		Lead_Thankyou_Message.Execute(driver);
	}

	@Then("^I check that the lead parsing to database succesfully$")
	public void i_check_that_the_lead_parsing_to_database_succesfully() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^I navigate to detailspage$")
	public void i_navigate_to_detailspage() throws Throwable {
		NavigateTo_DetailsPage.Execute(driver);
	}

	@And("^I fill all fields on the form and submit$")
	public void i_fill_all_fields_on_the_form_and_submit() throws Throwable {

		Lead_Submission obj = new Lead_Submission(driver);
		obj.test_BottomLeadSubmission();

	}

	@Then("^I should see thankyou message$")
	public void i_should_see_Thankyou_Message() throws Throwable {
		Lead_Thankyou_Message.Execute(driver);
	}

	@Then("^I should see Thankyou page$")
	public void i_should_see_Thankyou_page() throws Throwable {
		Lead_Thankyou_Message.Execute(driver);
	}

	@When("^I fill \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public void i_fill(String firstname, String email, String phone, String country, String remarks) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(detailspage.name_field_bottom));

		// Enter name
		detailspage.name_field_bottom.clear();
		detailspage.name_field_bottom.sendKeys(firstname);

		// Enter email
		detailspage.email_field_bottom.clear();
		detailspage.email_field_bottom.sendKeys(email);

		// Enter phone
		detailspage.phone_field_bottom.clear();
		detailspage.phone_field_bottom.sendKeys(phone);

		// Select Country
		Wait_Utils.elementtobeVisible(driver, detailspage.country_dropdown_bottom);
		DD_Util.selectByVisibleText(detailspage.country_dropdown_bottom, country);

		// Enter Reamrks
		detailspage.remark_field.sendKeys(remarks);

		// Check Updates
		detailspage.recieve_updates_check_bottom.click();
		detailspage.recieve_updates_check_bottom.click();

		// check Terms and conditions
		detailspage.terms_conditions_check_bottom.click();

	}

	@When("^I hit submit button$")
	public void i_hit_submit_button() throws Throwable {
		// Submit Btn
		detailspage.submit_btn_bottom.click();
	}

	@Then("^I should see successfully submitted$")
	public void i_should_see_successfully_submitted() throws Throwable {
		Lead_Thankyou_Message.Execute(driver);
	}

	@Then("^I go back to Welcome page and verify title$")
	public void i_go_back_to_Welcome_page_and_verify_title() throws Throwable {
		AssertJUnit.assertEquals("Welcome", driver.getTitle());
	}

}
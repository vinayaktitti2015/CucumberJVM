package step_definitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageFactory.Objects.HomePage_Objects;
import wait_Util.Wait_Utils;

public class AddItem_StepDefs {

	WebDriver driver;
	public HomePage_Objects page;

	public AddItem_StepDefs() {
		driver = Hooks.driver;
		page = new HomePage_Objects(driver);
	}

	@Then("^I click on content editor link$")
	public void i_click_on_content_editor_link() throws Throwable {
	}

	@Then("^I mouse hover to Home button$")
	public void i_mouse_hover_to_Home_button() throws Throwable {

		/*WebElement element = page.home_btn;

		Actions action = new Actions(driver);
		action.contextClick((element)).click().build().perform();

		Wait_Utils.elementtobeClickable(driver, page.insert_btn_home);*/

	}

	@Then("^I right click on home button$")
	public void i_right_click() throws Throwable {

		/*WebElement element = page.insert_btn_home;
		element.click();*/

	}

	@Then("^I click on sample item$")
	public void i_click_on_sample_item() throws Throwable {

		/*wait_Util.Wait_Utils.elementtobeClickable(driver, page.sample_item);
		page.sample_item.click();*/
	}

	@Then("^I enter name \"([^\"]*)\" in the editbox$")
	public void i_enter_name_in_the_editbox(String arg1) throws Throwable {
	/*	page.editbox_name.clear();
		page.editbox_name.sendKeys(arg1);*/
	}

	@Then("^I click on OK button$")
	public void i_click_OK_button() throws Throwable {
	}
	
	
	@When("^I click on Review Button$")
	public void i_click_on_Review_Button() throws Throwable {
	}

	@Then("^I click on submit button$")
	public void i_click_on_submit_button() throws Throwable {
	}

	@Then("^I enter \"([^\"]*)\" in comments section$")
	public void i_enter_in_comments_section(String arg1) throws Throwable {
	}
	
	@Then("^I click on OK ON COMMENTS button$")
	public void i_click_on_OK_ON_COMMENTS_button() throws Throwable {
	}

	@Then("^I click on Publish button$")
	public void i_click_on_Publish_button() throws Throwable {
	}


}

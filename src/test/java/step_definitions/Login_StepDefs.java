package step_definitions;

import org.openqa.selenium.WebDriver;

import config.ReadProperty;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.env.SharedDriver;
import modules.ConsumerLogin;
import pageFactory.Objects.LoginPage_POM;
import wait_util.Wait_Utils;

public class Login_StepDefs {

	public WebDriver driver;
	public ReadProperty prop;
	public LoginPage_POM page;

	public Login_StepDefs(SharedDriver driver) {
		this.driver = driver;
		page = new LoginPage_POM(driver);
		prop = new ReadProperty();
	}

	@When("^I click on login button$")
	public void i_click_on_login_button() throws Throwable {
		Wait_Utils.elementtobeClickable(driver, page.login_btn_homepage);
		page.clickLogin();
	}

	@Then("^I enter Username \"([^\"]*)\"$")
	public void i_enter_Username(String arg1) throws Throwable {
		Wait_Utils.elementtobeVisible(driver, page.username_field);
		page.enterusername(arg1);
	}

	@Then("^I enter Password \"([^\"]*)\"$")
	public void i_enter_Password(String arg1) throws Throwable {
		page.enterpassword(arg1);
	}

	@Then("^I click submit button$")
	public void i_click_submit_button() throws Throwable {
		page.clickSubmit();
	}

	@Then("^I should see account name \"([^\"]*)\"$")
	public void i_should_see_account_name(String expected) throws Throwable {
		Wait_Utils.elementtobeVisible(driver, page.account_name);
		page.checkAccountname(expected);
	}

	@When("^I login as Consumer$")
	public void i_login_as_Consumer() throws Throwable {
		ConsumerLogin obj = new ConsumerLogin(driver);
		ConsumerLogin.test_SuccessfulLogin();
	}

	@Then("^I Logout as user$")
	public void i_Logout_as_user() throws Throwable {

		page.clickArrowdown();
		Wait_Utils.elementtobeClickable(driver, page.logout);
		page.clickLogout();
	}

}

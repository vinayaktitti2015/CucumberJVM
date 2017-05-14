package step_definitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import config.ReadProperty;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.env.SharedDriver;
import pageFactory.Objects.HomePage_POM;
import pageFactory.Objects.ListingPage_POM;
import utility.CommonUtils;
import utility.Generic_Library;
import wait_util.Wait_Utils;

public class HomePage_StepDefs {

	public WebDriver driver;
	ReadProperty prop;
	HomePage_POM homepage;
	ListingPage_POM listing_page;

	public HomePage_StepDefs(SharedDriver driver) {
		this.driver = driver;
		prop = new ReadProperty();
		homepage = new HomePage_POM(driver);
		listing_page = new ListingPage_POM(driver);
	}

	@Given("^I open Iproperty Website$")
	public void i_open_Iproperty_Website() throws Throwable {
		driver.get(prop.getKey("baseurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("^I navigate to newlaunch sub-page$")
	public void i_navigate_to_newlaunch_sub_page() throws Throwable {
		homepage.clickNewlaunch();
	}

	@When("^I select \"([^\"]*)\" as propType$")
	public void i_select_as_propType(String arg1) throws Throwable {
		homepage.selectPropType(arg1);
	}

	@When("^I click search button$")
	public void i_click_search_button() throws Throwable {
		homepage.clickSearchbtn();
	}

	@When("^I search for \"([^\"]*)\"$")
	public void i_search_for(String arg1) throws Throwable {
		homepage.searchKeyword(arg1);
	}

	@Then("^The propType should contain \"([^\"]*)\"$")
	public void the_propType_should_contain(String expected_propType) throws Throwable {

		List<WebElement> all_proType = listing_page.propertytype_assertion;
		int propertylist = all_proType.size();
		int count = 0;
		String[] array_propType = new String[propertylist];

		for (WebElement proType : all_proType) {

			String actual_propType = proType.getText();
			// array_propType[count] = proType.getText();

			// actual_propType = array_propType[count];
			// count++;

			if (!expected_propType.contains(actual_propType)) {

				throw new Exception("Expected PropType Not Found: " + expected_propType + "Actual ProType Showing: "
						+ actual_propType);
			}

		}

	}

	@Then("^The breadcrumb should be like \"([^\"]*)\"$")
	public void the_breadcrumb_should_be_like(String expected) throws Throwable {

		String actual_breadcrumb = listing_page.breadcrumb.getText();
		Assert.assertEquals(actual_breadcrumb, expected);

	}

	@Then("^The header should be like \"([^\"]*)\"$")
	public void the_header_should_be_like(String expected) throws Throwable {

		String actual_header = listing_page.header.getText();
		Assert.assertTrue(actual_header.contains(expected),
				"Header Mis-Matched>>>" + "Expected:  " + expected + "Actual Showing:  " + actual_header);
	}

	@Then("^I should see listing as \"([^\"]*)\"$")
	public void i_should_see_listing_as(String expected) throws Throwable {
		Wait_Utils.elementtobeVisible(driver, listing_page.development_name);
		String actual = listing_page.development_name.getText();
		Assert.assertEquals(actual, expected);

	}

	@Then("^I click on view details button$")
	public void i_click_on_view_details_button() throws Throwable {

		listing_page.view_details_btn.click();
	}

	@When("^I Type \"([^\"]*)\"$")
	public void i_Type(String arg1) throws Throwable {
		homepage.search_Box.sendKeys(arg1);
		CommonUtils.pause(2000);
	}

	@When("^select autosuggestoption \"([^\"]*)\"$")
	public void select_autosuggestoption(String arg1) throws Throwable {

		Generic_Library.selectAutoCompletion(driver, homepage.auto_completion, arg1);
	}

}

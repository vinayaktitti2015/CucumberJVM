package step_definitions;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.env.SharedDriver;
import wait_util.Wait_Utils;

public class Predefined_StepDefs {

	public WebDriver driver;
	static String parenthandle;

	public Predefined_StepDefs(SharedDriver driver) {
		this.driver = driver;
	}

	/********* Navigation Steps *************/

	// Step to navigate to specified URL
	@Then("^I navigate to \"([^\"]*)\"$")
	public void navigate_to(String link) {
		driver.navigate().to(link);
	}

	// Step to navigate forward
	@Then("^I navigate forward")
	public void navigate_forward() {
		driver.navigate().forward();
	}

	// Step to navigate backward
	@Then("^I navigate back")
	public void navigate_back() {
		driver.navigate().back();
	}

	// steps to refresh page
	@Then("^I refresh page$")
	public void refresh_page() {
		driver.navigate().refresh();
	}

	@Then("^The parsing URL should be like \"([^\"]*)\"$")
	public void the_parsing_URL_should_be_like(String arg1) throws Throwable {

		String URL = driver.getCurrentUrl();
		Assert.assertTrue("URL Not Matched" + URL, URL.contains(arg1));

	}

	/********** Switch between windows *************/

	// Switch to new window
	@Then("^I swicth to child window$")
	public void i_swicth_to_child_window() throws Throwable {
		parenthandle = driver.getWindowHandle();

		Set<String> strhandle = driver.getWindowHandles();
		for (String childhandle : strhandle) {
			driver.switchTo().window(childhandle);
			break;
		}
	}

	// Switch to old window
	@Then("^I switch back to parent window$")
	public void switch_to_parent_window() {

		driver.switchTo().window(parenthandle);
	}

	// Switch to new window by window title
	@Then("^I switch to window having title \"(.*?)\"$")
	public void switch_to_window_by_title(String windowTitle) throws Exception {
		driver.switchTo().window(windowTitle);
	}

	// Close new window
	@Then("^I close new window$")
	public void close_new_window() {
		driver.close();
	}

	/******** Switch between frame *************/

	@Then("^I switch to frame having id \"([^\"]*)\"$")
	public void i_switch_to_frame_having_id(String arg1) throws Throwable {
		driver.switchTo().frame(driver.findElement(By.id(arg1)));
	}

	@Then("^I switch to iframe$")
	public void i_switch_to_iframe() throws Throwable {
		WebElement iFrame = driver.findElement(By.tagName("iframe"));

		driver.switchTo().frame(iFrame);
	}

	// Step to switch to frame by web element
	@Then("^I switch to frame having index \"(.*?)\"$")
	public void switch_frame_by_index(int arg1) {
		driver.switchTo().frame(arg1);
	}

	// step to switch to main content
	@Then("^I switch to main content$")
	public void switch_to_main_content() {
		driver.switchTo().defaultContent();
	}

	@When("^I switch parent frame$")
	public void i_switch_parent_frame() throws Throwable {
		driver.switchTo().parentFrame();
	}

	/********** To interact with browser ************/

	// step to resize browser
	@Then("^I resize browser window size to width (\\d+) and height (\\d+)$")
	public void resize_browser(int width, int heigth) {
	}

	// step to maximize browser
	@Then("^I maximize browser window$")
	public void maximize_browser() {
	}

	// Step to close the browser
	@Then("^I close browser$")
	public void close_browser() {

		driver.close();
	}

	/********* zoom in/out page ************/

	// steps to zoom in page
	@Then("^I zoom in page$")
	public void zoom_in() {
	}

	// steps to zoom out page
	@Then("^I zoom out page$")
	public void zoom_out() {
	}

	// zoom out webpage till necessary element displays

	// steps to zoom out till element displays
	@Then("^I zoom out page till I see element having (.+) \"(.*?)\"$")
	public void zoom_till_element_display(String type, String accessName) throws Exception {
	}

	// reset webpage view use
	@Then("^I reset page view$")
	public void reset_page_zoom() {
	}

	/********* scroll webpage **********/

	@Then("^I scroll to (top|end) of page$")
	public void scroll_page(String to) throws Exception {
	}

	// scroll webpage to specific element
	@Then("^I scroll to element having (.+) \"(.*?)\"$")
	public void scroll_to_element(String type, String accessName) throws Exception {
	}

	/******** hover over element ************/

	// Note: Doesn't work on Windows firefox
	@Then("^I hover over element having (.+) \"(.*?)\"$")
	public void hover_over_element(String type, String accessName) throws Exception {
	}

	/********* Assertion steps *************/

	/**
	 * page title checking
	 * 
	 * @param present
	 *            :
	 * @param title
	 *            :
	 */
	@Then("^I should\\s*((?:not)?)\\s+see page title as \"(.+)\"$")
	public void check_title(String present, String title) {
		// System.out.println("Present :" + present.isEmpty());
	}

	// step to check element partial text
	@Then("^I should\\s*((?:not)?)\\s+see page title having partial text as \"(.*?)\"$")
	public void check_partial_text(String present, String partialTextTitle) {
		// System.out.println("Present :" + present.isEmpty());
	}

	// step to check element text
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have text as \"(.*?)\"$")
	public void check_element_text(String type, String accessName, String present, String value) throws Exception {
	}

	// step to check element partial text
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have partial text as \"(.*?)\"$")
	public void check_element_partial_text(String type, String accessName, String present, String value)
			throws Exception {
	}

	// step to check attribute value
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+have attribute \"(.*?)\" with value \"(.*?)\"$")
	public void check_element_attribute(String type, String accessName, String present, String attrb, String value)
			throws Exception {
	}

	// step to check element enabled or not
	@Then("^element having (.+) \"([^\"]*)\" should\\s*((?:not)?)\\s+be (enabled|disabled)$")
	public void check_element_enable(String type, String accessName, String present, String state) throws Exception {
	}

	// step to check element present or not
	@Then("^element having (.+) \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
	public void check_element_presence(String type, String accessName, String present) throws Exception {
	}

	// step to assert checkbox is checked or unchecked
	@Then("^checkbox having (.+) \"(.*?)\" should be (checked|unchecked)$")
	public void is_checkbox_checked(String type, String accessName, String state) throws Exception {
	}

	// steps to assert radio button checked or unchecked
	@Then("^radio button having (.+) \"(.*?)\" should be (selected|unselected)$")
	public void is_radio_button_selected(String type, String accessName, String state) throws Exception {
	}

	// steps to assert option by text from radio button group
	// selected/unselected
	@Then("^option \"(.*?)\" by (.+) from radio button group having (.+) \"(.*?)\" should be (selected|unselected)$")
	public void is_option_from_radio_button_group_selected(String option, String attrb, String type, String accessName,
			String state) throws Exception {
	}

	// steps to check link presence
	@Then("^link having text \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
	public void check_element_presence(String accessName, String present) throws Exception {
	}

	// steps to check partail link presence
	@Then("^link having partial text \"(.*?)\" should\\s*((?:not)?)\\s+be present$")
	public void check_partial_element_presence(String accessName, String present) throws Exception {
	}

	// step to select dropdown list
	@Then("^option \"(.*?)\" by (.+) from dropdown having (.+) \"(.*?)\" should be (selected|unselected)$")
	public void is_option_from_dropdown_selected(String option, String by, String type, String accessName, String state)
			throws Exception {
	}

	// step to check dynamic text isPresent

	@Then("^I should see \"([^\"]*)\"$")
	public void i_should_see(String arg1) throws Throwable {
		WebElement element = driver.findElement(By.tagName("html"));
		Wait_Utils.elementtobeVisible(driver, element);

		if (!element.getText().contains(arg1)) {

			throw new Exception("Exepected Text Not Found: " + arg1);
		}
	}

	@Then("^I should not see \"([^\"]*)\"$")
	public void i_should_not_see(String arg1) throws Throwable {
		String text = driver.findElement(By.tagName("html")).getText();
		Assert.assertTrue("Should Not Display: " + arg1, !text.contains(arg1));
	}

	/********** Input steps **********/

	// enter text into input field steps
	@Then("^I enter \"([^\"]*)\" into input field having (.+) \"([^\"]*)\"$")
	public void enter_text(String text, String type, String accessName) throws Exception {
	}

	// clear input field steps
	@Then("^I clear input field having (.+) \"([^\"]*)\"$")
	public void clear_text(String type, String accessName) throws Exception {
	}

	/********** Select Options ***********/

	// select option by text/value from dropdown
	@Then("^I select \"(.*?)\" option by (.+) from dropdown having (.+) \"(.*?)\"$")
	public void select_option_from_dropdown(String option, String optionBy, String type, String accessName)
			throws Exception {
	}

	// select option by index from dropdown
	@Then("^I select (\\d+) option by index from dropdown having (.+) \"(.*?)\"$")
	public void select_option_from_dropdown_by_index(String option, String type, String accessName) throws Exception {
	}

	// select option by text/value from multiselect
	@Then("^I select \"(.*?)\" option by (.+) from multiselect dropdown having (.+) \"(.*?)\"$")
	public void select_option_from_multiselect_dropdown(String option, String optionBy, String type, String accessName)
			throws Exception {
	}

	// select option by index from multiselect
	@Then("^I select (\\d+) option by index from multiselect dropdown having (.+) \"(.*?)\"$")
	public void select_option_from_multiselect_dropdown_by_index(String option, String type, String accessName)
			throws Exception {
	}

	// deselect option by text/value from multiselect
	@Then("^I deselect \"(.*?)\" option by (.+) from multiselect dropdown having (.+) \"(.*?)\"$")
	public void deselect_option_from_multiselect_dropdown(String option, String optionBy, String type,
			String accessName) throws Exception {
	}

	// deselect option by index from multiselect
	@Then("^I deselect (\\d+) option by index from multiselect dropdown having (.+) \"(.*?)\"$")
	public void deselect_option_from_multiselect_dropdown_by_index(String option, String type, String accessName)
			throws Exception {
	}

	// step to select option from mutliselect dropdown list
	/*
	 * @Then(
	 * "^I select all options from multiselect dropdown having (.+) \"(.*?)\"$")
	 * public void select_all_option_from_multiselect_dropdown(String
	 * type,String accessName) throws Exception {
	 * miscmethod.validateLocator(type); //inputObj.
	 * //select_all_option_from_multiselect_dropdown(type, access_name) }
	 */

	// step to unselect option from mutliselect dropdown list
	@Then("^I deselect all options from multiselect dropdown having (.+) \"(.*?)\"$")
	public void unselect_all_option_from_multiselect_dropdown(String type, String accessName) throws Exception {
	}

	/************ Checkbox & Radio button **************/

	// check checkbox steps
	@Then("^I check the checkbox having (.+) \"(.*?)\"$")
	public void check_checkbox(String type, String accessName) throws Exception {
	}

	// uncheck checkbox steps
	@Then("^I uncheck the checkbox having (.+) \"(.*?)\"$")
	public void uncheck_checkbox(String type, String accessName) throws Exception {
	}

	// steps to toggle checkbox
	@Then("^I toggle checkbox having (.+) \"(.*?)\"$")
	public void toggle_checkbox(String type, String accessName) throws Exception {
	}

	// step to select radio button
	@Then("^I select radio button having (.+) \"(.*?)\"$")
	public void select_radio_button(String type, String accessName) throws Exception {
	}

	// steps to select option by text from radio button group
	@Then("^I select \"(.*?)\" option by (.+) from radio button group having (.+) \"(.*?)\"$")
	public void select_option_from_radio_btn_group(String option, String by, String type, String accessName)
			throws Exception {
		// miscmethodObj.validateOptionBy(optionBy);
	}

	/********** Click element Steps ****************/

	// click on web element
	@Then("^I click on element \"(.*?)\" having \"(.*?)\"$")
	public void click(String locatorValue, String locatorType) throws Exception {

		try {
			switch (locatorType) {
			case "id":
				driver.findElement(By.id(locatorValue)).click();
				break;
			case "xpath":
				driver.findElement(By.xpath(locatorValue)).click();
				break;
			case "classname":
				driver.findElement(By.className(locatorValue)).click();
				break;
			case "name":
				driver.findElement(By.name(locatorValue)).click();
				break;
			case "css":
				driver.findElement(By.cssSelector(locatorValue)).click();
				break;
			case "linktext":
				driver.findElement(By.linkText(locatorValue)).click();
				break;
			default:
				throw new Exception("No Element found");

			}
		} catch (Exception e) {

			throw new Exception("Not able to click element" + e.getMessage());
		}
	}

	// Forcefully click on element
	@Then("^I forcefully click on element having (.+) \"(.*?)\"$")
	public void click_forcefully(String type, String accessName) throws Exception {
	}

	// double click on web element
	@Then("^I double click on element having (.+) \"(.*?)\"$")
	public void double_click(String type, String accessValue) throws Exception {
	}

	// steps to click on link
	@Then("^I click on link having text \"(.*?)\"$")
	public void click_link(String accessName) {
	}

	// Step to click on partial link
	@Then("^I click on link having partial text \"(.*?)\"$")
	public void click_partial_link(String accessName) {

	}

	/************** Wait Progress methods ****************/

	@Given("^I implicitly wait for \"([^\"]*)\" seconds$")
	public void i_implicitly_wait_for_seconds(long arg1) throws Throwable {
		driver.manage().timeouts().implicitlyWait(arg1, TimeUnit.SECONDS);
	}

	@When("^I implicitly wait for few seconds$")
	public void i_implicitly_wait_for_few_seconds() throws Throwable {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// wait for specific period of time
	@Then("^I sleep for \"([^\"]*)\" seconds$")
	public void i_sleep_for_seconds(long arg1) throws Throwable {
		Thread.sleep(arg1);
	}
	
	@Then("^I sleep for few seconds$")
	public void i_sleep_for_few_seconds() throws Throwable {
		Thread.sleep(1000);
	}

	// wait for specific element to display for specific period of time
	@Then("^I wait (\\d+) seconds for element having (.+) \"(.*?)\" to display$")
	public void wait_for_ele_to_display(String duration, String type, String accessName) throws Exception {
	}

	// wait for specific element to enable for specific period of time
	@Then("^I wait (\\d+) seconds for element having (.+) \"(.*?)\" to be enabled$")
	public void wait_for_ele_to_click(String duration, String type, String accessName) throws Exception {
	}

	/********* JavaScript handling steps ***************/

	// Step to handle java script
	@Then("^I accept alert$")
	public void handle_alert() {
		driver.switchTo().alert().accept();
	}

	// step to assert javascript pop-up alert text
	@Then("^I should see alert text as \"(.*?)\"$")
	public void check_alert_text(String actualValue) {

		String text = driver.switchTo().alert().getText();
		Assert.assertTrue("Alert Text Not Found", text.contains(actualValue));
	}

	// Steps to dismiss java script
	@Then("^I dismiss alert$")
	public void dismiss_alert() {

		driver.switchTo().alert().dismiss();
	}

	/********** Screen shot methods **************/

	@Then("^I take screenshot$")
	public void take_screenshot() throws IOException {
	}

	/********* Configuration steps **************/

	// step to print configuration
	@Then("^I print configuration$")
	public void print_config() {
	}

	/********* Cookie Handling **********/

	@Then("^I delete all cookies$")
	public void i_delete_all_cookies() throws Throwable {
		driver.manage().deleteAllCookies();
	}
}

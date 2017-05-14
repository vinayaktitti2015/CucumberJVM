package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import config.Constants;
import pageFactory.Objects.LoginPage_POM;
import utility.Assertion;
import utility.Capture_Screenshot;
import utility.Generic_Library;
import wait_util.Wait_Utils;


/**
 *
 * @author Vinayak Titti
 */

public class ConsumerLogin {
	
	public LoginPage_POM page;
	static WebDriver driver;
	
	public ConsumerLogin(WebDriver driver){
		this.driver = driver;
		page = new LoginPage_POM(driver);
	}


	// MY & SG - Method to Execute
	public static void test_SuccessfulLogin() throws Exception {

		String url = driver.getCurrentUrl();
		if (url.contains(".my")) {

			try {
				ConsumerLogin obj = new ConsumerLogin(driver);
				obj.ConsumerLogin_MY(driver);
			} finally {
				Capture_Screenshot.getName(driver, "ConsumerLogin_MY");
			}

		} else {
			try {
				ConsumerLogin obj = new ConsumerLogin(driver);
				obj.ConsumerLogin_SG(driver);
			} finally {
				Capture_Screenshot.getName(driver, "ConsumerLogin_SG");
			}
		}

	}

	// MY Login method
	public void ConsumerLogin_MY(WebDriver driver) throws Exception {

		// click login btn on Home Page
		Wait_Utils.implicitwait(driver);
		page.login_btn_homepage.click();

		// navigate to Pop Up Login
		Generic_Library.Window_Handler(driver);
		Wait_Utils.elementtobeVisible(driver, page.username_field);

		// enter user credentials
		page.username_field.clear();
		page.username_field.sendKeys(Constants.TestData_my.getData("UserLogin", 1, 2));
		page.password_field.clear();
		page.password_field.sendKeys(Constants.TestData_my.getData("UserLogin", 1, 3));
		page.submit_btn.click();

		// verify Account Name displayed after successful login
		Assertion.AssertEquals(driver, page.account_name, Constants.TestData_my.getData("UserLogin", 1, 4), "Consumer Name Not Found After Login");

	}

	// SG Login Method
	public void ConsumerLogin_SG(WebDriver driver) throws Exception {

		// click LOGIN btn
		Wait_Utils.elementtobeClickable(driver, page.loginbtn_homepage_SG);
		page.loginbtn_homepage_SG.click();

		// verify Login Page Text
		Assert.assertTrue(driver.findElement(By.xpath("//h1[contains(.,'Member Login')]")).isDisplayed(),
				"Member Login Page Broken : ");

		// enter user credentials
		page.username_field_SG.clear();
		page.username_field_SG.sendKeys(Constants.TestData_my.getData("UserLogin", 1, 2));
		page.password_field_SG.clear();
		page.password_field_SG.sendKeys(Constants.TestData_my.getData("UserLogin", 1, 3));
		page.submit_btn_SG.click();

		// verify Account Name displayed after successful login
		Assertion.AssertEquals(driver, page.acctount_name_SG, Constants.TestData_my.getData("UserLogin", 1, 4), "Consumer Name Not Found After Login");

		// verify dashboard text
		Assert.assertEquals(page.iproperty_dashboard_text.getText(), "My iProperty Dashboard");

	}

}

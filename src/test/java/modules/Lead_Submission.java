package modules;

/**
*
* @author Vinayak Titti
* Date: 14/9/2016
*/

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.Robot;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import config.Constants;
import main.env.SharedDriver;
import pageFactory.Objects.DetailsPage_POM;
import pageFactory.Objects.HomePage_POM;
import pageFactory.Objects.ListingPage_POM;
import utility.Assertion;
import utility.Javascript_Util;
import wait_util.Wait_Utils;

public class Lead_Submission {

	static String Name_frontend, Email_frontend, Phone_frontend, Country_frontend,
	Remarks_frontend, Country_frontend_custom;
	WebDriver driver = null;
	static String date_frontend;
	public HomePage_POM homepage;
	public ListingPage_POM listpage;
	public DetailsPage_POM detailspage;

	public Lead_Submission(WebDriver driver) {
		this.driver = driver;
		homepage = new HomePage_POM(driver);
		listpage = new ListingPage_POM(driver);
		detailspage = new DetailsPage_POM(driver);
	}

	public void test_BottomLeadSubmission() throws Exception {

		// READ LEAD DATA FROM EXCEL
		int iRow = 1;
		Name_frontend = Constants.TestData_my.getData("LeadSubmissionData", iRow, 1);
		Email_frontend = Constants.TestData_my.getData("LeadSubmissionData", iRow, 2);
		Phone_frontend = Constants.TestData_my.getData("LeadSubmissionData", iRow, 3);
		Country_frontend = Constants.TestData_my.getData("LeadSubmissionData", iRow, 4);
		Country_frontend_custom = Constants.TestData_my.getData("LeadSubmissionData", iRow, 5);
		Remarks_frontend = Constants.TestData_my.getData("LeadSubmissionData", iRow, 6);

		Wait_Utils.elementtobeVisible(driver, detailspage.name_field_bottom);
		// Enter name
		detailspage.name_field_bottom.clear();
		detailspage.name_field_bottom.sendKeys(Name_frontend);

		// Enter email
		detailspage.email_field_bottom.clear();
		detailspage.email_field_bottom.sendKeys(Email_frontend);

		// Enter phone
		detailspage.phone_field_bottom.clear();
		detailspage.phone_field_bottom.sendKeys(Phone_frontend);

		Wait_Utils.PresenceofElementLocated(driver, (By) detailspage.country_dropdown_bottom);

		// Select Country
		Select_CountryDD.Execute(driver, detailspage.country_dropdown_bottom, Country_frontend);

		// Verify Remarks content isDisplayed
		/*
		 * JavascriptExecutor exe= (JavascriptExecutor) driver;
		 * exe.executeScript("documnet.getElementByName('remark').value;");
		 */

		detailspage.remark_field.sendKeys(Remarks_frontend);

		// check Terms and conditions
		detailspage.terms_conditions_check_bottom.click();

		// Submit Btn
		detailspage.submit_btn_bottom.click();

	}

	public void test_TopLeadSubmisison(WebDriver driver) throws Exception {

		// ENTER LEAD DATA
		int iRow = 2;
		Name_frontend = Constants.TestData_my.getData("LeadSubmissionData", iRow, 1);
		Email_frontend = Constants.TestData_my.getData("LeadSubmissionData", iRow, 2);
		Phone_frontend = Constants.TestData_my.getData("LeadSubmissionData", iRow, 3);
		Country_frontend = Constants.TestData_my.getData("LeadSubmissionData", iRow, 4);
		Country_frontend_custom = Constants.TestData_my.getData("LeadSubmissionData", iRow, 5);
		Remarks_frontend = "";

		// put implicit wait
		Wait_Utils.elementtobeClickable(driver, detailspage.name_field_top);

		// Enter name
		detailspage.name_field_top.clear();
		detailspage.name_field_top.sendKeys((Name_frontend));

		// Enter email
		detailspage.email_field_top.clear();
		detailspage.email_field_top.sendKeys(Email_frontend);

		// Enter phone
		detailspage.phone_field_top.clear();
		detailspage.phone_field_top.sendKeys(Phone_frontend);

		// verify default value & Select Country
		Select_CountryDD.Execute(driver, detailspage.country_dropdown_top, Country_frontend);

		Wait_Utils.elementtobeClickable(driver, detailspage.terms_conditions_check_top);

		// check Terms and conditions
		detailspage.terms_conditions_check_top.click();

		Wait_Utils.elementtobeClickable(driver, detailspage.submit_btn_top);

		// Submit Btn
		detailspage.submit_btn_top.click();

		// put implicit wait
		Wait_Utils.implicitwait(driver);

		// Verify Thankyou message
		Lead_Thankyou_Message.Execute(driver);

	}

}

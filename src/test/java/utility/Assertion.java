package utility;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class Assertion {

	// pass actual & expected values in the script ex:
	// class.Execute(driver,"actual","expected");

	public static void AssertEquals(WebDriver driver, WebElement locator, String expected, String message)
			throws IOException {

		String Actual;
		WebElement element = locator;
		Actual = element.getText();
		System.out.println("Actual Message Showing: " + Actual);
		
		if (!expected.contentEquals(Actual)) {
			System.out.println("Actual Message Showing : " + Actual);
			System.out.println("Expected Message Should Show : " + expected);
		}

		Assert.assertEquals(Actual, expected, message);

	}
	
	
	public static void AssertContains(WebDriver driver, WebElement locator, String expected)
			throws Exception {

		String Actual;
		WebElement element = locator;
		Actual = element.getText();
		
		System.out.println("Actual Message Showing: " + Actual);

		if (!Actual.contains(expected)) {
			throw new Exception("Actual Message Showing : " + Actual + "Expected Message Should Show : " + expected );
		}

	}

	public static void SplitText(WebDriver driver, WebElement locator, String expected, String textname)
			throws IOException {
		String st1 = "This World is Very Nice";
		String st2 = " And Beautiful.";
		String Actual;

		WebElement element = locator;
		Actual = element.getText();
		st1 = "Size : 1024 sq. ft. - 1600 sq. ft.";
		st2 = "Location : Bukit Jelutong, Shah Alam, Selangor Posted Date : 17/01/2011";
		String splt[] = Actual.split(st2);
		System.out.println("String Part 1 Is -> " + splt[0]);
		Assert.assertEquals(splt[0], expected);
		System.out.println("Actual Element: " + splt);
		System.out.println("Expected Element: " + expected);
	}

	public static void AssertEquals(WebDriver driver, String Actual, String expected, String textname) {
		// TODO Auto-generated method stub
		SoftAssert Assert = new SoftAssert();
		Assert.assertEquals(Actual, expected,
				"Actual Message Showing : " + Actual + ">>>" + "Expected Message Should Show : " + expected);

		if (!expected.contentEquals(Actual)) {
			System.out.println("Actual Message : " + Actual);
			System.out.println("Expected Message : " + expected);
		}

		Assert.assertAll();

	}

	public static void isSelected(WebDriver driver, WebElement locator, String message) throws IOException {

		Assert.assertTrue(locator.isSelected(), message);

	}

	public static void isEnabled(WebDriver driver, WebElement locator, String message) throws IOException {

		Assert.assertTrue(locator.isEnabled(), message);

	}

	public static void isDisplayed(WebDriver driver, WebElement locator, String message) throws IOException {
		// Assert.assertTrue(driver.getTitle().contains("Selenium"));
		Assert.assertTrue(locator.isDisplayed(), message);

	}

	public static void verify_Title(WebDriver driver, String expected, String result) throws IOException {

			Assert.assertEquals(driver.getTitle(), expected, result);
	}

	public static void verify_Text_Boolean(WebDriver driver, WebElement locator, String textname) throws IOException {

		try {

			WebElement TextFile = locator;
			String Actual = TextFile.getText();
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", Actual);

			if (!ImagePresent) {
				System.out.println(Actual + "  Text NOT Found.");
			} else {
				System.out.println(Actual + " Text  Found.");
			}

		} catch (Exception e) {
			System.out.println(e.getClass());
			e.printStackTrace();
		}

	}

	// pass actual & expected values in the script
	// ex:class.Execute(driver,"actual","expected");

	public static void verify_TY_Message(WebDriver driver, WebElement path, String expected) throws IOException {

		try {
			String Element1 = "Make sure to check these out!";
			assertTrue("Verification failed: Element1 and Element2 are not same.",
					Element1.equals(driver.findElement(By.className("home__section__title")).getText()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void Verify_Image_Boolean(WebDriver driver, WebElement locator, String pagename) throws IOException {

		// GETTING CC IMAGE

		try {

			WebElement ImageFile = locator;
			Boolean ImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					ImageFile);

			if (!ImagePresent) {
				System.out.println(pagename + "  IMAGE NOT DISPLAYED.");
			} else {
				System.out.println(pagename + " IMAGE DISPLAYED.");
			}

		} catch (Exception e) {
			System.out.println(e.getClass());
			e.printStackTrace();
		}

	}

	public static void Verift_Alert_Text(WebDriver driver, String expected) {

		try {

			// Now once we hit AlertButton we get the alert
			Alert alert = driver.switchTo().alert();
			// Text displayed on Alert using getText() method of Alert class
			String Actual = alert.getText();
			// accept() method of Alert Class is used for ok button
			alert.accept();
			// Verify Alert displayed correct message to user
			SoftAssert Assert = new SoftAssert();
			Assert.assertEquals(Actual, expected);

			if (!expected.contentEquals(Actual)) {
				System.out.println("Actual Text Showing: " + Actual);
				System.out.println("Expected Text Should Show : " + expected);
				System.out.println("Assertion Failed");
			}
			Assert.assertAll();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void Verify_Element_Exist(WebElement locator) {
		// TODO Auto-generated method stub
		WebElement element = locator;
		System.out.println(Exist(element));
	}

	public static boolean Exist(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public static void Verify_error_message(WebDriver driver, WebElement username_element, WebElement submitbtn_element,
			WebElement errormessage_locator, String value, String Expected, String Formfieldname) throws IOException {

		username_element.clear();
		username_element.sendKeys(value);
		submitbtn_element.click();

		WebElement alertMessage = errormessage_locator;
		String Actual = alertMessage.getText();

		SoftAssert Assert = new SoftAssert();
		Assert.assertEquals(Expected, Actual);

		if (!Expected.contentEquals(Actual)) {
			System.out.println(Formfieldname + " Error Message Not displayed  ");
		}

		Assert.assertAll();
		// System.out.println(Actual);
	}

}

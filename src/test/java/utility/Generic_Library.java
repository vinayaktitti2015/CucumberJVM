package utility;

/**
*
* @author Vinayak Titti
*/

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Generic_Library {

	/*******************
	 * User Defined Functions
	 **************************************/

	private static long _waitTime = 1000;

	public static long waitTime() {
		return _waitTime;
	}

	public static void handleAlert(WebDriver driver) {

		if (isAlertPresent(driver)) {
			Alert alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}
	}

	public static boolean isAlertPresent(WebDriver driver) {

		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}

	public static void Window_Handler(WebDriver driver) throws IOException {

		// get the main handle and remove it
		// whatever remains is the child pop up window handle

		String parentWindowHandler = driver.getWindowHandle(); // Store your
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window
															// handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);

		// switch back to parent window
		// driver.switchTo().window(parentWindowHandler);

	}

	public static String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		return (dateFormat.format(date));

	}

	/*******************
	 * Date Added: 23/9/2016
	 **************************************/

	public boolean PageLoadSuccess(WebDriver outDriver, String pageMark) {
		long end = System.currentTimeMillis() + (waitTime() * 24);
		while (System.currentTimeMillis() < end) {
			try {
				WebElement resultsDom = outDriver.findElement(By.id(pageMark));
				return resultsDom.isDisplayed();
			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}

	public void navigateWeb(WebDriver driver, String website) {
		driver.get(website);
		try {
			driver.wait(waitTime());
		} catch (Exception e) {
		}
	}

	public int closeBrowser(WebDriver driver) {
		driver.quit();
		return 1;
	}

	public WebElement findElementByID(WebDriver driver, String elementID) {
		try {
			WebElement we = driver.findElement(By.id(elementID));
			return we;
		} catch (Exception NoSuchElementException) {
			return null;
		}
	}

	public WebElement findElementByClass(WebDriver driver, String className) {
		try {
			WebElement we = driver.findElement(By.className(className));
			return we;
		} catch (Exception NoSuchElementException) {
			return null;
		}
	}

	public WebElement findElementByXPath(WebDriver driver, String xPath) {
		try {
			WebElement we = driver.findElement(By.xpath(xPath));
			return we;
		} catch (Exception NoSuchElementException) {
			return null;
		}
	}

	public int setTextbyID(WebDriver driver, String id, String text) {
		try {
			WebElement textBox = driver.findElement(By.id(id));
			textBox.clear();
			textBox.sendKeys(text);
			return 1;
		} catch (Exception NoSuchElementException) {
			return 0;
		}
	}

	public int setDropdownbyID(WebDriver driver, String id, String text) {
		try {
			WebElement select = driver.findElement(By.id(id));
			List<WebElement> options = select.findElements(By.tagName("option"));
			for (WebElement option : options) {
				// if(debug){System.out.println("Looking
				// for:"+text+":Found:"+option.getText());}
				if (text.equals(option.getText())) {
					option.click();
					break;
				}
			}
			return 1;
		} catch (Exception NoSuchElementException) {

			return 0;
		}
	}

	public boolean setDropdownbyText(WebElement element, String text) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(text);
			return true;
		} catch (Exception e) {
			System.out.println("Error on SetDropdownbyText: " + text + " " + e);
			return false;
		}
	}

	public boolean setDropdownbyValue(WebElement element, String value) {
		try {
			Select select = new Select(element);
			select.selectByValue(value);
			return true;
		} catch (Exception e) {
			System.out.println("Error on SetDropdownbyValue: " + value + " " + e);
			return false;
		}
	}

	public boolean setDropdownbyIndex(WebElement element, int index) {
		try {
			Select select = new Select(element);
			select.selectByIndex(index);
			return true;
		} catch (Exception e) {
			System.out.println("Error on SetDropdownbyText: " + Integer.toString(index) + " " + e);
			return false;
		}
	}

	public String getOptionSelectedText(WebElement element) {
		try {
			return new Select(element).getFirstSelectedOption().getText();
		} catch (Exception e) {
			return null;
		}
	}

	public String getAttributeValue(WebElement element, String attribute) {
		try {
			return element.getAttribute(attribute);
		} catch (Exception e) {
			return null;
		}
	}

	public boolean isAlertExist(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void alertClickAccept(WebDriver driver) {
		try {
			if (isAlertExist(driver)) {
				driver.switchTo().alert().accept();
			}
		} catch (Exception e) {
		}
	}

	public void alertClickCancel(WebDriver driver) {
		try {
			if (isAlertExist(driver)) {
				driver.switchTo().alert().dismiss();
			}
		} catch (Exception e) {
		}
	}

	/**************
	 * Date Added: 7/12/2016
	 * 
	 * @throws Exception
	 ************************/

	// Usage: WebElements[] elements = { element1, element2, element3};
	// call method: SelectMultipleCheckBoxes(10, elements);

	public static void SelectMultipleCheckBoxes(WebDriver driver, int waittime, WebElement... elements) throws Exception {

		WebElement checkBox = null;

		try {
			if (elements.length > 0) {

				for (WebElement currentElement : elements) {

					checkBox = currentElement;
					WebDriverWait wait = new WebDriverWait(driver, waittime);
					wait.until(ExpectedConditions.elementToBeClickable(currentElement));

					if (!checkBox.isSelected()) {
						checkBox.click();

					} else {
						throw new Exception("Checkbox is already selected: " + checkBox);
					}

				}
			}
		} catch (AssertionError e) {
			// TODO Auto-generated catch block
			Assert.fail(e.getMessage());
		}

	}

	public static void selectAutoCompletion(WebDriver driver, List<WebElement> element, String texttoSelect)
			throws Exception {

		for (WebElement option : element) {

			System.out.println("First Option showing " + option.getText());

			if (option.getText().contains(texttoSelect)) {

				System.out.println("Trying to Select: " + texttoSelect);
				Thread.sleep(2000);
				option.click();
				break;

			} else {
				throw new Exception("AutoSuggestion Not Showing: ");

			}
		}

	}

}

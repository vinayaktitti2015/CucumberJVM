package wait_util;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Custom_Wait {

	// Usage: in test script.
	// Custom_wait.isElementPresnt(driver, locator, 20).sendKeys("xxx");
	public static WebElement isElementPresent(WebDriver driver, WebElement locator, int time) {

		WebElement final_element = null;

		for (int i = 0; i < time; i++) {
			try {
				final_element = locator;
				break;
			} catch (Exception e) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e1) {
					System.out.println("Waiting for element to appear on DOM");
				}
			}

		}
		return final_element;

	}

	public static void click_on_visibleElements(List<WebElement> elements) throws InterruptedException {

		int i;

		for (i = 0; i < 20; i++) {

			if (elements.size() > 0) {

				for (WebElement visible_element : elements) {

					if (visible_element.isDisplayed()) {
						visible_element.click();
						break;
					}

				}
			} else {

				Thread.sleep(1000);
			}

		}

	}

	public static void element_notNull(WebDriver driver, WebElement element) {

		if (element != null) {

			element.click();
		} else {
			System.out.println("Element Not Found");
		}
	}

	public static void elements_size_notNull(WebDriver driver, List<WebElement> element) {

		if (element.size() != 0) {
			element.get(0).click();

		} else {
			System.out.println("Element Not Found");
		}
	}

	public static void click_method(WebDriver driver, WebElement element) throws Exception {

		try {
			for (int n = 0; n < 15; n++) {
				try {
					element.click();
					break;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Thread.sleep(1000);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("Element Not Found");
		}

	}

	public static void double_clickmethod(WebDriver driver, WebElement element) throws InterruptedException {

		try {
			for (int i = 0; i < 10; i++) {

				try {
					if (element.isSelected()) {
						element.click();
						element.click();
						break;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Thread.sleep(1000);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block

			throw e;
		}
	}

	public static void waitForDisappear(WebDriver driver, final By by) {

		ExpectedCondition<Boolean> condition = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {

				try {

					Assert.assertNotNull(driver.findElement(by));
					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.invisibilityOfElementLocated(by));

					return false;

				} catch (NoSuchElementException e) {
					return true;

				}

			}

		};

	}

	public static void waitForPageLoadCompletely(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return ((JavascriptExecutor) driver).executeScript("returndocument.readtState").equals("complete");
			}

		};

		try {

			wait.until(expectation);

			((JavascriptExecutor) driver).executeScript("returndocument.readyState").equals("complete");

		} catch (Throwable error) {
			((JavascriptExecutor) driver).executeScript("returndocument.readyState").equals("complete");
			Assert.assertFalse(true, "Timeout waiting for Page Load Request to Complete");
		}

	}

}

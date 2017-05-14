package wait_util;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class Wait_Utils {

	public static void elementtobeClickable(WebDriver driver, WebElement locator) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void clickWhenReady(WebDriver driver, By locator) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	

	public static void PresenceofElementLocated(WebDriver driver, By locator) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public static void elementtobeVisible(WebDriver driver, WebElement locator) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	
	public static void visibilityofElementLocated(WebDriver driver, WebElement locator) throws IOException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By) locator));
	}

	
	public static void Visibilityof_AllElements(WebDriver driver, List<WebElement> locator) {
		// TODO Auto-generated method stub
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElements((List<WebElement>) locator));
	}

	// use for StaleElementReference Exceptions
	public static void elementIdentified(WebDriver driver, WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(elementIdentified((By) locator));
	}

	private static Function<WebDriver, WebElement> elementIdentified(final By locator) {
		return new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		};
	}

	public WebElement getWhenVisible(WebDriver driver, By locator) throws IOException {

		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;

	}

	public static void implicitwait(WebDriver driver) throws IOException {
		// Put an Implicit wait,
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void implicitwait_byTime(WebDriver driver, int time) throws IOException {
		// Put an Implicit wait,
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

	}

	public static void invisibilityofElement(WebDriver driver, By element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(element));

	}

}

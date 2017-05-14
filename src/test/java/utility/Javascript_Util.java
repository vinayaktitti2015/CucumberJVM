package utility;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Javascript_Util {

	public static void highlight_Elements(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);

	}

	public static void Scroll_PageUp(WebDriver driver) throws IOException {

		((JavascriptExecutor) driver).executeScript("scroll(500, 0)");

	}

	public static void Scroll_PageDown(WebDriver driver) throws IOException {

		((JavascriptExecutor) driver).executeScript("scroll(0,1000)");

	}

	public static void gotoElementPosition(WebDriver driver, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Point buttonLocation = element.getLocation();
			js.executeScript("javascript:window.scrollBy(" + buttonLocation.getX() + "," + buttonLocation.getY() + ")");
		} catch (Exception e) {
		}
	}

	public static void click_X_Coordinate(WebDriver driver, WebElement element) {

		WebElement elementtoclick = element;

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + elementtoclick.getLocation().x + ")");

		elementtoclick.click();

	}

	public static void click_Y_Coordinate(WebDriver driver, WebElement element) {

		WebElement elementtoclick = element;

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + elementtoclick.getLocation().y + ")");

		elementtoclick.click();

	}

	public static void safeJavaScriptClick(WebDriver driver, WebElement element) {

		try {
			if (element.isEnabled() && element.isDisplayed()) {

				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

			}
		} catch (Exception e) {

			Assert.fail(e.getMessage());
		}

	}

}

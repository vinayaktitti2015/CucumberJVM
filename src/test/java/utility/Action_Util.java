package utility;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Action_Util {

	public static void sendKeys_ArrowUp(WebDriver driver, WebElement locator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.contextClick(locator).sendKeys(Keys.ARROW_UP).build().perform();
	}
	
	public static void sendKeys_ArrowDown(WebDriver driver, WebElement locator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.contextClick(locator).sendKeys(Keys.ARROW_DOWN).build().perform();
	}

	public static void isRightClick(WebDriver driver, WebElement locator) throws InterruptedException {
		Actions act = new Actions(driver);
		act.contextClick(locator).perform();
	}

	public static void draganddrop(WebDriver driver, WebElement srclocator, WebElement destination_locator ) {
		
		// Create object of actions class
		Actions act = new Actions(driver);

		// find element which we need to drag
		WebElement drag = srclocator;

		// find element which we need to drop
		WebElement drop = destination_locator;

		// this will drag element to destination
		act.dragAndDrop(drag, drop).build().perform();

	}

	public static void Select_AutoSuggest(WebDriver driver, WebElement locator, String strng)
			throws InterruptedException {

		// Type something on Skill textbox
		locator.sendKeys(strng);

		// Create object on Actions class
		Actions builder = new Actions(driver);

		// find the element which we want to Select from auto suggestion
		WebElement ele = locator;

		// use Mouse hover action for that element
		builder.moveToElement(ele).build().perform();

		// Give wait for 2 seconds
		Thread.sleep(2000);

		// finally click on that element
		builder.click(ele).build().perform();

	}
}

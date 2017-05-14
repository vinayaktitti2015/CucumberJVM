package utility;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import config.Constants;


public class CommonUtils {

	// This method is wrapping selenium find element into findElement.
	// WebDriver, Elemet Type and Element Locator are parameters. Use to locate
	// an element.
	public static WebElement findElement(WebDriver driver, String elementtype, String elementloc) throws Exception {
		WebElement element = null;
		try {
			switch (elementtype) {
			case "id":
				element = driver.findElement(By.id(elementloc));
				break;

			case "name":
				element = driver.findElement(By.name(elementloc));
				break;

			case "xpath":
				element = driver.findElement(By.xpath(elementloc));
				break;

			case "link":
				element = driver.findElement(By.linkText(elementloc));
				break;

			case "css":
				element = driver.findElement(By.cssSelector(elementloc));
				break;
			}
		} catch (Exception e) {
			Log.warn("Unable to find element.");
			Log.debug(e.getMessage());
		}
		return element;
	}

	// This method wrapping the list and selenium find elements into
	// findElemets. WebDriver, Elemet Type and Element Locator are parameters.
	// Use to list the elemets.
	public static List<WebElement> findElements(WebDriver driver, String elementtype, String elementloc)
			throws Exception {
		
		List<WebElement> elements = null;
		
		try {
			
			switch (elementtype) {
			
			case "id":
				elements = driver.findElements(By.id(elementloc));
				break;

			case "name":
				elements = driver.findElements(By.name(elementloc));
				break;

			case "xpath":
				elements = driver.findElements(By.xpath(elementloc));
				break;

			case "link":
				elements = driver.findElements(By.linkText(elementloc));
				break;

			case "css":
				elements = driver.findElements(By.cssSelector(elementloc));
				break;
			}
			
		} catch (Exception e) {
			
			Log.warn("Unable to find elements.");
			Log.debug(e.getMessage());
			
		}
		
		return elements;
		
	}

	// This method use to count the expected element in DOM.
	public static int countElements(WebDriver driver, String elementtype, String elementloc) {
		
		int i = 0;
		
		try {
			
			switch (elementtype) {
			case "id":
				i = driver.findElements(By.id(elementloc)).size();
				break;

			case "name":
				i = driver.findElements(By.name(elementloc)).size();
				break;

			case "xpath":
				i = driver.findElements(By.xpath(elementloc)).size();
				break;
				
			case "css":
				i = driver.findElements(By.cssSelector(elementloc)).size();
				break;

			case "link":
				i = driver.findElements(By.linkText(elementloc)).size();
				break;
				
			}
			
		} catch (Exception e) {
			
			Log.warn("Unable to find the element -- " + elementloc);
			Log.debug(e.getMessage());
			
		}
		
		return i;
		
	}

	// This method use to check if the element is exist on the page or not.
	public static boolean isElementExist(WebDriver driver, String elementtype, String elementloc) {
		
		boolean isEmpty = true;
		boolean isExist = false;
		
		try {
			switch (elementtype) {
			case "id":
				isEmpty = driver.findElements(By.id(elementloc)).isEmpty();
				break;
				
			case "name":
				isEmpty = driver.findElements(By.name(elementloc)).isEmpty();
				break;

			case "xpath":
				isEmpty = driver.findElements(By.xpath(elementloc)).isEmpty();
				break;
				
			case "css":
				isEmpty = driver.findElements(By.cssSelector(elementloc)).isEmpty();
				break;

			case "link":
				isEmpty = driver.findElements(By.linkText(elementloc)).isEmpty();
				break;
			}
			
		} catch (Exception e) {
			
			Log.warn("Element --- " + elementloc + " --- is not exist.");
			Log.debug(e.getMessage());
			
		}

		if (!isEmpty) {
			
			isExist = true;
			
		} else {
			
			Log.warn("Element --- " + elementloc + " --- is not exist.");
		}
		
		return isExist;
	}

	// Click on an element
	public static void click(WebElement element) {
		
		try {
			
			element.click();
			Thread.sleep(100);
			
		} catch (Exception e) {
			
			Log.warn("Unable to click on the " + element);
			Assert.fail(e.getMessage());
			
		}
		
		Log.info("Clicked on the " + element);
		
	}

	// Type/enter text inside an element
	public static void type(WebElement element, String value) {
		
		try {
			
			element.clear();
			element.sendKeys(value);
			Thread.sleep(100);
			
		} catch (Exception e) {
			
			Log.debug(e.getMessage());
			
		}
		
		Log.info("Type '" + value + "' into the element.");
		
	}

	// This method use to upload file using sendkeys function from selenium.
	// Must provide an element with input tag and type = file. Another way shall
	// be using AutoIt windows forms interact tools.
	public static void upload(WebElement element, String path) {
		
		try {
			
			element.sendKeys(path);
			
		} catch (Exception e) {
			
			Log.debug(e.getMessage());
			
		}
		
		Log.info("Upload file --- " + path);
		
	}

	// Selenium implicit wait
	public static void implicitWait(WebDriver driver, int time) {
		
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		
	}
	
	// This method use to call the explicit wait to wait until the element count to be the number you want.
	public static void waitUntilNumberOfElementToBe(WebDriver driver, int time, int number, String elementtype, String elementloc){
		
		try {
			
			switch(elementtype){
			
			case "id":
				new WebDriverWait(driver, time).until(ExpectedConditions.numberOfElementsToBe(By.id(elementloc), number));
				break;
				
			case "name":
				new WebDriverWait(driver, time).until(ExpectedConditions.numberOfElementsToBe(By.name(elementloc), number));
				break;
				
			case "xpath":
				new WebDriverWait(driver, time).until(ExpectedConditions.numberOfElementsToBe(By.xpath(elementloc), number));
				break;
				
			case "css":
				new WebDriverWait(driver, time).until(ExpectedConditions.numberOfElementsToBe(By.cssSelector(elementloc), number));
				break;
			
			}
			
		} catch (Exception e) {
		
			Log.debug(e.getMessage());
			
		}
		
	}

	// Pause the thread
	public static void pause(long time) throws Exception {
		
		Thread.sleep(time);
		
	}

	public static void checkPageReady(WebDriver driver, int seconds) throws Exception {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		for (int i = 0; i < seconds; i++) {
			
			if (i != seconds) {
				
				System.out.println(i);
				Thread.sleep(1000);
				
				if (js.executeScript("return document.readyState").toString().equals("complete")) {
					break;
					
				}
				
			} else {
				
				throw new InterruptedException("Wait timeout.");
			
			}
			
		}
		
	}

	// This method wrap the selenium find element and switch to iframe into
	// switch to frame. Use to switch to the frame where the provided element
	// located. Must provide the By method to tell selenium how to find frame,
	// and must provide the By element to locate the element.
	public static void switchToFrame(WebDriver driver, By by_frame, By by_elements) {
		
		int framecount = driver.findElements(by_frame).size();
		
		for (int i = 0; i < framecount; i++) {
			
			driver.switchTo().frame(i);
			int eles = driver.findElements(by_elements).size();
			
			if (eles != 0) {
				
				Log.info("Switched to frame: " + (i + 1));
				break;
				
			} else {
				
				Log.info("Continue to switch.");
				driver.switchTo().defaultContent();
				
			}

		}

	}

	// Switch to default content (Top Window) from current iFrame
	public static void switchToMainFrame(WebDriver driver) {
		try {
			
			driver.switchTo().defaultContent();
			Log.info("Driver switched to default content.");
			
		} catch (Exception e) {
			
			Log.debug(e.getMessage());
			Log.warn("Failed to switch to default content");
			
		}
		
	}

	// Validate all URL on a webpage
	public static void checkAllLinks(WebDriver driver) throws Exception {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for (WebElement i : links) {
			
			try {
				
				// String linktext = i.getText();
				String link = i.getAttribute("href");
				
				if (String.valueOf(link).startsWith("http")) {
					
					URL url = new URL(link);
					Thread.sleep(100);
					HttpURLConnection http = (HttpURLConnection) url.openConnection();
					http.setRequestMethod("GET");
					http.connect();
					int responsecode = http.getResponseCode();
					
					if (responsecode == 200) {
						
						Log.info(link + "     " + "Valid");
						
					} else {
						
						Log.warn(link + "     " + "Invalid");
						
					}
					
				}
				
			} catch (Exception ex) {
				
				Log.debug(ex.getMessage());
				
			}
			
		}
		
	}

	// Scroll to element
	public static void scrollDownToElement(WebDriver driver, String elementtype, String elementloc) {
		try {
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement ele = CommonUtils.findElement(driver, elementtype, elementloc);
			int y = ele.getLocation().getY() - 300;
			js.executeScript("window.scrollBy(0," + y + ");");
			
		} catch (Exception e) {
			
			Log.info("Unable to scroll to element.");
			Log.debug(e.getMessage());
			
		}
		
		Log.info("Scroll down webpage to element --- " + elementloc + " --- location.");
		
	}

	// Select element from a select dropdown 
	public static void select(WebElement sel, String selecttype, String value) {
		
		Select select = new Select(sel);
		
		try {
			
			switch (selecttype) {
			
			case "text":
				select.selectByVisibleText(value);
				Log.info("Selected --- " + value);
				Thread.sleep(100);
				break;
				
			case "value":
				select.selectByValue(value);
				Log.info("Selected --- " + value);
				Thread.sleep(100);
				break;
				
			}
			
		} catch (Exception e) {
			
			Log.warn("Unable to select the element.");
			Log.debug(e.getMessage());
			
		}
		
	}

	// Check if alert is present
	public static boolean isAlertPresent(WebDriver driver) {
		if (driver instanceof PhantomJSDriver) {
			
			return false;
			
		} else {
			
			try {
				
				driver.switchTo().alert();
				return true;
				
			} catch (NoAlertPresentException alert) {
				
				return false;
				
			}
			
		}

	}

	public static HashMap<String, String> getQueryMap(String query) {
		
		String[] params = query.split("&");
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		for (String param : params) {
			
			String[] p = param.split("=");
			String name = p[0];
			
			if (p.length > 1) {
				
				String value = p[1];
				map.put(name, value);
				
			}
			
		}
		
		return map;
		
	}

	// Get the parameter from URL
	public static String getUrlParameter(String url, String param) {
		
		HashMap<String, String> map = getQueryMap(url);
		String value = map.get(param);

		return value;
	}

	// This method use to capture the screen and store at given location + file
	// name in png format.
	public static void screenCapture(WebDriver driver, String fileName) {
		
		try {
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			//FileUtils.copyFile(src, new File(Constants.screenShotPath + fileName + ".png"));
			System.out.println("Screenshot taken.");
			
		} catch (Exception e) {
			
			System.out.println("Error while taking screenshot --- " + e.getMessage());
			
		}
		
	}

}

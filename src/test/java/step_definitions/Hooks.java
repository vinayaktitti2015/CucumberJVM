package step_definitions;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import main.env.SharedDriver;
import utility.Capture_Screenshot;

public class Hooks {

	WebDriver driver;

	public Hooks(SharedDriver driver) {
		this.driver = driver;
	}

	@After
	public void embedScreenshot(Scenario scenario) throws IOException {

		System.out.println("Execute After Method");

		if (scenario.isFailed()) {

			 //Reporter.addScreenCaptureFromPath(Capture_Screenshot.getName(driver, scenario.getName()));
			try {
				scenario.write("Current Page URL is " + driver.getCurrentUrl());
				// byte[] screenshot = getScreenshotAs(OutputType.BYTES);
				byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}

		}

	}

}

package testRunner;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.aventstack.extentreports.ExtentReporter;
import com.cucumber.listener.ExtentCucumberFormatter;
import com.cucumber.listener.Reporter;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.junit.Cucumber;
import main.env.SharedDriver;
import utility.Capture_Screenshot;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", plugin = { "pretty",
		"com.cucumber.listener.ExtentCucumberFormatter:target/Reports/extentreport.html",
		"html:target/Reports/cucumber-html-report", "rerun:failed/rerun.txt" }, glue = {
				"step_definitions" }, monochrome = false, tags = { "@positivescenario" })

public class ExtentTestRunner {

	@AfterClass
	public static void setUp() throws IOException {
		String path = "src\\test\\resources\\extent-config.xml";

		ExtentReports report = new ExtentReports(path);

		report.loadConfig(new File(path));
		report.addSystemInfo("user", System.getProperty("user.name"));
		report.addSystemInfo("OS", "windows");
		report.setTestRunnerOutput("Sample Test Runner");

		Reporter.addScreenCaptureFromPath("./target/Reports/ErrorScreenshots/verify Delete Cookies.png", "Failed");

	}

}

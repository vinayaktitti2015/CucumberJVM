package testRunner;

import org.junit.runner.RunWith;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(
jsonReport = "target/Reports/cucumber.json",
jsonUsageReport = "target/Reports/cucumber-usage.json",
outputFolder = "target/Reports",
detailedReport = true,
detailedAggregatedReport = true,
overviewReport = true,
usageReport = true,
retryCount = 0,
screenShotLocation = "target/Reports/ErrorScreenshots/",
screenShotSize = "300px",
toPDF = true
)


@CucumberOptions(
		features = "classpath:features",
		plugin = {"pretty:target/Reports/cucumber-pretty.txt", "html:target/Reports/cucumber-html-report", 
				 "json:target/Reports/cucumber.json", "usage:target/Reports/cucumber-usage.json", "junit:target/Reports/cucumber-results.xml", 
				"rerun:failed/rerun.txt"},
		glue ={"step_definitions"},
		monochrome = false,
		tags = {"@login"}
		)
public class ExtendedCucumberRunner{
	
}
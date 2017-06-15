package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", plugin = { "pretty", "html:target/Reports/cucumber-html-report",
		"json:target/Reports/cucumber.json",
		"rerun:failed/rerun.txt" }, monochrome = false, glue = { "step_definitions" }, tags = { "@login" })

public class JunitRunner {

}

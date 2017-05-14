package testRunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "@failed/rerun.txt" }, plugin = { "pretty", "html:target/Reports/cucumber-html-report",
		"json:target/cucumber.json" }, monochrome = false,
         glue = {"step_definitions"} )

public class RerunFailedScenarios {

}

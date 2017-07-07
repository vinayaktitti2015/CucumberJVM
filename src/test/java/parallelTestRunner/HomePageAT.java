package parallelTestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "classpath:features",
		plugin = {"pretty", "html:target/Reports/cucumber-html-report", "json:target/Reports/cucumber.json", 
				"rerun:failed/rerun.txt"},
		glue ={"step_definitions"},
		monochrome = false,
		tags = {"@homepage"}
		)
public class HomePageAT{
	
}
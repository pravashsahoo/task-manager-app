package selenium;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = { "json:target/selenium/taskmanager.json", "html:target/selenium/taskmanager.html",
		"pretty" }, features = "src/test/resources/features",
		monochrome = true, 
		glue = "selenium"
//		tags = "@smoke  and @fast"
)
public class TaskManagerTestRunner {
}

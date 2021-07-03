package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/java/features",
        glue = "Steps",
        plugin = {"pretty","html:target/cucumber-reports/cucumber.html","json:target/cucumber-reports/cucumber.json"},
        monochrome = true,
        dryRun = false)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {

}

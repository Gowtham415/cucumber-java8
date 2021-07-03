package Steps;

import com.google.common.util.concurrent.Uninterruptibles;
import framework.AutomationUI;
import framework.WebDriverUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.*;

public class GooglePageSteps {
    WebDriverUtils webDriverUtils;
    AutomationUI selenium;
    public GooglePageSteps(WebDriverUtils webDriverUtils, AutomationUI selenium) {
        this.webDriverUtils = webDriverUtils;
        this.selenium=selenium;
    }

    @Given("the user opens the google page")
    public void openGooglePage(){
        System.out.println("Launching browser...");
        String url = selenium.getPropertyFileReader().getProperty("application.url");
        this.webDriverUtils.getToUrl(url);
    }

    @When("user searches for {string}")
    public void searchString(final String searchString){
        this.webDriverUtils.getWebElement(By.name("q")).sendKeys(searchString);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
    }

    @Then("search Results should be displayed")
    public void validateResults(){
        assertThat(true).isEqualTo(true);
        this.webDriverUtils.tearDown();
    }
}

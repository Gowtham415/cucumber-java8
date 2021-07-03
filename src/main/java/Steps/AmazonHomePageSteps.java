package Steps;

import framework.AutomationUI;
import framework.WebDriverUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

public class AmazonHomePageSteps {

    AutomationUI automationUI;
    WebDriverUtils webDriverUtils;

    public AmazonHomePageSteps(AutomationUI automationUI, WebDriverUtils webDriverUtils) {
        this.automationUI = automationUI;
        this.webDriverUtils = webDriverUtils;
    }

    @Given("Amazon website is opened")
    public void amazon_website_is_opened() {
        this.webDriverUtils.getToUrl(automationUI.getPropertyFileReader().getProperty("application.amazon.url"));
    }

    @Then("all the link should be fetched")
    public void all_the_link_should_be_fetched() {
        this.webDriverUtils
                .getAllElements(By.xpath("//a"))
                .stream()
                .map(e->e.getText()).filter(e-> !e.isEmpty() || !e.equals(""))
                .distinct()
                .forEach(System.out::println);
    }

}

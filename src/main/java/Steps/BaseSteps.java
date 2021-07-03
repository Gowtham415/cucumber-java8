package Steps;

import framework.AutomationUI;
import framework.WebDriverUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseSteps {
    WebDriverUtils webDriverUtils;
    AutomationUI selenium;
    public BaseSteps(WebDriverUtils webDriverUtils, AutomationUI selenium) {
        this.webDriverUtils = webDriverUtils;
        this.selenium=selenium;
    }

    @Before("@FeatureSetup")
    public void setUp(){
        this.webDriverUtils.launchBrowser();
    }

    @After("@FeatureSetup")
    public void tearDown(){
        this.webDriverUtils.tearDown();
    }
}

package framework;

import framework.BrowserType;
import framework.PropertyFileReader;
import framework.WebDriverBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.picocontainer.PicoFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverUtils {
    private static final String weburl = "https://google.co.in";
    private WebDriver driver;

    public void launchBrowser(){
        BrowserType browserType = BrowserType.valueOf((String) new PropertyFileReader().properties.get("browser"));
        driver = WebDriverBuilder.build(browserType);
        driver.manage().window().maximize();
    }

    public void tearDown(){
        driver.quit();
    }

    public void getToUrl(String url){
        driver.get(url);
    }

    public WebElement getWebElement(By by){
        return driver.findElement(by);
    }

    public List<WebElement> getAllElements(By by){
        return driver.findElements(by);
    }

    public WebElement findVisibleWebElement(By by, int waitTimeInSeconds){
        return (new WebDriverWait(driver,waitTimeInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by)));
    }

    public List<WebElement> findAllVisibleWebElements(By by, int waitTimeInSeconds){
        return (new WebDriverWait(driver,waitTimeInSeconds).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by)));
    }
}

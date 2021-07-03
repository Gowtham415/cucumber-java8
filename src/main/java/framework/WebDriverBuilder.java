package framework;

import io.cucumber.java8.Fi;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class WebDriverBuilder {

    private static Supplier<WebDriver> chrome = () -> {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    };
    private static Supplier<WebDriver> firefox = () -> {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    };
    private static Supplier<WebDriver> safari = () -> new SafariDriver();

    private static Map<BrowserType,Supplier<WebDriver>> browserMap = new EnumMap<BrowserType, Supplier<WebDriver>>(BrowserType.class);
    static{
        browserMap.put(BrowserType.CHROME,chrome);
        browserMap.put(BrowserType.FIREFOX,firefox);
        browserMap.put(BrowserType.SAFARI,safari);
    }

    public static WebDriver build(BrowserType browserType){
        return browserMap.get(browserType).get();  // Second get method is from Supplier Interface
    }
}

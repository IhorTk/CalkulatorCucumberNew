package HomeWork.context;

import HomeWork.utils.ConfigurationReader;
import HomeWork.utils.DriverFactory;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestContext {

    private TestContext() {
    }

    private static WebDriver driver;
    public static WebDriverWait wait;
    public static JavascriptExecutor js;
    public static Actions actions;
    public static Alert alert;
    public static Scenario scenario ;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = DriverFactory.get();
            wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(ConfigurationReader.get("timeout"))));
            actions = new Actions(driver);
            js = (JavascriptExecutor) driver;
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

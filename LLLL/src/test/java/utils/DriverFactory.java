package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver get(){
        WebDriver driver;
        String browser = ConfigurationReader.get("browser");

        switch (browser){
            case "chrome":
                ChromeOptions options = new ChromeOptions();

                if(ConfigurationReader.get("headless").toLowerCase().contains("true")){
                    options.addArguments("--headless");
                }

                driver = new ChromeDriver(options);

                if(ConfigurationReader.get("maximize").toLowerCase().contains("true")){
                    driver.manage().window().maximize();
                }
                return driver;
            case "firefox":
                return new FirefoxDriver();
            case "edge":
                return new EdgeDriver();
        }
        throw new WebDriverException("Параметр browser не выбран в конфигурации configuration.properties");
    }
}

package com.finalproject.qa;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.*;

public class WebDriverProvider {

    public static WebDriver createDriver(String browser) {
        ConfigFileReader configFileReader = new ConfigFileReader();

        WebDriver driver;
        switch (browser.toLowerCase()) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", configFileReader.getDriverPathFirefox());
                driver = new FirefoxDriver();
                System.out.println("Created firefox driver");
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", configFileReader.getDriverPathEdge());
                driver = new EdgeDriver();
                System.out.println("Created edge driver");
                break;
            case "remote":
                driver = new RemoteWebDriver(new DesiredCapabilities());
                break;
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPathChrome());
                driver = new ChromeDriver();
                System.out.println("Created chrome driver");
                break;
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }

}

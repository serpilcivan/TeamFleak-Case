package base;

import actionDriver.WebActions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebActions actions;


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver","/Users/master/Downloads/chromedriver-mac-arm64/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com.tr");
        driver.manage().window().maximize();

        actions = new WebActions(driver);
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}

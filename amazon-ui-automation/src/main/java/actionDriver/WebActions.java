package actionDriver;

import java.util.List;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebActions extends BasePage implements ActionInterface {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public WebActions(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }


    @Override
    public void click(By locator) {
        waitForElementToBeClickable((By) locator);
        driver.findElement((By) locator).click();
    }



    @Override
    public void sendKeys(By locator, String text) {
        waitForElementToBeVisible(locator);
        driver.findElement(locator).sendKeys(text);
    }



    @Override
    public boolean isElementVisible(By locator) {
        try {
            waitForElementToBeVisible(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    @Override
    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


    @Override
    public void clickElement(WebElement element) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(element))
                .click();
    }


    @Override
    public WebElement waitForElement(By locator, int timeout) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    @Override
    public List<WebElement> waitForElements(By locator, int timeout) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }



}
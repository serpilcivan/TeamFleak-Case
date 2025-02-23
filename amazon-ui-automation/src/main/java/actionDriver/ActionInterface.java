package actionDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public interface ActionInterface {
    void click(By locator);
    void clickElement(WebElement element);
    void sendKeys(By locator, String text);
    boolean isElementVisible(By locator);
    void waitForElementToBeVisible(By locator);
    void waitForElementToBeClickable(By locator);
    WebElement waitForElement(By locator, int timeout);
    List<WebElement> waitForElements(By locator, int timeout);


}

package pages;

import actionDriver.WebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;
    private WebActions actions;

    public SearchResultsPage(WebDriver driver,WebActions actions) {
        this.driver = driver;
        this.actions = actions;
    }

    private By searchResultsLocator = By.cssSelector("[data-component-type='s-search-result']");
    private By sponsoredTagLocator = By.cssSelector("span.sponsored-label-text");
    private By productTitleLocator = By.xpath("//div[@data-component-type='s-search-result']//a[@class='a-link-normal s-no-outline']");


    //Retrieves a list of all search result elements.
    //Iterates through the list and checks if an item has a sponsored tag.
    //If an item does not have a sponsored tag, it clicks on the first such product.
    public void clickFirstOrganicProduct() {
        List<WebElement> searchResults = actions.waitForElements(searchResultsLocator, 10);

        for (WebElement result : searchResults) {
            if (result.findElements(sponsoredTagLocator).isEmpty()) {
                WebElement firstOrganicProduct = result.findElement(productTitleLocator);
                actions.clickElement(firstOrganicProduct);
                return;
            }
        }
        throw new RuntimeException("No organic products found!");
    }
}
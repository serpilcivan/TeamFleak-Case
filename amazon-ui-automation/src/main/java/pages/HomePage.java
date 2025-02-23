package pages;

import actionDriver.WebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
    private WebDriver driver;
    private WebActions actions;


    private By amazonLogo= By.id("nav-logo-sprites");
    private By cookiesAcceptButton = By.id("sp-cc-accept");
    private By searchBar = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");


    public HomePage(WebDriver driver, WebActions actions) {
        this.driver = driver;
        this.actions = actions;
        PageFactory.initElements(driver, this);
    }

    //This check is useful for test cases that require the homepage as a starting point.
    public void isAmazonHomePageOpened() {
        actions.isElementVisible(amazonLogo);
    }

    //This method ensures smooth test execution by accepting cookies when needed.
    public void acceptCookies() {
        if (actions.isElementVisible(cookiesAcceptButton)) {
            actions.click(cookiesAcceptButton);
        }
    }

    //Allows test cases to verify search functionality.
    public void searchProduct(String product) {
        actions.sendKeys(searchBar, product);
        actions.click(searchButton);
    }
}

package pages;

import actionDriver.WebActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {
    private WebDriver driver;

    private WebActions actions;



    private final By addToCartButton = By.id("add-to-cart-button");
    private By cartButtonLocator = By.id("nav-cart");


    public ProductDetailPage(WebDriver driver, WebActions actions) {
        this.driver = driver;
        this.actions= actions;

        PageFactory.initElements(driver, this);
    }

    //This method combines them into a correctly formatted price.
    public String getProductPrice() {


        try {
            By wholePartLocator = By.xpath("//*[@id=\"corePrice_feature_div\"]/div/div/span[1]/span[2]/span[1]");
            By fractionPartLocator = By.xpath("//*[@id=\"corePrice_feature_div\"]/div/div/span[1]/span[2]/span[2]");

            WebElement wholePartElement = actions.waitForElement(wholePartLocator, 10);
            WebElement fractionPartElement = actions.waitForElement(fractionPartLocator, 10);

            if (wholePartElement != null && fractionPartElement != null) {
                // Combine the whole number and fractional part using ","
                String priceText = wholePartElement.getText().trim() + "," + fractionPartElement.getText().trim();
                System.out.println("Price: " + priceText);
                return priceText;
            } else {
                System.out.println("Not found price!");
                return null;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }

    }

    //Ensures smooth navigation from the product detail page to the cart page.
    public void addToCartAndGoToCartPage() {
        actions.click(addToCartButton);
        actions.click(cartButtonLocator);
    }
}

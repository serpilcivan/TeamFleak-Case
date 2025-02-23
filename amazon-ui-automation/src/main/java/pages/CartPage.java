package pages;

import actionDriver.WebActions;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    private WebDriver driver;
    private WebActions actions;


    public CartPage(WebDriver driver, WebActions actions) {
        this.driver = driver;
        this.actions= actions;
        PageFactory.initElements(driver, this);
    }

    private By cartTotalPriceLocator = By.cssSelector("#sc-subtotal-amount-buybox");

    //It extracts the total price displayed in the cart for validation purposes.
    //This is used in test cases to compare the product price with the cart total.
    public String cartTotalPrice() {
        WebElement cartTotalElement = actions.waitForElement(cartTotalPriceLocator, 10);
        String cartTotalPrice = cartTotalElement.getText().replace("TL", "").trim();

        System.out.println("Cart Total Price: " + cartTotalPrice);

        return cartTotalPrice;
    }
}

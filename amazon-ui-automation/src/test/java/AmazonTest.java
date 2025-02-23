
import actionDriver.WebActions;
import base.BasePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductDetailPage;
import pages.SearchResultsPage;
import io.qameta.allure.Description;

public class AmazonTest extends BasePage {

    //Test Case: Search for MacBook Pro, add it to the cart, and validate the price.
    /*
     **Test Steps:**
     * 1. Open the Amazon homepage and verify it is displayed.
     * 2. Accept cookies (if prompted).
     * 3. Search for "MacBook Pro".
     * 4. Select the first organic (non-sponsored) product from the search results.
     * 5. Retrieve the product price from the detail page.
     * 6. Add the product to the cart and navigate to the cart page.
     * 7. Get the total price from the cart.
     * 8. Compare the product price and the cart total price to ensure they match.
     */

    @Test
    @Description("Search for MacBook Pro, add to cart and validate price")
    public void testAmazonShopping() {

        // Step 1: Open Amazon homepage and verify it is displayed
        HomePage homePage = new HomePage(driver, actions);
        homePage.isAmazonHomePageOpened();
        homePage.acceptCookies();
        homePage.searchProduct("MacBook Pro");

        // Step 2: Click on the first organic (non-sponsored) product from the search results
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver, actions);
        searchResultsPage.clickFirstOrganicProduct();

        // Step 3: Retrieve product price from the product detail page
        ProductDetailPage productDetailPage = new ProductDetailPage(driver, actions);
        productDetailPage.getProductPrice();
        String priceText = productDetailPage.getProductPrice();

        // Step 4: Add the product to the cart and navigate to the cart page
        productDetailPage.addToCartAndGoToCartPage();


        // Step 5: Get the cart total price
        CartPage cartPage = new CartPage(driver, actions);
        cartPage.cartTotalPrice();
        String cartTotalPrice = cartPage.cartTotalPrice();

        // Step 6: Validate that the product price and the cart total price are the same
        Assert.assertEquals(cartTotalPrice, priceText, "Cart total does not match product price!");


    }

}
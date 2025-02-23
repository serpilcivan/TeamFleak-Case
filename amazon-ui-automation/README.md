# Amazon UI Test Automation Framework

This project is a Selenium-based UI test automation framework for Amazon.  
It automates key user flows such as searching for a product, adding it to the cart, and validating the cart total price.

## Technologies Used

- **Java 11** - Programming Language
- **Selenium WebDriver** - Browser Automation
- **TestNG** - Test Framework
- **Maven** - Dependency Management
- **Allure** - Test Reporting

#### Test Scenarios
```md
## Test Scenarios

- ✅ Open Amazon home page and verify it loads successfully  
- ✅ Accept cookies (if present)  
- ✅ Search for a product (e.g., "MacBook Pro")  
- ✅ Click the first organic product (not sponsored)  
- ✅ Retrieve product price from the detail page  
- ✅ Add product to cart  
- ✅ Validate that the cart total matches the product price  


## Challenges & Solutions

### 1️⃣ Product Price Extraction  
**Issue:** Some products displayed the price in different formats (e.g., "105.999,00 TL").  
**Solution:** Used XPath to extract whole and fractional parts separately and formatted the price correctly.

### 2️⃣ Handling Sponsored Products  
**Issue:** Search results contained both sponsored and organic products.  
**Solution:** Implemented a filter to ignore sponsored products.

### 3️⃣ Handling Dynamic Elements  
**Issue:** Some elements took longer to load.  
**Solution:** Used **explicit waits** (`WebDriverWait`) to handle dynamic elements.

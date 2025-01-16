package OnlinePotique;

import OnlinePotique.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePageOnline {
    private  WebDriver driver;
    private By productName= By.cssSelector(".hot-product-card");
    private By currencyOptionLocator = By.cssSelector("option");
    private By currencyDropdownLocator = By.id("currency_form");



    public HomePageOnline(WebDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("Online Boutique"));
    }



    public Currency selectCurrency(String currencyCode) {

        WebElement currencyDropdown = driver.findElement(currencyDropdownLocator);

        // Get all options within the dropdown
        List<WebElement> currencyOptions = currencyDropdown.findElements(currencyOptionLocator);

        // Iterate through the options to find the desired currency
        for (WebElement option : currencyOptions) {
            String value = option.getAttribute("value");
            String displayText = option.getText();


            if (value.equalsIgnoreCase(currencyCode)) {
                option.click();
                return new Currency(displayText, value);
            }
        }


        throw new RuntimeException("Currency with value '" + currencyCode + "' not found.");
    }

    public ProductPage selectProductByName(String productNameWant) {


        List<WebElement> products = driver.findElements(productName);
        for (WebElement product : products) {
            String productName2 = product.findElement(By.cssSelector(".hot-product-card-name")).getText();
            if (productName2.equalsIgnoreCase(productNameWant)) {
                product.click();
                return new ProductPage(driver);
            }
        }

        throw new RuntimeException("Product with name '" + productName + "' not found on the Home Page.");
    }
}

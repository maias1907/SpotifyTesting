package OnlinePotique;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    public class ProductPage {
        private WebDriver driver;

        // Locators
        private By productName = By.cssSelector("div.product-wrapper h2");
        private By price = By.className("product-price");
        private By addToCartButton = By.className("cymbal-button-primary");
        private By currProduct=By.className("controls-form");

        public ProductPage(WebDriver driver) {
            this.driver = driver;
        }

        public String getProductName() {
            return driver.findElement(productName).getText();
        }

        public String getProductPrice() {
            return driver.findElement(price).getText();
        }

        public Cart addToCart() {
            driver.findElement(addToCartButton).click();
            return new Cart(driver);
        }

    }


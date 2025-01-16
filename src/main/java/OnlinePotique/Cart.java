/*package OnlinePotique;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private WebDriver driver;

    // Locators
    private By cartTotal = By.className("text-right");


    public Cart(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isProductInCart(String productName) {
        // Locate all cart items by their container
        List<WebElement> cartItems = driver.findElements(By.cssSelector(".row.cart-summary-item-row"));

        // Iterate through each cart item to find the product name
        for (WebElement cartItem : cartItems) {
            // Locate the product name inside the cart item
            WebElement productNameElement = cartItem.findElement(By.cssSelector("h4"));
            String name = productNameElement.getText();

            // Check if the product name matches the desired one
            if (name.equalsIgnoreCase(productName)) {
                return true; // Product found in the cart
            }
        }

        return false; // Product not found in the cart
    }



}*/

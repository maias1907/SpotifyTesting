import OnlinePotique.Cart;
import OnlinePotique.Currency;
import OnlinePotique.HomePageOnline;
import OnlinePotique.ProductPage;
import org.example.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;
import java.net.URL;


import static OnlinePotique.DriverFactory.getDriver;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlineBoutiqueTest {
    private WebDriver driver;
    private HomePageOnline homePage;
   @Before
    public void setUp() {
        //driver = new ChromeDriver();
        //driver.manage().window().maximize();
       driver=getDriver();
       driver.get("https://cymbal-shops.retail.cymbal.dev");

        //PageFactory.initElements(driver,this);
       homePage=new HomePageOnline(driver);

    }


    @Test
    public void testOrderProductSelect() {
        // Step 1: Select product
        String productName = "Tank Top";
        ProductPage productPage = homePage.selectProductByName(productName);
        assertEquals(productName, productPage.getProductName());

        // Step 2: Select currency EUR and verify product price
        String value = "EUR";
        String symbol2 = "€";
        Currency curr = homePage.selectCurrency(value);
        assertEquals(value, curr.getCurrencyCode());

        // Verify that the product price currency is in EUR and has the € symbol
        String priceInEUR = productPage.getProductPrice();
        assertTrue(priceInEUR.contains(symbol2)); // Ensure the price contains € symbol

        // Step 3: Add product to the cart and verify cart contains the product
        Cart cart = productPage.addToCart();
        assertTrue(cart.isProductInCart(productName));
    }
    @Test
    public void testOrderProductSelec(){
        String productName = "Mug";
       ProductPage productPage = homePage.selectProductByName(productName);
        assertEquals(productName, productPage.getProductName());

        String value = "USD";
        String symbol1 = "$";
        Currency curr = homePage.selectCurrency(value);
        assertEquals(value, curr.getCurrencyCode());

        // Verify that the product price currency is now in USD and has the $ symbol
        String priceInUSD = productPage.getProductPrice();
        assertTrue(priceInUSD.contains(symbol1)); // Ensure the price contains $ symbol

        Cart cart = productPage.addToCart();
        assertTrue(cart.isProductInCart(productName));
        
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

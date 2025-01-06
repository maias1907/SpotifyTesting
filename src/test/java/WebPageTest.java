import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WebPageTest {
    WebDriver driver;

    private static final String baseURL = "https://www.selenium.dev/selenium/web/dynamic.html";


    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }
    // Test method for adding a box
    @Test
    public void testAddBox() {
        // Open the webpage
        driver.get(baseURL);

        // Find the "Add a box!" button
        WebElement addBoxButton = driver.findElement(By.id("adder"));

        // Click the button to add a box
        addBoxButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // Get all the boxes after clicking the button
        List<WebElement> boxes = driver.findElements(By.className("redbox"));

        // Assert that at least one box was added
        assertTrue(boxes.size() > 0, "No boxes were added after clicking 'Add a box!'");
    }
    @Test
    public void testTextField() {
        // Open the webpage
        driver.get(baseURL);
        WebElement addBoxTextField=driver.findElement(By.id("reveal"));
        addBoxTextField.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(500));
        WebElement textField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));

        textField.sendKeys("Hello Maias");
        assertEquals("Hello Maias", textField.getAttribute("value"), "Text input value mismatch");

    }

    // This method will run after each test to clean up
    @AfterEach
    public void teardown() {
        driver.quit();

    }
}

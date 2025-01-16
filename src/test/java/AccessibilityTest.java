import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.nio.file.Paths;

public class AccessibilityTest {
    WebDriver driver;


    String URLBase = "https://www.selenium.dev/selenium/web/web-form.html";


    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void accessibilityFormTest() {
        driver.get(URLBase);
        driver.switchTo().activeElement().sendKeys("\tjohn");
        driver.switchTo().activeElement().sendKeys("\t1234");
        driver.switchTo().activeElement().sendKeys("\tElvis has left the building");
        driver.switchTo().activeElement().sendKeys("\t\t\t");
        driver.switchTo().activeElement().sendKeys("Two");
        driver.switchTo().activeElement().sendKeys("\tSeattle");
        driver.switchTo().activeElement().sendKeys("\t\t"); // Check the first checkbox
        driver.switchTo().activeElement().sendKeys("\t "); //checked the default and
        driver.switchTo().activeElement().sendKeys("\t ");

        WebElement defaultRadioButton = driver.findElement(By.id("my-radio-2"));
        Actions actions = new Actions(driver);
        actions.moveToElement(defaultRadioButton).click().perform();















    }
}

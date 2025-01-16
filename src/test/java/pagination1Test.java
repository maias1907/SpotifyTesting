import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class pagination1Test {
    WebDriver driver;


    String pagePath = Paths.get("C:/Users/maias/BeyonDev4/selenium_exercises/pagination/pagination1.html").toUri().toString();




    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }
    @Test
    public void pagesContentTest() {

        driver.get(pagePath);

        WebElement page1Button = driver.findElement(By.id("page-number1"));//page 1
        page1Button.click();
        WebElement page1ButtonText=driver.findElement(By.id("content"));
        String value1=page1ButtonText.getText();
        assertEquals("Welcome to Page 1! This is the content of the first page.",value1);

        WebElement page2Button = driver.findElement(By.id("page-number2"));//page 2
        page2Button.click();
        WebElement page2ButtonText=driver.findElement(By.id("content"));
        String value2=page2ButtonText.getText();
        assertEquals("Welcome to Page 2! This is the content of the first page.",value2);

        WebElement page3Button = driver.findElement(By.id("page-number3"));//page 3
        page3Button.click();
        WebElement page3ButtonText=driver.findElement(By.id("content"));
        String value3=page3ButtonText.getText();
        assertEquals("Welcome to Page 3! This is the content of the first page.",value3);


    }
    @Test
    public void nextPrevButtonsTest() {

        driver.get(pagePath);
        int i;
        WebElement pageButton = driver.findElement(By.id("page-number1"));
        pageButton.click();

        for(i=1;i<3;i++)
        {
            WebElement pageButtonText=driver.findElement(By.id("content"));
            String value3=pageButtonText.getText();
            String expectedContent = "Welcome to Page " + i + "! This is the content of the first page.";
            assertEquals(expectedContent,value3);
            WebElement nextButton = driver.findElement(By.id("next"));
            nextButton.click();

        }
        WebElement page3Button = driver.findElement(By.id("page-number3"));
        page3Button.click();
        for(i=3;i>0;i--)
        {
            WebElement pageButtonText=driver.findElement(By.id("content"));
            String value3=pageButtonText.getText();
            String expectedContent = "Welcome to Page " + i + "! This is the content of the first page.";
            assertEquals(expectedContent,value3);
            WebElement prevButton = driver.findElement(By.id("prev"));
           prevButton.click();

        }





        }








    @AfterEach
    public void teardown() {
        driver.quit(); // Clean up and close the browser after each test
    }
}

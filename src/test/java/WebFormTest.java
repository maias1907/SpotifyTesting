import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

public class WebFormTest {
    WebDriver driver;

    private static final String baseURL = "https://www.selenium.dev/selenium/web/web-form.html";


    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }


    @Test//test 1
    public void inputFieldTest(){
        // 1. Enter text into the Text input field and verify the entered value
        driver.get(baseURL);
        WebElement textInput = driver.findElement(By.id("my-text-id"));
        textInput.sendKeys("Hello Maias");
        assertEquals("Hello Maias", textInput.getAttribute("value"), "Text input value mismatch");
    }
    @Test//test 2
    public void textareaTest(){

        driver.get(baseURL);
        WebElement textInput = driver.findElement(By.name("my-textarea"));
        textInput.sendKeys("Hello Maias,how are you?");
        assertEquals("Hello Maias,how are you?", textInput.getAttribute("value"), "Text input value mismatch");

    }
    @Test//test 3
    public void disabledInput(){

        driver.get(baseURL);
        WebElement disabledInput = driver.findElement(By.name("my-disabled"));
        assertFalse(disabledInput.isEnabled(), "Disabled input field is interactable");
    }
    @Test//test4
    public void readOnlyInput(){

        driver.get(baseURL);
        WebElement readOnly = driver.findElement(By.name("my-readonly"));
        assertEquals("Readonly input",readOnly.getDomAttribute("value"),"Readonly input value mismatch");
        assertTrue(readOnly.isDisplayed());
    }
    @Test//test5
    public void dropDownSelect(){

        driver.get(baseURL);
        Select dropdown = new Select(driver.findElement(By.name("my-select")));
        dropdown.selectByVisibleText("Two");
        assertEquals("2", dropdown.getFirstSelectedOption().getAttribute("value"), "Dropdown selection mismatch");

    }
    @Test //test 6
    public void dataListTest()
    {
        driver.get(baseURL);
        WebElement datalistInput = driver.findElement(By.name("my-datalist"));
        datalistInput.sendKeys("New York");
        assertEquals("New York", datalistInput.getAttribute("value"), "Datalist selection mismatch");
    }
   @Test //test 7
   public void selectedbyDefault()
   {
       driver.get(baseURL);
       WebElement checkedCheckbox = driver.findElement(By.id("my-check-2"));
       WebElement checkedRadio = driver.findElement(By.id("my-radio-2"));
       assertFalse(checkedCheckbox.isSelected(), "Checkbox should not be selected by default");
       checkedCheckbox.click();
       assertTrue(checkedCheckbox.isSelected(), "Checkbox should be selected after clicking");
       assertFalse(checkedRadio.isSelected(), "checkedRadio should not be selected by default");
       checkedRadio.click();
       assertTrue(checkedRadio.isSelected(), "Checked radio should be selected after clicking");
   }
    @Test //test 8
    public void toggleCheckboxRadio()
    {
        driver.get(baseURL);

        WebElement uncheckedCheckbox = driver.findElement(By.id("my-check-1"));

        if(uncheckedCheckbox.isSelected())
        {
            uncheckedCheckbox.click();
        }
        assertFalse(uncheckedCheckbox.isSelected());
        uncheckedCheckbox.click();
        assertTrue(uncheckedCheckbox.isSelected());


        WebElement uncheckedRadio = driver.findElement(By.id("my-radio-1"));
        uncheckedRadio.click();
        assertTrue(uncheckedRadio.isSelected(), "Radio should be selected after click");
    }
    @Test //test 9
    public void submitButton()
    {
        driver.get(baseURL);
        WebElement submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
        submitButton.click();
        WebElement messageElement = driver.findElement(By.className("display-6"));

        // Validate the message
        String actualMessage = messageElement.getText();
        String expectedMessage = "Form submitted";
        assertEquals(expectedMessage, actualMessage, "The displayed message after form submission is incorrect");



    }

    @AfterEach
    public void teardown() {
        driver.quit(); // Clean up and close the browser after each test
    }



}

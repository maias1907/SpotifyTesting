import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    WebDriver driver;

    private static final String baseURL = "http://localhost:8082"; // Replace with actual URL
    private static final String expectedPageTitle = "Spotify Clone"; // Optional: Verify page title
    private static final String expectedPageMessage = "Oops.... Not Available"; // Optional: Check message

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void testPlayPauseButton() {
        // Navigate to your target page
        driver.get(baseURL);

        // Locate the button by its ID (can be changed to className or CSS Selector)
        WebElement playButton = driver.findElement(By.id("masterPlay"));
        playButton.click();

        // Wait for the action to reflect (media should be playing now)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(playButton, "class", "bi-pause-fill")); // Waiting for the play button to change to pause

        // Validate that the play button class changed to "bi-pause-fill" (indicating it's playing)
        String playClass = playButton.getAttribute("class");
        assertTrue(playClass.contains("bi-pause-fill"), "Play action failed! Button did not change to Pause.");
        playButton.click();

        // Wait for the action to reflect (media should be paused now)
        wait.until(ExpectedConditions.attributeContains(playButton, "class", "bi-play-fill")); // Waiting for the play button to revert to play

        // Validate that the play button class changed back to "bi-play-fill" (indicating it's paused)
        String pauseClass = playButton.getAttribute("class");
        assertTrue(pauseClass.contains("bi-play-fill"), "Pause action failed! Button did not revert to Play.");
    }


    @AfterEach
    public void teardown() {
        driver.quit(); // Clean up and close the browser after each test
    }
}

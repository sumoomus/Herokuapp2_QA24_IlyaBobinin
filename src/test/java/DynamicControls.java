import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicControls {
    private static final String URL = "https://the-internet.herokuapp.com/dynamic_controls";

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void navigate() {
        driver.get(URL);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testDynamicControl() {
        WebElement removeButton = driver.findElement(By.cssSelector("#checkbox-example button"));
        removeButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "It's gone!"));

        WebElement checkbox = driver.findElement(By.id("checkbox"));
        Assert.assertFalse(checkbox.isDisplayed());

        WebElement input = driver.findElement(By.cssSelector("#input-example input[type='text']"));
        Assert.assertFalse(input.isEnabled());

        WebElement addButton = driver.findElement(By.cssSelector("#input-example button"));
        addButton.click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("message"), "It's enabled!"));
        Assert.assertTrue(input.isEnabled());
    }
}

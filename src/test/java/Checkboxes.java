import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Checkboxes {
    private static final String URL = "https://the-internet.herokuapp.com/";

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
    public void add() throws InterruptedException {

        WebElement checkBoxes = driver.findElement(By.xpath("//a[normalize-space()='Checkboxes']"));
        checkBoxes.click();


        WebElement checkbox1 = driver.findElement(By.cssSelector("[type=checkbox]"));
        checkbox1.isEnabled();
        WebElement successMessage = driver.findElement(By.cssSelector("[type=checkbox]"));
        Assert.assertTrue(successMessage.isEnabled());
        checkbox1.click();
        WebElement successMessage1 = driver.findElement(By.cssSelector("[type=checkbox]"));
        Assert.assertTrue(successMessage1.isSelected());


        WebElement checkbox2 = driver.findElement(By.cssSelector("[type=checkbox]"));
        checkbox2.isSelected();
        WebElement successMessage2 = driver.findElement(By.cssSelector("[type=checkbox]"));
        Assert.assertFalse(successMessage2.isSelected());
        checkbox2.click();
        WebElement successMessage3 = driver.findElement(By.cssSelector("[type=checkbox]"));
        Assert.assertTrue(successMessage3.isEnabled());


    }
}
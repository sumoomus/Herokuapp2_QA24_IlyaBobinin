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

public class AddRemove {
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

        WebElement addRemoveButton = driver.findElement(By.xpath("//a[normalize-space()='Add/Remove Elements']"));
        addRemoveButton.click();

        WebElement successMessage = driver.findElement(By.cssSelector("body > div:nth-child(2) > div:nth-child(2) > h3:nth-child(1)"));
        Assert.assertTrue(successMessage.isDisplayed());
        String expectedSuccessMessage = "Add/Remove Elements";
        Assert.assertEquals(successMessage.getText(), expectedSuccessMessage);

        WebElement addElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElementButton.click();
        addElementButton.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[text()='Delete']"));
        deleteButton.click();

        WebElement[] deleteButtons = driver.findElements(By.xpath("//button[text()='Delete']")).toArray(new WebElement[0]);
        int deleteButtonCount = deleteButtons.length;

        String result = (deleteButtonCount == 1) ? "Test passed!" : "Test failed.";
        System.out.println(result);

    }

}
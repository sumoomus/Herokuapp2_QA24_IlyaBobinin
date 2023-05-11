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
import java.util.List;

public class AddRemove {
    private static final String URL = "http://the-internet.herokuapp.com/add_remove_elements/";

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


            WebElement addElementButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
            addElementButton.click();
            addElementButton.click();

            List<WebElement> removeButtons = driver.findElements(By.xpath("//button[text()='Delete']"));
            Assert.assertEquals(removeButtons.size(), 2);
            removeButtons.get(0).click();

            List<WebElement> deleteButtons1 = driver.findElements(By.xpath("//button[text()='Delete']"));
            Assert.assertEquals(deleteButtons1.size(), 1);
    }

}
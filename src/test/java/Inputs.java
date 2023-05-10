import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Inputs {
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
        WebElement inputs = driver.findElement(By.xpath("//a[normalize-space()='Inputs']"));
        inputs.click();

        WebElement inputsField = driver.findElement(By.tagName("input"));
        inputsField.click();

        inputsField.sendKeys("3");
        inputsField.sendKeys(Keys.ARROW_UP);
        inputsField.sendKeys("q");
        inputsField.sendKeys(Keys.ARROW_DOWN);
        inputsField.sendKeys("1");


    }
}
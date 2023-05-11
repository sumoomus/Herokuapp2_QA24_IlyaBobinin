import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Inputs {
    private static final String URL = "https://the-internet.herokuapp.com/inputs";

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

        WebElement inputs = driver.findElement(By.tagName("input"));
        inputs.sendKeys("2");

        String keyResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(keyResult, "2");
        inputs.sendKeys(Keys.ARROW_UP);

        String upKeyResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(upKeyResult, "3");
        inputs.sendKeys(Keys.ARROW_DOWN);

        String downKeyResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(downKeyResult, "2");

        inputs.clear();
        inputs.sendKeys("qwe");
        String lettersResult = driver.findElement(By.tagName("input")).getAttribute("value");
        Assert.assertEquals(lettersResult, "");


    }
}
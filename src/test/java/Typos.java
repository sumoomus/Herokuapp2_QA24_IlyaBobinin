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


public class Typos {
    private static final String URL = "https://the-internet.herokuapp.com/typos";

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

        String typos = driver.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]")).getText();

        Assert.assertEquals(typos, "Sometimes you'll see a typo, other times you won't.", "Error:'won,t' is misspelled");
    }
}
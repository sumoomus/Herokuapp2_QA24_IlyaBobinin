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




public class Frames {
    private static final String URL = "https://the-internet.herokuapp.com/frames";
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
    public void testFrames() {

        WebElement iframeLink = driver.findElement(By.linkText("iFrame"));
        iframeLink.click();

        driver.switchTo().frame("mce_0_ifr");

        WebElement paragraph = driver.findElement(By.tagName("p"));
        String paragraphText = paragraph.getText();


        Assert.assertEquals(paragraphText, "Your content goes here.");
        driver.switchTo().defaultContent();



    }

}

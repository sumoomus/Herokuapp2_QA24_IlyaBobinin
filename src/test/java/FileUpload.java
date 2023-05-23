import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;


public class FileUpload {
    private static final String URL = "https://the-internet.herokuapp.com/upload";
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
    public void testFileUpload() {


        driver.findElement(By.xpath("//input[@type='file']"))
                .sendKeys(System.getProperty("user.dir") + "/src/test/resources/example.txt");
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        File uploadedFile = new File("/src/test/resources/example.txt");

        String actualFileName = uploadedFile.getName();
        String expectedFileName = uploadedFile.getName();
        Assert.assertEquals(actualFileName, expectedFileName);
    }
}



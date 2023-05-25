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


public class FileUpload {
    private static final String URL = "https://the-internet.herokuapp.com/upload";
    private WebDriver driver;
    private WebDriverWait wait;

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


        driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir") + "/src/test/resources/example.txt");
        driver.findElement(By.id("file-submit")).click();

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text() = 'File Uploaded!']")));

        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        uploadedFile.getText();
        
        Assert.assertEquals(uploadedFile.getText(), "example.txt");
    }
}



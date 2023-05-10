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
        WebElement typos = driver.findElement(By.xpath("//a[normalize-space()='Typos']"));
        typos.click();


//        я нашел такого вида решение данной задачи


//
//        java.util.List<WebElement> paragraphs = driver.findElements(By.tagName("p"));
//
//
//        String expectedText = "This example demonstrates a typo being introduced. It does it randomly on each page load.";
//        String actualText = paragraphs.get(0).getText();
//        if (!actualText.equals(expectedText)) {
//            System.out.println("Ошибка: текст первого параграфа не соответствует ожидаемому");
//        }
//
//
//        expectedText = "Sometimes you'll see a typo, other times you won't.";
//        actualText = paragraphs.get(1).getText();
//        if (!actualText.equals(expectedText)) {
//            System.out.println("Ошибка: текст второго параграфа не соответствует ожидаемому");
//        }


//     а тут мое, я не смог ничего качественного придумать

        WebElement text = driver.findElement(By.tagName("p"));
        Assert.assertTrue(text.isDisplayed());
        String successText = "This example demonstrates a typo being introduced. It does it randomly on each page load.\n" +
                "\n" +
                "Sometimes you'll see a typo, other times you won't.";

        Assert.assertEquals(text.getText(), successText);


    }
}
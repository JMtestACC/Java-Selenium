import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertEquals;

public class FirstTest {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://przyklady.javastart.pl/jpetstore/");
    }

    @Test
    public void myFirstTest() {
        driver.findElement(By.xpath("//a[.='Enter the Store']")).click();

        driver.findElement(By.xpath("//a[.='Sign In']")).click();
        driver.findElement(By.name("username")).sendKeys("wrongName");
        driver.findElement(By.name("password")).sendKeys("wrongPasswd");
        driver.findElement(By.name("signon")).click();

        assertEquals(driver.findElement(By.xpath("//ul[@class='messages']/li")).getText(), "Invalid username or password. Signon failed.");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}

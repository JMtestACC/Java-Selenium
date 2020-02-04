import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertEquals;

public class FailedLoginTests {

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
        WebElement enterStoreLink = driver.findElement(By.xpath("//a[.='Enter the Store']"));
        enterStoreLink.click();

        WebElement signOnLink = driver.findElement(By.xpath("//a[.='Sign In']"));
        signOnLink.click();

        WebElement usernameFiled = driver.findElement(By.name("username"));
        usernameFiled.sendKeys("wrongName");

        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("wrongPasswd");

        WebElement signOnButton = driver.findElement(By.name("signon"));
        signOnButton.click();

        WebElement messageLabel = driver.findElement(By.xpath("//ul[@class='messages']/li"));

        assertEquals(messageLabel.getText(), "Invalid username or password. Signon failed.");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}

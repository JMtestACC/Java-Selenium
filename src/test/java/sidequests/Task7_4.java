package sidequests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Task7_4 {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/hovers");
    }

    @Test
    public void hoverTest() {
        WebElement firstUserAvatar = driver.findElement(By.xpath("(//div[@class='figure'])[1]"));
        WebElement secondUserAvatar = driver.findElement(By.xpath("(//div[@class='figure'])[2]"));
        WebElement thirdUserAvatar = driver.findElement(By.xpath("(//div[@class='figure'])[3]"));

        Actions action = new Actions(driver);
        action.moveToElement(firstUserAvatar).perform();

        WebElement firstUserText = driver.findElement(By.xpath("(//div[@class='figure'])[1]/div/h5"));
        WebElement secondUserText = driver.findElement(By.xpath("(//div[@class='figure'])[2]/div/h5"));
        WebElement thirdUserText = driver.findElement(By.xpath("(//div[@class='figure'])[3]/div/h5"));

        assertEquals(firstUserText.getText(), "name: user1");
        assertEquals(secondUserText.getText(), "");
        assertEquals(thirdUserText.getText(), "");

        action.moveToElement(secondUserAvatar).perform();

        assertEquals(firstUserText.getText(), "");
        assertEquals(secondUserText.getText(), "name: user2");
        assertEquals(thirdUserText.getText(), "");

        action.moveToElement(thirdUserAvatar).perform();

        assertEquals(firstUserText.getText(), "");
        assertEquals(secondUserText.getText(), "");
        assertEquals(thirdUserText.getText(), "name: user3");

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}

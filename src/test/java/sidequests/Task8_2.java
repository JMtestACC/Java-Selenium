package sidequests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Task8_2 {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dynamic_controls");
    }

    @Test
    public void waitForPresenceOfTheElement() {
        WebElement checkboxFiled = driver.findElement(By.xpath("//div/input[@id='checkbox']"));
        assertFalse(checkboxFiled.isSelected());
        assertTrue(checkboxFiled.isDisplayed());

        WebElement removeOrAddButton = driver.findElement(By.id("btn"));
        removeOrAddButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(checkboxFiled));

        WebElement messageLabel = driver.findElement(By.id("message"));
        assertEquals(messageLabel.getText(), "It's gone!");

        removeOrAddButton.click();

        checkboxFiled = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/input[@id='checkbox']")));

        assertFalse(checkboxFiled.isSelected());
        assertTrue(checkboxFiled.isDisplayed());

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}

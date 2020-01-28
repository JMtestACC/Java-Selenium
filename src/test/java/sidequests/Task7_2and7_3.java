package sidequests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class Task7_2and7_3 {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTests() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void checkboxesTest() {
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/checkboxes");

        WebElement checkbox1 = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

        assertFalse(checkbox1.isSelected());
        assertTrue(checkbox2.isSelected());

        sleep();

        checkbox1.click();
        checkbox2.click();

        sleep();

        assertTrue(checkbox1.isSelected());
        assertFalse(checkbox2.isSelected());

    }

    @Test
    public void dropdownTest() {
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/dropdown");

        WebElement dropdownList = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdownList);

        String selectedOption = select.getFirstSelectedOption().getText();
        assertEquals(selectedOption, "Please select an option");

        select.selectByValue("1");
        selectedOption = select.getFirstSelectedOption().getText();
        assertEquals(selectedOption, "Option 1");

        select.selectByValue("2");
        selectedOption = select.getFirstSelectedOption().getText();
        assertEquals(selectedOption, "Option 2");
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }


}

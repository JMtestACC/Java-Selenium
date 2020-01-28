package sidequests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task7_3 {

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://theinternet.przyklady.javastart.pl/upload");
    }

    @Test
    public void fileUploadTest() {
        WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
        chooseFileButton.sendKeys("D:\\fileForSeleniumTest.txt");

        WebElement uploadFileButton = driver.findElement(By.id("file-submit"));
        uploadFileButton.click();

        WebElement uploadedFileName = driver.findElement(By.id("uploaded-files"));
        assertEquals(uploadedFileName.getText(), "fileForSeleniumTest.txt");
    }

    @AfterMethod
    public void afterTest() {
        driver.close();
        driver.quit();
    }

}

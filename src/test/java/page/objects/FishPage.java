package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishPage {

    @FindBy(xpath = "//a[.='FI-SW-01']")
    private WebElement angelFishProductIdLink;

    public WebDriver driver;

    public FishPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnAngelFishProductId() {
        angelFishProductIdLink.click();
    }

}

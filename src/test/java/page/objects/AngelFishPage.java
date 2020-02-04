package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelFishPage {

    @FindBy(xpath = "(//a[.='Add to Cart'])[2]")
    private WebElement smallAngelFishAddToCartButton;

    public WebDriver driver;

    public AngelFishPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToCartSmallAngelFish() {
        smallAngelFishAddToCartButton.click();
    }
}

package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AngelFishPage {

    @FindBy(xpath = "(//a[.='Add to Cart'])[2]")
    private WebElement smallAngelFishAddToCartButton;

    public AngelFishPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void addToCartSmallAngelFish() {
        smallAngelFishAddToCartButton.click();
    }
}

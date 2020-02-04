package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    @FindBy(xpath = "//a[.='Proceed to Checkout']")
    private WebElement proceedToCheckoutButton;

    public WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

}

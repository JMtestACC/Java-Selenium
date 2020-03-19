package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//a[.='Proceed to Checkout']")
    private WebElement proceedToCheckoutButton;

    @Step("Click on button 'Proceed to Checkout'")
    public CheckoutPage clickOnProceedToCheckoutButton() {
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        log().info("Checkout Button was clicked");
        return new CheckoutPage();
    }

}

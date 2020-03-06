package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class ShoppingCartPage {

    private Logger logger = LogManager.getLogger(ShoppingCartPage.class);

    @FindBy(xpath = "//a[.='Proceed to Checkout']")
    private WebElement proceedToCheckoutButton;

    public ShoppingCartPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Click on button 'Proceed to Checkout'")
    public CheckoutPage clickOnProceedToCheckoutButton() {
        WaitForElement.waitUntilElementIsClickable(proceedToCheckoutButton);
        proceedToCheckoutButton.click();
        logger.info("Checkout Button was clicked");
        return new CheckoutPage();
    }

}

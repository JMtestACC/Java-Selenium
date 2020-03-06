package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class AngelFishPage {

    private Logger logger = LogManager.getLogger(AngelFishPage.class);

    @FindBy(xpath = "(//a[.='Add to Cart'])[2]")
    private WebElement smallAngelFishAddToCartButton;

    public AngelFishPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Add 'Small Angel Fish' to shop cart")
    public ShoppingCartPage addToCartSmallAngelFish() {
        WaitForElement.waitUntilElementIsClickable(smallAngelFishAddToCartButton);
        smallAngelFishAddToCartButton.click();
        logger.info("Small Angel Fish was added to cart");
        return new ShoppingCartPage();
    }
}

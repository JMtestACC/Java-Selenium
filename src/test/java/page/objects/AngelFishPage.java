package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class AngelFishPage extends BasePage {

    @FindBy(xpath = "(//a[.='Add to Cart'])[2]")
    private WebElement smallAngelFishAddToCartButton;

    @Step("Add 'Small Angel Fish' to shop cart")
    public ShoppingCartPage addToCartSmallAngelFish() {
        WaitForElement.waitUntilElementIsClickable(smallAngelFishAddToCartButton);
        smallAngelFishAddToCartButton.click();
        log().info("Small Angel Fish was added to cart");
        return new ShoppingCartPage();
    }
}

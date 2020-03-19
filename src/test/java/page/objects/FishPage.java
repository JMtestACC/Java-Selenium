package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class FishPage extends BasePage {

    @FindBy(xpath = "//a[.='FI-SW-01']")
    private WebElement angelFishProductIdLink;

    @Step("Click on Angel Fish Product ID")
    public AngelFishPage clickOnAngelFishProductId() {
        WaitForElement.waitUntilElementIsClickable(angelFishProductIdLink);
        angelFishProductIdLink.click();
        log().info("Product ID link for Angel Fish was clicked.");
        return new AngelFishPage();
    }

}

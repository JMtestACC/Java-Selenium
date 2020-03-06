package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class FishPage {

    private Logger logger = LogManager.getLogger(FishPage.class);

    @FindBy(xpath = "//a[.='FI-SW-01']")
    private WebElement angelFishProductIdLink;

    public FishPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Click on Angel Fish Product ID")
    public AngelFishPage clickOnAngelFishProductId() {
        WaitForElement.waitUntilElementIsClickable(angelFishProductIdLink);
        angelFishProductIdLink.click();
        logger.info("Product ID link for Angel Fish was clicked.");
        return new AngelFishPage();
    }

}

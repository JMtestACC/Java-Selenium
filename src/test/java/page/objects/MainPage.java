package page.objects;

import driver.manager.DriverManager;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class MainPage {

    private Logger logger = LogManager.getLogger(MainPage.class);

    @FindBy(xpath = "//img[@src='../images/fish_icon.gif']")
    private WebElement fishLinkFromSideList;

    public MainPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Open page with Fishes using menu from left side")
    public FishPage openFishPageByUsingSideList() {
        WaitForElement.waitUntilElementIsClickable(fishLinkFromSideList);
        fishLinkFromSideList.click();
        logger.info("Fish Page was selected from side list and opened.");
        return new FishPage();
    }



}

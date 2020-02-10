package page.objects;

import driver.manager.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class MainPage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//img[@src='../images/fish_icon.gif']")
    private WebElement fishLinkFromSideList;

    public MainPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public FishPage openFishPageByUsingSideList() {
        WaitForElement.waitUntilElementIsClickable(fishLinkFromSideList);
        fishLinkFromSideList.click();
        logger.info("Fish Page was selected from side list and opened.");
        return new FishPage();
    }



}

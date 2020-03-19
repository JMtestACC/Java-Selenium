package page.objects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class MainPage extends BasePage {

    @FindBy(xpath = "//img[@src='../images/fish_icon.gif']")
    private WebElement fishLinkFromSideList;

    @Step("Open page with Fishes using menu from left side")
    public FishPage openFishPageByUsingSideList() {
        WaitForElement.waitUntilElementIsClickable(fishLinkFromSideList);
        fishLinkFromSideList.click();
        log().info("Fish Page was selected from side list and opened.");
        return new FishPage();
    }



}

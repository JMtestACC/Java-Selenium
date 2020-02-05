package page.objects;

import driver.manager.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class MainPage {

    @FindBy(xpath = "//img[@src='../images/fish_icon.gif']")
    private WebElement fishLinkFromSideList;

    public MainPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public void openFishPageByUsingSideList() {
        WaitForElement.waitUntilElementIsClickable(fishLinkFromSideList);
        fishLinkFromSideList.click();
    }



}

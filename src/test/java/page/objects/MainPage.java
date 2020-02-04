package page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "//img[@src='../images/fish_icon.gif']")
    private WebElement fishLinkFromSideList;

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openFishPageByUsingSideList() {
        fishLinkFromSideList.click();
    }



}

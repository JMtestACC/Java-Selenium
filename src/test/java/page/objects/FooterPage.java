package page.objects;

import driver.manager.DriverManager;
import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.WaitForElement;

public class FooterPage {

    private Logger logger = LogManager.getLogger(FooterPage.class);

    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerAfterLoginLogo;

    public FooterPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    @Step("Assert that dog banner is displayed after successful login")
    public FooterPage assertThatDogBannerAfterLoginDisplayed(){
        WaitForElement.waitUntilElementIsVisible(bannerAfterLoginLogo);
        AssertWebElement.assertThat(bannerAfterLoginLogo).isDisplayed();
        return this;
    }

}
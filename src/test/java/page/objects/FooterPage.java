package page.objects;

import generic.assertions.AssertWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import waits.WaitForElement;

public class FooterPage extends BasePage {

    @FindBy(css = "#Banner img[src*='dog']")
    private WebElement bannerAfterLoginLogo;

    @Step("Assert that dog banner is displayed after successful login")
    public FooterPage assertThatDogBannerAfterLoginDisplayed(){
        WaitForElement.waitUntilElementIsVisible(bannerAfterLoginLogo);
        AssertWebElement.assertThat(bannerAfterLoginLogo).isDisplayed();
        return this;
    }

}
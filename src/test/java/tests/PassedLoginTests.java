package tests;

import org.testng.annotations.Test;
import page.objects.LandingPage;

import static org.testng.Assert.assertTrue;

public class PassedLoginTests extends TestBase {

    @Test
    public void asUserLoginUsingValidLoginAndPassword() {
        LandingPage landingPage = new LandingPage();
        boolean isBannerAfterLoginDisplayed = landingPage
                .clickOnEnterStoreLink()
                .clickOnSignInLink()
                .typeIntoUserNameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .isBannerAfterLoginDisplayed();
        assertTrue(isBannerAfterLoginDisplayed);
    }
}


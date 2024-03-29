package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;
import static org.testng.Assert.assertTrue;

public class PassedLoginTests extends TestBase {

    @Test
    @TmsLink("PRTEST-2")
    @Issue("RGR_TA_BUG-2")
    @Severity(SeverityLevel.BLOCKER)
    @Description("The goal of this test is to log in using proper username and password" +
            "and check if Dog Banner is displayed after")
    public void asUserLoginUsingValidLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("j2ee")
                .typeIntoPasswordField("j2ee")
                .clickOnLoginButton()
                .assertThatDogBannerAfterLoginDisplayed();
    }
}


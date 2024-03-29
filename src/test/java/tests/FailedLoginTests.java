package tests;

import driver.manager.DriverUtils;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import page.objects.LoginPage;

import static navigation.ApplicationURLs.LOGIN_URL;

public class FailedLoginTests extends TestBase {

    @Test
    @TmsLink("PRTEST-1")
    @Issue("RGR_TA_BUG-1")
    @Severity(SeverityLevel.NORMAL)
    @Description("The goal of this test is to log in using not proper username and password" +
            "and check if warning message Invalid username or password is displayed")
    public void asUserTryToLogInWithIncorrectLoginAndPassword() {
        DriverUtils.navigateToPage(LOGIN_URL);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoUserNameField("wrongName")
                .typeIntoPasswordField("wrongPasswd")
                .clickOnLoginButton();
        loginPage
                .assertThatWarningMessageIsDisplayed("Invalid username or password. Signon failed.");
    }
}

package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import page.objects.*;

public class ShoppingCartTest extends TestBase{

    @Test
    @TmsLink("PRTEST-3")
    @Issue("RGR_TA_BUG-3")
    @Severity(SeverityLevel.CRITICAL)
    @Description("The goal of this test is to add to cart one Angel Fish" +
            "and check if warning message regarding missing sign in is displayed")
    public void asNotLoggedUserIWillNotProceedToCheckout() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        MainPage mainPage = new MainPage();
        mainPage
                .openFishPageByUsingSideList()
                .clickOnAngelFishProductId()
                .addToCartSmallAngelFish()
                .clickOnProceedToCheckoutButton();

        LoginPage loginPage = new LoginPage();
        loginPage
                .assertThatWarningMessageIsDisplayed("You must sign on before attempting to check out. Please sign on and try checking out again.");
    }

}

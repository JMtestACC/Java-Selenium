package tests;

import org.testng.annotations.Test;
import page.objects.*;
import static org.testng.Assert.assertTrue;

public class ShoppingCartTest extends TestBase{

    @Test
    public void asNotLoggedUserIWillNotProceedToCheckout() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnEnterStoreLink();

        MainPage mainPage = new MainPage(driver);
        mainPage.openFishPageByUsingSideList();

        FishPage fishPage = new FishPage(driver);
        fishPage.clickOnAngelFishProductId();

        AngelFishPage angelFishPage = new AngelFishPage(driver);
        angelFishPage.addToCartSmallAngelFish();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.clickOnProceedToCheckoutButton();

        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.getWarningMessage().contains("You must sign on before attempting to check out"));
    }

}

package tests;

import org.testng.annotations.Test;
import page.objects.*;
import static org.testng.Assert.assertTrue;

public class ShoppingCartTest extends TestBase{

    @Test
    public void asNotLoggedUserIWillNotProceedToCheckout() {
        LandingPage landingPage = new LandingPage();
        landingPage.clickOnEnterStoreLink();

        MainPage mainPage = new MainPage();
        mainPage.openFishPageByUsingSideList();

        FishPage fishPage = new FishPage();
        fishPage.clickOnAngelFishProductId();

        AngelFishPage angelFishPage = new AngelFishPage();
        angelFishPage.addToCartSmallAngelFish();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.clickOnProceedToCheckoutButton();

        LoginPage loginPage = new LoginPage();
        assertTrue(loginPage.getWarningMessage().contains("You must sign on before attempting to check out"));
    }

}

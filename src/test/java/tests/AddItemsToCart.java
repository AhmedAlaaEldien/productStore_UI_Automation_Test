package tests;

import base.BaseTests;
import helpers.TestngListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyCartsPage;
import pages.ProductPage;
import pages.ShopPage;
import static org.testng.Assert.assertFalse;

@Listeners(TestngListener.class)
public class AddItemsToCart extends BaseTests {

    @Test(dataProvider = "place_order",  dataProviderClass = data_provider.PlaceOrderFormDataProvider.class)
    public void AddToCartTest(String name, String country, String city, String card, String month, String year){


        var homepage = new HomePage(getDriver());
        homepage.ClickOnLogInOption().enterUserCredentials().logIn();


        var shopPage = new ShopPage(getDriver());
        shopPage.selectCategoryFromList().selectItemFromList();

        var productPage = new ProductPage(getDriver());
        productPage.AddItemToCart().openMyCart();

        var myCartsPage = new MyCartsPage(getDriver());
        myCartsPage.ClickOnPlaceOrder().fillPlaceOrderForm(name, country, city, card,  month, year).ClickOnPurchaseButton();

        var AlertMSgIsDisplayed = myCartsPage.getAlertMSG();
        assertFalse(AlertMSgIsDisplayed);



}
}

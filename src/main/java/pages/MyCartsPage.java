package pages;

import helpers.GUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyCartsPage {

    private final WebDriver driver;
    private final GUIActions guiActions;
    private final By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");
    private final By placeOrderNameField = By.id("name");
    private final By placeOrderCountryField = By.id("country");
    private final By placeOrderCityField = By.id("city");
    private final By placeOrderCreditCardField = By.id("card");
    private final By placeOrderMonthField = By.id("month");
    private final By placeOrderYearField = By.id("year");
    private final By purchaseButton = By.xpath("//button[contains(text(),'Purchase')]");
    private final By closeButton = By.xpath("//button[contains(text(),'Close')]");





    public MyCartsPage(WebDriver driver) {
        this.driver = driver;
        guiActions = new GUIActions(driver);
    }

    public MyCartsPage ClickOnPlaceOrder(){
        guiActions.clickOn(placeOrderButton);
        return new MyCartsPage(driver);

    }

    public MyCartsPage fillPlaceOrderForm(String name, String country, String city, String card, String month, String year){
        guiActions.sendTextTo(placeOrderNameField, name);
        guiActions.sendTextTo(placeOrderCountryField, country);
        guiActions.sendTextTo(placeOrderCityField, city);
        guiActions.sendTextTo(placeOrderCreditCardField, card);
        guiActions.sendTextTo(placeOrderMonthField, month);
        guiActions.sendTextTo(placeOrderYearField, year);
        return new MyCartsPage(driver);
    }

    public MyCartsPage ClickOnPurchaseButton(){
        guiActions.clickOn(purchaseButton);
        return new MyCartsPage(driver);
    }

    public MyCartsPage ClickOnCloseButton(){
        guiActions.clickOn(closeButton);
        return new MyCartsPage(driver);
    }

    public boolean getAlertMSG(){
        return guiActions.captureAndAcceptAlertMsg();
    }

}

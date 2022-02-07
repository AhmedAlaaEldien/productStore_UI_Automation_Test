package pages;

import helpers.GUIActions;
import helpers.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final WebDriver driver;
    private final GUIActions guiActions;
    private final By logInOption= By.id("login2");
    private final By userNameField = By.id("loginusername");
    private final By passwordField = By.id("loginpassword");
    private final By confirmLogInButton = By.xpath("//button[contains(text(),'Log in')]");
    private final By closeButton = By.xpath("//button[contains(text(),'Close')]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        guiActions = new GUIActions(driver);
    }
    public HomePage ClickOnLogInOption() {
        guiActions.clickOn(logInOption);
        return new HomePage(driver);
    }

    public HomePage enterUserCredentials() {
        var userName =  new PropertiesReader("test-data").getProperty("username");
        var passWord =  new PropertiesReader("test-data").getProperty("password");
        guiActions.sendTextTo(userNameField, userName);
        guiActions.sendTextTo(passwordField, passWord);
        return new HomePage(driver);
    }


    public void logIn() {
        guiActions.clickOn(confirmLogInButton);
        new ShopPage(driver);
    }
}

package pages;

import helpers.GUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
    private final WebDriver driver;
    private final GUIActions guiActions;
    private final By myCart = By.id("cartur");
    private final By addToCartButton = By.xpath("//a[contains(text(),'Add to cart')]");


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        guiActions = new GUIActions(driver);

    }
    public ProductPage AddItemToCart(){
        guiActions.clickOn(addToCartButton);
        return new ProductPage(driver);
    }
    public MyCartsPage openMyCart(){
        guiActions.clickOn(myCart);
        return new MyCartsPage(driver);
    }


}

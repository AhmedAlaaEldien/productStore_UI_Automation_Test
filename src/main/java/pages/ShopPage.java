package pages;

import helpers.GUIActions;
import helpers.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage {

    private final WebDriver driver;
    private final GUIActions guiActions;
    private final By categoriesList = By.cssSelector("#itemc");
    private final By itemsList = By.cssSelector(".card-title");

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        guiActions = new GUIActions(driver);

    }

    public ShopPage selectCategoryFromList( ) {
        var selectedCategoryName = new PropertiesReader("test-data").getProperty("categoryName");
        guiActions.selectFromListByName(categoriesList , selectedCategoryName);
        return new ShopPage(driver);
    }

    public void selectItemFromList(){
        var selectedItemIndex = Integer.parseInt (new PropertiesReader("test-data").getProperty("ItemIndex"));
        guiActions.selectFromListByIndex(itemsList, selectedItemIndex);
        new ShopPage(driver);
    }
}


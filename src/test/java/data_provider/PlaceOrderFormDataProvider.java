package data_provider;

import base.BaseTests;

import helpers.Constant;
import helpers.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;


public class PlaceOrderFormDataProvider extends BaseTests {

    private final WebDriver driver;


    public PlaceOrderFormDataProvider(WebDriver driver) {
        this.driver = driver;
    }

    @DataProvider(name = "place_order")
    public static Object[][] placeOrderData() {
        var excelReader = new ExcelReader(Constant.Place_Order_DATA_FILE, Constant.Place_Order_DATA_SHEET);
        Object data[][]= excelReader.getData();
        return data;
    }
}

package base;

import helpers.PropertiesReader;
import helpers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void beforeClassSetUp() {

        driver = WebDriverFactory.getDriver();
    }

    @BeforeMethod
    public void beforeMethodSetUp() {
        driver = WebDriverFactory.getDriver();
        var url = new PropertiesReader("test-configurations")
                .getProperty("base-url");
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethodSetUp() {}

    @AfterClass
    public void afterClassSetUp() {

        driver.quit();
    }


}

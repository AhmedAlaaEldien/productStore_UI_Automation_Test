package helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GUIActions {
    private final WebDriver driver;
    private final Actions actions;
    private final WebDriverWait wait;


    public GUIActions(WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 1000);
    }

    /**
     * This function is used to do the clickOn action on any selected element
     * by passing the target element to it and wait till this element is presence and clickable
     * then do the click action
     */
    public void clickOn(By by)  {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void clickOn(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    /**
     * This function is used to send data to element "Type on selected Element"
     * by passing the target element to it and wait till this element is presence and clickable
     * then Clear it as it might has cached data, then send (Type) the text on this element
     */
    public void sendTextTo(By by, String text) {
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    /**
     * This function is used to perform the Scrolling Action to Selected element or "position" on the UI with JavaScript Execution
     */
    public void scrollToElement(By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        WebElement element = driver.findElement(by);
        wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor JS =((JavascriptExecutor)driver);
        JS.executeScript("arguments[0].scrollIntoView(true)",by);

    }
    /**
     * This function is used to confine any List Of element when need to interact with it or with any index on it.
     */
    public int getListSize(By by) {
        List<WebElement> list = driver.findElements(by);
        return list.size();
    }

    public void selectFromListByName(By by, String IndexName) {

        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        List<WebElement> list = driver.findElements(by);
        for (WebElement l : list) {
            if (l.getText().equals(IndexName)){
                l.click();
                break;
            }
        }
    }

    public void selectFromListByIndex(By by, int Index) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        List <WebElement> list = driver.findElements(by);
        clickOn(list.get(Index));
    }


    public boolean captureAndAcceptAlertMsg(){
        boolean alertMsgIsDisplayed = driver.switchTo().alert().getText().isEmpty();
        if(!alertMsgIsDisplayed){
            System.out.println("Alert Msg Is Displayed: " + driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
            return false;
        }
        else{
            System.out.println("Alert Msg Is Not Displayed: " + driver.switchTo().alert().getText());
            driver.switchTo().alert().accept();
            return true;
        }

    }
}


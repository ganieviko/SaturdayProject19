package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

public class Base {

    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, 10);

    protected void clickOnElement (WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected void sendKeysToElement(WebElement element, String key){
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(key);
    }

}

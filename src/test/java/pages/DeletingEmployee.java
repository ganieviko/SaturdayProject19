package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeletingEmployee extends Base{

    public DeletingEmployee(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "ms-delete-button > button")
    private WebElement deleteButton;

    @FindBy(css = "ms-text-field[placeholder='GENERAL.FIELD.FIRST_NAME'] input")
    private WebElement searchBox;

    @FindBy(css = "ms-browse-search>div button")
    private WebElement searchButton;

    @FindBy(css = "button[type='submit']")
    private WebElement confirmYes;

    @FindBy(xpath = "//td[text()='ArturSec  GanievSec']")
    private WebElement editButton;

    @FindBy(id = "toast-container")
    private WebElement popUpMessageDeleted;

    public void deleteEmployee(String arturSec) throws InterruptedException {
        clickOnElement(searchBox);
        sendKeysToElement(searchBox, arturSec);
        clickOnElement(searchButton);
//        clickOnElement(editButton);
        clickOnElement(deleteButton);
//        Thread.sleep(2000);
        clickOnElement(confirmYes);

    }

    public void deleteEmployeeSecond(String arturSec) throws InterruptedException {
        clickOnElement(searchBox);
        sendKeysToElement(searchBox, arturSec);
        clickOnElement(searchButton);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ms-delete-button > button"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        driver.findElement(By.cssSelector("button[type='submit']")).click();

    }
    public String getTextPopUpMessageDeleted(){
        wait.until(ExpectedConditions.textToBePresentInElement(popUpMessageDeleted, "Employee successfully deleted"));
        popUpMessageDeleted.getText();
        return popUpMessageDeleted.getText();
    }
}

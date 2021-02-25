package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UpdateEmployee extends Base{

    public UpdateEmployee(){
        PageFactory.initElements(driver, this);}

    @FindBy(css = "ms-text-field[formcontrolname='firstName']>input")
    private WebElement updateFirstName;

    @FindBy(css = "ms-text-field[formcontrolname='lastName']>input")
    private WebElement updateLastName;

    @FindBy(css = "mat-form-field[class]:nth-child(1) input[data-placeholder='Employee ID']")
    private WebElement updateEmployeeIDElement;

    @FindBy(xpath = "//span[text()='Document Type']")
    private WebElement updateDocumentType;

    @FindBy(css = "[data-placeholder='Document Number']")
    private WebElement updateDocumentNumber;

    @FindBy(css = "mat-option:nth-child(3)")
    private WebElement subBirthCertificate;

    @FindBy(css = "ms-save-button")
    private WebElement saveButton;

    @FindBy(css = "ms-text-field[placeholder='GENERAL.FIELD.FIRST_NAME'] input")
    private WebElement searchBox;

    @FindBy(css = "ms-browse-search>div button")
    private WebElement searchButton;

    @FindBy(xpath = "//td[text()='Artur  Ganiev']")
    private WebElement editButton;

    @FindBy(id = "toast-container")
    private WebElement popUpMessageUpdated;


    public void findEmployee(String employeeName){
        clickOnElement(searchBox);
        sendKeysToElement(searchBox, employeeName);
        clickOnElement(searchButton);
        clickOnElement(editButton);
    }

    public void updateFirstName(String firstNameUpdated){
        sendKeysToElement(updateFirstName, firstNameUpdated);

    }
    public void updateLastName(String lastNameUpdated){
        sendKeysToElement(updateLastName, lastNameUpdated);
    }
    public void updatedDocumentNumber(String documentNumberUpdated){
        sendKeysToElement(updateDocumentNumber, documentNumberUpdated);
    }
    public void updateDocumentType(){
        clickOnElement(updateDocumentType);
        clickOnElement(subBirthCertificate);
    }
    public void clickOnSaveButton() {
        clickOnElement(saveButton);
    }

    public void waitPopMessageDisappear(){
        wait.until(ExpectedConditions.invisibilityOf(popUpMessageUpdated));
    }

    public String getTextPopUpMessageUpdated() {
        wait.until(ExpectedConditions.textToBePresentInElement(popUpMessageUpdated, "Employee successfully updated"));
        popUpMessageUpdated.getText();
        return popUpMessageUpdated.getText();
    }
}

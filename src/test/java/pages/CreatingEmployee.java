package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreatingEmployee extends Base{


    public CreatingEmployee(){
        PageFactory.initElements(driver, this);}

    @FindBy(css = ".group-items > :nth-child(5)")
    private WebElement humanResources;

    @FindBy(xpath = "//*[text()='Employees']")
    private WebElement employee;

    @FindBy(css = "ms-table-toolbar > div ms-add-button")
    private WebElement plusButton;

    @FindBy(css = "ms-text-field[formcontrolname='firstName']>input")
    private WebElement firstName;

    @FindBy(css = "ms-text-field[formcontrolname='lastName']>input")
    private WebElement lastName;

    @FindBy(css = "mat-form-field[class]:nth-child(1) input[data-placeholder='Employee ID']")
    private WebElement employeeIDElement;

    @FindBy(xpath = "//span[text()='Document Type']")
    private WebElement documentType;

    @FindBy(css = "[data-placeholder='Document Number']")
    private WebElement documentNumber;

    @FindBy(css = "mat-option:nth-child(1)")
    private WebElement subDocumentPersonalID;

    @FindBy(css = "mat-option:nth-child(2)")
    private WebElement subPassport;

    @FindBy(css = "mat-option:nth-child(3)")
    private WebElement subBirthCertificate;

    @FindBy(css = "ms-save-button")
    private WebElement saveButton;

    @FindBy(id = "toast-container")
    private WebElement popUpMessage;


    public void enterFirstName(String firstNameEmployee){
        sendKeysToElement(firstName, firstNameEmployee); }

    public void enterLastName(String lastNameEmployee){
        sendKeysToElement(lastName, lastNameEmployee);
    }

    public void enterEmployeeID(String employeeID){
        sendKeysToElement(employeeIDElement, employeeID);
    }

    public void clickOnPlusButton(){
        clickOnElement(plusButton);
    }

    public void clickOnHumanResources(){ clickOnElement(humanResources); }

    public void clickOnEmployee(){
        clickOnElement(employee);
    }

    public void choseDocumentType(){ clickOnElement(documentType); clickOnElement(subPassport);
    }

    public void enterDocumentNumber(String documentNumberSendKey){
        sendKeysToElement(documentNumber, documentNumberSendKey);
    }

    public void clickOnSaveButton() {
        clickOnElement(saveButton);
    }

    public String getTextPopUpMessage(){
        wait.until(ExpectedConditions.textToBePresentInElement(popUpMessage, "Employee successfully created"));
        popUpMessage.getText();
        return popUpMessage.getText();
    }
}
//    public static By docelement1 =By.cssSelector("mat-option:nth-child(1)");
//    public static By docelement2 =By.cssSelector("mat-option:nth-child(2)");
//    public static By docelement3 =By.cssSelector("mat-option:nth-child(3)");
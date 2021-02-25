package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.Base;
import pages.CreatingEmployee;
import pages.DeletingEmployee;
import pages.UpdateEmployee;
import java.util.Map;

public class TestCreateEmployee extends Base {
    CreatingEmployee creatingEmployee = new CreatingEmployee();
    UpdateEmployee updateEmployee = new UpdateEmployee();
    DeletingEmployee deletingEmployee = new DeletingEmployee();

    @When("I create an Employee with min required info")
    public void iCreateAnEmployeeWithMinRequiredInfo(DataTable table) {
        Map<String, String> map = table.asMap(String.class, String.class);
        creatingEmployee.enterFirstName(map.get("firstName"));
        creatingEmployee.enterLastName(map.get("lastName"));
        creatingEmployee.enterEmployeeID(map.get("employeeID"));
        creatingEmployee.enterDocumentNumber(map.get("DocumentNumber"));
        creatingEmployee.choseDocumentType();
        creatingEmployee.clickOnSaveButton();
    }

    @Then("I see success message created {string}")
    public void iSeeSuccessMessage(String successfulMessage) {
        String actualMessage = creatingEmployee.getTextPopUpMessage();
        Assert.assertEquals(successfulMessage, actualMessage);
    }

    @When("I update first name {string}")
    public void iUpdate(String firstName) {
        updateEmployee.updateFirstName(firstName);
        updateEmployee.clickOnSaveButton();
        updateEmployee.waitPopMessageDisappear();
    }

    @And("I click on save button")
    public void iClickOnSaveButton() {
        updateEmployee.clickOnSaveButton();
    }

    @Given("I am going to Human resource and click on Employees")
    public void iAmGoingToAndClickOn() {
        creatingEmployee.clickOnHumanResources();
        creatingEmployee.clickOnEmployee();
    }

    @And("I click on plus button")
    public void iClickOnPlusButton() {
        creatingEmployee.clickOnPlusButton();
    }

    @And("Find employee I have created {string}")
    public void findEmployeeIHaveCreated(String employeeNameString) {
        updateEmployee.findEmployee(employeeNameString);
    }

    @When("I update last name {string}")
    public void iUpdateLastName(String lastName) {
        updateEmployee.updateLastName(lastName);
        updateEmployee.clickOnSaveButton();
    }

    @When("I update Document Number {string}")
    public void iUpdateDocumentNumber(String documentNumber) {
        updateEmployee.updatedDocumentNumber(documentNumber);
        updateEmployee.clickOnSaveButton();
    }

    @Then("I see success message updated {string}")
    public void iSeeSuccessMessageUpdated(String ExpectedMessage){
        String actualMessage = updateEmployee.getTextPopUpMessageUpdated();
        Assert.assertEquals(ExpectedMessage, actualMessage);
            }


    @And("Find employee I have created and delete it {string}")
    public void findEmployeeIHaveCreatedAndDeleteIt(String arturSec) throws InterruptedException {
        deletingEmployee.deleteEmployeeSecond(arturSec);
    }

    @Then("I see success message deleted {string}")
    public void iSeeSuccessMessageDeleted(String expectedMessage) {
        String actualMessage = deletingEmployee.getTextPopUpMessageDeleted();
        Assert.assertEquals(expectedMessage, actualMessage);
    }
}


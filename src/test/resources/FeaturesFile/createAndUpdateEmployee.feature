Feature: I can create an employee with minimum requirements and check if we can update it

  Background:
    Given I navigate to WebSite "homepage"
    And I login in using username "daulet2030@gmail.com" and login "TechnoStudy123@"


  @scenarioCreate
  Scenario: I can create an employee with the min required info
    Given I am going to Human resource and click on Employees
    And I click on plus button
    When I create an Employee with min required info
      | firstName      | Artur        |
      | lastName       | Ganiev       |
      | employeeID     | NewYorkID313 |
      | DocumentNumber | UFA102       |
    Then I see success message created "Employee successfully created"

  @scenarioUpdate
  Scenario Outline: We can update the employee we have created
    Given I am going to Human resource and click on Employees
    And Find employee I have created "Artur"
    When I update first name "<firstname>"
    When I update last name "<Lastname>"
    When I update Document Number "<DocumentNumber>"
    Then I see success message updated "Employee successfully updated"

    Examples:
      | firstname | Lastname  | DocumentNumber |
      | ArturSec  | GanievSec | UFA 02         |

  @scenarioDelete
  Scenario: I can delete employee I have created
    Given I am going to Human resource and click on Employees
    And Find employee I have created and delete it "ArturSec"
    Then I see success message deleted "Employee successfully deleted"
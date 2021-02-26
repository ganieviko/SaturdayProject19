package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.Base;
import pages.LoginPage;
import utilities.Driver;
import utilities.ReadFromConfigPropertiesFile;

public class Background extends Base {
    LoginPage loginPage = new LoginPage();
    WebDriver driver = Driver.getDriver();

    @Given("I navigate to WebSite {string}")
    public void iNavigateToWebSite(String homepage) {
        driver.get(ReadFromConfigPropertiesFile.getValueFor(homepage));
        driver.manage().window().maximize();

    }

    @And("I login in using username {string} and login {string}")
    public void iLoginInUsingUsernameAndLogin(String username, String password) {
        loginPage.enterPassword(password);
        loginPage.enterUserName(username);
        loginPage.clickOnLoginButton();
    }

}

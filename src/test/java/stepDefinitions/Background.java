package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.Base;
import pages.LoginPage;
import utilities.Driver;

public class Background extends Base {
    LoginPage loginPage = new LoginPage();
    WebDriver driver = Driver.getDriver();

    @Given("I navigate to WebSite {string}")
    public void iNavigateToWebSite(String url) {
        driver.get(url);
        driver.manage().window().maximize();

    }

    @And("I login in using username {string} and login {string}")
    public void iLoginInUsingUsernameAndLogin(String username, String password) {
        loginPage.enterPassword(password);
        loginPage.enterUserName(username);
        loginPage.clickOnLoginButton();
    }

}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base{

    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "input[data-placeholder=\"Username\"]")
    private WebElement userNameElement;

    @FindBy(css = "input[data-placeholder=\"Password\"]")
    private WebElement loginPassword;

    @FindBy(css = "button[aria-label=\"LOGIN\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@role='alertdialog']")
    private WebElement alertDialog;


    public void enterUserName(String username){
        sendKeysToElement(userNameElement, username);
    }

    public void enterPassword(String password){
        sendKeysToElement(loginPassword, password);
    }

    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }
}

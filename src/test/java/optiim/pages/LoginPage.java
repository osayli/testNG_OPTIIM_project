package optiim.pages;

import optiim.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="login-email")
    public WebElement emailBox;

    @FindBy(id="login-password-input")
    public WebElement passwordBox;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement loginButton;
}

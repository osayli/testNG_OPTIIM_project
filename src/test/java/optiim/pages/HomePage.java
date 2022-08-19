package optiim.pages;

import optiim.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

  public HomePage(){
      PageFactory.initElements(Driver.getDriver(),this);
  }

  @FindBy(xpath = "//div[@title='Kapat']")
  public WebElement closePopUp;

  @FindBy(xpath = "//p[text()='Giriş Yap']")

  public WebElement loginBox;






    @FindBy( id = "myAccount")
    public WebElement myAccountBox;

    @FindBy( id = "login")
    public WebElement login;

    @FindBy(xpath = "//input[@id='txtUserName']")
  public WebElement emailBox;

  @FindBy(xpath = "//button[@id='btnLogin']")
  public WebElement girisYap;

  @FindBy(xpath = "//input[@class='desktopOldAutosuggestTheme-input']")
  public WebElement searchBar;



}

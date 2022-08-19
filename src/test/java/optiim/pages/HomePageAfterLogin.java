package optiim.pages;

import optiim.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageAfterLogin {

    public HomePageAfterLogin(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//input[@class='search-box']")
    public WebElement searchBox;
}

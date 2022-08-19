package optiim.pages;

import optiim.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewWindowForSelectedItem {

    public NewWindowForSelectedItem(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = " //h1[@class='pr-new-br']//span")
    public WebElement myFavoriteItem;

    @FindBy(xpath = "//button[@class='fv']//i[contains(@class,'i-heart')]")
    public WebElement HeartButton;
}

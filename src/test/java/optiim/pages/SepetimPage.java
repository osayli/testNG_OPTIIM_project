package optiim.pages;

import optiim.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SepetimPage {

    public SepetimPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//i[@class='i-trash']")
    public WebElement deleteIcon;

    @FindBy(xpath = "//button[text()='Sil']")
    public WebElement deleteButton;
}

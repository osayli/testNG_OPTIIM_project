package optiim.pages;

import optiim.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FavorilerimPage {

    public FavorilerimPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = " //span[@class='prdct-desc-cntnr-name no-white-space']")
    public WebElement favorilerim;

    @FindBy(xpath = "//span[@class='basket-text ']")
    public WebElement addToCart;

    @FindBy(xpath = "//p[text()='Sepetim']")
    public WebElement sepetimButton;
}

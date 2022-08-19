package optiim.pages;

import optiim.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AfterClickCellPhones {

    public AfterClickCellPhones (){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[@class='prdct-desc-cntnr-ttl']")
    public List<WebElement> resultPhones;

  /*  public List<WebElement> getResultPhones(){
        try {
            String title = resultPhones.get(0).getAttribute("title");
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }  catch (StaleElementReferenceException e) {
            resultPhones = Driver.getDriver().findElements(By.xpath("//span[@class='prdct-desc-cntnr-ttl']"));
        }
        return resultPhones;
    }*/

    @FindBy(xpath = "(//div[@class='image-overlay-body'])[5]")
    public WebElement FifthElementInSearch;

    @FindBy(xpath = "//p[text()='Favorilerim']")
    public WebElement myFavorites;
}

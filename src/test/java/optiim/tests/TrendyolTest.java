package optiim.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import optiim.pages.*;
import optiim.utilities.Driver;
import optiim.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class TrendyolTest {

    HomePage homePage=new HomePage();
    LoginPage loginPage=new LoginPage();
    HomePageAfterLogin homePageAfterLogin=new HomePageAfterLogin();
    SearchResultPage searchResultPage=new SearchResultPage();
    AfterClickCellPhones afterClickCellPhones=new AfterClickCellPhones();
    NewWindowForSelectedItem newWindowForSelectedItem=new NewWindowForSelectedItem();
    FavorilerimPage favorilerimPage=new FavorilerimPage();
    SepetimPage sepetimPage=new SepetimPage();
    private static WebDriver driver = Driver.getDriver();

    protected ExtentReports extentReports;
    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentTest extentTest;


    @BeforeClass
    public void setup(){
        //Code about extent report

        //step 1: report path= create the html right under test-output folder
        String currentDate=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path=System.getProperty("user.dir")+"/test-output/report/"+currentDate+"test_report.html";
        //step2: create Html reporter using the path
        extentHtmlReporter =new ExtentHtmlReporter(path);
        //step 3: create extent report
        extentReports=new ExtentReports();
        //optional: Add custom information
        extentReports.setSystemInfo("Environment","Test Environment");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Application","Trendyol");
        extentReports.setSystemInfo("SQA","Osman");

        extentHtmlReporter.config().setDocumentTitle("OPTIIM QA Task");
        extentHtmlReporter.config().setReportName("OPTIIM QA Extent Report");
        //step4: Attach html and extent report
        extentReports.attachReporter(extentHtmlReporter);

        //Report is done . now we need to create test using extentTest object
        extentTest=extentReports.createTest("tRENDYOL Extent Report","This is for Trendyol test report");

        //Done with configuration....
    }


    @Test
    public void test(){
        driver.get("https://www.trendyol.com/");

        String expectedPageTitle="En Trend Ürünler Türkiye'nin Online Alışveriş Sitesi Trendyol'da";
        Assert.assertEquals(driver.getTitle(),expectedPageTitle,"You are not on homepage of Trendyol");
        extentTest.pass("user goes to Trendyol home page");
        homePage.closePopUp.click();

        homePage.loginBox.click();

        loginPage.emailBox.sendKeys("osmansayli@gmail.com");
        loginPage.passwordBox.sendKeys("5236Kalaycilar");
        loginPage.loginButton.click();
        ReusableMethods.waitFor(3);
        extentTest.pass("user successfully logged in  to Trendyol webpage");
        homePageAfterLogin.searchBox.sendKeys("Samsung"+ Keys.ENTER);
        extentTest.info("user search for Samsung in Trendyol arter login");
        ReusableMethods.waitFor(1);
        searchResultPage.divClickforPopUp.click();
        searchResultPage.cellPhones.click();
        extentTest.info("user clicked Cell Phones button to limit search result");
        ReusableMethods.waitFor(3);

        for(WebElement eachResult:afterClickCellPhones.resultPhones) {
            Assert.assertTrue(eachResult.getAttribute("title").equalsIgnoreCase("Samsung"), "Some results do not contain Samsung keyword");
        }
        extentTest.pass("user verified all result include Samsung keyword");

        String currentWindow=driver.getWindowHandle();
        ReusableMethods.waitFor(3);
        afterClickCellPhones.FifthElementInSearch.click();
        extentTest.info("user clicked fifth Cell Phones from search result");
        Set<String> allWindowHandles=driver.getWindowHandles();
        for(String windowHandle:allWindowHandles){
            if(!windowHandle.equals(currentWindow)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        extentTest.info("user navigates to new tab");
        String expectedFavoriteItem=newWindowForSelectedItem.myFavoriteItem.getText();

        if(!(newWindowForSelectedItem.HeartButton.getAttribute("class").equals("i-heart-orange"))) {
            newWindowForSelectedItem.HeartButton.click();
        }
        extentTest.info("user added the item to sepetim");
        currentWindow= driver.getWindowHandle();

        for(String windowHandle:allWindowHandles){
            if(!windowHandle.equals(currentWindow)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        extentTest.info("user navigates to searched items tab");

        afterClickCellPhones.myFavorites.click();
        extentTest.info("user clicked favarilerim");
        Assert.assertTrue(expectedFavoriteItem.contains(favorilerimPage.favorilerim.getText()));
        extentTest.pass("user verified favorilerim include last added item");
        ReusableMethods.waitFor(2);
        favorilerimPage.addToCart.click();
        extentTest.info("user clicked sepete ekle");
        ReusableMethods.waitFor(2);
        favorilerimPage.sepetimButton.click();
        extentTest.info("user navigated to sepetim page");
        sepetimPage.deleteIcon.click();
        sepetimPage.deleteButton.click();
        extentTest.info("user deleted the item from sepetim");





    }

    @AfterClass
    public void tearDown(){
            extentReports.flush();
            driver.quit();
    }
}

package optiim.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class Driver {

    //create a private static WebDriver object
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;
    private static WebDriver driver;
    private Driver() {

    }

//    create getDriver method to create and initiate the driver instance
public static WebDriver getDriver(){
    if(driver==null) {
        switch (ConfigReader.getProperty("browser")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                break;
        }}
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    return driver;
}//getDriver ends here

    //create a closeDriver method to close the driver
    public static void closeDriver(){
        //quit the driver if it is pointing chromedriver, firefoxdriver, edgedriver,....
        if (driver!=null) {
            driver.quit();
            driver=null;
        }
    }
}

package utils.com.frame;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import javax.tools.JavaCompiler;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class DriverConfigurations extends PropertyReader {

    private static WebDriver driver;
    @BeforeSuite
   public void initializeDriver() throws IOException {

        if(getData("Browser").equals("Firefox"))
        {
            System.setProperty("webdriver.gecko.driver","Drivers/geckodriver");
            driver = new FirefoxDriver();
            driver.get(getData("Url"));
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }
        else if(readFile.getProperty("Browser").equals("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver","Drivers/chromedriver");
            driver = new ChromeDriver();
            driver.get(getData("Url"));

        }
        else if(readFile.getProperty("Browser").equals("IE"))
        {
         driver = new InternetExplorerDriver();
        }


    }


    public WebDriver getDriver(){
        return driver;
    }

    @AfterSuite
    public void closeBrowser()
    {
        driver.quit();
    }

    public void waitForPageLoad()
    {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("return document.readyState").equals("complete");
    }
}
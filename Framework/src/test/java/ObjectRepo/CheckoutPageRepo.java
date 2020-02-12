package ObjectRepo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.com.frame.DriverConfigurations;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckoutPageRepo extends DriverConfigurations {
    private WebDriver browserDrivers;


    @FindBy(how = How.XPATH,using = "//form[@id='payment-form']//div[@class='card-info-box']//input[@type='text' and @name='cardname']")
    public WebElement cardName;

    @FindBy(how = How.XPATH,using = "//form[@id='payment-form']//div[@class='card-info-box']//input[@type='tel' and @name ='cardno']")
    public WebElement cardNumber;

    @FindBy(how = How.XPATH,using = "//form[@id='payment-form']//div[@class='card-info-box']//input[@type='tel' and @name ='expmonth']")
    public WebElement monthDetails;

    @FindBy(how = How.XPATH,using = "//form[@id='payment-form']//div[@class='card-info-box']//input[@type='tel' and @name ='expyear']")
    public WebElement yearDetails;

    @FindBy(how = How.XPATH,using = "//form[@id='payment-form']//div[@class='card-info-box']//input[@type='password' and @name ='cvvno']")
    public WebElement cvvDetails;

    @FindBy(how = How.XPATH,using = "//form[@role='form']//input[@type='email' and @name ='txtEmail']")
    public WebElement emailId;

    @FindBy(how = How.XPATH,using = "//form[@role='form']//div[@class='row']//button[@id='paylimit' and @type='button']")
    public WebElement rechargeButton;

    @FindBy(how = How.XPATH,using = "//div[@class='modal-dialog']//div[@class='modal-header' and contains(@style,'border-bottom:')]//button[@type='button' and @class='close' and@data-dismiss='modal']")
    public WebElement modalWindow;

    public CheckoutPageRepo(WebDriver driver)
    {

        browserDrivers=driver;

        PageFactory.initElements(browserDrivers,this);
    }
    public void cardName_Details()
    {

        cardName.sendKeys(getData("UserName"));
    }

    public void cardName_Click()
    {
        cardName.click();
    }

    public void cardNumber_Click()
    {
        cardNumber.click();
    }

    public void cardNumber_Details()
    {
        cardNumber.click();
        cardNumber.sendKeys(getData("CardNumber"));
    }

    public void month_Details()
    {
        monthDetails.click();
        monthDetails.sendKeys(getData("monthDetails"));
    }

    public void year_Details()
    {
        yearDetails.click();
        yearDetails.sendKeys(getData("yearDetails"));
    }

    public void cvv_Details()
    {
        cvvDetails.click();
        cvvDetails.sendKeys(getData("cvvDetails"));
    }

    public void emailId_Details()
    {
        emailId.click();
        emailId.sendKeys(getData("emailId"));
    }

    public void acceptButton()
    {
        rechargeButton.click();
    }

    public void elementInteract_CardName()
    {
        WebDriverWait wait = new WebDriverWait(browserDrivers,40);
        wait.until(ExpectedConditions.elementToBeClickable(cardName));
    }

    public void rechargeButtonClick()
    {
        rechargeButton.click();
    }

    public void waitforElementVisible()
    {

        WebDriverWait wait = new WebDriverWait(browserDrivers,40);
        wait.until(ExpectedConditions.visibilityOf(modalWindow));
    }

    public void modalWindow() {
     modalWindow.click();
    }
}

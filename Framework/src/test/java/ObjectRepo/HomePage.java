package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.com.frame.DriverConfigurations;

import java.io.IOException;
import java.util.List;

public class HomePage extends DriverConfigurations {

    private WebDriver browserDrivers;

    @FindBy(how = How.XPATH,using = "//input[@type='tel']")
    public WebElement mobileNumber;

    @FindBy(how = How.XPATH,using = "//input[@type='text' and @name ='operator']")
    public WebElement telecomOperator;

    @FindBy(how = How.XPATH,using = "//input[@type='text' and @name ='amount']")
    public WebElement purchaseAmountTabClick;

    @FindBy(how = How.XPATH,using = "//div[@class='suggestion']//li")
    public List<WebElement> operatorList;

    @FindBy(how = How.XPATH,using = "//div[@class='desc-info' and contains(text(),'Recarga $10')]")
    public WebElement rechargeAmount;

    @FindBy(how = How.XPATH,using = "//button[@perform='payment' and contains(text(),'Siguiente')]")
    public WebElement submitButton;

    public HomePage(WebDriver driver)
    {
        browserDrivers=driver;
        PageFactory.initElements(browserDrivers,this);
    }

    public void sendKeys_MobileNumber() throws IOException {
        mobileNumber.click();
       mobileNumber.sendKeys(getData("MobileNumber"));
    }


    public void clickOperatorTab()
    {
        telecomOperator.click();
    }

    public void selectedOperator()
    {
        List<WebElement> listOfOperators = operatorList;
        for(WebElement operator : listOfOperators)
        {

            if(operator.getText().equals(getData("Operator")))
            {
                operator.click();
                break;
            }
        }



    }

    public void purchaseAmount()
    {
        purchaseAmountTabClick.click();
    }

    public void selectedRechargeAmount()
    {
        rechargeAmount.click();
    }
    public void paymentButton()
    {
        JavascriptExecutor jse = (JavascriptExecutor) browserDrivers;
        jse.executeScript("arguments[0].click();", submitButton);

    }
}

package com.testcases;


import ObjectRepo.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.com.frame.DriverConfigurations;

import java.io.IOException;

public class Payment extends DriverConfigurations {
    HomePage homePage;

    @BeforeMethod
   public void driver()
   {
       homePage  = new HomePage(getDriver());
       
   }

    @Test(priority = 1)
    public void homePage_operatorSelection() throws IOException {
        waitForPageLoad();

        homePage.clickOperatorTab();
        homePage.selectedOperator();
    }


    @Test(priority = 2)
    public void homePage_mobileNumber() throws IOException {

        homePage.sendKeys_MobileNumber();
    }

    @Test(priority = 3)
    public void homePage_rechargeAmount() throws IOException {

        homePage.purchaseAmount();
        homePage.selectedRechargeAmount();
    }

    @Test(priority = 4)
    public void homePage_SubmitButton() throws IOException {
        homePage.paymentButton();
    }
}

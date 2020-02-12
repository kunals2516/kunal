package com.testcases;

import ObjectRepo.CheckoutPageRepo;
import ObjectRepo.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.com.frame.DriverConfigurations;

import java.io.IOException;

public class CheckoutPage extends DriverConfigurations  {
    CheckoutPageRepo checkoutPage;
    HomePage homePage;


    @BeforeMethod
    public void driver() {
        checkoutPage = new CheckoutPageRepo(getDriver());
        homePage = new HomePage(getDriver());

    }

    @Test(priority = 1)
    public void checkoutPage_cardName() throws IOException, InterruptedException {

        homePage.waitForPageLoad();
        checkoutPage.elementInteract_CardName();
        checkoutPage.cardName_Click();
        checkoutPage.cardName_Details();
    }


    @Test(priority = 2)
    public void checkoutPage_cardNumber() throws IOException {

        checkoutPage.cardNumber_Click();
        checkoutPage.cardNumber_Details();
    }

    @Test(priority = 3)
    public void checkoutPage_month() throws IOException {


        checkoutPage.month_Details();
    }

    @Test(priority = 4)
    public void checkoutPage_year() throws IOException {

        checkoutPage.year_Details();
    }

    @Test(priority = 5)
    public void checkoutPage_cvv() throws IOException {

        checkoutPage.cvv_Details();
    }

    @Test(priority = 6)
    public void checkoutPage_emailId() throws IOException {

        checkoutPage.emailId_Details();
    }

    @Test(priority = 7)
    public void checkoutPage_AcceptButton() throws IOException {
        checkoutPage.rechargeButtonClick();
    }

    @Test(priority = 8)
    public void checkoutPage_closeModalWindow() throws IOException {
        checkoutPage.waitforElementVisible();
       checkoutPage.modalWindow();
    }
}


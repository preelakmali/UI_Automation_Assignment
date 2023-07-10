package com.test.sauceDemo.testCases;

import data.UserData;
import io.qameta.allure.Description;
import org.junit.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import webdriverinit.WebDriverInit;


public class BuyProductTests extends WebDriverInit {

    private LoginPage loginPage;
    private HomePage homePage;
    private Cart cart;
    private Checkout checkout;
    private Overview overview;
    private Finish finish;

    @BeforeClass
    public void setup() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cart = new Cart(driver);
        checkout = new Checkout(driver);
        overview = new Overview(driver);
        finish = new Finish(driver);
    }

    @Test
    @Description(value = " checks possibility to login with correct data and make successful purchase.")
    public void buyProduct() {
    loginPage.login(UserData.userNameLogin, UserData.userPassword);
    Assert.assertTrue(homePage.getVisibleCartButton().isDisplayed());
    homePage.addSeveralItemsToCart();
    homePage.clickCartButton();
    cart.clickCheckoutButton();
    checkout.fillFields(UserData.firstName, UserData.lastName, UserData.zipCode);
    checkout.clickContinueButton();
    Assert.assertEquals(3, cart.listOfItems());
    Assert.assertEquals(overview.textOfPaymentInfoElement(), "Payment Information");
    Assert.assertEquals(overview.textOfShippingInfoElement(), "Shipping Information");
    Assert.assertTrue("Price Total is not displayed",overview.isDisplayedPriceTotal());
    Assert.assertTrue("Item Total is not displayed",overview.isDisplayedItemTotalElement());
    Assert.assertEquals(overview.getItemTotal().split(":")[1].trim(),"$55.97");
    Assert.assertTrue("Tax is not displayed",overview.isDisplayedtaxElement());
    Assert.assertEquals(overview.gettaxElement().split(":")[1].trim(),"$4.48");
    Assert.assertTrue("Total amount is not displayed",overview.isDisplayedtotalAmountElement());
    Assert.assertEquals(overview.getTotalAmountElement().split(":")[1].trim(),"$60.45");
    overview.clickFinishButton();
    Assert.assertEquals("Thank you for your order!", finish.getGratitudeNotification());
  }

}
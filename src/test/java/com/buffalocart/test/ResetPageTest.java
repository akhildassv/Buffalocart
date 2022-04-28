package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.LogInPage;
import com.buffalocart.pages.MyAccountPage;
import com.buffalocart.pages.ResetPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ResetPageTest extends Base {
    LogInPage login;
    MyAccountPage account;
    ResetPage reset;
    ExcelUtility excel=new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 5,enabled = true,groups = {"Regression","Sanity"},description = "TC_005_Verify error meesage displyed on  Reset Password page with invalid email id")
    public void Verify_error_meesage_displyed_on_Reset_Password_page_with_invalid_email_id()  {
        extentTest.get().assignCategory("Regression");
        extentTest.get().assignCategory("Sanity");
        login = new LogInPage(driver);
        reset=login.clickOnForgetPassword();
        extentTest.get().log(Status.PASS, "Clicked Forget Password Button successfully");
        List<String> resetData =excel.readDataFromExcel("ResetPage");
        reset.enterMailID(resetData.get(1));
        extentTest.get().log(Status.PASS, "Invalid Mail ID Entered successfully");
        reset.clickOnResetLinkButton();
        extentTest.get().log(Status.PASS, "Clicked on Send_Password_ResetLink Button successfully");
        String expectedErrorMessage="We can't find a user with that e-mail address.";
        String actualErrorMessage=reset.getErrorMessageInReset();
        extentTest.get().log(Status.PASS, "Got Error messeg successfully");
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Cannot able to click on Remember Me Button");
        extentTest.get().log(Status.PASS, "User can not able to reset password");
    }
}

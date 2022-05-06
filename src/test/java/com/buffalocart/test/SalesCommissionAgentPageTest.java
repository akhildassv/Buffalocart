package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.*;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SalesCommissionAgentPageTest extends Base {

    LogInPage login;
    MyAccountPage account;
    SalesCommissionAgentPage salescommision;
    RolesPage role;
    AddRolesPage addrole;
    UsersPage user;
    AddUserPage adduser;

    ExcelUtility excel=new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 28,enabled = true,description = "TC_028_Verify_Sales_Commission_Agents_page_Title",groups = {"Regression"})
    public void Verify_Sales_Commission_Agents_page_Title () {
        extentTest.get().assignCategory("Regression");
        login = new LogInPage(driver);
        List<String> data = excel.readDataFromExcel("LoginPage");
        login.enterUserName(data.get(3));
        extentTest.get().log(Status.PASS, "User name enetred successfully");
        login.enterPassword(data.get(4));
        extentTest.get().log(Status.PASS, "Password enetred successfully");
        login.clickOnRememberMeCheckbox();
        extentTest.get().log(Status.PASS, "Clicked Remember_Me Button successfully");
        account = login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        account.clickOnEndTourButton();
        extentTest.get().log(Status.PASS, "clicked on End_Tour button successfully");
        account.clickOnUserManagementbutton();
        extentTest.get().log(Status.PASS, "clicked on UserManagement button successfully");
        salescommision=account.clickOnSalesCommissionSubMenuButton();
        String actualSaleCommissionPageTitle=salescommision.getSalesCommissionPageTitle();
        extentTest.get().log(Status.PASS, "Page Title Received successfully");
        String expectedSaleCommissionPageTitle="Sales Commission Agents - Llolll";
        Assert.assertEquals(actualSaleCommissionPageTitle,expectedSaleCommissionPageTitle,"Invalid title");
        extentTest.get().log(Status.PASS, "Expected title is mached with actual SalesCommission page title");



    }


}

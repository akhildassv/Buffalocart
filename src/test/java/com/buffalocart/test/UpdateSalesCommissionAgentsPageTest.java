package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.*;
import com.buffalocart.utilities.ExcelUtility;
import com.buffalocart.utilities.RandomDataUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class UpdateSalesCommissionAgentsPageTest extends Base {
    LogInPage login;
    MyAccountPage account;
    SalesCommissionAgentPage salescommision;
    AddSalesCommissionAgentPage addsales;
    UpdateSalesCommissionAgentsPage updatesales;
    ExcelUtility excel=new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 30,enabled = true,description = "TC_030_Verify_Edit_Sales_Agent_Details",groups = {"Regression"})
    public void Verify_Edit_Sales_Agent_Details() {
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
        salescommision.enterSearchBox("Akhil");
        updatesales=salescommision.clickOnEditSalesAgentButton();
        updatesales.enterSalesPercent("90");
        salescommision=updatesales.clickOnSaveButton();
        extentTest.get().log(Status.PASS, "clicked on SAVE button successfully");
        String actualRolesAddedMessage=salescommision.getNewAgentAddedSccessMessage();
        extentTest.get().log(Status.PASS, "Add sales commission agent success message Received successfully");
        String expectedRolesAddedMessage="Commission agent updated successfully";
        Assert.assertEquals(actualRolesAddedMessage,expectedRolesAddedMessage,"New Agent not Added");
        extentTest.get().log(Status.PASS, "Sales Agent Add success message mach with expected result");
    }

    @Test(priority = 31,enabled = true,description = "TC_031_Verify_User_Can_Delete_a_Sales_Commission_Agents",groups = {"Regression"})
    public void Verify_User_Can_Delete_a_Sales_Commission_Agents() {
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
        extentTest.get().log(Status.PASS, "clicked on SalesCommissionAgents SubMenuButton button successfully");
        addsales=salescommision.clickOnAddSalesCommissionAgentButton();
        extentTest.get().log(Status.PASS, "clicked on Add SalesCommissionAgents button successfully");
        addsales.enterFirstName("Akhil");
        extentTest.get().log(Status.PASS, "entered First Name successfully");
        RandomDataUtility random=new RandomDataUtility();
        String email=random.getRandomMail();
        addsales.enterEmailId(email);
        extentTest.get().log(Status.PASS, "entered Email ID successfully");
        addsales.entersalesCommissionPercent("80");
        extentTest.get().log(Status.PASS, "entered sales Commission Percent successfully");
        salescommision=addsales.clickOnSaveButton();
        extentTest.get().log(Status.PASS, "clicked on SAVE button successfully");
        System.out.println(salescommision.getSalesCommissionPageTitle());
        salescommision.enterSearchBox("Akhil");
        updatesales=salescommision.clickOnDeleteSalesAgentButton();
        extentTest.get().log(Status.PASS, "clicked on Delete button successfully");
        salescommision=updatesales.clickOnDeleteOkButton();
        String actualRolesAddedMessage=salescommision.getNewAgentAddedSccessMessage();
        extentTest.get().log(Status.PASS, "Add sales commission agent success message Received successfully");
        String expectedRolesAddedMessage="Commission agent updated successfully";
        Assert.assertEquals(actualRolesAddedMessage,expectedRolesAddedMessage,"New Agent not Added");
        extentTest.get().log(Status.PASS, "Sales Agent Add success message mach with expected result");

    }



}

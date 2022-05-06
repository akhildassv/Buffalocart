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

public class AddSalesCommissionAgentPageTest extends Base {

    LogInPage login;
    MyAccountPage account;
    SalesCommissionAgentPage salescommision;
    AddSalesCommissionAgentPage addsales;


    ExcelUtility excel=new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 29,enabled = true,description = "TC_029_Verify_User_can_Add_Sales_Agent",groups = {"Regression"})
    public void Verify_User_can_Add_Sales_Agent() {
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
        String actualRolesAddedMessage=salescommision.getNewAgentAddedSccessMessage();
        extentTest.get().log(Status.PASS, "Add sales commission agent success message Received successfully");
        String expectedRolesAddedMessage="Commission agent added successfully";
        Assert.assertEquals(actualRolesAddedMessage,expectedRolesAddedMessage,"New Agent not Added");
        extentTest.get().log(Status.PASS, "Sales Agent Add success message mach with expected result");



    }

}

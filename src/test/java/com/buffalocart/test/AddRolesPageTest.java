package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.AddRolesPage;
import com.buffalocart.pages.LogInPage;
import com.buffalocart.pages.MyAccountPage;
import com.buffalocart.pages.RolesPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddRolesPageTest extends Base {

    LogInPage login;
    MyAccountPage account;
    RolesPage role;
    AddRolesPage addrole;

    ExcelUtility excel=new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();


    @Test(priority = 22,enabled = true,description = "TC_019_Verify_Add_Roles_Page_Title",groups = {"Regression"})
    public void Verify_Add_Roles_Page_Title  () {
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
        role=account.clickOnRolesSubMenuButton();
        extentTest.get().log(Status.PASS, "clicked on Roles sub-button successfully");
        addrole=role.clickOnAddRolesButton();
        String actualRolesPageTitle=addrole.getAddRolesPageTitle();
        extentTest.get().log(Status.PASS, "Add Roles Page title received successfully");
        String expectedRolesPageTitle="Add Role - Llolll";
        Assert.assertEquals(actualRolesPageTitle,expectedRolesPageTitle,"Invalid Page Title");
        extentTest.get().log(Status.PASS, "Roles Page title Matches with expected title");
    }

    @Test(priority = 23,enabled = true,description = "TC_019_Verify_User_can_Add_Roles",groups = {"Regression"})
    public void Verify_User_can_Add_Roles() {
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
        role=account.clickOnRolesSubMenuButton();
        extentTest.get().log(Status.PASS, "clicked on Roles sub-button successfully");
        addrole=role.clickOnAddRolesButton();
        extentTest.get().log(Status.PASS, "clicked on Add-Roles button successfully");
        addrole.enterRoleName("QA -Engg1");
        extentTest.get().log(Status.PASS, "entered role name successfully");
        addrole.selectUserCheckbox();
        extentTest.get().log(Status.PASS, "selected user check box successfully");
        addrole.selectRolesCheckbox();
        extentTest.get().log(Status.PASS, "selected roles check box successfully");
        role=addrole.clickOnSaveButton();
        extentTest.get().log(Status.PASS, "clicked on SAVE button successfully");
        String actualRolesAddedMessage=role.getRoleAddedSccessMessage();
        extentTest.get().log(Status.PASS, "Add Roles Page title received successfully");
        String expectedRolesAddedMessage="Role added successfully";
        Assert.assertEquals(actualRolesAddedMessage,expectedRolesAddedMessage,"New roles not Added");
        extentTest.get().log(Status.PASS, "Roles Add success message mach with expected result");
    }

}

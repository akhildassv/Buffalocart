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

public class DeleteRolePageTest extends Base {
    LogInPage login;
    MyAccountPage account;
    RolesPage role;
    AddRolesPage addrole;
    DeleteRolePage deleterole;


    ExcelUtility excel=new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();
    @Test(priority = 26,enabled = true,description = "TC_026_Verify_User_Can_Delete_a_role_From_the_List",groups = {"Regression"})
    public void Verify_User_Can_Delete_a_role_From_the_List () {
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
        addrole.enterRoleName("QA -Engg5");
        extentTest.get().log(Status.PASS, "entered role name successfully");
        addrole.selectUserCheckbox();
        extentTest.get().log(Status.PASS, "selected user check box successfully");
        addrole.selectRolesCheckbox();
        extentTest.get().log(Status.PASS, "selected roles check box successfully");
        role=addrole.clickOnSaveButton();
        role.enterRoleNameforSearch("QA -Engg5");
        deleterole=role.clickOnDeleteRolesButton();
        role=deleterole.clickOnOkDeleteButton();
        extentTest.get().log(Status.PASS, "clicked on SAVE button successfully");
        String actualRolesAddedMessage=role.getRoleDeletedSccessMessage();
        extentTest.get().log(Status.PASS, "Role updated Message Received successfully");
        String expectedRolesAddedMessage="Role deleted successfully";
        Assert.assertEquals(actualRolesAddedMessage,expectedRolesAddedMessage,"Role not updated");
        extentTest.get().log(Status.PASS, "Role update success message mach with expected result");
    }



}

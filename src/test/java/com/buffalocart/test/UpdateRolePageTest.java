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

public class UpdateRolePageTest extends Base {
    LogInPage login;
    MyAccountPage account;
    RolesPage role;
    AddRolesPage addrole;
    UpdateRolePage updaterole;

    ExcelUtility excel=new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 24,enabled = true,description = "TC_024_Verify_Edit_Role_Page_Title",groups = {"Regression"})
    public void Verify_Edit_Role_Page_Title() {
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
        updaterole=role.clickOnEditRolesButton();
        extentTest.get().log(Status.PASS, "clicked on EDIT button successfully");
        String actualEditRolePageTitle=updaterole.getEditRolePageTitle();
        extentTest.get().log(Status.PASS, "EDIT Roles Page title received successfully");
        String expectedEditRolePageTitle="Edit Role - Llolll";
        Assert.assertEquals(actualEditRolePageTitle,expectedEditRolePageTitle,"Invalid Page Title");
        extentTest.get().log(Status.PASS, "Edit Roles Page Title mach with expected result");
    }

    @Test(priority = 25,enabled = true,description = "TC_025_Verify_User_Can_Update_a_Role",groups = {"Regression"})
    public void Verify_User_Can_Update_a_Role () {
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
        addrole.enterRoleName("QA -Engg6");
        extentTest.get().log(Status.PASS, "entered role name successfully");
        addrole.selectUserCheckbox();
        extentTest.get().log(Status.PASS, "selected user check box successfully");
        addrole.selectRolesCheckbox();
        extentTest.get().log(Status.PASS, "selected roles check box successfully");
        role=addrole.clickOnSaveButton();
        role.enterRoleNameforSearch("QA -Engg6");
        updaterole=role.clickOnEditRolesButton();
        updaterole.clickOnSupplierCheckBox();
        updaterole.clickOnCustomerCheckBox();
        role=updaterole.clickOnSaveButton();
        extentTest.get().log(Status.PASS, "clicked on SAVE button successfully");
        String actualRolesAddedMessage=role.getRoleAddedSccessMessage();
        extentTest.get().log(Status.PASS, "Role updated Message Received successfully");
        String expectedRolesAddedMessage="Role updated successfully";
        Assert.assertEquals(actualRolesAddedMessage,expectedRolesAddedMessage,"Role not updated");
        extentTest.get().log(Status.PASS, "Role update success message mach with expected result");
    }
}

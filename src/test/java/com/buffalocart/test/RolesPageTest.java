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

public class RolesPageTest extends Base {
    LogInPage login;
    MyAccountPage account;
    RolesPage role;
    AddRolesPage addrole;
    UsersPage user;
    AddUserPage adduser;

    ExcelUtility excel=new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();


    @Test(priority = 21,enabled = true,description = "TC_019_Verify_Roles_Page_Title",groups = {"Regression"})
    public void Verify_Roles_Page_Title  () {
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
        String actualRolesPageTitle=role.getRolesPageTitle();
        extentTest.get().log(Status.PASS, "Roles Page title received successfully");
        String expectedRolesPageTitle="Roles - Llolll";
        Assert.assertEquals(actualRolesPageTitle,expectedRolesPageTitle,"Invalid Page Title");
        extentTest.get().log(Status.PASS, "Roles Page title Matches with expected title");


    }

    @Test(priority = 27,enabled = true,description = "TC_027_Verify_Whether_the_added_role_in_Role_Page_is_Listed_in_Roles_Field_in_user_add_page",groups = {"Regression"})
    public void Verify_Whether_the_added_role_in_Role_Page_is_Listed_in_Roles_Field_in_user_add_page () {
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
        role = account.clickOnRolesSubMenuButton();
        extentTest.get().log(Status.PASS, "clicked on Roles sub-button successfully");
        addrole = role.clickOnAddRolesButton();
        extentTest.get().log(Status.PASS, "clicked on Add-Roles button successfully");
        String roleName="QA--Engineer";
        addrole.enterRoleName(roleName);
        extentTest.get().log(Status.PASS, "entered role name successfully");
        addrole.selectUserCheckbox();
        extentTest.get().log(Status.PASS, "selected user check box successfully");
        addrole.selectRolesCheckbox();
        extentTest.get().log(Status.PASS, "selected roles check box successfully");
        role = addrole.clickOnSaveButton();
        user=role.clickOnUsersSubMenuButton();
        adduser=user.clickOnAddUserButton();
        boolean actualDropdownResult=adduser.getRolesListCheckResult(roleName);
        Assert.assertTrue(actualDropdownResult,"Drop down doesnot contains Added Role");
    }

}

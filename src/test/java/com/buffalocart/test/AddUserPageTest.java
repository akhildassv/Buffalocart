package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.AddUserPage;
import com.buffalocart.pages.LogInPage;
import com.buffalocart.pages.MyAccountPage;
import com.buffalocart.pages.UsersPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddUserPageTest extends Base {

    LogInPage login;
    MyAccountPage account;
    UsersPage users;
    AddUserPage adduser;
    ExcelUtility excel=new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 13,enabled = true,description = "TC_013_Verify_the_error_message_displayed_without_filling_mandatory_fields_in_add_user_form",groups = {"Regression"})
    public void Verify_the_error_message_displayed_without_filling_mandatory_fields_in_add_user_form()  {
        extentTest.get().assignCategory("Regression");
        login = new LogInPage(driver);
        List<String> data =excel.readDataFromExcel("LoginPage");
        login.enterUserName(data.get(3));
        extentTest.get().log(Status.PASS, "User name enetred successfully");
        login.enterPassword(data.get(4));
        extentTest.get().log(Status.PASS, "Password enetred successfully");
        login.clickOnRememberMeCheckbox();
        extentTest.get().log(Status.PASS, "Clicked Remember_Me Button successfully");
        account=login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        account.clickOnEndTourButton();
        extentTest.get().log(Status.PASS, "clicked on End_Tour button successfully");
        account.clickOnUserManagementbutton();
        extentTest.get().log(Status.PASS, "clicked on UserManagement button successfully");
        users=account.clickOnUsersSubMenuButton();
        extentTest.get().log(Status.PASS, "users page Opened successfully");
        adduser=users.clickOnAddUserButton();
        extentTest.get().log(Status.PASS, "Add user page Opened successfully");
        adduser.enterEmail("sv.akhildas@gmai.com");
        extentTest.get().log(Status.PASS, "EmailId Entered successfully");
        adduser.enterPassword("123456");
        extentTest.get().log(Status.PASS, "Password Entered successfully");
        adduser.enterConfirmPassword("123456");
        extentTest.get().log(Status.PASS, "Confirm Password Entered successfully");
        adduser.clickOnSaveButton();
        extentTest.get().log(Status.PASS, "Clicked on Save Button successfully");
        String actualErrorMessage=adduser.getFirstnameErrorMessage();
        extentTest.get().log(Status.PASS, "Field Required message received successfully");
        String expectedErrorMessage="This field is required.";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Invalid message display");
        extentTest.get().log(Status.PASS, "Invalid Search result message matching with expected message");
    }

    @Test(priority = 15,enabled = true,description = "TC_015_Verify_Add_Users_page_title",groups = {"Regression"})
    public void Verify_Add_Users_page_title()  {
        extentTest.get().assignCategory("Regression");
        login = new LogInPage(driver);
        List<String> data =excel.readDataFromExcel("LoginPage");
        login.enterUserName(data.get(3));
        extentTest.get().log(Status.PASS, "User name enetred successfully");
        login.enterPassword(data.get(4));
        extentTest.get().log(Status.PASS, "Password enetred successfully");
        login.clickOnRememberMeCheckbox();
        extentTest.get().log(Status.PASS, "Clicked Remember_Me Button successfully");
        account=login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        account.clickOnEndTourButton();
        extentTest.get().log(Status.PASS, "clicked on End_Tour button successfully");
        account.clickOnUserManagementbutton();
        extentTest.get().log(Status.PASS, "clicked on UserManagement button successfully");
        users=account.clickOnUsersSubMenuButton();
        extentTest.get().log(Status.PASS, "users page Opened successfully");
        adduser=users.clickOnAddUserButton();
        extentTest.get().log(Status.PASS, "Add_user page Opened successfully");
        String actualAddUserPageTitle=adduser.getAddUserPageTitle();
        extentTest.get().log(Status.PASS, "page title  received successfully");
        String expectedAddUserPageTitle="Add user - Llolll";
        Assert.assertEquals(actualAddUserPageTitle,expectedAddUserPageTitle,"Invalid Page title");
        extentTest.get().log(Status.PASS, "actual and Expected Add User page titles are matching");
    }

}

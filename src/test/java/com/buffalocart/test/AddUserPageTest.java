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

public class AddUserPageTest extends Base {

    LogInPage login;
    MyAccountPage account;
    UsersPage users;
    AddUserPage adduser;
    MyProfilePage profile;
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

    @Test(priority = 14,enabled = true,description = "TC_014_Verify_user_login_with_Newly_Added_User",groups = {"Regression"})
    public void Verify_user_login_with_Newly_Added_User()  {
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
        adduser.enterFirstName("Albert");
        RandomDataUtility random=new RandomDataUtility();
        String email=random.getRandomMail();
        adduser.enterEmail(email);
        adduser.enterUserName(email);
        extentTest.get().log(Status.PASS, "EmailId Entered successfully");
        adduser.enterPassword("123456");
        extentTest.get().log(Status.PASS, "Password Entered successfully");
        adduser.enterConfirmPassword("123456");
        extentTest.get().log(Status.PASS, "Confirm Password Entered successfully");
        users=adduser.clickOnSubmitButton();
        extentTest.get().log(Status.PASS, "Clicked on Save Button successfully");
/**Needs to add wait.**/
        users.clickOnUserProfilebutton();
        login=users.clickOnSignOutButton();
        login.enterUserName(email);
        extentTest.get().log(Status.PASS, "User name enetred successfully");
        login.enterPassword("123456");
        extentTest.get().log(Status.PASS, "Password enetred successfully");
        login.clickOnRememberMeCheckbox();
        extentTest.get().log(Status.PASS, "Clicked Remember_Me Button successfully");
        account=login.clickOnLoginButton();
        extentTest.get().log(Status.PASS, "clicked on login button successfully");
        String actualUserName=account.getUserName();
        extentTest.get().log(Status.PASS, "User Account Name received successfully");
        String expectedUserName="Albert";
        Assert.assertEquals(actualUserName,expectedUserName,"Invalid userName  display");
        extentTest.get().log(Status.PASS, "Login data matching with expected message");
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

    @Test(priority = 16,enabled = true,description = "TC_016_Verify_User_can_Add_User_Details",groups = {"Regression","Smoke"})
    public void Verify_User_can_Add_User_Details()  {
        extentTest.get().assignCategory("Regression");
        extentTest.get().assignCategory("Smoke");
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
        account.clickOnUserProfilebutton();
        extentTest.get().log(Status.PASS, "clicked User Profile button successfully");
        profile=account.clickOnProfilebutton();
        extentTest.get().log(Status.PASS, "clicked on Profile button successfully");
        profile.enterSureName("Sir");
        profile.clickOnUpdateButton();
        extentTest.get().log(Status.PASS, "clicked Update button successfully");
        String actualUpdatemessage=profile.getupdatedMessage();
        extentTest.get().log(Status.PASS, "Received Success message successfully");
        String expectedUpdatemessage="Profile updated successfully";
        Assert.assertEquals(actualUpdatemessage,expectedUpdatemessage,"Profile not updated");
        extentTest.get().log(Status.PASS, "Profile Updated Successfully");
    }



}

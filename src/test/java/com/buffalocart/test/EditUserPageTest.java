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

public class EditUserPageTest extends Base {

    LogInPage login;
    MyAccountPage account;
    UsersPage users;
    AddUserPage adduser;
    MyProfilePage profile;
    EditUserPage edit;
    DeleteUserPage delete;
    ExcelUtility excel=new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 17,enabled = true,description = "TC_017_Verify_Edit_User_page_Title",groups = {"Regression"})
    public void Verify_Edit_User_page_Title  () {
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
        users = account.clickOnUsersSubMenuButton();
        extentTest.get().log(Status.PASS, "users page Opened successfully");
        users.enterTextInSearchBox("Akhildas");
        edit=users.clickOnAkhilEditButton();
        String actualEditPageTitle= edit.getEditPageTitle();
        extentTest.get().log(Status.PASS, "Received Page Title successfully");
        String expectedEditPageTitle="Edit user - Llolll";
        Assert.assertEquals(actualEditPageTitle,expectedEditPageTitle,"Profile not updated");
        extentTest.get().log(Status.PASS, "Edit Page Title Verified Successfully");
    }


    @Test(priority = 18,enabled = true,description = "TC_018_Verify_User_can_Edit_the_user_Details",groups = {"Regression"})
    public void Verify_User_can_Edit_the_user_Details  () {
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
        users = account.clickOnUsersSubMenuButton();
        extentTest.get().log(Status.PASS, "users page Opened successfully");
        users.enterTextInSearchBox("Akhildas");
        edit=users.clickOnAkhilEditButton();
        edit.enterSalesCommissionValue("88");
        edit.clickOnEditUpdateButton();
        String actualUpdatemessage=edit.getEditUpdatedMessage();
        extentTest.get().log(Status.PASS, "Received Success message successfully");
        String expectedUpdatemessage="User updated successfully";
        Assert.assertEquals(actualUpdatemessage,expectedUpdatemessage,"Profile not updated");
        extentTest.get().log(Status.PASS, "Profile Updated Successfully");
    }

    @Test(priority = 19,enabled = true,description = "TC_019_Verify_User_Can_Delete_a_User",groups = {"Regression"})
    public void Verify_User_Can_Delete_a_User  () {
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
        users = account.clickOnUsersSubMenuButton();
        extentTest.get().log(Status.PASS, "users page Opened successfully");
        users.enterTextInSearchBox("Albert");
        delete=users.clickOnAlbertDeleteButton();
        delete.clickOnDeleteOKButton();
        String actualDeleteSuccessMessage= delete.getDeleteSuccessMessage();
        extentTest.get().log(Status.PASS, "Received Page Title successfully");
        String expectedDeleteSuccessMessage="User deleted successfully";
        Assert.assertEquals(actualDeleteSuccessMessage,expectedDeleteSuccessMessage,"Profile not Deleted");
        extentTest.get().log(Status.PASS, "User profile deleted Successfully");
    }
}

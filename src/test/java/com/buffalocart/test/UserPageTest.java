package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.constants.Constants;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.LogInPage;
import com.buffalocart.pages.MyAccountPage;
import com.buffalocart.pages.ResetPage;
import com.buffalocart.pages.UsersPage;
import com.buffalocart.utilities.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class UserPageTest extends Base {
    LogInPage login;
    MyAccountPage account;
    UsersPage users;
    ExcelUtility excel=new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 10,enabled = true,description = "TC_0010_verify_Users_Page_Title",groups = {"Regression"})
    public void verify_Users_Page_Title ()  {
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
        String actualUsersPageTitle=users.getUsersPageTitle();
        extentTest.get().log(Status.PASS, "users page Title received successfully");
        String expectedUsersPageTitle="Users - Llolll";
        Assert.assertEquals(actualUsersPageTitle,expectedUsersPageTitle,"Invalid Page Tile");
        extentTest.get().log(Status.PASS, "Expected title is mached with actual Users page title");
    }

    @Test(priority = 11,enabled = true,description = "TC_011_Verify_User_Search_With_Valid_Data",groups = {"Regression"})
    public void Verify_User_Search_With_Valid_Data()  {
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
        users.enterTextInSearchBox("Tom m");



        List<WebElement> rowItems = driver.findElements(By.xpath("//*[@id=\"users_table\"]/tbody/tr[@role='row']"));
        List<WebElement> columnItems = driver.findElements(By.xpath("//*[@id=\"users_table\"]/tbody/tr/td"));
        System.out.println("Row size is.."+rowItems.size());
        System.out.println("column size is.."+columnItems.size());

    }

    @Test(priority = 12,enabled = true,description = "TC_011_Verify_User_Search_With_Valid_Data",groups = {"Regression","Smoke"})
    public void Verify_Message_Displayedby_User_Search_With_Invalid_Data()  {
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
        account.clickOnUserManagementbutton();
        extentTest.get().log(Status.PASS, "clicked on UserManagement button successfully");
        users=account.clickOnUsersSubMenuButton();
        extentTest.get().log(Status.PASS, "users page Opened successfully");
        users.enterTextInSearchBox("Aravindth");
        extentTest.get().log(Status.PASS, "Invalid data entered for search successfully");
        String actualInvalidSearchMessage=users.getNoMatchingMessage();
        extentTest.get().log(Status.PASS, "No Data matching message received successfully");
        String expectedInvalidSearchMessage="No matching records found";
        Assert.assertEquals(actualInvalidSearchMessage,expectedInvalidSearchMessage,"Invalid message display");
        extentTest.get().log(Status.PASS, "Invalid Search result message matching with expected message");
    }


}

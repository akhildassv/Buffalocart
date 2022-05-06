package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.LogInPage;
import com.buffalocart.pages.MyAccountPage;
import com.buffalocart.utilities.DateUtility;
import com.buffalocart.utilities.ExcelUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

public class MyAccountPageTest extends Base {
    MyAccountPage account;
    LogInPage login;
    ExcelUtility excel=new ExcelUtility();
    DateUtility date=new DateUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 6,enabled = true,description = "TC_006_Verify Home Page Title",groups = {"Regression"})
    public void verify_Home_Page_Title()  {
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
        List<String> accountdata =excel.readDataFromExcel("MyAccountPage");
        String actualTitle=account.getMyAccountPageTitle();
        extentTest.get().log(Status.PASS, "Page Title Received successfully");
        String expectedTitle=accountdata.get(3);
        Assert.assertEquals(actualTitle,expectedTitle,"Invalid title");
        extentTest.get().log(Status.PASS, "Expected title is mached with actual home page title");
    }

    @Test(priority = 7,enabled = true,description = "TC_007_Verify_Date_Displeyed_In_Home_Page",groups = {"Regression"})
    public void Verify_Date_Displeyed_In_Home_Page ()  {
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
        LocalDate actualDate=account.getDateDisplayed_LocalDate();
        extentTest.get().log(Status.PASS, "Actual date Displayed on webpage Received successfully");
        LocalDate expectedDate=date.getTodaysDate();
        Assert.assertEquals(actualDate,expectedDate,"Invalid Date Displayed");
        extentTest.get().log(Status.PASS, "Expected Date is mached with actual home page Date Displayed");
    }

    @Test(priority = 8,enabled = true,description = "TC_008_Verify_Whether_Useris_Navigatingto_Login_Pageby_Clickingon_Signout_Button",groups = {"Regression","Smoke"})
    public void Verify_Whether_Useris_Navigatingto_Login_Pageby_Clickingon_Signout_Button ()  {
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
        extentTest.get().log(Status.PASS, "clicked on User Account button successfully");
        login=account.clickOnSignOutButton();
        String actualPageTitle=login.getLoginPageTitle();
        extentTest.get().log(Status.PASS, "Current page Title Received successfully");
        String expectedPageTitle =data.get(5);
        Assert.assertEquals(actualPageTitle,expectedPageTitle,"Invalid Page Returm");
        extentTest.get().log(Status.PASS, "Actual Page title is mached with Expected Login page title");
    }

    @Test(priority = 9,enabled = true,description = "TC_009_Verify_The_Usermangement_Sub_Tabs",groups = {"Regression"})
    public void Verify_The_Usermangement_Sub_Tabs ()  {
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
        List<String> actualSubMenuList=account.getUserManagementSubMenu();
        List<String> expectedSubMenuList =excel.readDataFromExcel("UserManagement");
        Assert.assertEquals(actualSubMenuList,expectedSubMenuList,"Invalid UserManagement Sub List");
    }
}

package com.buffalocart.test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.buffalocart.automationcore.Base;
import com.buffalocart.listeners.TestListener;
import com.buffalocart.pages.LogInPage;
import com.buffalocart.pages.MyAccountPage;
import com.buffalocart.pages.ResetPage;
import com.buffalocart.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;


public class LogInPageTest extends Base {
    LogInPage login;
    MyAccountPage account;
    ResetPage reset;
    ExcelUtility excel=new ExcelUtility();
    ThreadLocal<ExtentTest> extentTest = TestListener.getTestInstance();

    @Test(priority = 1,enabled = true,description = "TC_001_Verify Login Page Title",groups = {"Regression"})
    public void verify_Login_Page_Title()  {
        extentTest.get().assignCategory("Regression");
        login = new LogInPage(driver);
        List<String> data =excel.readDataFromExcel("LoginPage");
        String expectedTitle =data.get(5);
        String actualTitle =login.getLoginPageTitle();
        extentTest.get().log(Status.PASS, "Login page title recieved");
        Assert.assertEquals(actualTitle,expectedTitle,"Page title not equal");
        extentTest.get().log(Status.PASS, "Expected title is mached with actual home page title");
    }

    @Test(priority = 2,enabled = true,description = "TC_002_Verify Login with valid user credentials",groups = {"Regression","Smoke"})
    public void verify_User_Login_With_Valid_User_Credentials()  {
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
        String expectedUserName =accountdata.get(2);
        account.clickOnEndTourButton();
        extentTest.get().log(Status.PASS, "clicked on Endtour button successfully");
        String actualUserName =account.getUserAccountName();
        extentTest.get().log(Status.PASS, "User Account Name Recieved");
        Assert.assertEquals(actualUserName,expectedUserName,"Invalid Username or Password");
        extentTest.get().log(Status.PASS, "User Logged in successfully");
    }

    @DataProvider(name = "user_credentials")
    public Object[][] userLoginData()  {
        Object[][] data = excel.getData("Logindata");
        return data;
    }

    @Test(priority = 3,dataProvider = "user_credentials",enabled = true,groups = {"Regression"},description = "TC_003_Verify the error message displayed for user login with invalid credentials")
    public void verify_User_Error_Login_With_InValid_User_Credentials(String uname, String pword) {
        extentTest.get().assignCategory("Regression");
        login = new LogInPage(driver);
        login.enterUserName(uname);
        extentTest.get().log(Status.PASS, "User name enetred successfully");
        login.enterPassword(pword);
        extentTest.get().log(Status.PASS, "Password enetred successfully");
        login.clickOnRememberMeCheckbox();
        extentTest.get().log(Status.PASS, "Clicked Remember_Me Button successfully");
        account=login.clickOnLoginButton();
        String actualErrorMessage =login.getLoginErrorMessage();
        extentTest.get().log(Status.PASS, "Error Message Recieved");
        String expectedErrorMessage ="These credentials do not match our records.";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Logged In-Having Error in Login");
        extentTest.get().log(Status.PASS, "User Logged in Failed and Error Message Displayed");
    }

    @Test(priority = 4,enabled = true,groups = {"Regression"},description = "TC_004_Verify Remember me' checkbox is Clickable")
    public void verify_User_RememberMe_Checkbox_clickable(){
        extentTest.get().assignCategory("Regression");
        login = new LogInPage(driver);
        login.clickOnRememberMeCheckbox();
        extentTest.get().log(Status.PASS, "Clicked Remember_Me Button successfully");
        boolean actualResult=login.getSelectCheckboxResult();
        extentTest.get().log(Status.PASS, "Received result of Selection");
        Assert.assertTrue(actualResult,"Cannot able to click on Remember Me Button");
        extentTest.get().log(Status.PASS, "User can able to click on 'Remember me' checkbox");
    }
}

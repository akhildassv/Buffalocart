package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage extends ObjectUtility {
    WebDriver driver;
    /** Page constructor**/
    public LogInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /** Page Elements**/

    private final String _username="username";
    @FindBy(id=_username) WebElement username;

    private final String _password="password";
    @FindBy(id=_password) WebElement password;

    private final String _checkbox="//div//label//input";
    @FindBy(xpath=_checkbox) WebElement checkbox;

    private final String _loginbutton="//div//button";
    @FindBy(xpath=_loginbutton) WebElement loginbutton;

    private final String _errormessage="//div//span//strong";
    @FindBy(xpath=_errormessage) WebElement errormessage;

    private final String _forgetpassword="//div//a";
    @FindBy(xpath=_forgetpassword) WebElement forgetpassword;



    /**User Actions Methods**/

    public String getLoginPageTitle(){
        String title=page.getPageTitle(driver);
        return title;
    }

    public void enterUserName(String uName){
        page.enterText(username,uName);
    }

    public void enterPassword(String pName){
        page.enterText(password,pName);
    }

    public void clickOnRememberMeCheckbox(){
        page.clickOnElement(checkbox);
    }

    public MyAccountPage clickOnLoginButton(){
        page.clickOnElement(loginbutton);
        return new MyAccountPage(driver);
    }

    public String getLoginErrorMessage(){
        String message=page.getElementText(errormessage);
        return message;
    }

    public boolean getSelectCheckboxResult(){
        boolean ans=page.isElementSelected(checkbox);
        return ans;
    }

    public ResetPage clickOnForgetPassword(){
        page.clickOnElement(forgetpassword);
        return new ResetPage(driver);
    }
}

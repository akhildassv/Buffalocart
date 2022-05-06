package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import com.buffalocart.utilities.WaitUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersPage extends ObjectUtility {
    WebDriver driver;
    /** Page constructor**/
    public UsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /** Page Elements**/
    private final String _accountname="/html/body/div[2]/header/nav/div/ul/li[2]/a";
    @FindBy(xpath=_accountname) WebElement accountname;

    private final String _searchtextbox="//div[@id='users_table_filter']//input";
    @FindBy(xpath=_searchtextbox) WebElement searchtextbox;

    private final String _nomatchingmessage="//table[@id='users_table']//tbody//tr//td";
    @FindBy(xpath=_nomatchingmessage) WebElement nomatchingmessage;

    private final String _adduserbutton="//div[@class='box-tools']//a";
    @FindBy(xpath=_adduserbutton) WebElement adduserbutton;

    private final String _Useraccountname="//li[@class='dropdown user user-menu']//a//span";
    @FindBy(xpath=_Useraccountname) WebElement Useraccountname;



    private final String _signoutbutton="//div[@class='pull-right']//a";
    @FindBy(xpath=_signoutbutton) WebElement signoutbutton;

    private final String _akhileditbutton="//*[@id=\"users_table\"]/tbody/tr/td[5]/a[1]";
    @FindBy(xpath=_akhileditbutton) WebElement akhileditbutton;

    private final String _albertDeleteButton="//*[@id=\"users_table\"]/tbody/tr[3]/td[5]/button";
    @FindBy(xpath=_albertDeleteButton) WebElement albertDeleteButton;

    /**user actions**/
    public String getUsersPageTitle(){
        String title=page.getPageTitle(driver);
        return title;
    }

    public void enterTextInSearchBox(String value){
        wait.setPageLoadWait(driver);
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_searchtextbox);
        page.enterText(searchtextbox,value);
    }

    public String getNoMatchingMessage(){
        wait.waitForVisibilityOfElement(driver,nomatchingmessage);
        String message=page.getElementText(nomatchingmessage);
        return message;
    }


    public AddUserPage clickOnAddUserButton(){
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_adduserbutton);
        page.clickOnElement(adduserbutton);
        return new AddUserPage(driver);
    }

    public void clickOnUserProfilebutton1(){
        wait.setPageLoadWait(driver);
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_Useraccountname);
        page.clickOnElement(Useraccountname);
    }
    public void clickOnUserProfilebutton(){

        wait.waitForVisibilityOfElement(driver,accountname);
        page.clickOnElement(accountname);
    }

    public LogInPage clickOnSignOutButton(){
        page.clickOnElement(signoutbutton);
        return new LogInPage(driver);
    }
    public EditUserPage clickOnAkhilEditButton(){
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_akhileditbutton);
        page.clickOnElement(akhileditbutton);
        return new EditUserPage(driver);
    }

    public DeleteUserPage clickOnAlbertDeleteButton(){
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_albertDeleteButton);
        page.clickOnElement(albertDeleteButton);
        return new DeleteUserPage(driver);
    }

}

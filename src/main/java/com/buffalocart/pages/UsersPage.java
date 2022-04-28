package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
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

    private final String _searchtextbox="//div[@id='users_table_filter']//input";
    @FindBy(xpath=_searchtextbox) WebElement searchtextbox;

    private final String _nomatchingmessage="//table[@id='users_table']//tbody//tr//td";
    @FindBy(xpath=_nomatchingmessage) WebElement nomatchingmessage;

    private final String _adduserbutton="//div[@class='box-tools']//a";
    @FindBy(xpath=_adduserbutton) WebElement adduserbutton;


    /**user actions**/
    public String getUsersPageTitle(){
        String title=page.getPageTitle(driver);
        return title;
    }

    public void enterTextInSearchBox(String value){
        page.enterText(searchtextbox,value);
    }

    public String getNoMatchingMessage(){
        String message=page.getElementText(nomatchingmessage);
        return message;
    }

    public AddUserPage clickOnAddUserButton(){
        page.clickOnElement(adduserbutton);
        return new AddUserPage(driver);
    }


}

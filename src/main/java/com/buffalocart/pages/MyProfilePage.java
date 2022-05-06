package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage extends ObjectUtility {
    WebDriver driver;
    /** Page constructor**/
    public MyProfilePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /** Page Elements**/
    private final String _enterSureName="surname";
    @FindBy(id=_enterSureName) WebElement enterSureName;

    private final String _updateButton="//div[2]/div/button";
    @FindBy(xpath=_updateButton) WebElement updateButton;

    private final String _updatedMessage="//div[@id='toast-container']//div[@class='toast-message']";
    @FindBy(xpath=_updatedMessage) WebElement updatedMessage;

    private final String _succesmessage="//div[@id='toast-container']//div[@class='toast-message']";
    @FindBy(xpath=_succesmessage) WebElement succesmessage;


    /**user actions**/
    public void enterSureName(String value){
        page.enterText(enterSureName,value);
    }

    public void clickOnUpdateButton(){
        page.clickOnElement(updateButton);
    }

    public String getupdatedMessage(){
        String updatedMessage=page.getElementText(succesmessage);
        return updatedMessage;

    }

}

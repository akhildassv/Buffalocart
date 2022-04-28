package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddUserPage extends ObjectUtility {
    WebDriver driver;
    /** Page constructor**/
    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /** Page Elements**/

    private final String _enteremail="email";
    @FindBy(id=_enteremail) WebElement enteremail;

    private final String _password="password";
    @FindBy(id=_password) WebElement password;

    private final String _confPassword="confirm_password";
    @FindBy(id=_confPassword) WebElement confPassword;

    private final String _savebutton="submit_user_button";
    @FindBy(id=_savebutton) WebElement savebutton;

    private final String _firstnameErrorMessage="first_name-error";
    @FindBy(id=_firstnameErrorMessage) WebElement firstnameErrorMessage;

    /**user actions**/
    public void enterEmail(String value){
        page.enterText(enteremail,value);
    }

    public void enterPassword(String value){
        page.enterText(password,value);
    }

    public void enterConfirmPassword(String value){
        page.enterText(confPassword,value);
    }

    public void clickOnSaveButton(){
        page.clickOnElement(savebutton);
    }

    public String getFirstnameErrorMessage(){
        String errorMessage=page.getElementText(firstnameErrorMessage);
        return errorMessage;
    }

    public String getAddUserPageTitle(){
        String addUserPageTitle=page.getPageTitle(driver);
        return addUserPageTitle;
    }
}

package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import com.buffalocart.utilities.WaitUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddUserPage extends ObjectUtility {
    WebDriver driver;
    /** Page constructor**/
    public AddUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /** Page Elements**/


    private final String _enterfirstname="first_name";
    @FindBy(id=_enterfirstname) WebElement enterfirstname;

    private final String _enteremail="email";
    @FindBy(id=_enteremail) WebElement enteremail;

    private final String _enterUsername="username";
    @FindBy(id=_enterUsername) WebElement enterUsername;

    private final String _password="password";
    @FindBy(id=_password) WebElement password;

    private final String _confPassword="confirm_password";
    @FindBy(id=_confPassword) WebElement confPassword;

    private final String _savebutton="submit_user_button";
    @FindBy(id=_savebutton) WebElement savebutton;

    private final String _firstnameErrorMessage="first_name-error";
    @FindBy(id=_firstnameErrorMessage) WebElement firstnameErrorMessage;

    private final String _roleoptions="role";
    @FindBy(id=_roleoptions) WebElement roleoptions;


    /**user actions**/
    public void enterFirstName(String value){
        page.enterText(enterfirstname,value);
    }

    public void enterEmail(String value){
        page.enterText(enteremail,value);
    }

    public void enterUserName(String value){
        page.enterText(enterUsername,value);
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

    public UsersPage clickOnSubmitButton(){
        page.clickOnElement(savebutton);
        return new UsersPage(driver);

    }

    public String getFirstnameErrorMessage(){
        String errorMessage=page.getElementText(firstnameErrorMessage);
        return errorMessage;
    }

    public String getAddUserPageTitle(){
        String addUserPageTitle=page.getPageTitle(driver);
        return addUserPageTitle;
    }



    public boolean getRolesListCheckResult(String roleName) {
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Id,_roleoptions);
        Select select = new Select(roleoptions);
        List<WebElement> options = select.getOptions();
        boolean match = false;
        for(WebElement we:options)
        {
            if (we.getText().equals(roleName))
            {
                match = true;
                break;
            }
        }
        return match;
    }

}

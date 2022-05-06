package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import com.buffalocart.utilities.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RolesPage extends ObjectUtility {
    WebDriver driver;

    public RolesPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    private final String _addrolesbutton="//div[@class='box-tools']//a";
    @FindBy(xpath =_addrolesbutton) WebElement addrolesbutton;

    private final String _succesmessage="//div[@id='toast-container']//div[@class='toast-message']";
    @FindBy(xpath=_succesmessage) WebElement succesmessage;

    private final String _searchroletextbox="//div[@id='roles_table_filter']//input";
    @FindBy(xpath=_searchroletextbox) WebElement searchroletextbox;

    private final String _roleEditButton="//*[@id=\"roles_table\"]/tbody/tr/td[2]/a";
    @FindBy(xpath=_roleEditButton) WebElement roleEditButton;

    private final String _deleteRoleButton="//*[@id=\"roles_table\"]//td[2]/button";
    @FindBy(xpath=_deleteRoleButton) WebElement deleteRoleButton;


    private final String _userssubmenubutton="//li[2]/ul/li[1]/a/span";
    @FindBy(xpath=_userssubmenubutton) WebElement userssubmenubutton;

    public String getRolesPageTitle(){
        wait.setPageLoadWait(driver);
        String title=page.getPageTitle(driver);
        return title;
    }

    public AddRolesPage clickOnAddRolesButton(){
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_addrolesbutton);
        page.clickOnElement(addrolesbutton);
        return new AddRolesPage(driver);
    }

    public String getRoleAddedSccessMessage() {
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_succesmessage);
        String updatedMessage = page.getElementText(succesmessage);
        return updatedMessage;
    }

    public String getRoleDeletedSccessMessage() {
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_succesmessage);
        String updatedMessage = page.getElementText(succesmessage);
        return updatedMessage;
    }

    public void enterRoleNameforSearch(String name){
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_searchroletextbox);
        page.enterText(searchroletextbox,name);
    }

    public UpdateRolePage clickOnEditRolesButton(){
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_roleEditButton);
        page.clickOnElement(roleEditButton);
        return new UpdateRolePage(driver);
    }

    public DeleteRolePage clickOnDeleteRolesButton(){
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_deleteRoleButton);
        page.clickOnElement(deleteRoleButton);
        return new DeleteRolePage(driver);
    }

    public UsersPage clickOnUsersSubMenuButton(){
        page.clickOnElement(userssubmenubutton);
        return new UsersPage(driver);
    }

}

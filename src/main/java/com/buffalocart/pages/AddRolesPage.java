package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRolesPage extends ObjectUtility {
    WebDriver driver;
    public AddRolesPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private final String _rolename="name";
    @FindBy(id = _rolename) WebElement rolename;

    private final String _usercheckbox="//*[@id=\"role_add_form\"]/div[3]/div[2]/div/label/div/ins";
    @FindBy(xpath = _usercheckbox) WebElement usercheckbox;

    private final String _rolescheckbox="//*[@id=\"role_add_form\"]/div[4]/div[2]/div/label/div/ins";
    @FindBy(xpath = _rolescheckbox) WebElement rolescheckbox;

    private final String _savebutton="//div[@class='col-md-12']//button";
    @FindBy(xpath = _savebutton) WebElement savebutton;

    public String getAddRolesPageTitle(){
        wait.setPageLoadWait(driver);
        String title=page.getPageTitle(driver);
        return title;
    }

    public void enterRoleName(String name){
        page.enterText(rolename,name);
    }

    public void selectUserCheckbox(){
        page.clickOnElement(usercheckbox);
    }

    public void selectRolesCheckbox(){
        page.clickOnElement(rolescheckbox);
    }

    public RolesPage clickOnSaveButton(){
        page.clickOnElement(savebutton);
        return new RolesPage(driver);
    }
}

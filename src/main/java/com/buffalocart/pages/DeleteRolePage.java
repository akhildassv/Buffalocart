package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteRolePage extends ObjectUtility {

    WebDriver driver;

    public DeleteRolePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    private final String _deleteRoleOKButton="//div[@class='swal-footer']//div[2]//button";
    @FindBy(xpath=_deleteRoleOKButton) WebElement deleteRoleOKButton;

    public RolesPage clickOnOkDeleteButton(){
        page.clickOnElement(deleteRoleOKButton);
        return new RolesPage(driver);
    }
}

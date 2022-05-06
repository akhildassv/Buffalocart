package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import com.buffalocart.utilities.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateRolePage extends ObjectUtility {
    WebDriver driver;
    public UpdateRolePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    private final String _suppliercheckbox="//*[@id=\"role_form\"]/div[5]/div[2]/div/label/div/ins";
    @FindBy(xpath =_suppliercheckbox) WebElement suppliercheckbox;

    private final String _customercheckbox="//*[@id=\"role_form\"]/div[6]/div[2]/div/label/div/ins";
    @FindBy(xpath =_customercheckbox) WebElement customercheckbox;

    private final String _updatebutton="//div[@class='col-md-12']//button";
    @FindBy(xpath = _updatebutton) WebElement updatebutton;

    public String getEditRolePageTitle(){
        wait.setPageLoadWait(driver);
        String title=page.getPageTitle(driver);
        return title;
    }

    public void clickOnSupplierCheckBox(){
        wait.setPageLoadWait(driver);
        page.clickOnElement(suppliercheckbox);
    }

    public void clickOnCustomerCheckBox(){
        page.clickOnElement(customercheckbox);
    }

    public RolesPage clickOnSaveButton(){
        page.clickOnElement(updatebutton);
        return new RolesPage(driver);
    }

}

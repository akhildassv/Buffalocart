package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import com.buffalocart.utilities.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditUserPage extends ObjectUtility {
    WebDriver driver;
    /** Page constructor**/
    public EditUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /** Page Elements**/

    private final String _salesCommission="cmmsn_percent";
    @FindBy(id=_salesCommission) WebElement salesCommission;

    private final String _updateButton="submit_user_button";
    @FindBy(id=_updateButton) WebElement updateButton;

    private final String _succesmessage="//div[@id='toast-container']//div[@class='toast-message']";
    @FindBy(xpath=_succesmessage) WebElement succesmessage;

/**User Actions Methods**/
    public void enterSalesCommissionValue(String value){
        page.enterText(salesCommission,value);
    }

    public String getEditUpdatedMessage() {
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_succesmessage);
        String updatedMessage = page.getElementText(succesmessage);
        return updatedMessage;
    }
    public void clickOnEditUpdateButton(){
        page.clickOnElement(updateButton);
    }

    public String getEditPageTitle(){
        wait.setPageLoadWait(driver);
        String editTitle=page.getPageTitle(driver);
        return editTitle;
    }
}

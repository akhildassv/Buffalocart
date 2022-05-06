package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import com.buffalocart.utilities.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateSalesCommissionAgentsPage extends ObjectUtility {
    WebDriver driver;
    /** Page constructor**/
    public UpdateSalesCommissionAgentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /** Page Elements**/
    private final String _salesPercent="cmmsn_percent";
    @FindBy(id=_salesPercent) WebElement salesPercent;

    private final String _savebutton="//*[@id=\"sale_commission_agent_form\"]/div[3]/button[1]";
    @FindBy(xpath=_savebutton) WebElement savebutton;

    private final String _deleteokbutton="//div[@class='swal-button-container'][2]//button";
    @FindBy(xpath=_deleteokbutton) WebElement deleteokbutton;

    public void enterSalesPercent(String value){
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Id,_salesPercent);
        page.enterText(salesPercent,value);
    }

    public SalesCommissionAgentPage clickOnSaveButton(){
        page.clickOnElement(savebutton);
        return new SalesCommissionAgentPage(driver);
    }

    public SalesCommissionAgentPage clickOnDeleteOkButton(){
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_deleteokbutton);
        page.clickOnElement(deleteokbutton);
        return new SalesCommissionAgentPage(driver);
    }


}

package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import com.buffalocart.utilities.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SalesCommissionAgentPage extends ObjectUtility {

    WebDriver driver;
    /** Page constructor**/
    public SalesCommissionAgentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /** Page Elements**/

    private final String _addsalesbutton="//div[@class='box-header']//button";
    @FindBy(xpath=_addsalesbutton) WebElement addsalesbutton;

    private final String _succesmessage="//div[@id='toast-container']//div[@class='toast-message']";
    @FindBy(xpath=_succesmessage) WebElement succesmessage;

    private final String _salescommissionsearchBox="#sales_commission_agent_table_filter > label > input";
    @FindBy(css=_salescommissionsearchBox) WebElement salescommissionsearchBox;

    private final String _salescommissionEditButton="//tr[1]//td//button[1]";
    @FindBy(xpath=_salescommissionEditButton) WebElement salescommissionEditButton;

    private final String _salescommissionDeleteButton="//tr[1]//td//button[2]";
    @FindBy(xpath=_salescommissionDeleteButton) WebElement salescommissionDeleteButton;

    public String getSalesCommissionPageTitle(){
        wait.setPageLoadWait(driver);
        String myaccountPageTitle=page.getPageTitle(driver);
        return myaccountPageTitle;
    }

    public AddSalesCommissionAgentPage clickOnAddSalesCommissionAgentButton(){
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_addsalesbutton);
        page.clickOnElement(addsalesbutton);
        return new AddSalesCommissionAgentPage(driver);
    }

    public String getNewAgentAddedSccessMessage() {
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_succesmessage);
        String updatedMessage = page.getElementText(succesmessage);
        return updatedMessage;
    }

    public void enterSearchBox(String value){
        wait.setPageLoadWait(driver);
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.CssSelector,_salescommissionsearchBox);
        page.enterText(salescommissionsearchBox,value);
    }

    public UpdateSalesCommissionAgentsPage clickOnEditSalesAgentButton(){
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_salescommissionEditButton);
        page.clickOnElement(salescommissionEditButton);
        return new UpdateSalesCommissionAgentsPage(driver);
    }

    public UpdateSalesCommissionAgentsPage clickOnDeleteSalesAgentButton(){
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_salescommissionDeleteButton);
        page.clickOnElement(salescommissionDeleteButton);
        return new UpdateSalesCommissionAgentsPage(driver);
    }



}

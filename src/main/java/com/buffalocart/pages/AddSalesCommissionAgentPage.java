package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import com.buffalocart.utilities.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddSalesCommissionAgentPage extends ObjectUtility {


    WebDriver driver;
    /** Page constructor**/
    public AddSalesCommissionAgentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /** Page Elements**/
    private final String _firstname="first_name";
    @FindBy(id=_firstname) WebElement firstname;

    private final String _emailid="email";
    @FindBy(id=_emailid) WebElement emailid;

    private final String _salesCommissionPercent="cmmsn_percent";
    @FindBy(id=_salesCommissionPercent) WebElement salesCommissionPercent;

    private final String _savebutton="//*[@id=\"sale_commission_agent_form\"]/div[3]/button[1]";
    @FindBy(xpath=_savebutton) WebElement savebutton;

    public void enterFirstName(String fName){
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Id,_firstname);
        page.enterText(firstname,fName);
    }

    public void enterEmailId(String email){
        page.enterText(emailid,email);
    }

    public void entersalesCommissionPercent(String percent){
        page.enterText(salesCommissionPercent,percent);
    }

    public SalesCommissionAgentPage clickOnSaveButton(){
        page.clickOnElement(savebutton);
        return new SalesCommissionAgentPage(driver);
    }


}

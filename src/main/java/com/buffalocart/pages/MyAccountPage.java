package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends ObjectUtility {
    WebDriver driver;
    /** Page constructor**/
    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /** Page Elements**/

    private final String _accountname="//li[@class='dropdown user user-menu']//a//span";
    @FindBy(xpath=_accountname) WebElement accountname;

    private final String _endtourbutton="//div[@id='step-0']//button[@class='btn btn-default btn-sm']";
    @FindBy(xpath=_endtourbutton) WebElement endtourbutton;

    /**User Actions Methods**/
    public String getUserAccountName(){
        String userAccount=page.getElementText(accountname);
        return userAccount;
    }

    public void clickOnEndTourButton(){
        page.clickOnElement(endtourbutton);
    }

}

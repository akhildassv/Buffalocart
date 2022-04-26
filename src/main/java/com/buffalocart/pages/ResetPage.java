package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage extends ObjectUtility {
    WebDriver driver;
    /** Page constructor**/
    public ResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /** Page Elements**/

    private final String _resetemail="email";
    @FindBy(id=_resetemail) WebElement resetemail;

    private final String _sendresetlinkbutton="//div//button";
    @FindBy(xpath=_sendresetlinkbutton) WebElement resetlinkbutton;

    private final String _erroremailmessage="//div//span//strong";
    @FindBy(xpath=_erroremailmessage) WebElement erroremailmessage;

    /**User Actions Methods**/
    public void enterMailID(String value){
        page.enterText(resetemail,value);
    }

    public void clickOnResetLinkButton(){
        page.clickOnElement(resetlinkbutton);
    }

    public String getErrorMessageInReset(){
        String mess=page.getElementText(erroremailmessage);
        return mess;
    }

}

package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import com.buffalocart.utilities.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteUserPage extends ObjectUtility {
    WebDriver driver;
    /** Page constructor**/
    public DeleteUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    /** Page Elements**/

    private final String _DeleteOKButton="//div[4]/div/div[4]/div[2]/button";
    @FindBy(xpath=_DeleteOKButton) WebElement DeleteOKButton;


    private final String _DeleteSuccessMeggage="//div[@id='toast-container']//div[@class='toast-message']";
    @FindBy(xpath=_DeleteSuccessMeggage) WebElement DeleteSuccessMeggage;

    public void clickOnDeleteOKButton(){
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_DeleteOKButton);
        page.clickOnElement(DeleteOKButton);
    }

    public String getDeleteSuccessMessage() {
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_DeleteSuccessMeggage);
        String updatedMessage = page.getElementText(DeleteSuccessMeggage);
        return updatedMessage;
    }

}

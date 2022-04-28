package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

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

    private final String _datedisplayed="//div[@class='m-8 pull-left mt-15 hidden-xs']//strong";
    @FindBy(xpath=_datedisplayed) WebElement datedisplayed;

    private final String _signoutbutton="//div[@class='pull-right']//a";
    @FindBy(xpath=_signoutbutton) WebElement signoutbutton;

    private final String _usermanagementbutton1="(//ul//li[@class='treeview']//a//span)[1]";
    @FindBy(xpath=_usermanagementbutton1) WebElement usermanagementbutton1;

    private final String _usermanagementbutton="/html/body/div[2]/aside/section/ul/li[2]/a/span[1]";
    @FindBy(xpath=_usermanagementbutton) WebElement usermanagementbutton;

    private final String _userssubmenubutton="//li[2]/ul/li[1]/a/span";
    @FindBy(xpath=_userssubmenubutton) WebElement userssubmenubutton;



    /**User Actions Methods**/

    public ArrayList<String> getUserManagementSubMenu() {
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='treeview-menu']//span[@class='title']"));
        ArrayList<String> submenu = new ArrayList<String>();
        for (int i = 0; i < options.size(); i++) {
            submenu.add(options.get(i).getText());
        }
        return submenu;
    }

    public void clickOnUserManagementSubMenu(String menuName) {
        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='treeview-menu']//span[@class='title']"));
        for (int i = 0; i < options.size(); i++) {
            if (options.get(i).getText().equalsIgnoreCase(menuName)) {
                options.get(i).click();
            }
        }
    }

    public String getUserAccountName(){
        String userAccount=page.getElementText(accountname);
        return userAccount;
    }

    public void clickOnEndTourButton(){
        page.clickOnElement(endtourbutton);
    }

    public String getMyAccountPageTitle(){
        String myaccountPageTitle=page.getPageTitle(driver);
        return myaccountPageTitle;
    }

    public LocalDate getDateDisplayed_LocalDate(){
        String displayedDate=page.getElementText(datedisplayed);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate date = LocalDate.parse(displayedDate, formatter);
        return date;
    }

    public void clickOnUserProfilebutton(){
        page.clickOnElement(accountname);
    }

    public LogInPage clickOnSignOutButton(){
        page.clickOnElement(signoutbutton);
        return new LogInPage(driver);
    }

    public void clickOnUserManagementbutton(){
        page.clickOnElement(usermanagementbutton);
    }

    public UsersPage clickOnUsersSubMenuButton(){
        page.clickOnElement(userssubmenubutton);
        return new UsersPage(driver);
    }

}

package com.buffalocart.pages;

import com.buffalocart.utilities.ObjectUtility;
import com.buffalocart.utilities.WaitUtility;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
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

    private final String _userssubmenutags="//ul[@class='treeview-menu']//span[@class='title']";
    @FindBy(xpath=_userssubmenutags) List<WebElement> userssubmenutags;

    private final String _profilebutton="//div/ul/li[2]/ul/li[2]/div[1]/a";
    @FindBy(xpath=_profilebutton) WebElement profilebutton;

    private final String _rolessubmenubutton="//ul/li[2]/ul/li[2]/a/span";
    @FindBy(xpath=_rolessubmenubutton) WebElement rolessubmenubutton;

    private final String _salesCommissionSubMenu="//li[2]/ul/li[3]/a/span";
    @FindBy(xpath=_salesCommissionSubMenu) WebElement salesCommissionSubMenu;

    /**User Actions Methods**/

    public ArrayList<String> getUserManagementSubMenu() {
        ArrayList<String> submenu = new ArrayList<String>();
        for (int i = 0; i < userssubmenutags.size(); i++) {
            submenu.add(userssubmenutags.get(i).getText());
        }
        return submenu;
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

    public RolesPage clickOnRolesSubMenuButton(){
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_rolessubmenubutton);
        page.clickOnElement(rolessubmenubutton);
        return new RolesPage(driver);
    }

    public SalesCommissionAgentPage clickOnSalesCommissionSubMenuButton(){
        wait.waitVisibilityOfElementLocatorBy(driver, WaitUtility.LocatorType.Xpath,_salesCommissionSubMenu);
        page.clickOnElement(salesCommissionSubMenu);
        return new SalesCommissionAgentPage(driver);
    }

    public String getUserName(){
       String Uname= page.getElementText(accountname);
        return Uname;
    }

    public MyProfilePage clickOnProfilebutton(){
        page.clickOnElement(profilebutton);
        return new MyProfilePage(driver);

    }

}

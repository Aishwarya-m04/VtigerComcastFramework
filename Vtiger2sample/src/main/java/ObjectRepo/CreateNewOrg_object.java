package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebdriverUtility;

public class CreateNewOrg_object {
   WebDriver driver;
   public CreateNewOrg_object(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(xpath=("//input[@name='accountname']"))
   private WebElement OrgnizationName;
   
   @FindBy(xpath=("//select[@name='industry']"))
   private WebElement Industry;
   
   @FindBy(xpath=("//input[@value='U']"))
   private WebElement AssignedToUser;
   
   @FindBy(xpath=("//input[@value='T']"))
   private WebElement AssignedToGroup;
   
   @FindBy(xpath=("//select[@name='assigned_user_id']"))
   private WebElement AssignedTo;
   
   @FindBy(xpath=("//input[@title='Save [Alt+S]']"))
   private WebElement SaveButton;
   
   @FindBy(id="phone")
   private WebElement PhoneNo;
   
   @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
   private WebElement signoutLogo;
   
   @FindBy(linkText = ("Sign Out"))
   private WebElement signout;
   
   public WebElement getSignoutLogo() {
	return signoutLogo;
}

   public WebElement getSignout() {
	return signout;
   }

   public WebElement getPhoneNo() {
   return PhoneNo;
   }
   
   public WebElement getSaveButton() {
	return SaveButton;
    }

   public WebDriver getDriver() {
	return driver;
   }

   public WebElement getOrgnizationName() {
	return OrgnizationName;
   }

   public WebElement getIndustry() {
	return Industry;
   }

   public WebElement getAssignedToUser() {
	return AssignedToUser;
   }

   public WebElement getAssignedToGroup() {
	return AssignedToGroup;
   }

   public WebElement getAssignedTo() {
	return AssignedTo;
   }
   
   
   public void createOrgWithName(String name)
   {
	   OrgnizationName.clear();
	   OrgnizationName.sendKeys(name);
	   
	   SaveButton.click();
	   
   }
   
   public void createOrgWithIndustry(String OrgName,String Indname)
   {
	   OrgnizationName.clear();
	   OrgnizationName.sendKeys(OrgName);
	   
	   WebdriverUtility wlib=new WebdriverUtility();
	   wlib.selectByDD(Indname, Industry);
	   
	   SaveButton.click();
   }
   
   public void createOrgWithPhone(String OrgName,String phNo)
   {
	   OrgnizationName.clear();
	   OrgnizationName.sendKeys(OrgName);
	   
	   PhoneNo.clear();
	   PhoneNo.sendKeys(phNo);
	   
	   SaveButton.click();
   }
   
   
   
}

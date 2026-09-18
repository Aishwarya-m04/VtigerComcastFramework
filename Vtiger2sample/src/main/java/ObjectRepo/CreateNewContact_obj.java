package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.JavaUtility;

public class CreateNewContact_obj {
     WebDriver driver;
     public CreateNewContact_obj(WebDriver driver)
     {
    	 this.driver=driver;
    	 PageFactory.initElements(driver, this);
     }
     
     @FindBy(xpath="//input[@name='lastname']")
     private WebElement LastName;
     
     @FindBy(xpath="//input[@name='support_end_date']")
     private WebElement endtDate;
     
     @FindBy(xpath="//input[@title='Save [Alt+S]']")
     private WebElement SaveButton;
     
     @FindBy(xpath = "//input[@name='account_name']/../img")
     private WebElement OrgNmaeButton;
     
	 public WebDriver getDriver() {
		 return driver;
	 }

	 public WebElement getLName() {
		 return LastName;
	 }

	 public WebElement getEndDate() {
		 return endtDate;
	 }

	 public WebElement getSaveButton() {
		 return SaveButton;
	 }

	 public WebElement getOrgNmaeButton() {
		 return OrgNmaeButton;
	 }
	 
	 public void createContactWithName(String OrgName)
	 {
		 LastName.sendKeys(OrgName);
		 SaveButton.click();
	 }
	 
//	 public void createContactWithEndDate(String days)
//	 {   
//		 endtDate.clear();
//		 JavaUtility jlib=new JavaUtility();
//		 
//		 endtDate.sendKeys(jlib.calenderDate(+30));
//	 }
//	 
	
     
     
}

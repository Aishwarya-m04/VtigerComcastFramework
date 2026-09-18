package com.vTiger.crm.organization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseTest.BaseClassTest;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesUtility;
import GenericUtility.WebdriverUtility;
import ObjectRepo.CreateNewOrg_object;
import ObjectRepo.HomePage_object;
import ObjectRepo.Login_object;
import ObjectRepo.OrgInfo_object;
import ObjectRepo.Organization_object;
import reportUtility.UtilityClassObject;

/**
 * Author:Aishwarya M
 * verifying user can create organiztion successfully;
 * **/

@Listeners(GenericUtility.ListnerImplementClass.class)       //written for debugging
public class CreateOrganizationTest extends BaseClassTest {
	
	@Test(groups = "ST")
   public void createOrg() throws Exception {
//	WebdriverUtility wlib=new WebdriverUtility();
	// JavaUtility jlib=new JavaUtility();
//	PropertiesUtility plib=new PropertiesUtility();
    // ExcelUtility elib=new ExcelUtility();
//	
//	String browser = plib.toReadDataFromPropertyFile("browser");
//	String url = plib.toReadDataFromPropertyFile("url");
//	String username = plib.toReadDataFromPropertyFile("username");
//	String password = plib.toReadDataFromPropertyFile("password");
	
//	WebDriver driver=null;
//	driver=wlib.webdriverLaunch(browser);
//	wlib.maxBrowser(driver);
//	
//    driver.get(url);
//	Login_object login=new Login_object(driver);
//	login.loginAction(username,password);

	UtilityClassObject.getTest().log(Status.INFO,"Navigate to organization page");
	HomePage_object home=new HomePage_object(driver);
	home.getOrganization().click();
	
	UtilityClassObject.getTest().log(Status.INFO, "Navigate to create organization");
	Organization_object org=new Organization_object(driver);
	org.getCreateOrgButton().click();
	
	int randomNum = jlib.genRandomNumber();
	
	UtilityClassObject.getTest().log(Status.INFO, "Read data from Excel");
	String orgName = elib.readDataFromExcelFile("Organization", 1, 0)+randomNum;
	
	UtilityClassObject.getTest().log(Status.INFO, "create new organization");
	CreateNewOrg_object Name=new CreateNewOrg_object(driver);
	Name.getOrgnizationName().sendKeys(orgName);
	Name.getSaveButton().click();
	UtilityClassObject.getTest().log(Status.INFO, orgName+"====>Created new organization");
	
	Thread.sleep(2000);
	WebElement headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
	wlib.explicitWait(driver, headerInfo, 10);
	String confirmOrg = headerInfo.getText();
	boolean status = confirmOrg.contains(orgName);
	Assert.assertEquals(status, true);                        //using assertion
			//	if(confirmOrg.contains(orgName)) {
//		System.out.println(orgName +" is verfied and pass");
//	}
//	else {
//		System.out.println(orgName+" is not verified");
//	}
	
//	OrgInfo_object signout=new OrgInfo_object(driver);
//	Thread.sleep(3000);
//	signout.signOutAction();
//	
//	driver.quit();
	
}
	
	@Test(groups = {"ST","RT"})
	public void createOrgWithIndustry() throws Exception {
//		
//	WebdriverUtility wlib=new WebdriverUtility();
//	JavaUtility jlib=new JavaUtility();
//	PropertiesUtility plib=new PropertiesUtility();
//	ExcelUtility elib=new ExcelUtility();
	
//	String browser = plib.toReadDataFromPropertyFile("browser");
//	String url = plib.toReadDataFromPropertyFile("url");
//	String username = plib.toReadDataFromPropertyFile("username");
//	String password = plib.toReadDataFromPropertyFile("password");
//	
//	WebDriver driver=null;
//	driver=wlib.webdriverLaunch(browser);
//	wlib.maxBrowser(driver);
//	
//	driver.get(url);
//	Login_object login=new Login_object(driver);
//	login.loginAction(username,password);
	
	HomePage_object home=new HomePage_object(driver);
	home.getOrganization().click();
	
	Organization_object org=new Organization_object(driver);
	org.getCreateOrgButton().click();
	
	int randomNum = jlib.genRandomNumber();
	
//	CreateNewOrg_object cnew=new CreateNewOrg_object(driver);
	String orgName = elib.readDataFromExcelFile("Organization", 1, 0)+randomNum;
	String indName = elib.readDataFromExcelFile("Organization", 1, 1);

	
//	cnew.createOrgWithIndustry(orgName, indName);
	
	CreateNewOrg_object Name=new CreateNewOrg_object(driver);
	Name.getOrgnizationName().sendKeys(orgName);
	wlib.selectByDD(Name.getIndustry(), indName);
	Name.getSaveButton().click();
	
	Thread.sleep(2000);
	
	
	
//	WebElement headerInfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
//	wlib.explicitWait(driver, headerInfo, 10);

//	WebElement contact = home.getContacts();
//	wlib.explicitWait(driver, contact, 10);
	
//	OrgInfo_object oo=new OrgInfo_object(driver);
//	Thread.sleep(3000);
//	oo.signOutAction();
	
	}
	
	@Test(groups = "RT")
	public void createOrgWithPhone() throws Exception{
//		
//		WebdriverUtility wlib=new WebdriverUtility();
//		JavaUtility jlib=new JavaUtility();
//		PropertiesUtility plib=new PropertiesUtility();
//		ExcelUtility elib=new ExcelUtility();
//		
//		String browser = plib.toReadDataFromPropertyFile("browser");
//		String url = plib.toReadDataFromPropertyFile("url");
//		String username = plib.toReadDataFromPropertyFile("username");
//		String password = plib.toReadDataFromPropertyFile("password");
//		
//		WebDriver driver=null;
//		driver=wlib.webdriverLaunch(browser);
//		wlib.maxBrowser(driver);
//		
//		driver.get(url);
//		Login_object login=new Login_object(driver);
//		login.loginAction(username,password);
		
		HomePage_object hp=new HomePage_object(driver);
		hp.getOrganization().click();
		
		Organization_object oo=new Organization_object(driver);
		oo.getCreateOrgButton().click();
		
		String orgName = elib.readDataFromExcelFile("Organization", 1, 0)+jlib.genRandomNumber();
		String phoneNo=elib.readDataFromExcelFile("Organization", 1, 2);
		
		CreateNewOrg_object co=new CreateNewOrg_object(driver);
		co.createOrgWithPhone(orgName, phoneNo);
		
		Thread.sleep(2000);
		
//		OrgInfo_object orginfo=new OrgInfo_object(driver);
//		Thread.sleep(3000);
//		orginfo.signOutAction();
//		

	}

}

	
	
	
	


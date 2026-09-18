package com.vTiger.crm.organization;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesUtility;
import GenericUtility.WebdriverUtility;
import ObjectRepo.CreateNewOrg_object;
import ObjectRepo.HomePage_object;
import ObjectRepo.Login_object;
import ObjectRepo.OrgInfo_object;
import ObjectRepo.Organization_object;

public class createOrgWithPhoneNo {

	@Test
	public void createOrgWithPhone() throws Exception{
		
		WebdriverUtility wlib=new WebdriverUtility();
		JavaUtility jlib=new JavaUtility();
		PropertiesUtility plib=new PropertiesUtility();
		ExcelUtility elib=new ExcelUtility();
		
		String browser = plib.toReadDataFromPropertyFile("browser");
		String url = plib.toReadDataFromPropertyFile("url");
		String username = plib.toReadDataFromPropertyFile("username");
		String password = plib.toReadDataFromPropertyFile("password");
		
		WebDriver driver=null;
		driver=wlib.webdriverLaunch(browser);
		wlib.maxBrowser(driver);
		
		driver.get(url);
		Login_object login=new Login_object(driver);
		login.loginAction(username,password);
		
		HomePage_object hp=new HomePage_object(driver);
		hp.getOrganization().click();
		
		Organization_object oo=new Organization_object(driver);
		oo.getCreateOrgButton().click();
		
		String orgName = elib.readDataFromExcelFile("Organization", 1, 0)+jlib.genRandomNumber();
		String phoneNo=elib.readDataFromExcelFile("Organization", 1, 2);
		
		CreateNewOrg_object co=new CreateNewOrg_object(driver);
		co.createOrgWithPhone(orgName, phoneNo);
		
		OrgInfo_object orginfo=new OrgInfo_object(driver);
		Thread.sleep(3000);
		orginfo.signOutAction();
		

	}

}

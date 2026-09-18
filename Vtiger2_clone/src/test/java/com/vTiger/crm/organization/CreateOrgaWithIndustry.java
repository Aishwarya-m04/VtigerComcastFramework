package com.vTiger.crm.organization;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class CreateOrgaWithIndustry{

	@Test
	public void createOrgWithIndustry() throws Exception {
		WebdriverUtility wlib = new WebdriverUtility();
		JavaUtility jlib = new JavaUtility();
		PropertiesUtility plib = new PropertiesUtility();
		ExcelUtility elib = new ExcelUtility();

		String browser = plib.toReadDataFromPropertyFile("browser");
		String url = plib.toReadDataFromPropertyFile("url");
		String username = plib.toReadDataFromPropertyFile("username");
		String password = plib.toReadDataFromPropertyFile("password");

		WebDriver driver = null;
		driver = wlib.webdriverLaunch(browser);
		wlib.maxBrowser(driver);

		driver.get(url);
		Login_object login = new Login_object(driver);
		login.loginAction(username, password);

		HomePage_object home = new HomePage_object(driver);
		home.getOrganization().click();

		Organization_object org = new Organization_object(driver);
		org.getCreateOrgButton().click();

		int randomNum = jlib.genRandomNumber();

		CreateNewOrg_object cnew = new CreateNewOrg_object(driver);
		String orgName = elib.readDataFromExcelFile("Organization", 1, 0) + randomNum;
		String indName = elib.readDataFromExcelFile("Organization", 1, 1);

		cnew.createOrgWithIndustry(orgName, indName);

		WebElement contact = home.getContacts();
		wlib.explicitWait(driver, contact, 10);

		OrgInfo_object oo = new OrgInfo_object(driver);
		Thread.sleep(3000);
		oo.signOutAction();

	}
}

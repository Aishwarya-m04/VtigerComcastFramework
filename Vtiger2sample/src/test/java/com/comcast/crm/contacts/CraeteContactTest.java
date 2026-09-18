package com.comcast.crm.contacts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseTest.BaseClassTest;
import GenericUtility.DataBaseUtility;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesUtility;
import GenericUtility.WebdriverUtility;
import ObjectRepo.Contact_object;
import ObjectRepo.CreateNewContact_obj;
import ObjectRepo.HomePage_object;
import ObjectRepo.Login_object;
import ObjectRepo.OrgInfo_object;
import reportUtility.UtilityClassObject;

@Listeners(GenericUtility.ListnerImplementClass.class)
public class CraeteContactTest extends BaseClassTest{

         @Test(groups = "ST")
         public void createContactwithName() throws Exception
         {
	
//		WebdriverUtility wlib=new WebdriverUtility();
//		JavaUtility jlib=new JavaUtility();
//		DataBaseUtility dblib=new DataBaseUtility();
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
		
        UtilityClassObject.getTest().log(Status.INFO,"Navigate to Contact page");
		HomePage_object hp=new HomePage_object(driver);
		hp.getContacts().click();
		
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to create contact page");
		Contact_object create=new Contact_object(driver);
		create.getCreateContactButton().click();
		
		UtilityClassObject.getTest().log(Status.INFO,"read lastName from excel");
		String lastName = elib.readDataFromExcelFile("Contact", 1, 0);
		CreateNewContact_obj cnew=new CreateNewContact_obj(driver);
		cnew.createContactWithName(lastName);
		
//		OrgInfo_object oo=new OrgInfo_object(driver);
//		Thread.sleep(3000);
//		oo.signOutAction();
		
		
         }

    	     @Test(groups = "RT")
    	     public void createContactWithSupportDate() throws Exception{  
//    		WebdriverUtility wlib=new WebdriverUtility();
//    		JavaUtility jlib=new JavaUtility();
//    		PropertiesUtility plib=new PropertiesUtility();
//    		ExcelUtility elib=new ExcelUtility();
    	
//    		String browser = plib.toReadDataFromPropertyFile("browser");
//    		String url = plib.toReadDataFromPropertyFile("url");
//    		String username = plib.toReadDataFromPropertyFile("username");
//         	String password = plib.toReadDataFromPropertyFile("password");
    		
//    		WebDriver driver=null;
//    		driver=wlib.webdriverLaunch(browser);
//    		wlib.maxBrowser(driver);
//    		
//        	driver.get(url);
//    		Login_object login=new Login_object(driver);
//    	    login.loginAction(username,password);
    		
    		HomePage_object hp=new HomePage_object(driver);
    		hp.getContacts().click();
    		
    		Contact_object create=new Contact_object(driver);
    		create.getCreateContactButton().click();
    		
    		String lastName = elib.readDataFromExcelFile("Contact", 1, 0);
    		CreateNewContact_obj cnew=new CreateNewContact_obj(driver);
    		String reqdate = jlib.calenderDate(30);
    		cnew.getEndDate().clear();
    		cnew.getEndDate().sendKeys(reqdate);
    		cnew.createContactWithName(lastName);
    		
//    		OrgInfo_object oo=new OrgInfo_object(driver);
//    		oo.signOutAction();

    	     }	

    }

         
	




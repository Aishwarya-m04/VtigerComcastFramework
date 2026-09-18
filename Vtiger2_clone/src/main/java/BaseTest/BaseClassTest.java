package BaseTest;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertiesUtility;
import GenericUtility.WebdriverUtility;
import ObjectRepo.Login_object;
import ObjectRepo.OrgInfo_object;
import reportUtility.UtilityClassObject;

public class BaseClassTest {
	public WebDriver driver;
	public static WebDriver sdriver;      //to get driver instance in listnerimpementaClass
	//DataBaseUtility dlib=new DataBaseUtility();
	public JavaUtility jlib=new JavaUtility();
	public ExcelUtility elib=new ExcelUtility();
	public WebdriverUtility wlib=new WebdriverUtility();
	public PropertiesUtility plib=new PropertiesUtility();
	
	@BeforeSuite(groups = {"ST","RT"})
	public void configBS()
	{
		System.out.println("====Dtabase connection====");
		System.out.println("=====Report configration===");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"ST","RT"})
	public void configBC() throws Exception //String Browser insert this when doing parellel execution (crossBrowser only)
	{
		System.out.println("====launch the browser====");
		String Browser = plib.toReadDataFromPropertyFile("browser");
		driver=wlib.webdriverLaunch(Browser);
		
//		{
//			//String browser=Browser;
//			driver=wlib.webdriverLaunch(browser);
//		}
		
		sdriver = driver;
		UtilityClassObject.setDriver(driver);       ///to avoid disadvg of static var in parrallel excn used this from utility
     	wlib.maxBrowser(driver);
	}
	
	@BeforeMethod(groups = {"ST","RT"})
	public void configBM() throws Exception
	{
		System.out.println("====== Login ======");
		//store in a variable and call login method from login page
		String url = plib.toReadDataFromPropertyFile("url");
		
		driver.get(url);
		String username = plib.toReadDataFromPropertyFile("username");
		String password = plib.toReadDataFromPropertyFile(("password"));
		
		Login_object login=new Login_object(driver);
		login.loginAction(username, password);
		Reporter.log("Login done",true);
		
		
	}
	
	@AfterMethod(groups = {"ST","RT"})
	public void configAM()
	{
		System.out.println("=======Logout======");
		OrgInfo_object signout=new OrgInfo_object(driver);
		signout.signOutAction();
	}
	
	@AfterClass(groups = {"ST","RT"})
	public void configAC() 
	{
		System.out.println("=====Close the Browser=====");
		driver.quit();
	}
	
	@AfterSuite(groups = {"ST","RT"})
	public void configAS()
	{
		System.out.println("======Close database========");
		System.out.println("=====Report Backup========");
	}

}

package practise;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import GenericUtility.ListnerImplementClass;



public class ReportCreateContactprgm extends ListnerImplementClass{
	@Test
	public void createContact() {
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.29.4:8888/");
		
		
		
//		//Spark Report config
//		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
//		spark.config().setDocumentTitle("CRM test suite report");
//		spark.config().setReportName("CRM report");
//		spark .config().setTheme(Theme.DARK);
//		
//		//add environment info and create test
//		
//		ExtentReports report=new ExtentReports();
//		report.attachReporter(spark);
//		report.setSystemInfo("Browser", "Chrome-100");
//		report.setSystemInfo("OS", "window-10");
//		
		ExtentTest test = report.createTest("Create contact test");
		Reporter.log("This is from TestNg report",true);
		test.log(Status.INFO, "Login to app");
		test.log(Status.INFO, "navigate to app");
		if("HDFC".equals("HFFC")){
			test.log(Status.PASS, "Contact created");
		}
		else {
			//test.addScreenCaptureFromBase64String(filePath, "Errorfile");
			test.log(Status.FAIL, "contact is not created");
		}
	
//		report.flush();
		
		
	}

}

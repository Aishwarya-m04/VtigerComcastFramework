package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseTest.BaseClassTest;
import reportUtility.UtilityClassObject;

public class ListnerImplementClass implements ITestListener,ISuiteListener{
  // WebDriver driver;
   public ExtentSparkReporter spark;
   public  ExtentReports report;
   public ExtentTest test;
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		//Spark Report config
		String date = new Date().toString().replace(" ", "_").replace(":", "_");
				spark=new ExtentSparkReporter("./AdvanceReport/report_"+date+".html");
				spark.config().setDocumentTitle("CRM test suite report");
				spark.config().setReportName("CRM report");
				spark .config().setTheme(Theme.DARK);
				
				//add environment info and create test
				
				report=new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("Browser", "Chrome-100");
				report.setSystemInfo("OS", "window-10");
				
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report configuration");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		//System.out.println("========"+result.getMethod().getMethodName()+"========Start======");
		test=report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);   ///to avoid disadvg of static var in parrallel excn used this from utility
		test.log(Status.INFO, result.getMethod().getMethodName()+"========STARTED=======");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//System.out.println("========="+result.getMethod().getMethodName()+"=======End=======");
		test.log(Status.INFO,result.getMethod().getMethodName()+"=======COMPLETED=======" );
	}

	@Override
	public void onTestFailure(ITestResult result) {
	String TestName=result.getMethod().getMethodName();
//    TakesScreenshot ts=(TakesScreenshot)BaseClassTest.sdriver;       //to take normal screenShot
//    File src = ts.getScreenshotAs(OutputType.FILE);
//    String date = new Date().toString().replace(" ", "_").replace(":", "_");
//    File dest=new File("./Screenshot/"+TestName+"+"+date+".png");
//    try {
//		FileHandler.copy(src, dest);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
	//to take sc with ExtentReport
	
	TakesScreenshot ts=(TakesScreenshot)BaseClassTest.sdriver;
	String filePath=ts.getScreenshotAs(OutputType.BASE64);
	String date = new Date().toString().replace(" ", "_").replace(":", "_");
	test.addScreenCaptureFromBase64String(filePath, TestName+"_"+date);
	test.log(Status.FAIL, result.getMethod().getMethodName()+"=======FAILED=======");
    
	}

	

	
	
	

	
	

}

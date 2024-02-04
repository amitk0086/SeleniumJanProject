package com.Banking.Utilities;

import java.io.File;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class GenerateExtentReports {
	
	ExtentReports extent; //Specify the location of the report
	ExtentTest test; //what details should be populated in the report

	@BeforeTest
	public void startReport()
	{
		extent= new ExtentReports(System.getProperty("user.dir")+"/test-output/ownreport.html",true);
		extent.addSystemInfo("Host Name", "LocalHost");
		extent.addSystemInfo("Environmant", "QA");
		extent.addSystemInfo("User Name", "Amit");
		extent.loadConfig( new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}

	@Test
	public void demoReportPass()
	{
		test=extent.startTest("demoReportPass");
		Assert.assertTrue(true);
		test.log(LogStatus.PASS, "Assert pass as Condition is true");
	}
	
	@Test
	public void demoReportFail()
	{
		test=extent.startTest("demoReportFail");
		Assert.assertTrue(false);
		test.log(LogStatus.FAIL, "Assert failed as Condition is false");
	}
	
	@AfterMethod
	public void getResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getThrowable());
		}
		extent.endTest(test);
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
}

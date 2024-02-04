package com.Banking.Utilities;

import java.io.File;
import java.io.IOException;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.Banking.TestCases.BaseClass;

public class Listeners extends TestListenerAdapter{
	
	public void onTestStart(ITestResult tr)
	{
		System.out.println("On Test Start");
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		System.out.println("On Test Success");
	}

	public void onTestFailure(ITestResult tr)
	{
		
		BaseClass baseclass= new BaseClass();
		
		try {
			baseclass.captureScreenshots(tr.getMethod().getMethodName()+".png");
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		System.out.println("On Test Skipped");
	}
}

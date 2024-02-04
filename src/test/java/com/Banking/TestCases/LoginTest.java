package com.Banking.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Banking.PageObject.LoginPage;

public class LoginTest extends BaseClass {
	
	
	@Test
	public void loginPageTest()
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		
		logger.info("User Name Entered");
		
		lp.setPassword(password);
		
		logger.info("Password Entered");
		lp.clickbutton();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login is Successful");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Login is Failed");
		}
	}

}

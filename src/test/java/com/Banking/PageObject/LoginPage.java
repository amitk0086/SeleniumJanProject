package com.Banking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement clickbutton;
	
	
	public void setUserName(String name)
	{
		username.sendKeys(name);	
	}
	
	public void setPassword(String pass)
	{
		password.sendKeys(pass);	
	}
	
	public void clickbutton()
	{
		clickbutton.click();	
	}

}

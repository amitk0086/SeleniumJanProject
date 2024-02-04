package com.Banking.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.Banking.Utilities.ReadConfig;





public class BaseClass {
	
	ReadConfig readConfig = new ReadConfig();
	public String url=readConfig.getUrl();
	public String username=readConfig.getUserName();
	public String password=readConfig.getPassword();
	public static WebDriver driver;
	Logger logger;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String br)
	{
		if(br.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", readConfig.getChromepath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxpath());
			driver=new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readConfig.getIEpath());
			driver=new InternetExplorerDriver();
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		logger=logger.getLogger("Jan2024SeleniumProject");
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreenshots(String filename) throws IOException
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File desc= new File("./Screenshot"+filename);
		FileUtils.copyFile(src, desc);
	}

}

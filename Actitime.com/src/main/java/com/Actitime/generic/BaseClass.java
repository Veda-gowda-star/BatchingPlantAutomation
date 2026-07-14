package com.Actitime.generic;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	public WebDriver driver;
	@BeforeTest
	public void openbrowser()
	{
		Reporter.log("Opening browser",true);
	 driver=new ChromeDriver();
		driver.get("http://localhost/login.do");
	}
	
	@AfterTest
	public void closebrowser()
	{
		Reporter.log("Closing browser",true);
		driver.close();
		
	}
	
	@BeforeMethod
	public void login()
	{
		Reporter.log("Logged in",true);
	}
	
	@AfterMethod
	public void close()
	{
		Reporter.log("Logged out",true);
	}
	
}

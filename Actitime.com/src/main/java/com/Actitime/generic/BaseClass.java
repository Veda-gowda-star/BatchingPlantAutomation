package com.Actitime.generic;

import java.sql.Driver;
import java.time.Duration;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.openqa.selenium.By;
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
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
	}
	
	@AfterMethod
	public void close()
	{
		Reporter.log("Logged out",true);
	}
	
}

package com.myproj.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	public static int implicitWait = Integer.parseInt(prop.getProperty("implicitWait"));
	public static int pageLoadTimeOut = Integer.parseInt(prop.getProperty("pageLoadTimeOut"));
	
	
	public void loadConfig()
	{
		try 
		{
		prop = new Properties();
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir", "\\ConfigFiles\\config.properties"));
		prop.load(fileInputStream);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeTest
	public static void launchApp()
	{
		String browserName = prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if (browserName.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if (browserName.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeOut));	
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
		System.out.println("Tear Down Successfully");
	}

		

}

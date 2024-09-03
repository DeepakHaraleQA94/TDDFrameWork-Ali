package com.jala.qa.testbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.jala.qa.utility.TestUtils;

import jdk.internal.org.jline.utils.Log;



public class TestBase {
	public static Properties prop;
	public static FileInputStream file;
	public static WebDriver driver;
	public static Logger logger;
	public TestBase() throws IOException{
		 prop = new Properties();
		 
		 file = new FileInputStream("C:\\Users\\OM SAI AM\\eclipse-workspace\\Jala_ProjectsUsingHybridFramework\\src\\main\\java\\com\\jala\\qa\\property\\config.properties");
		prop.load(file);
	} 
	

	public void Initilization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		}
//		logger = LogManager.getLogger("JalaAcadamyTest");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtils.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
//		Log.info("url luanched");
	}
	
	public void holdtime() throws InterruptedException {
		Thread.sleep(3000);
	}
}

package com.jala.qa.testpage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.pages.LoginPage;
import com.jala.qa.testbase.TestBase;

public class HomeTestPage extends TestBase {
	LoginPage login;
	public HomeTestPage() throws IOException {
		super();
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		Initilization();
		 login = new LoginPage();
		 login.validateLoginCredential(prop.getProperty("Uname"), prop.getProperty("Pass"));
		 Thread.sleep(4000);
	}
	
	@Test
	public void vaildatHomePege() {
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, "https://magnus.jalatechnologies.com/Home/Index");
		Reporter.log("HomePage Url matched",true);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
		driver.quit();
	}

}

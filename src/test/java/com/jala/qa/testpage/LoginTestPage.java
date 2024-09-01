package com.jala.qa.testpage;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jala.qa.pages.LoginPage;
import com.jala.qa.testbase.TestBase;
import com.jala.qa.utility.TestUtils;

public class LoginTestPage extends TestBase{
	LoginPage login;
	public LoginTestPage() throws IOException {
		super();		
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		Initilization();
		holdtime();
		login = new LoginPage();
	}
	
	@Test(priority = 1)
	public void validatePageName() {
		String expected = "JALA Academy";
		String actual = login.checkLoginPageName();
		System.out.println(actual);
		Assert.assertEquals(actual, expected);
		Reporter.log("Login text matched",true);
		
	}
	
//	@Test(priority = 2, dataProvider = "testData", dataProviderClass = TestUtils.class)
	public void validateLoginCredential() throws InterruptedException {
		 login.validateLoginCredential(prop.getProperty("Uname"), prop.getProperty("Pass"));
		 holdtime();
		String actual = driver.getTitle();
		 Assert.assertEquals(actual, "Magnus");
		 Reporter.log("landing successfully on home page",true);

	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		holdtime();
		driver.close();
		driver.quit();
	}
	

}

package com.jala.qa.testpage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jala.qa.pages.CreateEmployeeDetailsPage;
import com.jala.qa.pages.HomePage;
import com.jala.qa.pages.LoginPage;
import com.jala.qa.testbase.TestBase;
import com.jala.qa.utility.TestUtils;

public class CreateEmployeeTestPage extends TestBase {
	LoginPage login;
	CreateEmployeeDetailsPage emp ;
	HomePage homepage;
	TestUtils util;
//	String SheetNum ="Sheet2";
	public CreateEmployeeTestPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws Exception {
		Initilization();
		 login = new LoginPage();
		 login.validateLoginCredential(prop.getProperty("Uname"), prop.getProperty("Pass"));
		 Thread.sleep(4000);
		 homepage = new HomePage();
		 homepage.createEmployee();
		  emp = new CreateEmployeeDetailsPage();
//		  util = new TestUtils();
	}
	
//	@DataProvider
//	public Object[][] data() {
//		Object testData[][]= {{"abc","xyz","bfg"},
//							{"pqr","stw","gg"}};
//		
//	return testData;	
//	}
	
	@DataProvider
	public Object[][] getData() throws IOException {
		 util = new TestUtils();
		Object data[][]= util.CollectDataFromExcel("Sheet2");
		System.out.println(data);
		return data;
	}
	
	@Test(dataProvider ="getData")
	public void validateEmployeeDetails(String Fname, String email) throws InterruptedException
	{
		
	
		boolean CheckIsEnable = emp.FirstName(Fname);
		Assert.assertTrue(CheckIsEnable);
		Reporter.log("we can able to enter into firstName field",true);
		
	
		emp.LasstName("dhs");
		
		emp.Email(email);
		emp.MobileNo("7684950475");
		emp.DOB("13/08/2024");
		emp.Gender();
		emp.Address("Maharashtra Pune");
		emp.selectCountry();
		emp.selectCity();
		emp.selectSkill();
		emp.saveBTN();
		
	}
	
//	@Test
//	public void validateCreateEmployeeInfo() {
//		emp.createDeatilsOfEmployee("xyz", "abc", "abc@gmail.com", "8765489345", "22/08/2024", "shivajinagar, pune");
//	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
		driver.quit();
	}
}

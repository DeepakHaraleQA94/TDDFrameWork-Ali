package com.jala.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.testbase.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(linkText = "JALA Academy")
	WebElement nameOfJala;
	
	@FindBy(id = "UserName")
	WebElement username;
	
	@FindBy(id = "Password")
	WebElement password;

	@FindBy(id = "btnLogin")
	WebElement loginbtn;
	
	public LoginPage()throws Exception{
		PageFactory.initElements(driver, this);
	}
	
	public String checkLoginPageName() {
		String actual = nameOfJala.getText();
//		System.out.println("login page name is :"+actual);
		return actual;
	}
	
	public void validateLoginCredential(String uname, String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginbtn.click();
		
		
	}
	 
}

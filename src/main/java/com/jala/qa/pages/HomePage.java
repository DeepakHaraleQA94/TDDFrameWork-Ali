package com.jala.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jala.qa.testbase.TestBase;

public class HomePage  extends TestBase {

	@FindBy(linkText = "Employee")
	WebElement employeeTab;
	
	@FindBy(linkText = "Create")
	WebElement createTab;
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void createEmployee() throws InterruptedException {
		employeeTab.click();
		Thread.sleep(4000);
		createTab.click();
	}
	
	
}

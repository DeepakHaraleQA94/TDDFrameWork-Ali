package com.jala.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.jala.qa.testbase.TestBase;

public class CreateEmployeeDetailsPage extends TestBase{
	
	@FindBy(id = "FirstName")
	WebElement firstName;
	
	@FindBy(id = "LastName")
	WebElement lastName;
	
	@FindBy(id = "EmailId")
	WebElement emailId;
	
	@FindBy(id = "MobileNo")
	WebElement mobileNO;
	
	@FindBy(id = "DOB")
	WebElement dob;
	
	@FindBy(id = "rdbMale")
	WebElement gender;
	
	@FindBy(id = "Address")
	WebElement address;
	
	@FindBy(id = "CountryId")
	WebElement countryId;
	
	@FindBy(id = "CityId")
	WebElement cityId;

	
	@FindBy(id = "chkSkill_5")
	WebElement aws;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement save;
	
	public CreateEmployeeDetailsPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean FirstName(String fname) {
		firstName.sendKeys(fname);
		boolean validateEnableTextField = firstName.isEnabled();
		
		return validateEnableTextField;
		
	}
	public void LasstName(String lname) {
		lastName.sendKeys(lname);
	}
	public void Email(String email) {
		emailId.sendKeys(email);
	}
	
	public void MobileNo(String mNuber) {
		mobileNO.sendKeys(mNuber);
	}
	
	public void DOB(String DOB) {
		dob.sendKeys(DOB);
	}
	
	public void Gender() {
		gender.click();
	}
	
	public void Address(String Address) {
		address.sendKeys(Address);
	}
	
	public void selectCountry() throws InterruptedException {
		Select select = new Select(countryId);
		select.selectByIndex(4);
		holdtime();
	}
	
	public void selectCity() {
		Select selectCity = new Select(cityId);
		selectCity.selectByIndex(6);
	}
	
	public void selectSkill() {
		aws.click();
	}
	
	public void saveBTN() {
		save.click();
	}
	
	
//	public void createDeatilsOfEmployee(String fname, String lname, String email,
//			String mNuber, String DOB, String Address ) {
//		firstName.sendKeys(fname);
//		lastName.sendKeys(lname);
//		emailId.sendKeys(email);
//		mobileNO.sendKeys(mNuber);
//		dob.sendKeys(DOB);
//		gender.click();
//		address.sendKeys(Address);
//		Select select = new Select(countryId);
//		select.selectByIndex(4);
//		
//		Select selectCity = new Select(cityId);
//		selectCity.selectByIndex(6);
//		aws.click();
//		save.click();
//	}

}

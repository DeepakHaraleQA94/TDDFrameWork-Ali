package com.jala.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jala.qa.testbase.TestBase;

public class TestUtils extends TestBase {
	public TestUtils() throws IOException {
		super();
		// TODO Auto-generated constructor stub

	}

	public static int IMPLICIT_WAIT = 15;
	String sData = "C:\\Users\\Ali\\Desktop\\GitHubCloningProject\\TDDFrameWork-Ali\\src\\main\\java\\com\\jala\\qa\\testdata\\Excel.xlsx";
	String EXCEL_SHEET_PATH = "C:\\Users\\OM SAI AM\\eclipse-workspace\\Jala_ProjectsUsingHybridFramework\\src\\main\\java\\com\\jala\\qa\\testdata\\Excel.xlsx";

//@DataProvider(name="testData")
//	public Object[][] data() {
//		Object testData[][]= {{"abc","xyz"},
//							{"pqr","stw"}};
//	return testData;	
//	}

	@DataProvider(name = "testData")

	public Object[][] CollectDataFromExcel() throws IOException {
		FileInputStream Findpath = new FileInputStream(sData);
		XSSFWorkbook action = new XSSFWorkbook(Findpath);
		XSSFSheet sheetName = action.getSheet("Sheet2");
		Object data[][] = new Object[sheetName.getLastRowNum()][sheetName.getRow(0).getLastCellNum()];

		for (int r = 0; r < sheetName.getLastRowNum(); r++) {

			for (int c = 0; c < sheetName.getRow(0).getLastCellNum(); c++) {
//			System.out.println(sheetName.getRow(r).getCell(c).toString());
				data[r][c] = sheetName.getRow(r).getCell(c).toString();
			}
		}
		return data;
	}

//user method to capture screen shot
	public File captureScreenShot(String testName) throws IOException {
		// step1: convert webdriver object to TakesScreenshot interface
		TakesScreenshot screenshot = ((TakesScreenshot) driver);

		// step2: call getScreenshotAs method to create image file

		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir") + "\\listner\\" + testName + ".png");

		// step3: copy image file to destination
		FileUtils.copyFile(src, dest);

		return dest;
	}

}
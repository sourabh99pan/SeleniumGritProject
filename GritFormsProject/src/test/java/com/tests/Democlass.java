package com.tests;
import com.aventstack.extentreports.ExtentReports;
import com.vsysq.base.*;
import com.vsysq.utilities.ExcelUtils;

import Generic_TestClass.ElementsGeneric;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;


public class Democlass extends TestBase {

	public static ExtentReports extent;
	private String sTestCaseName;
	private int iTestCaseRow;
	ElementsGeneric obj = new ElementsGeneric();
	SoftAssert sa = new SoftAssert();
	@Test(dataProvider = "DemoTest")
	 public void Elem_Check_FullName_textBox(String fullname, String email, String currAddress, String permAddress) throws InterruptedException, IOException,Throwable
	 {
		 //driver.navigate().to("https://demoqa.com/text-box");
		 //driver.findElement(By.id("userName")).
		 //driver.navigate().to("https://demoqa.com/text-box");
		 boolean name= driver.findElement(By.id("userName")).isDisplayed();
		 
		 System.out.println("Title of ToolsQA "+driver.getTitle());
		 //Assert.assertEquals(driver.getTitle(),"ToolsTTQA");
		 //sa.assertEquals(driver.getTitle(),"ToolsTTQA");
		 if(name==true)
		 {
			 System.out.println("Name is displayed");
		 }
		 else
		 {
			 System.out.println("Name is not displayed");
		 }
		 
		 obj.submitDet(fullname, email, currAddress, permAddress);
			
		 
			Thread.sleep(4000);
			//sa.assertAll();
	 }
	 
	@Test(dataProvider = "DemoTest")
	 public void Elem_Check_FullName_textBox_js(String fullname, String email, String currAddress, String permAddress) throws InterruptedException, IOException,Throwable
	 {
		 
		driver.navigate().to("https://demoqa.com/text-box");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		/*js.executeScript("document.getElementById('userName').value='sourabh99pan';");
		js.executeScript("document.getElementById('userEmail').value='rbc@xyz.com';");
		js.executeScript("document.getElementById('currentAddress').value='Ratlam';");
		js.executeScript("document.getElementById('permanentAddress').value='Thane';");
		js.executeScript("document.getElementById('submit').click();");*/
		
		js.executeScript("document.getElementById('userName').value='"+fullname+"';");
		js.executeScript("document.getElementById('userEmail').value='"+email+"';");
		js.executeScript("document.getElementById('currentAddress').value='"+currAddress+"';");
		js.executeScript("document.getElementById('permanentAddress').value='"+permAddress+"';");
		js.executeScript("document.getElementById('submit').click();");
		
		
			
		 
			Thread.sleep(4000);
			//sa.assertAll();
	 }
	 
	
	// Excel Data Picker
	@DataProvider(name = "DemoTest")
	public Object[][] Authentication() throws Exception {

		// Setting up the Test Data Excel file

		ExcelUtils.setExcelFile(System.getProperty("user.dir") + "/TestData/ToolsQAData.xlsx",
				"TestData");
		sTestCaseName = this.toString();
		System.out.println(sTestCaseName);
		sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
		System.out.println(sTestCaseName);
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, 0);
		
		System.out.println(iTestCaseRow);
		System.out.println(System.getProperty("user.dir"));
		Object[][] testObjArray = ExcelUtils.getTableArray(
				System.getProperty("user.dir") + "\\TestData\\ToolsQAData.xlsx", "TestData",
				iTestCaseRow);

		return (testObjArray);

	}
	
	/*@DataProvider(name = "DemoTest")
	public Map<String, String>  Authentication() throws Throwable {

		// Setting up the Test Data Excel file

		ExcelUtils.setExcelFile(System.getProperty("user.dir") + "/TestData/ToolsQAData.xlsx",
				"TestData");
		sTestCaseName = this.toString();
		System.out.println(sTestCaseName);
		sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
		System.out.println(sTestCaseName);
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, 0);
		
		System.out.println(iTestCaseRow);
		System.out.println(System.getProperty("user.dir"));
		Map<String, String>  mapValues = ExcelUtils.getExcelAsMap(
				System.getProperty("user.dir") + "\\TestData\\ToolsQAData.xlsx", "TestData",
				iTestCaseRow);

		return (mapValues);

	}*/
}

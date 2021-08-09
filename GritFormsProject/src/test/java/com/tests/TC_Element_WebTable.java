package com.tests;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.vsysq.base.TestBase;
import com.vsysq.utilities.ExcelUtils;

import Generic_TestClass.ElementsGeneric;

public class TC_Element_WebTable extends TestBase {
	
	public static ExtentReports extent;
	private String sTestCaseName;
	private int iTestCaseRow;
	ElementsGeneric obj = new ElementsGeneric();
	@Test
	public void webTabledata()
	{
		driver.findElement(By.id("item-3")).click();
        //Store the table size
        WebElement webtable = driver.findElement(By.xpath("//div[contains(@class,'ReactTable')]"));
        
        //Get rows which has data
        ArrayList<WebElement>rowsWithData = (ArrayList<WebElement>) webtable.findElements(By.xpath(".//div[contains(@class,'rt-td') and text()]/ancestor::div[contains(@class,'rt-tr-group')]"));
        
        //Print the whole web table
        System.out.println("Table Data is: ");
        outer: for(int rowIndex =0; rowIndex<rowsWithData.size(); rowIndex++) {
         System.out.println("Data of Row " + (rowIndex+1) + " is:");
         ArrayList<WebElement> colsWithData = (ArrayList<WebElement>)rowsWithData.get(rowIndex).findElements(By.xpath(".//div[@class='rt-td'][text()]"));
         
	         for(int colIndex =0; colIndex<colsWithData.size(); colIndex++)
	         {
	        	 System.out.println("Data at Cell with Row "+ (rowIndex+1) + " Column " + (colIndex+1) + " : "+ colsWithData.get(colIndex).getText());
	         		if(colsWithData.get(colIndex).getText().equalsIgnoreCase("Insurance"))
	         		{
	         			System.out.println("Insurance found");
	         			break outer;
	         		}
	         		
	         }
        }

	}
	
	@Test(dataProvider = "webTableData")
	public void addData_webTabledata(String firstName,String lastName, String Age, String Email, String Salary, String Department) throws InterruptedException, IOException,Throwable
	{
		driver.findElement(By.id("item-3")).click();
        //Store the table size
        
		Salary = Salary.replace(".0", "");
        obj.submitDetonWebTable(firstName,lastName,Age,Email,Salary,Department);
        
        


    	
	}
	
	// Excel Data Picker
	@DataProvider(name = "webTableData")
	public Object[][] Authentication1() throws Exception {

		// Setting up the Test Data Excel file

		ExcelUtils.setExcelFile(System.getProperty("user.dir") + "/TestData/ToolsQAData.xlsx",
				"WebTableData");
		sTestCaseName = this.toString();
		System.out.println(sTestCaseName);
		sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
		System.out.println(sTestCaseName);
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, 0);
		
		System.out.println(iTestCaseRow);
		System.out.println(System.getProperty("user.dir"));
		Object[][] testObjArray = ExcelUtils.getTableArray(
				System.getProperty("user.dir") + "\\TestData\\ToolsQAData.xlsx", "WebTableData",
				iTestCaseRow);

		return (testObjArray);

	}
}	

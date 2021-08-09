package com.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.vsysq.base.TestBase;

import Generic_TestClass.ElementsGeneric;

public class Droppable extends TestBase{
	
	public static ExtentReports extent;
	private String sTestCaseName;
	private int iTestCaseRow;
	ElementsGeneric obj = new ElementsGeneric();
	SoftAssert sa = new SoftAssert();
	
	@Test
	public void Interactions_Droppable() throws InterruptedException, IOException,Throwable
	 {
		 driver.get("https://demoqa.com/droppable/");
		 Actions builder = new Actions(driver);
		 
		 WebElement from = driver.findElement(By.id("draggable"));
		 
		 WebElement to = driver.findElement(By.id("droppable")); 
		 //Perform drag and drop
		 builder.dragAndDrop(from, to).perform();
		 
		 //verify text changed in to 'Drop here' box 
		 String textTo = to.getText();
		 
		 if(textTo.equals("Dropped!")) {
		 System.out.println("PASS: Source is dropped to target as expected");
		 }else {
		 System.out.println("FAIL: Source couldn't be dropped to target as expected");
		 }
			
		 
			Thread.sleep(4000);
			//sa.assertAll();
	 }
	 
}

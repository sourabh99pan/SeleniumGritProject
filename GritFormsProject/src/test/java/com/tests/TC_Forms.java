package com.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentReports;
import com.vsysq.base.TestBase;

import Generic_TestClass.ElementsGeneric;

public class TC_Forms extends TestBase{
	
	public static ExtentReports extent;
	private String sTestCaseName;
	private int iTestCaseRow;
	ElementsGeneric obj = new ElementsGeneric();
	
	 public void TC_001_Forms() throws InterruptedException, IOException
	 {
		 driver.get("https://demoqa.com/automation-practice-form");
		driver.findElement(By.id("firstName")).sendKeys("Sourabh");
		driver.findElement(By.id("lastName")).sendKeys("Pandya");
		

}

}
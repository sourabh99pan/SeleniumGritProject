package com.tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.vsysq.base.TestBase;

import Generic_TestClass.ElementsGeneric;

public class TC_Element_CheckBox extends TestBase{

	public static ExtentReports extent;
	private String sTestCaseName;
	private int iTestCaseRow;
	ElementsGeneric obj = new ElementsGeneric();
	@Test
	 public void TC_002_RadioButton() throws InterruptedException, IOException
	 {
		driver.findElement(By.id("item-2")).click();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("yesRadio"))).click().perform();
			
			Thread.sleep(4000);
			obj.radioBtnText("Yes");
			

	 }
	
	@Test
	 public void TC_003_RadioButton() throws InterruptedException, IOException
	 {
		driver.findElement(By.id("item-2")).click();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.id("impressiveRadio"))).click().perform();
			
			Thread.sleep(4000);
			obj.radioBtnText("Impressive");
			

	 }
	
}

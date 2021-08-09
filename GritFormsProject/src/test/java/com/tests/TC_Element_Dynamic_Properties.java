package com.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.vsysq.base.TestBase;

import Generic_TestClass.ElementsGeneric;

public class TC_Element_Dynamic_Properties extends TestBase {

	ElementsGeneric obj = new ElementsGeneric();
	
	@Test
	public void checkButton1() throws IOException, InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("window.scrollBy(0,2000)");
		 
		driver.findElement(By.id("item-8")).click();
				
		WebElement DP_Button = driver.findElement(By.id("enableAfter"));
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		 wait.until(ExpectedConditions.elementToBeClickable(DP_Button));
		 
		 obj.isDiplayed(DP_Button);
		 
		//WebElement DP_Button_col = driver.findElement(By.id("colorChange"));
		 
		// System.out.println(DP_Button_col.getAttribute("background-color"));
		 
		
	}
	
	@Test
	public void checkVisible() throws IOException, InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("window.scrollBy(0,2000)");
		 
		driver.findElement(By.id("item-8")).click();
				
		System.out.println("in checkVisible");
				
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
		 
		 WebElement DP_Vis_Button = driver.findElement(By.id("visibleAfter"));
		 
		 obj.isDiplayed(DP_Vis_Button);
		 
		
	}
	
	@Test
	public void checkVisibleFluent() throws IOException, InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		 js.executeScript("window.scrollBy(0,2000)");
		 
		driver.findElement(By.id("item-8")).click();
				
		System.out.println("in checkVisible");
				
		//WebDriverWait waitWebDriverbDriverWait(driver,10);
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.withMessage("RCV Academy: This is custom message")
				.ignoring(NoSuchElementException.class);
		
		 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter")));
		 
		 WebElement DP_Vis_Button = driver.findElement(By.id("visibleAfter"));
		 
		 obj.isDiplayed(DP_Vis_Button);
		 
		
	}
}

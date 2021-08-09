package com.vsysq.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.vsysq.base.ExtentTestManager;

public class OpportunityUserLoginPage {

	WebDriver driver;
	ExtentTest test = ExtentTestManager.getTest();
	
	// Setup Icon
	@FindBy(how = How.XPATH, using = "//a[@data-aura-rendered-by='81:229;a']")
	@CacheLookup
	WebElement SetupIcon;

	// Click on Setup Link
	@FindBy(how = How.XPATH, using = "(//span[text()='Setup'])[2]")
	@CacheLookup
	WebElement SetupLink;

	// Click on Setup Link
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search Setup']")
	@CacheLookup
	WebElement SearchSetup;

	// Click on Setup Login
	@FindBy(how = How.XPATH, using = "//td[@id='topButtonRow']//input[@name='login']")
	@CacheLookup
	WebElement SetupLogin;

	
	public OpportunityUserLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void ClickSetupIcon() throws InterruptedException {
	     try {
	    	 Thread.sleep(8000);
	    	 driver.findElement(By.xpath("//li[@data-aura-rendered-by='338:0;p']")).click();
	     }
	     catch(Exception e) {
	    	 driver.findElement(By.xpath("//li[@data-aura-rendered-by='338:0;p']")).click(); 

	     }	
	}

	public void ClickSetupLink() {
		try{
			SetupLink.click();
			test.pass("User clicked setup link successfully");
		}
		catch(Exception e){
			test.fail("Failed to Click Setup icon");
		}
	}

	public void SearchOpportunityOwner(String OpportunityOwner) throws InterruptedException {
		try{
		       ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		       Thread.sleep(5000);
		       driver.switchTo().window(tabs2.get(1));	
		       Thread.sleep(8000);
			   SearchSetup.click();
			   SearchSetup.sendKeys(OpportunityOwner);
		       Thread.sleep(4000);    
		       driver.findElement(By.xpath("(//ul[@class='lookup__list  visible']//li)[1]//a")).click();
		       Thread.sleep(2000);
		       driver.findElement(By.xpath("//input[@placeholder='Search Setup']")).sendKeys(Keys.ENTER);	
		       Thread.sleep(2000);	
		       test.pass("Opportunity Owner name '"+ OpportunityOwner +"'entered successfully in search box");
		}
		catch(Exception e){
			test.fail("Failed to search approver name in Setup Search box");
		}       
	}

	public void SetupLogin() throws InterruptedException {		
		try{
			Thread.sleep(8000);
			SetupLogin.click();
		}
		catch(Exception e){
			test.fail("Failed to click on Login button on Setup page");
		}
	}
}

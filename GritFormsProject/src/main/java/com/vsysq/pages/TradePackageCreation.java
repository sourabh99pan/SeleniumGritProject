package com.vsysq.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vsysq.base.ExtentTestManager;

public class TradePackageCreation {
	
	WebDriver driver;
	ExtentTest test = ExtentTestManager.getTest();
	
	public TradePackageCreation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="username")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(id="Login")
	@CacheLookup
	WebElement btnLogin;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//div[@class='loginError'][@id='error']")
	WebElement loginError;
	
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
			
			//Click on More Link
			@FindBy(how = How.XPATH, using = "//span[text()='More']")
			@CacheLookup
			WebElement MoreLink;
			
			//Click on Trade Packages
			@FindBy(how = How.XPATH, using = "(//span[text()='Trade Packages'])[2]/parent::*/parent::*")
			@CacheLookup
			WebElement TradePackageLink1;
			
			@FindBy(how = How.XPATH, using = "(//span[text()='Trade Packages'])[2]/parent::*")
			@CacheLookup
			WebElement TradePackageLink2;
			
			//Click on New Button
			@FindBy(how = How.XPATH, using = "//div[text()='New']")
			@CacheLookup
			WebElement New1;
			
			//Account Name
			@FindBy(how = How.XPATH, using = "//input[@placeholder='Search Accounts...']")
			@CacheLookup
			WebElement Account;
			
			//Select Account Name
			@FindBy(how = How.XPATH, using = "//tr[1]//td[1]//a")
			@CacheLookup
			WebElement AccountName;
			
			//Enter Contact Name
			@FindBy(how = How.XPATH, using = "//input[@title='Search Contacts']")
			@CacheLookup
			WebElement Contact;
			
			//Select Contact Name
			@FindBy(how = How.XPATH, using = "//tr[1]//td[1]//a")
			@CacheLookup
			WebElement ContactName;
			
			//Save Button
			@FindBy(how = How.XPATH, using = "(//span[text()='Save'])[2]")
			@CacheLookup
			WebElement Save1;	
			
			//Trade Package Type
			@FindBy(how = How.XPATH, using = "//button[@title='Edit Purchase Only']/span[1]")
			@CacheLookup
			WebElement TypeOfTP;	
			
			//Save Button
			@FindBy(how = How.XPATH, using = "//button[text()='Save']")
			@CacheLookup
			WebElement Save2;
			
			@CacheLookup
			@FindBy(how = How.XPATH, using = "//a[text()='Related']")
			WebElement RelatedTab;
			
			@CacheLookup
			@FindBy(how = How.XPATH, using = "//span[text()='Trade Package Line Items']/parent::a/span[1]")
			WebElement TPLILink;
			
			@CacheLookup
			@FindBy(how = How.XPATH, using = "(//div[@title='New'])[3]")
			WebElement New2;
			
		    //Actions act1=new Actions(driver);
			
			JavascriptExecutor js=(JavascriptExecutor)driver;
			
			
			 public void setUserName(String uname)
		    	{
		    		try{
		    			txtUserName.sendKeys(uname);
		    		}
		    		catch(Exception e){
		    			test.fail("Failed to enter user name");
		    			driver.quit();
		    		}		
		    	}
		    	
		    	public void setPassword(String pwd)
		    	{
		    		try{
		    			txtPassword.sendKeys(pwd);			
		    		}
		    		catch(Exception e){
		    			test.fail("Failed to enter password");
		    			driver.quit();
		    		}		
		    	}
		    	
		    	public void clickSubmit()
		    	{
		    		try{
		    			btnLogin.click();
		    		}
		    		catch(Exception e){
		    			test.fail("Failed to click login button");
		    			driver.quit();
		    		}
		    		
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

		   	public void SearchInitialUser(String InitialUser) throws InterruptedException {
		   		try{
		   		       ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
		   		       Thread.sleep(5000);
		   		       driver.switchTo().window(tabs2.get(1));	
		   		       Thread.sleep(8000);
		   			   SearchSetup.click();
		   			   SearchSetup.sendKeys(InitialUser);
		   		       Thread.sleep(4000);    
		   		       driver.findElement(By.xpath("(//ul[@class='lookup__list  visible']//li)[1]//a")).click();
		   		       Thread.sleep(2000);
		   		       driver.findElement(By.xpath("//input[@placeholder='Search Setup']")).sendKeys(Keys.ENTER);	
		   		       Thread.sleep(2000);	
		   		       test.pass("Opportunity Owner name '"+ InitialUser +"'entered successfully in search box");
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
		
		   	
		   	public void SelectTradePackage() throws Exception {
		   			Thread.sleep(8000);
		   			MoreLink.click();
		   			WebElement TP1=driver.findElement(By.xpath("(//span[text()='Trade Packages'])[2]/parent::*/parent::*"));
		   	        WebElement TP2=driver.findElement(By.xpath("(//span[text()='Trade Packages'])[2]/parent::*"));
		   	        //WebElement TP3=wd.findElement(By.xpath("(//*[@role='menuitemcheckbox'])[9]"));
		   	        //WebElement TP4=wd.findElement(By.xpath("//ONE-APP-NAV-BAR-MENU-ITEM/A[@role=\"menuitemcheckbox\" and normalize-space()=\"TPLI Valuation\"]"));
		   	     JavascriptExecutor js=(JavascriptExecutor)driver;


		   	         //Click on TP
		   	         Thread.sleep(6000);
		   	         try {
		   	        TP1.click();
		   	        	// js.executeScript("arguments[0].click();", TP1);
		   	         }
		   	         catch(Exception e) {
		   	        	 try {
		   	        	 TP2.click(); 
		   	        		// js.executeScript("arguments[0].click();", TP2);
		   	        	 }
		   	        	 catch(Exception f) {
		   	        		 try {
		   	        		//TP3.click(); 
		   	        		  // js.executeScript("arguments[0].click();", TP3);
		   	        		 }
		   	        		 catch(Exception g) {
		   	        			 System.out.println(" No Success");
		   	        		 }
		   	        	 }
		   	         }
		   	         

		   	         try {
		   	        // wd.findElement(By.xpath("//div//one-app-nav-bar-menu-button//span[text()='Trade Packages']/parent::*/parent::*")).click();
		   	        	 js.executeScript("arguments[0].click();", TP1);
		   	         }
		   	         catch(Exception e) {
		   	        	 try {
		   	        	// wd.findElement(By.xpath("//div//one-app-nav-bar-menu-button//span[text()='Trade Packages']/parent::*/")).click(); 
		   	        		 js.executeScript("arguments[0].click();", TP2);
		   	        	 }
		   	        	 catch(Exception f) {
		   	        		 try {
		   	        		// wd.findElement(By.xpath("(//*[@role='menuitemcheckbox'])[9]")).click(); 
		   	        		  // js.executeScript("arguments[0].click();", TP3);
		   	        		 }
		   	        		 catch(Exception g) {
		   	        			 System.out.println(" No Success 2");
		   	    		 
		   	        		 }
		   	        		 
		   	        	 }
		   	         }
//		   	         Click on New Button
		   	         Thread.sleep(8000);
		   		      New1.click();
		   		     }
		   	
		   	public void EnterAccount(String AccName) throws Exception {
		   		try{
		   			
		   			
		   		   Thread.sleep(8000);
		   	       driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']")).sendKeys(AccName);
		   	       Thread.sleep(8000);
		   	       driver.findElement(By.xpath("//input[@placeholder='Search Accounts...']")).sendKeys(Keys.ENTER);
		   	      Thread.sleep(8000);
		   	      driver.findElement(By.xpath("//tr[1]//td[1]//a")).click();
			   		
		   		}
		   		catch(Exception e){
		   			test.fail("Failed to enter Account Name");
		   		}
		   		
		  }
		   	
		   	public void EnterContact(String ContactNames) throws InterruptedException {
		   		try{
		   			Thread.sleep(8000);
		   	      driver.findElement(By.xpath("//input[@title='Search Contacts']")).sendKeys(ContactNames);
		   	      Thread.sleep(8000);
		   	      driver.findElement(By.xpath("//input[@title='Search Contacts']")).sendKeys(Keys.ENTER);
		   	     Thread.sleep(8000);
		   	     driver.findElement(By.xpath("//tr[1]//td[1]//a")).click();
		   		}
		   		catch(Exception e){
		   			test.fail("Failed to enter Contact Name");
		   		} 	
		   	}
		   	
		   	public void SaveClick1() throws InterruptedException {
				try{
					Thread.sleep(2000);
					Save1.click();			
				}
				catch(Exception e){
					test.fail("Failed to click on  Save Trade Package button");
				}
			}
		   	
		   	public void SelectTypeofTP(String Type)
		   	{
		   		try{
					Thread.sleep(10000);
					if(Type.equals("Purchase Only"))		
					{
						TypeOfTP.click();
						Thread.sleep(10000);
					   driver.findElement(By.xpath("//input[@name='Purchase_Only__c']")).click();
					   
					}
					
					else if(Type.equals("Intercompany Transfer")) 
					{
						driver.findElement(By.xpath("//button[@title='Edit Intercompany Transfer']")).click();
						Thread.sleep(5000);
					    driver.findElement(By.xpath("//input[@name='Intercompany_Transfer__c']")).click();
						
					}
					
					else if(Type.equals("Program Agreement"))
					{
						driver.findElement(By.xpath("//button[@title='Edit Program Agreement']")).click();
						Thread.sleep(5000);
					    driver.findElement(By.xpath("//input[@name='Program_Agreement__c']")).click();
					}
					
					else
						
					{
						driver.findElement(By.xpath("//button[@title='Edit New Equipment Oppty Associated']")).click();
						Thread.sleep(5000);
					    driver.findElement(By.xpath("//input[@name='New_Equipment_Oppty_Associated__c']")).click();
					}
					Thread.sleep(6000);
					Save2.click();
				}
				catch(Exception e){
					test.fail("Failed to select Type of Trade Package");
				}
		   	}
		   	
		   	
		   	public void ClickRelatedTab()
			{
				try{
					Thread.sleep(10000);
					RelatedTab.click();
		   			test.pass("User clicked related tab link successfully");

				}
				catch(Exception e){
					test.fail("Failed to select Related Tab");
					
				}		
			}
		   	
//		    public void ClickTPLItemLink()
//			{
//				try{
//					Thread.sleep(6000);
//				     act1.moveToElement(TPLILink).click().build().perform();
//				     Thread.sleep(8000);
//				     New2.click();
//			   	     test.pass("User clicked TPLI link and new button successfully");
//		
//				}
//				catch(Exception e){
//					test.fail("Failed to click on TPLI link and new button");
//					
//				}		
//			}
		   
			
}

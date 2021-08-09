package com.vsysq.pages;

import java.util.ArrayList;
import java.util.List;

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

public class Valuation {
	WebDriver driver;
	ExtentTest test = ExtentTestManager.getTest();
	
	public Valuation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//button[@title='Edit Trade Package Stage'])[2]")
	WebElement Stage;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//label[text()='Trade Package Stage']/following-sibling::div/lightning-base-combobox//input")
	WebElement StageClick;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[text()='02 Valuation']/parent::*/parent::lightning-base-combobox-item/span/span")
	WebElement ValuationClick;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	WebElement Save3;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[text()='More']")
	WebElement More3;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//span[text()='TPLI Valuation'])[2]/parent::*/parent::*")
	WebElement TPLIValuation1;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//span[text()='TPLI Valuation'])[2]/parent::*")
	WebElement TPLIValuation2;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Log out as')]")
	WebElement Logout;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//table[@id='j_id0:formId:pgBlckId:reloadPageBlockTable']")
	WebElement TogetRows;
	
	
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	
	public void ChangeStage1() throws Exception {
   		try{
   			Thread.sleep(10000);
   		    Stage.click();
   		    Thread.sleep(10000);
   		    StageClick.click();
   		    Thread.sleep(15000);
   		    //ValuationClick.click();
   		 Actions act=new Actions(driver);
   		 try {
         act.moveToElement(driver.findElement(By.xpath("//span[text()='02 Valuation']/parent::*/parent::lightning-base-combobox-item/span/span"))).click().build().perform();
   		 }
   		 catch(Exception e) {
   			 System.out.println("Action hover didn't work");
   			 Thread.sleep(5000);
   	 		 try {
   	 			ValuationClick.click();
   	    		 }
   	    		 catch(Exception f) {
   	    			 System.out.println("Normal click didn't work");
   	    		 }
   		 }
//   		 JavascriptExecutor js=(JavascriptExecutor)driver;
//   		    WebElement VC=driver.findElement(By.xpath("//span[text()='02 Valuation']"));
//   		 js.executeScript("arguments[0].click();", VC);
   		 Thread.sleep(5000);
   		    Save3.click();
	   		
   		}
   		catch(Exception e){
   			test.fail("Failed to change stage to Valuation");
   		}
   		
  }
   	
	public void SelectTPLIValuation() throws Exception {
		
		       More3.click();
	      
//	      //Click on TPLI Valuation
	      WebElement TPLI1=driver.findElement(By.xpath("(//span[text()='TPLI Valuation'])[2]/parent::*/parent::*"));
	      WebElement TPLI2=driver.findElement(By.xpath("(//span[text()='TPLI Valuation'])[2]/parent::*"));
//	      
	      JavascriptExecutor js=(JavascriptExecutor)driver;
      Thread.sleep(6000);
	      try {
           TPLI1.click();
     	
      }
      catch(Exception e) {
     	 try {
     	 TPLI2.click(); 
	     		
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
	     	 js.executeScript("arguments[0].click();", TPLI1);
	      }
	      catch(Exception e) {
	     	 try {
	     		 js.executeScript("arguments[0].click();", TPLI2);
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
			
		  }
	
	
	public void Logout() throws InterruptedException
	{
		Thread.sleep(5000);
		Logout.click();
		
	}
	
	
	public void FillValuationValues(String rouseFLV, String rbLatest, String BookValue, String rouseOLV, String rouseFMV, String suggestedRP) throws Exception
	{
		Thread.sleep(10000);
		List<WebElement>TotalRowsList = TogetRows.findElements(By.tagName("tr"));
		System.out.println("Total number of Rows in the table are : "+ TotalRowsList.size());
		int rowNum=TotalRowsList.size();
		for (int i = 1; i <rowNum ; i++) {
			WebElement thirdCell = driver.findElement(By.xpath("//table[@id='j_id0:formId:pgBlckId:reloadPageBlockTable']/tbody/tr[" + i +"]/td[2]"));	
	   	 	System.out.println(thirdCell.getText());
	   	 	if (thirdCell.getText().equalsIgnoreCase(TPLICreation.TPNo)) {
	   	 		//rouseFLV
	   	 		Thread.sleep(5000);
	   	 		driver.findElement(By.xpath("//table[@id='j_id0:formId:pgBlckId:reloadPageBlockTable']/tbody/tr[" + i +"]/td[8]/input[1]")).sendKeys(rouseFLV);
	   	 		//rblatest
	   	 		Thread.sleep(5000);
	   	 		driver.findElement(By.xpath("//table[@id='j_id0:formId:pgBlckId:reloadPageBlockTable']/tbody/tr[" + i +"]/td[9]/input[1]")).sendKeys(rbLatest);
	   	 		//Book Value
	   	 		Thread.sleep(5000);

	   	 		driver.findElement(By.xpath("//table[@id='j_id0:formId:pgBlckId:reloadPageBlockTable']/tbody/tr[" + i +"]/td[12]/input[1]")).sendKeys(BookValue);
	   	 		//rouse OLV
	   	 		Thread.sleep(5000);

	   	 		driver.findElement(By.xpath("//table[@id='j_id0:formId:pgBlckId:reloadPageBlockTable']/tbody/tr[" + i +"]/td[14]/input[1]")).sendKeys(rouseOLV);
	   	 		//rouse FMV
	   	 		Thread.sleep(5000);

	   	 		driver.findElement(By.xpath("//table[@id='j_id0:formId:pgBlckId:reloadPageBlockTable']/tbody/tr[" + i +"]/td[15]/input[1]")).sendKeys(rouseFMV);
	   	 		//suggested retail price
	   	 		Thread.sleep(5000);

	   	 		driver.findElement(By.xpath("//table[@id='j_id0:formId:pgBlckId:reloadPageBlockTable']/tbody/tr[" + i +"]/td[18]/input[1]")).sendKeys(suggestedRP);
	   	 		Thread.sleep(5000);

	   	 		driver.findElement(By.xpath("//td[@class='pbButtonb ']/input[@value='Save']")).click();
	   	 		
	   			break;
	   		}
	      
	            }
	   	
			
		}
	
	public void SelectTradePackage() throws Exception {
			Thread.sleep(8000);
			More3.click();
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
	         }}
	public void SearchTP() 
	{
		try {
		Thread.sleep(10000);
	      driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(TPLICreation.TPNo);
	      driver.findElement(By.xpath("//input[@placeholder='Search this list...']")).sendKeys(Keys.ENTER);
	      Thread.sleep(8000);
	      driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']/tbody[1]/tr/th/span/a")).click();
	}
		catch(Exception e)
		{
			test.fail("Failed to search the Trade Package");
		}
	}
	
	public void UEQValuationCheck()
	{
		try {
		      Thread.sleep(8000);
		      JavascriptExecutor js=(JavascriptExecutor)driver;
	          WebElement UEQVal=driver.findElement(By.xpath("//button[@title='Edit Valuated by UEQ']"));
	          js.executeScript("arguments[0].scrollIntoView();", UEQVal);
	          js.executeScript("arguments[0].click();", UEQVal);
	          Thread.sleep(9000);
	          WebElement UEQcb=driver.findElement(By.xpath("//input[@name='Valuated_by_UEQ__c']"));
	          js.executeScript("arguments[0].click();", UEQcb);
	          Thread.sleep(8000);
 		      driver.findElement(By.xpath("//button[text()='Save']")).click();
	      
	      
	}catch(Exception e)
		{
		  test.fail("Failed to check UEQ Checkbox");
		}
	}
	
	public void FinanceApproval()
	{
		try {
			Thread.sleep(8000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement Stage1=driver.findElement(By.xpath("//button[@title='Edit Trade Package Stage']"));
			js.executeScript("arguments[0].scrollIntoView();", Stage1);
            js.executeScript("arguments[0].click();", Stage1);
            WebElement StageClick=driver.findElement(By.xpath("//label[text()='Trade Package Stage']/following-sibling::div//input"));
            js.executeScript("arguments[0].click();", StageClick);
            Thread.sleep(10000);
            WebElement FA=driver.findElement(By.xpath("//span[text()='03 Finance Approval']"));
            js.executeScript("arguments[0].click();", FA);
            Thread.sleep(5000);
            driver.findElement(By.xpath("//button[text()='Save']")).click();
		    Thread.sleep(8000);
		    WebElement FinanceApp=driver.findElement(By.xpath("//button[@title='Edit Trade Package Stage']"));
		    js.executeScript("arguments[0].scrollIntoView();", FinanceApp);
		    js.executeScript("arguments[0].click();", FinanceApp);
		    Thread.sleep(9000);
		    WebElement FinanceCb=driver.findElement(By.xpath("//input[@name='Approved_by_Finance__c']"));
		    js.executeScript("arguments[0].click();", FinanceCb);
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("//button[text()='Save']")).click();
            
		}catch(Exception e)
		{
			test.fail("User failed to click on finance approval and check the approval checkbox");
		}
	}
	
	public void CustomerApproval()
	{
		try
		{
			Thread.sleep(8000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement Stage1=driver.findElement(By.xpath("//button[@title='Edit Trade Package Stage']"));
			js.executeScript("arguments[0].scrollIntoView();", Stage1);
            js.executeScript("arguments[0].click();", Stage1);
            WebElement StageClick=driver.findElement(By.xpath("//label[text()='Trade Package Stage']/following-sibling::div//input"));
            js.executeScript("arguments[0].click();", StageClick);
            Thread.sleep(10000);
            WebElement CA=driver.findElement(By.xpath("//span[text()='04 Customer Approval']"));
            js.executeScript("arguments[0].click();", CA);
            Thread.sleep(5000);
            driver.findElement(By.xpath("//button[text()='Save']")).click();
            Thread.sleep(8000);
            WebElement ApprovalDate=driver.findElement(By.xpath("//button[@title='Edit Customer Approval Date']"));
            js.executeScript("arguments[0].scrollIntoView();", ApprovalDate);
            js.executeScript("arguments[0].click();", ApprovalDate);
            Thread.sleep(9000);
            WebElement DateClick= driver.findElement(By.xpath("//input[@name='Customer_Approval_Date__c']"));
            js.executeScript("arguments[0].click();", DateClick);
            Thread.sleep(6000);
            WebElement TodayClick=driver.findElement(By.xpath("//*[text()='Today']"));
            js.executeScript("arguments[0].click();", TodayClick);
            Thread.sleep(5000);
		     driver.findElement(By.xpath("//button[text()='Save']")).click();
		}catch(Exception e)
		{
			test.fail("User failed to click on customer approval and select the approval date");
		}
	}
	
	public void POCreation(String PONumber)
	{
		try
		{
			Thread.sleep(8000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			WebElement Stage1=driver.findElement(By.xpath("//button[@title='Edit Trade Package Stage']"));
			js.executeScript("arguments[0].scrollIntoView();", Stage1);
            js.executeScript("arguments[0].click();", Stage1);
            WebElement StageClick=driver.findElement(By.xpath("//label[text()='Trade Package Stage']/following-sibling::div//input"));
            js.executeScript("arguments[0].click();", StageClick);
            Thread.sleep(10000);
            WebElement POCreation=driver.findElement(By.xpath("//span[text()='05 PO Creation']"));
            js.executeScript("arguments[0].click();", POCreation);
            Thread.sleep(5000);
            driver.findElement(By.xpath("//button[text()='Save']")).click();
		    Thread.sleep(10000);
		    WebElement TMSClick=driver.findElement(By.xpath("//button[@title='Edit Ready for TMS']"));
		    js.executeScript("arguments[0].scrollIntoView();", TMSClick);
		    js.executeScript("arguments[0].click();", TMSClick);
		    Thread.sleep(9000);
	        WebElement TMSCb=driver.findElement(By.xpath("//input[@name='Ready_for_TMS__c']"));
	        js.executeScript("arguments[0].click();", TMSCb);
	        Thread.sleep(9000);
	        driver.findElement(By.xpath("//input[@name='Trade_PO_Number__c']")).sendKeys(PONumber);
	        Thread.sleep(5000);
	        driver.findElement(By.xpath("//button[text()='Save']")).click();
            
	}catch(Exception e)
		{
		test.fail("User failed to click on PO Creation and select the Ready for TMS checkbox");
		}
}}
	  
	  
	 



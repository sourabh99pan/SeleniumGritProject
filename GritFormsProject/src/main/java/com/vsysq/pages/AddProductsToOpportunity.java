package com.vsysq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.ExtentTest;
import com.vsysq.base.ExtentTestManager;

public class AddProductsToOpportunity {


	WebDriver driver;
	ExtentTest test = ExtentTestManager.getTest();
	
	@FindBy(how = How.XPATH, using = "//one-app-nav-bar-item-root[@data-id='home']")
	@CacheLookup
	WebElement HomeMenu;
	
	//Opportunity Tab
	@FindBy(how = How.XPATH, using = "//one-app-nav-bar-item-root[@data-id='Opportunity']")
	@CacheLookup
	WebElement OpportunityTab;
	
	//Find Opportunity
	@FindBy(how = How.XPATH, using = "//input[@title='Search Opportunities and more']")
	@CacheLookup
	WebElement SearchOpportunity;	
	
	//Add/Remove/Edit Products button
	@FindBy(how = How.XPATH, using = "//div[text()='Add/Remove/Edit Products']")
	@CacheLookup
	WebElement AddProductsButton;
	

	
	@FindBy(how = How.XPATH, using = "//span[text()='Submit']")
	@CacheLookup
	WebElement FinalSubmit;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Log out as')]")
	@CacheLookup
	WebElement UserLogout;
	
	
public AddProductsToOpportunity(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}	

public void ClickOpportunityTab(){
	try {
		OpportunityTab.click();
	}
	catch(Exception e){
		test.fail("Failed to Click Opportunity Tab");
	}
	
}

public void SearchOpportunity(String OpportunityName) throws InterruptedException{
	try{
		SearchOpportunity.sendKeys(OpportunityName);
		Thread.sleep(2000);
		SearchOpportunity.sendKeys(Keys.ENTER);			
	}
	catch(Exception e){
		test.fail("Failed to search Opportunity name");
	}

}

public void SelectOpportunity(String OpportunityName){
	try{
		driver.findElement(By.xpath("(//div[@data-aura-class='forceInlineEditGrid'])[2]//table[@data-aura-class='uiVirtualDataTable']//a[text()='"
				+ OpportunityName + "']")).click();			
	}
	catch(Exception e){
		test.fail("Failed to select Opportunity from list of opportunities");
	}
	
}

public void AddProducts(){
	try{
		AddProductsButton.click();
		test.pass("User Clicked 'Add/Remove/Edit Products' button successfully");
	}
	catch(Exception e){
		test.fail("Failed to click on Add/Remove/Edit Products button");
	}
	
}

public void SelectProducts(int i){
	 JavascriptExecutor executor = (JavascriptExecutor)driver;
	try{
	    //Select Product checkbox
		
	    WebElement chkbx1 = driver.findElement(By.xpath("(//input[@type='checkbox'])["+i+"]"));
	    //chkbx1.click();
	    executor.executeScript("arguments[0].scrollIntoView(true);", chkbx1);
		executor.executeScript("arguments[0].click();", chkbx1); 
		test.pass("Item selected successfully");
	}
	catch(Exception e){
		test.fail("Failed to select Item from add products page");
	}
	
	try{		
		//Click Add Selected Products Button
	    WebElement AddProductsBtn = driver.findElement(By.xpath("(//input[@value='Add Selected Products'])[1]"));
	    AddProductsBtn.click();
	    
	    //executor.executeScript("arguments[0].scrollIntoView(true);", AddProductsBtn);
	    //executor.executeScript("arguments[0].click();", AddProductsBtn);
	    test.pass("'Add Selected Product' button clicked successfully");		
	}
	catch(Exception e){
		test.fail("Failed to click 'Add Selected Product' button on add products page");
	}
}
	
public void SelectByProductName(String product){
	
	 JavascriptExecutor executor1 = (JavascriptExecutor)driver;
		try{
		    //Select Product checkbox
		    WebElement chkbxPrdt = driver.findElement(By.xpath("(//span[contains(text(),'"+product+"')]"));
		    chkbxPrdt.click();
		    //executor1.executeScript("arguments[0].scrollIntoView(true);", chkbxPrdt);
			//executor1.executeScript("arguments[0].click();", chkbxPrdt); 
		    boolean exists = driver
					.findElements(By.xpath("//input[@name='j_id0:ProductEntryForm:selected:j_id72:0:j_id105']"))
					.size() != 0;
			if (exists) {
				WebElement SpecialDesign = driver
						.findElement(By.xpath("//input[@name='j_id0:ProductEntryForm:selected:j_id72:0:j_id105']"));
				SpecialDesign.click();
			}
			test.pass("Item selected successfully");
		}
		catch(Exception e){
			test.fail("Failed to select Item from add products page");
		}
		
		try{		
			//Click Add Selected Products Button
		    WebElement AddProductsBtn = driver.findElement(By.xpath("(//input[@value='Add Selected Products'])[1]"));
		    executor1.executeScript("arguments[0].scrollIntoView(true);", AddProductsBtn);
		    executor1.executeScript("arguments[0].click();", AddProductsBtn);
		    test.pass("'Add Selected Product' button clicked successfully");		
		}
		catch(Exception e){
			test.fail("Failed to click 'Add Selected Product' button on add products page");
		}		
}



public void PerformMarginAnalysis(String MarginAmount) throws InterruptedException{
    JavascriptExecutor executor1 = (JavascriptExecutor)driver;
    
    try{
        //Thread.sleep(5000);
        WebElement MarginAnalysis = driver.findElement(By.xpath("(//input[@type='checkbox'])[4]"));
        executor1.executeScript("arguments[0].scrollIntoView(true);", MarginAnalysis);
        executor1.executeScript("arguments[0].click();", MarginAnalysis);     	
        test.pass("Margin Analysis checkbox clicked successfully");	   	
    }
    catch(Exception e){
    	 test.fail("Margin Analysis checkbox not clicked");	 
    }
	    
    try{
        //Enter Amount After Discount
        Thread.sleep(4000);
        WebElement MarginAmountField = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
        executor1.executeScript("arguments[0].click();", MarginAmountField);  
        driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys(MarginAmount);
        test.pass("Margin Amount entered successfully");	    	
    }
    catch(Exception e){
    	test.pass("Margin Amount not entered in Input box");
    }

    try{
        WebElement CalculateBtn = driver.findElement(By.xpath("(//input[@value='Calculate'])[2]"));
        executor1.executeScript("arguments[0].click();", CalculateBtn); 
        test.pass("Calculate Button clicked successfully");	   	
    }
    catch(Exception e){
    	test.fail("Failed to click Calculate Button");	
    }

    try{
        //Click Save Button	    
        WebElement SaveBtn = driver.findElement(By.xpath("(//input[@value='Save'])[1]"));
        executor1.executeScript("arguments[0].click();", SaveBtn);     	
        test.pass("'Save' button clicked successfully");
        Thread.sleep(1000); 	
    }
    catch(Exception e){
    	test.fail("Failed to click Save Button");	
    }
	
}

public void DOAPercentage(String DOAPercentage, String commission) throws InterruptedException{
	JavascriptExecutor executor2 = (JavascriptExecutor)driver;
	try{
		WebElement AdditionalDiscountField = driver.findElement(By.xpath("//input[@name='j_id0:ProductEntryForm:selected:j_id72:0:j_id112']"));
		executor2.executeScript("arguments[0].scrollIntoView(true);", AdditionalDiscountField);
	    executor2.executeScript("arguments[0].click();", AdditionalDiscountField);  
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@name='j_id0:ProductEntryForm:selected:j_id72:0:j_id112']")).clear();
	    driver.findElement(By.xpath("//input[@name='j_id0:ProductEntryForm:selected:j_id72:0:j_id112']")).sendKeys(DOAPercentage);
	    Thread.sleep(1000);
	    if (commission != "") 
	    {
		    driver.findElement(By.xpath("//input[@name='j_id0:ProductEntryForm:selected:j_id72:0:j_id127']")).clear();
		    driver.findElement(By.xpath("//input[@name='j_id0:ProductEntryForm:selected:j_id72:0:j_id127']")).sendKeys(commission);
		    test.pass("Additional Discount variance entered successfully as '"+commission+"' on add products pag");
	    test.pass("Additional DOA Discount percentage entered successfully");	
	    }
	}
	catch(Exception e){
		test.pass("Failed to enter Additional DOA Discount percentage");
	}
    
    try{
        WebElement CalculateBtn = driver.findElement(By.xpath("(//input[@value='Calculate'])[2]"));
        executor2.executeScript("arguments[0].click();", CalculateBtn); 
        test.pass("Calculate Button clicked successfully");	   	
    }
    catch(Exception e){
    	test.fail("Failed to click Calculate Button");	
    }

    try{
        //Click Save Button	    
        WebElement SaveBtn = driver.findElement(By.xpath("(//input[@value='Save'])[1]"));
        executor2.executeScript("arguments[0].click();", SaveBtn);     	
        test.pass("'Save' button clicked successfully");
        Thread.sleep(1000); 	
    }
    catch(Exception e){
    	test.fail("Failed to click Save Button");	
    }
}

public void AddState(String State) throws InterruptedException{
	try{
		Thread.sleep(2000);
		JavascriptExecutor executor3 = (JavascriptExecutor)driver;	
		Select StateField = new Select (driver.findElement(By.xpath("//select[@id='j_id0:ProductEntryForm:selected:j_id72:0:j_id107']")));
		executor3.executeScript("arguments[0].scrollIntoView(true);", StateField);
		executor3.executeScript("arguments[0].scrollIntoView(true);", StateField);
		executor3.executeScript("arguments[0].click();", StateField);
		StateField.selectByIndex(1);		
		test.pass("Selected 'State' value as 'AL' on add products page successfully");
	}
	catch(Exception e){
		test.fail("Failed to select 'State' value on add products page");
	}
}

public void AddAdditionalDiscountVariance(String AdditionalDiscPerc) throws InterruptedException{
	JavascriptExecutor executor2 = (JavascriptExecutor)driver;
	try{
		WebElement AdditionalDiscountField = driver.findElement(By.xpath("//input[@name='j_id0:ProductEntryForm:j_id31:j_id32:j_id46']"));
		executor2.executeScript("arguments[0].scrollIntoView(true);", AdditionalDiscountField);
	    executor2.executeScript("arguments[0].click();", AdditionalDiscountField);  
	    driver.findElement(By.xpath("//input[@name='j_id0:ProductEntryForm:j_id31:j_id32:j_id46']")).clear();
	    driver.findElement(By.xpath("//input[@name='j_id0:ProductEntryForm:j_id31:j_id32:j_id46']")).sendKeys(AdditionalDiscPerc);
	    test.pass("Additional Discount variance entered successfully as '"+AdditionalDiscPerc+"' on add products pag");		
	}
	catch(Exception e){
		test.pass("Failed to enter Additional Discount variance value on add products page");	
	}
    
    try{
    	Thread.sleep(2000);
        //Click Save Button	    
        WebElement SaveBtn = driver.findElement(By.xpath("(//input[@value='Save'])[1]"));
        executor2.executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
        executor2.executeScript("arguments[0].click();", SaveBtn);     	
        test.pass("'Save' button clicked successfully");
        Thread.sleep(1000); 	
    }
    catch(Exception e){
    	test.fail("Failed to click Save Button");	
    }
    Thread.sleep(1000);
}

public void AddActualDiscountVariance(String ActualDiscPerc) throws InterruptedException{
	JavascriptExecutor executor2 = (JavascriptExecutor)driver;
	try{
		WebElement AdditionalDiscountField = driver.findElement(By.xpath("//input[@name='j_id0:ProductEntryForm:selected:j_id72:0:j_id115']"));
		executor2.executeScript("arguments[0].scrollIntoView(true);", AdditionalDiscountField);
	    executor2.executeScript("arguments[0].click();", AdditionalDiscountField);  
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@name='j_id0:ProductEntryForm:selected:j_id72:0:j_id115']")).clear();
	    driver.findElement(By.xpath("//input[@name='j_id0:ProductEntryForm:selected:j_id72:0:j_id115']")).sendKeys(ActualDiscPerc);
	    test.pass("Actual discount percentage entered successfully");		
	}
	catch(Exception e){
		test.pass("Failed to enter Actual discount percentage");	
	}
    
    try{
        WebElement CalculateBtn = driver.findElement(By.xpath("(//input[@value='Calculate'])[2]"));
        executor2.executeScript("arguments[0].click();", CalculateBtn); 
        test.pass("Calculate Button clicked successfully");	   	
    }
    catch(Exception e){
    	test.fail("Failed to click Calculate Button");	
    }

    try{
        //Click Save Button	    
        WebElement SaveBtn = driver.findElement(By.xpath("(//input[@value='Save'])[1]"));
        executor2.executeScript("arguments[0].click();", SaveBtn);     	
        test.pass("'Save' button clicked successfully");
        Thread.sleep(1000); 	
    }
    catch(Exception e){
    	test.fail("Failed to click Save Button");	
    }
}




public void SubmitForApproval(){
	JavascriptExecutor executor2 = (JavascriptExecutor)driver;
	try{
		//Click Submit for approval button
	    WebElement SubmitForApprovalBtn = driver.findElement(By.xpath("//div[text()='Submit for Approval']"));
	    executor2.executeScript("arguments[0].scrollIntoView(true);", SubmitForApprovalBtn);
	    executor2.executeScript("arguments[0].click();", SubmitForApprovalBtn); 
	    test.pass("'Submit for Approval' button clicked successfully");
	}
	catch(Exception e){
		test.pass("Fail to click 'Submit for Approval' button");
	}
 	    
}

public void FinalSubmit(){
	try{
		FinalSubmit.click();
		test.pass("'Submit' button on Approval popup clicked successfully");
	}
	catch(Exception e){
		test.pass("Failed to click 'Submit' button on Approval popup");
	}
}

public void UserLogout(){
	try{
		UserLogout.click();	
		test.pass("Successfully logged out from current user");
	}
	catch(Exception e){
		test.fail("Failed to log out from current user");
	}
	
}


}

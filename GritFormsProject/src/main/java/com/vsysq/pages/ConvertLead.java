package com.vsysq.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vsysq.base.ExtentTestManager;

public class ConvertLead {
	
	WebDriver driver;
	ExtentTest test = ExtentTestManager.getTest();
	
	public ConvertLead(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
		@CacheLookup
		@FindBy(how = How.XPATH, using = "//one-app-nav-bar-item-root[@data-id='Lead']")
		WebElement LeadTab;	
			
		
		//Search For Lead Name
		@FindBy(how = How.XPATH, using = "//input[@placeholder='Search Leads and more...']")
		@CacheLookup
		WebElement LeadName;
		
		//Lead Link
		@FindBy(how = How.XPATH, using = "(//a[text()='ABC XYZ'])[3]")
		@CacheLookup
		WebElement LeadLink;
		
		// Click on Setup Link
				@FindBy(how = How.XPATH, using = "//input[@placeholder='Search Setup']")
				@CacheLookup
				WebElement SearchSetup;
				
		// Click on Setup Login
				@FindBy(how = How.XPATH, using = "//td[@id='topButtonRow']//input[@name='login']")
				@CacheLookup
				WebElement SetupLogin;			
				
		By Setupbox = By.xpath("//input[@placeholder='Search Setup']");
		By ConvertButton=By.xpath("//div[text()='Convert']");
		By FinalConvertButton=By.xpath("//span[text()='Convert']");
		By GoToLeadsButton=By.xpath("//button[text()='Go to Leads']");
		By AccountsLink=By.xpath("//one-app-nav-bar-item-root[@data-id='Account']");
		By ContactLink=By.xpath("//one-app-nav-bar-item-root[@data-id='Contact']");
		By OpportunityLink=By.xpath("//one-app-nav-bar-item-root[@data-id='Opportunity']");
		
		By Logout = By.xpath("//a[contains(text(),'Log out as')]");
		
		public void SearchOpportunityOwner(String Queue_User) throws InterruptedException {
	   		try{
	   		       ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	   		       Thread.sleep(5000);
	   		       driver.switchTo().window(tabs2.get(1));	
	   		       Thread.sleep(8000);
	   			   SearchSetup.click();
	   			   SearchSetup.sendKeys(Queue_User);
	   		       Thread.sleep(4000);    
	   		       driver.findElement(By.xpath("//input[@placeholder='Search Setup']")).click();
	   		       Thread.sleep(2000);
	   		       driver.findElement(By.xpath("//input[@placeholder='Search Setup']")).sendKeys(Keys.ENTER);	
	   		       Thread.sleep(2000);	
	   		       test.pass("Opportunity Owner name '"+ Queue_User +"'entered successfully in search box");
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
		
		public void ClickLeadTab() throws InterruptedException {
			try{
				LeadTab.click();
				test.pass("User clicked Leads tab successfully");
			}
			catch(Exception e){
				test.fail("Failed to click on Leads Tab");		
			}
		}
		
		//Search Lead Name 
		public void SearchLead(String Lead_Name) throws InterruptedException{
			try{
				LeadName.sendKeys(Lead_Name);
				Thread.sleep(2000);
				LeadName.sendKeys(Keys.ENTER);
			}
			catch(Exception e){
				test.fail("Failed to search lead for conversion");			
			}
		}

		public void SelectLeadFromList(String Lead_Name){		
			try{
			    JavascriptExecutor executor = (JavascriptExecutor)driver;		    
			    WebElement Leadlink = driver.findElement(By.xpath("((//table)[2]//tr[1]//a[text()='"+Lead_Name+"'])[1]"));
			    //executor.executeScript("arguments[0].scrollIntoView(true);", Opportunitylink);
				executor.executeScript("arguments[0].click();", Leadlink);			
			}
			catch(Exception e){
				test.fail("Failed to select search lead for conversion");		
			} 		
		}
	
		public void ClickConvertButton(){
			try{
				driver.findElement(ConvertButton).click();
			}
			catch(Exception e){
				test.fail("Failed to click on Convert Button on lead page");
			}		
		}	
		public void ClickFinalConvertButton(){
			try{
				driver.findElement(FinalConvertButton).click();
			}
			catch(Exception e){
				test.fail("Failed to click on Convert Button on lead page");
			}		
		}	
		
		public void ClickGotoLeadsButton(){
			try{
				driver.findElement(GoToLeadsButton).click();
			}
			catch(Exception e){
				test.fail("Failed to click on Go to leads button");
			}		
		}	
		
		public void ClickUserLogoutLink(){
			try{
				driver.findElement(Logout).click();
				
				Thread.sleep(1000);
			}
			catch(Exception e){
				test.fail("Failed to logout from user");	
			}
			
		}	
}

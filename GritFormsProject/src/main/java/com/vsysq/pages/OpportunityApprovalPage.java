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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.vsysq.base.ExtentTestManager;

public class OpportunityApprovalPage {

	WebDriver driver;
	ExtentTest test = ExtentTestManager.getTest();
	//WebDriverWait wait = new WebDriverWait(driver, 60);
	//Setup Icon
	@FindBy(how = How.XPATH, using = "//div[@data-aura-rendered-by='75:202;a']")
	@CacheLookup
	WebElement SetupIcon;

	//Click on Setup Link
	@FindBy(how = How.XPATH, using = "//span[text()='Setup'])[2]")
	@CacheLookup
	WebElement SetupLink;
	
	//Click on Setup Link
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Search Setup']")
	@CacheLookup
	WebElement SearchSetup;
	
	//Click on Setup Login
	@FindBy(how = How.XPATH, using = "//div[@class='pbHeader']//table/tbody/tr/td[@class='pbButton']//input[@name='login']")
	@CacheLookup
	WebElement SetupLogin;
	
	//Select Opportunity
	@FindBy(how = How.XPATH, using = "((//a[@title='Opportunity2')")
	@CacheLookup
	WebElement OpportunityLink;	
	
	//Approval1 : 
	@FindBy(how = How.XPATH, using = "(//table[@data-aura-class='uiVirtualDataTable']//th[@tabindex='-1'])[3]//a")
	@CacheLookup
	WebElement Approval1;		
	
	@FindBy(how = How.XPATH, using = "(//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']/tbody/tr/td[1]/a[contains(text(),'John Flynn')]")
	@CacheLookup
	WebElement OpportunityUserClick;	
	
	By Setupbox = By.xpath("//input[@placeholder='Search Setup']");
	By OpportunityTab = By.xpath("//one-app-nav-bar-item-root[@data-id='Opportunity']");
	By ApprovalHistory = By.xpath("//a[@class='slds-card__header-link baseCard__header-title-container']//span[@title='Approval History']");
	By ApprovalButton = By.xpath("//div[text()='Approve']");
	By FinalApproveButton = By.xpath("//span[text()='Approve']");
	By UserLogoutLink = By.xpath("//a[contains(text(),'Log out as')]");
	
	public OpportunityApprovalPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	public void ClickSetupIcon() throws InterruptedException {
			Thread.sleep(5000);
	     try {
	    	 Thread.sleep(8000);
	    	 driver.findElement(By.xpath("//div[@data-aura-rendered-by='75:202;a']")).click();
	     }
	     catch(Exception e) {
	    	 driver.findElement(By.xpath("//div[@data-aura-rendered-by='75:202;a']")).click(); 

	     }	
	}	
	
	public void ClickSetupLink(){
		try{
			SetupLink.click();
		}
		catch(Exception e){
			test.fail("Failed to Click Setup icon");
		}		
	}
	
	public void SearchOpportunityOwner(String OpportunityOwner) throws InterruptedException{	
		try{
		       ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());	
		       Thread.sleep(2000);
		       driver.switchTo().window(tabs2.get(1));	
		       driver.findElement(Setupbox).click();
		       Thread.sleep(1000);
		       driver.findElement(Setupbox).sendKeys(OpportunityOwner);
		       Thread.sleep(6000);   
		       driver.findElement(By.xpath("(//ul[@class='lookup__list  visible']//li)[1]//a")).click();
		       Thread.sleep(3000);			
		}
		catch(Exception e){
			test.fail("Failed to search approver name in Setup Search box");
		}	       
	}
	
	public void SetupLogin() throws InterruptedException{
		try{
			SetupLogin.click();
		}
		catch(Exception e){
			test.fail("Failed to click on Login button on Setup page");
		}       
	}
	
	public void ClickOpportunityTab(){
		try{
			driver.findElement(OpportunityTab).click();
		}
		catch(Exception e){
			test.fail("Failed to click on Opportunity tab");
		}
	}
	
	public void OpenApprovalhistory(){
		try{
			//driver.findElement(ApprovalHistory).click();
			WebElement element = driver.findElement(ApprovalHistory);
			//in order to click a non visible element
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("arguments[0].click();", element);
	        
		}
		catch(Exception e){
			test.fail("Failed to click on Approval History on Opportunity page");
		}		
	}	
	
	public void ClickApproveButton(){
		try{
			driver.findElement(ApprovalButton).click();
		}
		catch(Exception e){
			test.fail("Failed to click on Approve button on Approval history page");
		}		
	}	
	
	public void SelectopportunityToApprove(){
		try{
			OpportunityLink.click();
		}
		catch(Exception e){
			test.fail("Failed to select opportunity for approval");
		}		
	}	
	
	public void ClickFinalApprovalButton(){
		try{
			driver.findElement(FinalApproveButton).click();
		}
		catch(Exception e){
			test.fail("Failed to click approve button on approval Popup");			
		}		
	}	
	
	public void ClickUserLogoutLink(){
		try{
			driver.findElement(UserLogoutLink).click();
			Thread.sleep(1000);
		}
		catch(Exception e){
			test.fail("Failed to logout from user");	
		}
		
	}
	
	public void SelectApproverName(String approverName){
		try{
			//driver.findElement(By.xpath("(//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']//tr)[2]//a[text()='"+approverName+"']")).click();
			driver.findElement(By.xpath("((//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']//tr)[2]/td/a)[1]")).click();
			Thread.sleep(1000);
		}
		catch(Exception e){
			test.fail("Failed to select Approver Name for login");
		}		
	}
	
	public void ClickLogin() throws InterruptedException{
		try{
			Thread.sleep(5000);	
			driver.findElement(By.xpath("(//input[@name='login'])[1]")).click();
			Thread.sleep(8000);			
		}
		catch(Exception e){
			test.fail("Failed to click on Login button");
		}
	}
	
	public void SearchOpportunity(String OpportunityName) throws InterruptedException{
		try{
			driver.findElement(By.xpath("//input[@title='Search Opportunities and more']")).sendKeys(OpportunityName);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@title='Search Opportunities and more']")).sendKeys(Keys.ENTER);
		}
		catch(Exception e){
			test.fail("Failed to search Opportunity for approval");			
		}
	}

	public void SelectOpportunityFromList(String OpportunityName){		
		try{
		    JavascriptExecutor executor = (JavascriptExecutor)driver;		    
		    WebElement Opportunitylink = driver.findElement(By.xpath("((//table)[2]//tr[1]//a[text()='"	+ OpportunityName + "'])[1]"));
		    //executor.executeScript("arguments[0].scrollIntoView(true);", Opportunitylink);
			executor.executeScript("arguments[0].click();", Opportunitylink);			
		}
		catch(Exception e){
			test.fail("Failed to select Opportunity for approval");		
		} 		
	}
	
public void anotheropportunityApprovalFlow(String OpportunityName) throws InterruptedException {
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[@title='Items to Approve']//following::a[@class='viewAllLink']")).click();
	Thread.sleep(6000);
	driver.findElement(By.xpath("(//a[@title='"+OpportunityName+"'])[1]")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//div[text()='Approve']")).click();
	Thread.sleep(5000);
}
}

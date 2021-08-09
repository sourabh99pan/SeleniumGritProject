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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentTest;
import com.vsysq.base.ExtentTestManager;
import org.openqa.selenium.Keys;


public class CreateLeadPage {
	
	
	
		WebDriver driver;
		ExtentTest test = ExtentTestManager.getTest();
		
		public CreateLeadPage(WebDriver driver) {
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
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		@CacheLookup
		@FindBy(how = How.XPATH, using = "//one-app-nav-bar-item-root[@data-id='Lead']")
		WebElement LeadTab;

		@CacheLookup
		@FindBy(how = How.XPATH, using = "//a[@class='forceActionLink']//div[@title='New']")
		WebElement NewButton;
		
		@CacheLookup
		@FindBy(how = How.XPATH, using = "//div[@class='salutation compoundTLRadius compoundTRRadius compoundBorderBottom form-element__row uiMenu']")
		WebElement Salutation;
		
		
		@CacheLookup
		@FindBy(how = How.XPATH, using = "//span[text()='First Name']/parent::label/following-sibling::input")
		WebElement FirstNameEnter;
		
		@CacheLookup
		@FindBy(how = How.XPATH, using = "//span[text()='Last Name']/parent::label/following-sibling::input")
		WebElement LastNameEnter;
		
		@CacheLookup
		@FindBy(how = How.XPATH, using = "//span[text()='Phone']/parent::label/following-sibling::input")
		WebElement PhoneNumberEnter;
		
		@CacheLookup
		@FindBy(how = How.XPATH, using = "//span[text()='Company']/parent::label/following-sibling::input")
		WebElement CompanyNameEnter;
		
		@CacheLookup
		@FindBy(how = How.XPATH, using = "//span[text()='Email']/parent::label/following-sibling::input")
		WebElement EmailNameEnter;
		
		@CacheLookup
		@FindBy(how = How.XPATH, using = "(//a[@class='select'])[8]")
		WebElement CustommerType;
		
		
		@CacheLookup
		@FindBy(how = How.XPATH, using = "(//a[@class='select'])[10]")
		WebElement BusinessUnitType;
		
		
		@CacheLookup
		@FindBy(how = How.XPATH, using = "(//span[text()='Save'])[2]")
		WebElement SaveButton;
		
        By Logout = By.xpath("//a[contains(text(),'Log out as')]");
        
        
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

   	public void SearchOpportunityOwner(String LeadOwner) throws InterruptedException {
   		try{
   		       ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
   		       Thread.sleep(5000);
   		       driver.switchTo().window(tabs2.get(1));	
   		       Thread.sleep(8000);
   			   SearchSetup.click();
   			   SearchSetup.sendKeys(LeadOwner);
   		       Thread.sleep(4000);    
   		       driver.findElement(By.xpath("(//ul[@class='lookup__list  visible']//li)[1]//a")).click();
   		       Thread.sleep(2000);
   		       driver.findElement(By.xpath("//input[@placeholder='Search Setup']")).sendKeys(Keys.ENTER);	
   		       Thread.sleep(2000);	
   		       test.pass("Opportunity Owner name '"+ LeadOwner +"'entered successfully in search box");
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

		public void ClickNewButton() throws InterruptedException {
			try{
				NewButton.click();
				Thread.sleep(3000);	
				test.pass("User clicked New Lead button successfully");
			}
			catch(Exception e){
				test.fail("Failed to click on New button on Lead page");
			}
		}
		public void enterSalutation(String Salutation_Name) {
			try{
				Salutation.click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//a[@title='"+ Salutation_Name +"']")).click();
				test.pass("User entered Salutation as '"+ Salutation_Name +"' successfully");
			}
			catch(Exception e){
				test.fail("Failed to enter Salutation on Lead page");
			}		
		}	
		public void enterFName(String First_Name) {
			try{
				FirstNameEnter.sendKeys(First_Name);
				test.pass("User entered First name as '"+ First_Name +"' successfully");
			}
			catch(Exception e){
				test.fail("Failed to enter First Name on Lead page");
			}		
		}	
		
		public void enterLName(String Last_Name) {
			try{
				LastNameEnter.sendKeys(Last_Name);
				test.pass("User entered Last name as '"+ Last_Name +"' successfully");
			}
			catch(Exception e){
				test.fail("Failed to enter Last Name on Lead page");
			}		
		}	
		
		public void enterPhoneNumber(String Phone) {
			try{
				PhoneNumberEnter.sendKeys(Phone);
				test.pass("User entered Phone Number as '"+ Phone +"' successfully");
			}
			catch(Exception e){
				test.fail("Failed to enter Phone Number on Lead page");
			}		
		}
		public void enterCompanyName(String Company) {
			try{
				CompanyNameEnter.sendKeys(Company);
				test.pass("User entered Company name as '"+ Company +"' successfully");
			}
			catch(Exception e){
				test.fail("Failed to enter Company Name on Lead page");
			}		
		}
		public void enterEmail(String EmailId) {
			try{
				EmailNameEnter.sendKeys(EmailId);
				test.pass("User entered Email ID as '"+ EmailId +"' successfully");
			}
			catch(Exception e){
				test.fail("Failed to enter Email Id on Lead page");
			}		
		}
		
	     public void enterCustType(String CustType) {
		        try{
			CustommerType.click();
				driver.findElement(By.xpath("//a[@title='"+ CustType +"']")).click();
				test.pass("User entered Customer Type as '"+ CustType +"' successfully");
		         }
			catch(Exception e){
				test.fail("Failed to enter Customer Type on Lead page");
			}		
		}
		
		public void enterBusinessUnitType(String BUType) {
			try{
				BusinessUnitType.click();
				Thread.sleep(5000);
				
				driver.findElement(By.xpath("//a[@title='"+BUType+"']")).click();
				String BU="//a[@title='"+BUType+"']";
				System.out.println("BUType===="+BU+"-----");
				
				test.pass("User entered Associated Business Unit Type as '"+ BUType +"' successfully");
				
			}
			catch(Exception e){
				test.fail("Failed to enter Associated Business Unit Type on Lead page");
			}		
		}
		
		public void ClickSaveButton() throws InterruptedException {
			try{
				SaveButton.click();
				Thread.sleep(3000);	
				test.pass("User clicked Save button successfully");
			}
			catch(Exception e){
				test.fail("Failed to click on Save button on Lead page");
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

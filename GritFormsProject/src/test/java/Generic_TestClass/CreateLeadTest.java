package Generic_TestClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.vsysq.base.ExtentTestManager;
import com.vsysq.base.TestBase;
import com.vsysq.pages.CreateLeadPage;
import com.vsysq.pages.CreateOpportunitiesPage;
import com.vsysq.utilities.ExcelUtils;

public class CreateLeadTest extends TestBase{

	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}
	@Test
	public void addNewLead(String user, String pwd,String LeadOwner,String Salutation_Name, String First_Name,String Last_Name,String Phone,
			 String Company, String EmailId, String CustType, String BUType) throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
			CreateLeadPage createLeads = new CreateLeadPage(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
			// Entering user Name
			createLeads.setUserName(user);
			test.pass("user name "+user+" entered successfully");

			// Entering Password
			createLeads.setPassword(pwd);
			test.pass("password entered successfully");

			// Click on login button
			createLeads.clickSubmit();

			// capturing Login Error if login failed
			if (driver.findElements(By.xpath("//div[@class='loginError'][@id='error']")).size() != 0) {

				captureScreen(driver, "LoginUnsuccessful");
				test.fail("Not logged into salesforce application refer the screenshot", MediaEntityBuilder
						.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/LoginUnsuccessful.png")
						.build());
				Assert.assertTrue(false);

			} else {

				// Dynamic wait to load page objects
				//wait.until(ExpectedConditions
						//.visibilityOfElementLocated(By.xpath("//one-app-nav-bar-item-root[@data-id='home']")));
				captureScreen(driver, "LoginSuccessful");
				test.pass("successfully logged in and navigated to home page", MediaEntityBuilder
						.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/LoginSuccessful.png")
						.build());
				Assert.assertTrue(true);

			}
		// wait function
				//wait.until(ExpectedConditions
						//.visibilityOfElementLocated(By.xpath("//one-app-nav-bar-item-root[@data-id='Home']")));
				
				// wait function
				Thread.sleep(5000);
				// click Setup
				createLeads.ClickSetupIcon();
				test.pass("User clicked setup icon successfully");

				// click setup link
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Setup'])[2]")));
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Setup'])[2]")));
				
				createLeads.ClickSetupLink();		
				
				// Search User
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//li[@data-aura-rendered-by='338:0;p']")));
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//li[@data-aura-rendered-by='338:0;p']")));
				createLeads.SearchOpportunityOwner(LeadOwner);
						
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']//tr)[2]//a[text()='"+LeadOwner+"']")));
				driver.findElement(By.xpath("(//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']//tr)[2]//a[text()='"+LeadOwner+"']")).click();
				
				// Switch Frame for Login
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));

				//Click Login button
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='login'])[1]")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='login'])[1]")));
				driver.findElement(By.xpath("(//input[@name='login'])[1]")).click();
				Thread.sleep(8000);
				captureScreen(driver, "OpportunityOwnerLoginSuccessful");
				test.pass("User "+ LeadOwner +" logged in successfully", MediaEntityBuilder
						.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/OpportunityOwnerLoginSuccessful.png")
						.build());
				Assert.assertTrue(true);		
		
				
				
		// click on LeadTab
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//one-app-nav-bar-item-root[@data-id='Lead']")));
				createLeads.ClickLeadTab();
				
		//Wait until New button appears
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//a[@class='forceActionLink']//div[@title='New']")));
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//a[@class='forceActionLink']//div[@title='New']")));		
				createLeads.ClickNewButton();
				
	// Enter Salutation			
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("(//a[@class='select'])[2]")));
				Thread.sleep(10000);
				createLeads.enterSalutation(Salutation_Name);
				
	//Enter First Name
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//span[text()='First Name']/parent::label/following-sibling::input")));	
				Thread.sleep(10000);
				createLeads.enterFName(First_Name);
				
	//Enter Last Name
				
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//span[text()='Last Name']/parent::label/following-sibling::input")));	
				Thread.sleep(10000);
				createLeads.enterLName(Last_Name);	
				
	// Enter Phone Number
				
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//span[text()='Phone']/parent::label/following-sibling::input")));		
				Thread.sleep(10000);
				createLeads.enterPhoneNumber(Phone);
				
	// Scroll to Company Name
				
				Thread.sleep(5000);
		          JavascriptExecutor js = (JavascriptExecutor) driver;
		          WebElement Element = driver.findElement(By.xpath("//span[text()='Company']"));
		          js.executeScript("arguments[0].scrollIntoView();", Element);
		          
	// Enter Company Name
		          wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//span[text()='Company']/parent::label/following-sibling::input")));	
		          Thread.sleep(10000);
					createLeads.enterCompanyName(Company);  
					
	// Enter Email Id
					wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//span[text()='Email']/parent::label/following-sibling::input")));	
					Thread.sleep(10000);
					createLeads.enterEmail(EmailId); 	
					
	 //Scroll to Customer Type				
					
					Thread.sleep(5000);
			          WebElement Element1 = driver.findElement(By.xpath("//span[text()='MP Customer Type']"));
			          js.executeScript("arguments[0].scrollIntoView();", Element1);   
			          
	// Select Customer Type
			          wait.until(ExpectedConditions
								.visibilityOfElementLocated(By.xpath("(//a[@class='select'])[8]")));
			          Thread.sleep(10000);
						createLeads.enterCustType(CustType);
						
	// Select Business Unit
						 wait.until(ExpectedConditions
									.visibilityOfElementLocated(By.xpath("(//a[@class='select'])[10]")));	
						 Thread.sleep(10000);
						 
							createLeads.enterBusinessUnitType(BUType);	
							
	// Click on Save Button
							
							createLeads.ClickSaveButton();	
							
	ExtentTestManager.getTest()
		.pass("Successfully entered relevent lead details and clicked on save button");
	
	if (driver.findElements(By.xpath("//span[@class='genericError uiOutputText']")).size() != 0) {
		Thread.sleep(3000);
		captureScreen(driver, "reviewElementError");
		ExtentTestManager.getTest().fail("Review Element Error present", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/reviewElementError.png")
				.build());
	}
	
	boolean res = driver.getPageSource().contains("was created");

	if (res == true) {
		Assert.assertTrue(true);

		captureScreen(driver, "Lead Created");
		ExtentTestManager.getTest().pass("MP lead is created successfully", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/OpportunityCreated.png")
				.build());
	} else {

		Thread.sleep(3000);
		captureScreen(driver, "Lead NotCreated");
		ExtentTestManager.getTest().fail("MP lead is not created successfully",
				MediaEntityBuilder
						.createScreenCaptureFromPath(
								System.getProperty("user.dir") + "/Screenshots/Opportunity NotCreated.png")
						.build());

		Assert.assertTrue(false);
	}
	Thread.sleep(12000);
	createLeads.ClickUserLogoutLink();
	
} 
	
}	
	

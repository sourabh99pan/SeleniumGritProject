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
import com.vsysq.pages.TPLICreation;
import com.vsysq.pages.TradePackageCreation;
import com.vsysq.utilities.ExcelUtils;

public class TradePackageCreationTest extends TestBase{
	
	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}
	@Test
	public void createTradePackage(String user, String pwd,String InitialUser,String AccName,String ContactNames, String Type) throws Exception {

		ExtentTest test = ExtentTestManager.getTest();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		TradePackageCreation createTP = new TradePackageCreation(driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
			// Entering user Name
			createTP.setUserName(user);
			test.pass("user name "+user+" entered successfully");

			// Entering Password
			createTP.setPassword(pwd);
			test.pass("password entered successfully");

			// Click on login button
			createTP.clickSubmit();

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
				createTP.ClickSetupIcon();
				test.pass("User clicked setup icon successfully");

				// click setup link
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Setup'])[2]")));
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Setup'])[2]")));
				
				createTP.ClickSetupLink();		
				
				// Search User
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//li[@data-aura-rendered-by='338:0;p']")));
				wait.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//li[@data-aura-rendered-by='338:0;p']")));
				createTP.SearchInitialUser(InitialUser);
						
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']//tr)[2]//a[text()='"+InitialUser+"']")));
				driver.findElement(By.xpath("(//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']//tr)[2]//a[text()='"+InitialUser+"']")).click();
				
				// Switch Frame for Login
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));

				//Click Login button
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='login'])[1]")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='login'])[1]")));
				driver.findElement(By.xpath("(//input[@name='login'])[1]")).click();
				Thread.sleep(8000);
				captureScreen(driver, "OpportunityOwnerLoginSuccessful");
				test.pass("User "+ InitialUser +" logged in successfully", MediaEntityBuilder
						.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/UEQUserLoginSuccessful.png")
						.build());
				Assert.assertTrue(true);
				
				//Wait for More Link
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='More']")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='More']")));
				createTP.SelectTradePackage();
				captureScreen(driver, "SelectTradePackage");
				test.pass("More link clicked and entered into Trade Packages tab", MediaEntityBuilder
						.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/SelectTradePackage.png")
						.build());
				Assert.assertTrue(true);
				
				//Enter Account
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search Accounts...']")));
			    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search Accounts...']")));
				createTP.EnterAccount(AccName);
				captureScreen(driver, "EnterAccount");
				test.pass("Account entered successfully", MediaEntityBuilder
						.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/EnterAccount.png")
						.build());
				Assert.assertTrue(true);
				
				//Enter Contact
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@title='Search Contacts']")));
				//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Search Contacts']")));
				createTP.EnterContact(ContactNames);
				captureScreen(driver, "EnterContact");
				test.pass("Contact entered successfully", MediaEntityBuilder
						.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/EnterContact.png")
						.build());
				Assert.assertTrue(true);
				
				//Click on Save Button
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Save'])[2]")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Save'])[2]")));
				createTP.SaveClick1();
				
				//Select Type of Trade Package
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Edit Purchase Only']/span[1]")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Edit Purchase Only']/span[1]")));
				createTP.SelectTypeofTP(Type);
				test.pass("Package Type selected successfully", MediaEntityBuilder
						.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/TradePackageType.png")
						.build());
				Assert.assertTrue(true);
				
				
				createTP.ClickRelatedTab();
				captureScreen(driver, "ClickRelatedtab");
				test.pass("Related Tab is clicked", MediaEntityBuilder
						.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/ClickRelatedtab.png")
						.build());
				Assert.assertTrue(true);
				

				
	}
	
	}

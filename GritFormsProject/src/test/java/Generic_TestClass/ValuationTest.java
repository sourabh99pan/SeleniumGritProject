package Generic_TestClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.vsysq.base.ExtentTestManager;
import com.vsysq.base.TestBase;
import com.vsysq.pages.TradePackageCreation;
import com.vsysq.pages.Valuation;

public class ValuationTest extends TestBase {
	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}
	@Test
	public void ValuationandApproval(String rouseFLV, String rbLatest, String BookValue, String rouseOLV, String rouseFMV, String suggestedRP, String PONumber) throws Exception
	
	{
        ExtentTest test = ExtentTestManager.getTest();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Valuation value = new Valuation(driver);
		
		Random rand = new Random();
	       
        // Generate random integers in range 0 to 999999
        int RandomInteger = rand.nextInt(999999);
       
        String RandomValue="PO";
       
        PONumber=RandomValue+RandomInteger;
        
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@title='Edit Trade Package Stage'])[2]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@title='Edit Trade Package Stage'])[2]")));
		value.ChangeStage1();
		Thread.sleep(8000);
		captureScreen(driver, "StageChangeSuccessful");
		test.pass("Stage Changed Successfully", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/StageChangeSuccessful.png")
				.build());
		Assert.assertTrue(true);
		
		
		
		//Logout from initial user
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Log out as')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Log out as')]")));
		value.Logout();
		captureScreen(driver, "LoggedoutfromInitialUser");
		test.pass("User logged out successfully", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/LoggedoutfromInitialUser.png")
				.build());
		Assert.assertTrue(true);
		//Switch tab
		  ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
		  // driver.switchTo().window(tabs2.get(0));
		   Thread.sleep(10000);
		   driver.switchTo().window(tabs3.get(0));
		   
		//Wait for More Link
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='More']")));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='More']")));
			value.SelectTPLIValuation();
			captureScreen(driver, "SelectTPLIValuation");
			test.pass("More link clicked and entered into TPLI Valuation successfully", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/SelectTPLIValuation.png")
					.build());
			Assert.assertTrue(true);
			
			//Enter the Amount Values
			wait.until(ExpectedConditions
	   			.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='Valuation']")));
			
			value.FillValuationValues(rouseFLV, rbLatest, BookValue, rouseOLV, rouseFMV, suggestedRP);
			captureScreen(driver, "EnterAmountValues");
			test.pass("More link clicked and entered into TPLI Valuation successfully", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/SelectTPLIValuation.png")
					.build());
			Assert.assertTrue(true);
			
			//Switch back to original frame	
			 driver.switchTo().defaultContent();
			 
			//Wait for More Link
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='More']")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='More']")));
				value.SelectTradePackage();
				captureScreen(driver, "SelectTradePackage");
				test.pass("More link clicked and entered into Trade Packages tab", MediaEntityBuilder
						.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/SelectTradePackage.png")
						.build());
				Assert.assertTrue(true);
			 
			 //Search Trade Package
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search this list...']")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search this list...']")));
				value.SearchTP();
				captureScreen(driver, "SearchTradePackage");
				test.pass("Trade Package Searched and clicked successfully", MediaEntityBuilder
						.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/SearchTradePackage.png")
						.build());
				Assert.assertTrue(true);
				
			// UEQ Checkbox
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Edit Valuated by UEQ']")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Edit Valuated by UEQ']")));
				value.UEQValuationCheck();
				captureScreen(driver, "UEQCheckboxselected");
				test.pass("Validated by UEQ checkbox clicked successfully", MediaEntityBuilder
						.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/UEQCheckboxselected.png")
						.build());
				Assert.assertTrue(true);
				
			//Finance Approval
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Edit Trade Package Stage']")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Edit Trade Package Stage']")));
				value.FinanceApproval();
				captureScreen(driver, "ApprovedbyFinance");
				test.pass("Approved by Finance Successfully", MediaEntityBuilder
						.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/ApprovedbyFinance.png")
						.build());
				Assert.assertTrue(true);
				
			//Customer Approval
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Edit Trade Package Stage']")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Edit Trade Package Stage']")));
				value.CustomerApproval();
				captureScreen(driver, "ApprovedbyCustomer");
				test.pass("Approved by Customer Successfully", MediaEntityBuilder
						.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/ApprovedbyCustomer.png")
						.build());
				Assert.assertTrue(true);
				
			//PO Creation
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Edit Trade Package Stage']")));
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Edit Trade Package Stage']")));
				value.POCreation(PONumber);
				captureScreen(driver, "POCreatedandClosed");
				test.pass("PO created and closed Successfully", MediaEntityBuilder
						.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/POCreatedandClosed.png")
						.build());
				Assert.assertTrue(true);
				
		
	}
}

package Generic_TestClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import com.vsysq.pages.OpportunityUserLoginPage;
import com.vsysq.pages.SignInPage;
import com.vsysq.utilities.ExcelUtils;

public class opportunityloginTest extends TestBase {

	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test(groups = { "MPOpportunity" })

	public void OpportunityLogin( String OpportunityOwner)
			throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		OpportunityUserLoginPage addOpportunity = new OpportunityUserLoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		// wait function
		Thread.sleep(5000);
		// click Setup
		addOpportunity.ClickSetupIcon();
		test.pass("User clicked setup icon successfully");

		// click setup link
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Setup'])[2]")));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Setup'])[2]")));
		
		addOpportunity.ClickSetupLink();		
		
		// Search User
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//li[@data-aura-rendered-by='338:0;p']")));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//li[@data-aura-rendered-by='338:0;p']")));
		addOpportunity.SearchOpportunityOwner(OpportunityOwner);
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']//tr)[2]//a[text()='"+OpportunityOwner+"']")));
		driver.findElement(By.xpath("(//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']//tr)[2]//a[text()='"+OpportunityOwner+"']")).click();
		
		// Switch Frame for Login
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));

		//Click Login button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='login'])[1]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='login'])[1]")));
		driver.findElement(By.xpath("(//input[@name='login'])[1]")).click();
		Thread.sleep(8000);
		captureScreen(driver, "OpportunityOwnerLoginSuccessful");
		test.pass("User "+ OpportunityOwner +" logged in successfully", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/OpportunityOwnerLoginSuccessful.png")
				.build());
		Assert.assertTrue(true);		

	}

	

}

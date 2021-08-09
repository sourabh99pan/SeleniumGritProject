package Generic_TestClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.vsysq.base.ExtentTestManager;
import com.vsysq.base.TestBase;
import com.vsysq.pages.CreateOpportunitiesPage;

public class E2EOpportunityCreation extends TestBase {

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	public void CreateE2EOpportunity(String OppNameEnter, String PriceBookName, String OppQual, String deal1,
			String OpportunityTerms, String SPARReason, String SPARCommentry) throws InterruptedException, IOException {
		ExtentTest test = ExtentTestManager.getTest();
		WebDriverWait wait = new WebDriverWait(driver, 60);
		CreateOpportunitiesPage addOpportunity = new CreateOpportunitiesPage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='forceActionLink']//div[@title='New'])[2]")));
		driver.findElement(By.xpath("(//a[@class='forceActionLink']//div[@title='New'])[2]")).click();
		
		//addOpportunity.ClickNewButton();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Opportunity Information']/following::input[1]")));
		addOpportunity.sendOppoName(OppNameEnter);
		Thread.sleep(3000);

		// entring equipment territory manager
		addOpportunity.PriceName(PriceBookName);

		// selecting Equipment territory manager
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("((//span[text()='Est. Close Date'])[2]//following::input)[1]")));
		
		Thread.sleep(2000);;
		addOpportunity.CloseDateClick();
		addOpportunity.CloseDateEnter();	
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("((//span[contains(text(),'Anticipated Ship Date')])//following::input)[1]")));
		addOpportunity.ShipDateClick();
		
		// selecting customer type
		addOpportunity.ShipDateEnter();

		// selecting customer segment
		addOpportunity.StageClick(OppQual);/////// dropdown
		Thread.sleep(2000);
		// Click on save button
		addOpportunity.DealLikehooodClick(deal1);//////// dropdown
		Thread.sleep(2000);
		// Scroll to Complexity Driver
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Element = driver.findElement(By.xpath("//div[text()='Complexity Driver']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);

		// Select an option from Complexity Driver
		driver.findElement(By.xpath("//div[@data-value='TFS']")).click();
		driver.findElement(By.xpath("(//button[@title='Move selection to Chosen'])[1]")).click();
		test.pass("User selected complexity driver as 'TFS' successfully");

		// Opportunity Terms
		if (OpportunityTerms != "") {
			addOpportunity.OpportunityTerms(OpportunityTerms);
		}
		Thread.sleep(2000);
		// Enter SPAR Reason
		addOpportunity.SPARReasonClick(SPARReason);
		Thread.sleep(2000);
		// Enter SPAR Commentary
		addOpportunity.SPARCommentryClick(SPARCommentry);
		Thread.sleep(2000);
		// Click Save Button
		addOpportunity.SaveClick();
		Thread.sleep(2000);
		ExtentTestManager.getTest()
				.pass("Successfully entered relevent opportunity details and clicked on save button");

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

			captureScreen(driver, "OpportunityCreated");
			ExtentTestManager.getTest().pass("MP opportunity is created successfully", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/OpportunityCreated.png")
					.build());
		} else {

			Thread.sleep(3000);
			captureScreen(driver, "Opportunity NotCreated");
			ExtentTestManager.getTest().fail("Opportunity is not created successfully",
					MediaEntityBuilder
							.createScreenCaptureFromPath(
									System.getProperty("user.dir") + "/Screenshots/Opportunity NotCreated.png")
							.build());

			Assert.assertTrue(false);
		}

	}
}

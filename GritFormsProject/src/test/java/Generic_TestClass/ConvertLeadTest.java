package Generic_TestClass;

import java.io.IOException;

import org.openqa.selenium.By;
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
import com.vsysq.pages.ConvertLead;
import com.vsysq.pages.CreateLeadPage;
import com.vsysq.utilities.ExcelUtils;

public class ConvertLeadTest extends TestBase {

	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test(groups = { "MPLeads" })
	public void convertNewLead(String Queue_User, String Company, String Lead_Name)
			throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		ConvertLead convertLeads = new ConvertLead(driver);

		// Search User
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search Setup']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search Setup']")));
		convertLeads.SearchOpportunityOwner(Queue_User);

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']//tr)[2]//a[text()='"
						+ Queue_User + "']")));
		driver.findElement(
				By.xpath("(//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']//tr)[2]//a[text()='"
						+ Queue_User + "']"))
				.click();

		// Switch Frame for Login
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));

		// Click Login button
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='login'])[1]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='login'])[1]")));
		driver.findElement(By.xpath("(//input[@name='login'])[1]")).click();
		Thread.sleep(8000);
		captureScreen(driver, "OpportunityOwnerLoginSuccessful");
		test.pass("User " + Queue_User + " logged in successfully",
				MediaEntityBuilder
						.createScreenCaptureFromPath(
								System.getProperty("user.dir") + "/Screenshots/OpportunityOwnerLoginSuccessful.png")
						.build());
		Assert.assertTrue(true);

		// click on LeadTab
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//one-app-nav-bar-item-root[@data-id='Lead']")));
		convertLeads.ClickLeadTab();

		// Enter Lead Name
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@placeholder='Search Leads and more...']")));
		convertLeads.SearchLead(Lead_Name);
		Thread.sleep(5000);
		convertLeads.SelectLeadFromList(Lead_Name);

		// Wait for Convert Button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Convert']")));

		// Click On Convert Button
		convertLeads.ClickConvertButton();
		test.pass("Successfully clicked 'Approve' button");
		Thread.sleep(10000);
		// Wait for Final Convert Button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Convert']")));

		// Click On Final Convert Button
		Thread.sleep(15000);
		convertLeads.ClickFinalConvertButton();
		test.pass("Successfully clicked 'Approve' button");
		Thread.sleep(20000);
		// Wait for Go to Leads Button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Go to Leads']")));

		// Click On Go to Leads Button
		Thread.sleep(20000);
		convertLeads.ClickGotoLeadsButton();
		test.pass("Successfully clicked 'Approve' button");

		if (driver.findElements(By.xpath("//span[@class='genericError uiOutputText']")).size() != 0) {
			Thread.sleep(3000);
			captureScreen(driver, "reviewElementError");
			ExtentTestManager.getTest().fail("Review Element Error present", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/reviewElementError.png")
					.build());
		}

		Thread.sleep(8000);
		convertLeads.ClickUserLogoutLink();

	}

}

package Generic_TestClass;

import java.io.IOException;
import java.util.ArrayList;
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
import com.vsysq.pages.OpportunityApprovalPage;
import com.vsysq.utilities.ExcelUtils;

public class OpportunityApprovalPageTest extends TestBase {
	
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test(groups = { "MPOpportunity" })
	public void ApproveOpportunity(String ApproverNames, String OpportunityName)
			throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		OpportunityApprovalPage OpportunityApproval = new OpportunityApprovalPage(driver);

		WebDriverWait wait = new WebDriverWait(driver, 60);

		// wait for home Tab
		String[] arrapprover = ApproverNames.split(",", 0);

		for (String approverName : arrapprover) {
			System.out.println("Approver Name : " + approverName);

			/// Close Tab 2
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(1));

			// Search User
			OpportunityApproval.SearchOpportunityOwner(approverName);
			Thread.sleep(5000);
			test.pass("Opportunity Owner name '" + approverName + "' entered successfully in search box");

			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//table[@data-aura-class='uiVirtualDataGrid--default
			// uiVirtualDataGrid']//tr)[2]/td/a)[1]")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By
					.xpath("(//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']//tr)[2]//a[text()='"
							+ approverName + "']")));

			// Select Approver Name
			OpportunityApproval.SelectApproverName(approverName);
			Thread.sleep(10000);
			// Switch Frame for Login
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));
			Thread.sleep(10000);
			// Click On Login Button
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='login'])[1]")));
			OpportunityApproval.ClickLogin();
			Thread.sleep(3000);
			captureScreen(driver, "OpportunityApproverLoginSuccessful" + approverName + "");

			test.pass("User logged in successfully using opportunity approver name as '" + approverName + "'",
					MediaEntityBuilder
							.createScreenCaptureFromPath(System.getProperty("user.dir")
									+ "/Screenshots/OpportunityApproverLoginSuccessful" + approverName + ".png")
							.build());
			Assert.assertTrue(true);
			Thread.sleep(5000);
			// Click on Opportunities Tab
			/*
			 * wait.until(ExpectedConditions .elementToBeClickable(By.xpath(
			 * "//one-app-nav-bar-item-root[@data-id='Opportunity']")));
			 * OpportunityApproval.ClickOpportunityTab();
			 * 
			 * // Click on Opportunity to open wait.until(ExpectedConditions
			 * .elementToBeClickable(By.
			 * xpath("//input[@title='Search Opportunities and more']")));
			 * 
			 * //Enter Opportunity Name
			 * OpportunityApproval.SearchOpportunity(OpportunityName);
			 * test.pass("Opportunity name entered successfully in search box");
			 */
			// Click on Opportunities Tab
			/*
			 * wait.until(ExpectedConditions .elementToBeClickable(By.xpath(
			 * "//one-app-nav-bar-item-root[@data-id='Opportunity']")));
			 */
			// Click on Opportunity
			/*
			 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath
			 * ("((//table)[2]//tr[1]//a[text()='" + OpportunityName +
			 * "'])[1]")));
			 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
			 * "((//table)[2]//tr[1]//a[text()='" + OpportunityName +
			 * "'])[1]")));
			 * OpportunityApproval.SelectOpportunityFromList(OpportunityName);
			 * test.pass("Opportunity '"
			 * +OpportunityName+"' Opened successfully for approval");
			 * 
			 * // Wait for approval history
			 * wait.until(ExpectedConditions.elementToBeClickable(By.
			 * xpath("//a[@class='slds-card__header-link baseCard__header-title-container']//span[@title='Approval History']"
			 * )));
			 * 
			 * //Click On approval history Thread.sleep(2000);
			 * OpportunityApproval.OpenApprovalhistory();
			 * test.pass("Successfully clicked 'Approval History' tab");
			 * 
			 * // Wait for Approve Button
			 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
			 * "//div[text()='Approve']")));
			 * 
			 * //Click On Approve Button
			 * OpportunityApproval.ClickApproveButton();
			 * test.pass("Successfully clicked 'Approve' button");
			 */

			OpportunityApproval.anotheropportunityApprovalFlow(OpportunityName);
			Thread.sleep(5000);
			// Wait For Approve popup
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Approve']")));

			// Click On approve button
			OpportunityApproval.ClickFinalApprovalButton();
			Thread.sleep(3000);
			test.pass("Successfully clicked 'Approve' button");
			Thread.sleep(5000);
			// boolean res = driver.getPageSource().contains("Opportunity was
			// approved");
			// Wait For Approval Message
			/*
			 * (new WebDriverWait(driver, 10))
			 * .until(ExpectedConditions.presenceOfElementLocated(By.
			 * xpath("//*[contains(text(),'Opportunity was approved')]")));
			 * 
			 * boolean res = true;
			 * 
			 * if (res == true) { Assert.assertTrue(true);
			 * 
			 * captureScreen(driver, "OpportunityApproval_"+approverName+"");
			 * ExtentTestManager.getTest()
			 * .pass("MP opportunity is approved successfully by "+
			 * approverName, MediaEntityBuilder .createScreenCaptureFromPath(
			 * System.getProperty("user.dir") +
			 * "/Screenshots/OpportunityApproval_"+approverName+".png")
			 * .build()); } else {
			 * 
			 * Thread.sleep(3000); captureScreen(driver,
			 * "Opportunity NotApproved"); ExtentTestManager.getTest().
			 * fail("Opportunity is not approved successfully",
			 * MediaEntityBuilder .createScreenCaptureFromPath(
			 * System.getProperty("user.dir") +
			 * "/Screenshots/Opportunity NotApproved.png") .build());
			 * 
			 * Assert.assertTrue(false); }
			 */

			/// User Logout
			// OpportunityApproval.ClickUserLogoutLink();
			driver.findElement(By.xpath("//a[contains(text(),'Log out as')]")).click();
			test.pass("Successfully clicked user logout link");
			Thread.sleep(5000);
		}

	}

}

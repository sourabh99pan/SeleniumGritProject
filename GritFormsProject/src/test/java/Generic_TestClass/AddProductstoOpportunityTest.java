package Generic_TestClass;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.vsysq.base.ExtentTestManager;
import com.vsysq.base.TestBase;
import com.vsysq.pages.AddProductsToOpportunity;
import com.vsysq.utilities.ExcelUtils;

public class AddProductstoOpportunityTest extends TestBase {

	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test(groups = { "MPOpportunity" })

	public void AddProducts_Opportunity(String OpportunityOwner, String OpportunityName, String MarginAmount,
			String DOAPercentage, String Commission, String State, String AdditionalDiscPerc, String Product,
			String ActualDiscPerc, String UltimateApprover) throws InterruptedException, IOException {
		ExtentTest test = ExtentTestManager.getTest();
		AddProductsToOpportunity AddProducts = new AddProductsToOpportunity(driver);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		Thread.sleep(10000);
		/// Click Add/Remove/Edit Products
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Add/Remove/Edit Products']")));
		AddProducts.AddProducts();
		Thread.sleep(10000);
		wait.until(ExpectedConditions
				.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='accessibility title']")));
		List<WebElement> elements = driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("Number of Input :" + elements.size());

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@type='checkbox'])[5]")));

		// Enter Margin Amt
		if (Product == "") {
			AddProducts.SelectProducts(3);
			test.pass("User selected product to add successfully");
			Thread.sleep(9000);
			boolean exists = driver
					.findElements(By.xpath("//input[@name='j_id0:ProductEntryForm:selected:j_id72:0:j_id105']"))
					.size() != 0;
			if (exists) {
				WebElement SpecialDesign = driver
						.findElement(By.xpath("//input[@name='j_id0:ProductEntryForm:selected:j_id72:0:j_id105']"));
				SpecialDesign.click();
			}
		} else {
			AddProducts.SelectByProductName(Product);
			test.pass("User selected product to add successfully");
		}
		test.pass("'Add Selected Product' button clicked successfully");
		Thread.sleep(10000);
		// Click Margin Analysis Checkbox
		if (MarginAmount != "") {

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[5]")));
			AddProducts.PerformMarginAnalysis(MarginAmount);
			// test.pass("User entered Margin amount as '"+ MarginAmount +"' successfully");
		}
		Thread.sleep(10000);
		if (DOAPercentage != "") {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//input[@name='j_id0:ProductEntryForm:selected:j_id72:0:j_id112']")));
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//input[@name='j_id0:ProductEntryForm:selected:j_id72:0:j_id112']")));
			AddProducts.DOAPercentage(DOAPercentage, Commission);
			// test.pass("User entered Additional discount percentage as '" +DOAPercentage+
			// "' successfully");
		}
		Thread.sleep(10000);
		// Enter State : Required for MP Bidwell
		if (State != "") {
			AddProducts.AddState(State);
			// test.pass("User entered State as '"+ State +"' successfully");
		}

		if (AdditionalDiscPerc != "") {
			AddProducts.AddAdditionalDiscountVariance(AdditionalDiscPerc);
			// test.pass("User entered Additional Discount as '"+ AdditionalDiscPerc +"'
			// successfully");
		}
		Thread.sleep(10000);
		if (ActualDiscPerc != "") {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//input[@name='j_id0:ProductEntryForm:selected:j_id72:0:j_id115']")));
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//input[@name='j_id0:ProductEntryForm:selected:j_id72:0:j_id115']")));
			AddProducts.AddActualDiscountVariance(ActualDiscPerc);
			test.pass("User entered Additional discount percentage as '" + ActualDiscPerc + "' successfully");
		}
		Thread.sleep(10000);
		// Take Screenshot
		captureScreen(driver, "Products added to Opportunity successfully ");
		ExtentTestManager.getTest().pass("Added Products to Opportunity successfully",
				MediaEntityBuilder
						.createScreenCaptureFromPath(
								System.getProperty("user.dir") + "/Screenshots/ProductsAddedToOpportunity.png")
						.build());
		// checking ultimate approver
		Thread.sleep(10000);
		if (UltimateApprover != "") {
			wait.until(ExpectedConditions.visibilityOfElementLocated(
					By.xpath("//span[contains(text(),'Ultimate Approver')]//following::a[1]")));
			WebElement Ultimateapprove = driver
					.findElement(By.xpath("//span[contains(text(),'Ultimate Approver')]//following::a[1]"));
			String Approverlabel = Ultimateapprove.getText();
			if (UltimateApprover.equalsIgnoreCase(Approverlabel)) {
				test.pass("Ultimate approver Matchs'" + Approverlabel);
			} else {
				test.fail("Ultimate approver does not Matchs'" + Approverlabel);
			}
		}
	}
	
	public void SubmitOpportunityForApproval() throws IOException, InterruptedException {
		ExtentTest test = ExtentTestManager.getTest();
		AddProductsToOpportunity AddProducts = new AddProductsToOpportunity(driver);
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		// Wait for next page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Submit for Approval']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Submit for Approval']")));

		AddProducts.SubmitForApproval();
		Thread.sleep(10000);
		captureScreen(driver, "Opportunity Submitted for approval successfully ");
		ExtentTestManager.getTest().pass("Opportunity Submitted for approval successfully",
				MediaEntityBuilder
						.createScreenCaptureFromPath(
								System.getProperty("user.dir") + "/Screenshots/OpportunitySubmittedForapproval.png")
						.build());

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Submit']")));

		AddProducts.FinalSubmit();
		Thread.sleep(4000);
		captureScreen(driver, "OpportunityFinalSubmittedForapproval");
		ExtentTestManager.getTest().pass("Opportunity Submitted for approval successfully", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/SubmittedForapproval.png")
				.build());

		// Logout from current user
		Thread.sleep(6000);
		driver.findElement(By.xpath("//a[contains(text(),'Log out as')]")).click();
		test.pass("Logged Out from Opportunity Owner successfully");
		Thread.sleep(10000);
	}

}

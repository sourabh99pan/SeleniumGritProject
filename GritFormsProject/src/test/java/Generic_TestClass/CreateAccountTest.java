package Generic_TestClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vsysq.utilities.ExcelUtils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.vsysq.base.ExtentTestManager;
import com.vsysq.base.TestBase;
import com.vsysq.pages.BasePage;
import com.vsysq.pages.CreateAccountPage;
import com.vsysq.pages.SignInPage;

public class CreateAccountTest extends TestBase {

	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeClass
	public void setUp() {
		driver = getDriver();

	}

	@Test(groups = { "Regression" })

	public void CreatePartAccount(String AccountType, String AccountHolderName, String RegionalSalesManager,
			String EquipmentTerritorySalesManager, String ServiceTerritorySalesManager, String CustomerType,
			String CustomerSegment, String Taxtype) throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//one-app-nav-bar-item-root[@data-id='home']")));

		CreateAccountPage addcust = new CreateAccountPage(driver);

		// wait function
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//one-app-nav-bar-item-root[@data-id='home']")));
		// click on Home Menu
		addcust.ClickHomeMenu();
		// click on Accounts menu
		addcust.ClickAccountsMenu();
		// Explicit wait
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@class='forceActionLink']//div[@title='New']")));
		// validation point to check the home page title
		String HomePage = driver.getTitle();
		System.out.println(HomePage);
		String expectedaccountspageTitle = "Recently Viewed | Accounts | Salesforce";
		if (HomePage.equalsIgnoreCase(expectedaccountspageTitle)) {
			captureScreen(driver, "HomePage");
			test.pass("We are on Accounts Page", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/HomePage.png").build());
		} else {
			captureScreen(driver, "NotHomePage");
			test.fail("we are not on accounts page", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/NotHomePage.png")
					.build());
		}
		// click on new button
		addcust.ClicknewAccountButton();
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//span[@class='slds-form-element__label'][text()='" + AccountType + "']")));

		if (driver.findElements(By.xpath("//h2[text()='New Account: Prospect']")).size() != 0) {
			captureScreen(driver, "NewAccountPage");
			ExtentTestManager.getTest().pass("Successfully navigated to new accounts page", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/NewAccountPage.png")
					.build());

		} else {
			captureScreen(driver, "NotNewAccountPage");
			ExtentTestManager.getTest().fail("navigation unsuccessful on new accounts page", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/NotNewAccountPage.png")
					.build());
		}

		// click on radio button
		// addcust.PartAccountRadioButtonClick();
		// click on next button
		// addcust.NextButtonClick();
		// wait.until(ExpectedConditions
		// .visibilityOfElementLocated(By.xpath("//span[text()='Regional Sales
		// Manager']//following::input[1]")));
		ExtentTestManager.getTest().pass("Successfully navigated to accounts page");

		// entering account name
		addcust.ParentAccountName(AccountHolderName);

		// Entering regional manager name
		addcust.RegionalSalesManager(RegionalSalesManager);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']/tbody/tr")));

		// selecting regional manager
		addcust.addManager(RegionalSalesManager);
		Thread.sleep(300);

		// entring equipment territory manager
		addcust.EquipmentTerritorySalesManager(EquipmentTerritorySalesManager);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']/tbody/tr")));
		Thread.sleep(300);

		// selecting Equipment territory manager
		addcust.addManager(EquipmentTerritorySalesManager);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']/tbody/tr")));
		Thread.sleep(300);

		// entering service territory manager
		addcust.ServiceTerritorySalesManager(ServiceTerritorySalesManager);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']/tbody/tr")));

		// selecting service territory manager
		addcust.addManager(ServiceTerritorySalesManager);
		Thread.sleep(3000);

		// selecting customer type
		addcust.customerType();
		driver.findElement(By.xpath(
				"//div[@class='select-options']/ul/li/a[@role='menuitemradio'][(text()='" + CustomerType + "')]"))
				.click();
		Thread.sleep(300);

		// selecting customer segment
		addcust.customerSegment();

		driver.findElement(By.xpath(
				"//div[@class='select-options']/ul/li/a[@role='menuitemradio'][(text()='" + CustomerSegment + "')]"))
				.click();
		Thread.sleep(300);

		// selecting tax type
		addcust.taxtype();
		driver.findElement(
				By.xpath("//div[@class='select-options']/ul/li/a[@role='menuitemradio'][(text()='" + Taxtype + "')]"))
				.click();
		Thread.sleep(3000);

		// Click on save button
		addcust.saveButton();
		Thread.sleep(3000);

		ExtentTestManager.getTest().pass("Successfully entered relevent account details and clicked on save button");

		if (driver.findElements(By.xpath("//span[@class='genericError uiOutputText']")).size() != 0) {
			Thread.sleep(300);
			captureScreen(driver, "reviewElementError");
			ExtentTestManager.getTest().fail("Review Element Error present", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/reviewElementError.png")
					.build());

		}

		boolean res = driver.getPageSource().contains("Part Account created Successfully!!!");

		if (res == true) {
			Assert.assertTrue(true);

			captureScreen(driver, "AccountCreated");
			ExtentTestManager.getTest().pass("Part Account is created successfully", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/AccountCreated.png")
					.build());
		} else {

			Thread.sleep(300);
			captureScreen(driver, "AccountNotCreated");
			ExtentTestManager.getTest().fail("Part Account is not created successfully", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/AccountNotCreated.png")
					.build());

			Assert.assertTrue(false);
		}

	}

}

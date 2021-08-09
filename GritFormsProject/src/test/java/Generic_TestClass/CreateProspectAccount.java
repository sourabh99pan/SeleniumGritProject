package Generic_TestClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.vsysq.base.ExtentTestManager;
import com.vsysq.base.TestBase;

public class CreateProspectAccount extends TestBase {

	@BeforeClass
	public void setUp() {
		driver = getDriver();

	}

	public void ProspectAccount(String AccountStatus, String AccountHolder, String CustomerType)
			throws IOException, InterruptedException {
		ExtentTest test = ExtentTestManager.getTest();
		// click on Accounts tab
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//one-app-nav-bar-item-root[@data-id='home']")));

		// click on Home Menu
		driver.findElement(By.xpath("//one-app-nav-bar-item-root[@data-id='home']")).click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//one-app-nav-bar-item-root[@data-id='Account']")));
		driver.findElement(By.xpath("//one-app-nav-bar-item-root[@data-id='Account']")).click();

		// Click on new Button
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//a[@class='forceActionLink']//div[@title='New']")));
		// validation point to check the home page title
		String AccountPage = driver.getTitle();
		System.out.println(AccountPage);
		String expectedaccountspageTitle = "Recently Viewed | Accounts | Salesforce";
		if (AccountPage.equalsIgnoreCase(expectedaccountspageTitle)) {
			captureScreen(driver, "AccountsPage");
			test.pass("We are on Accounts Page", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/AccountsPage.png")
					.build());
		} else {
			captureScreen(driver, "NoAccountsPage");
			test.fail("we are not on Accounts page", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/NoAccountsPage.png")
					.build());
		}
		// click on new button
		driver.findElement(By.xpath("//a[@class='forceActionLink']//div[@title='New']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='New Account: Prospect']")));

		if (driver.findElements(By.xpath("//h2[text()='New Account: Prospect']")).size() != 0) {
			captureScreen(driver, "NewAccountPage");
			ExtentTestManager.getTest().pass("Successfully navigated to new Account page", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/NewAccountPage.png")
					.build());

		} else {
			captureScreen(driver, "NotNewAccountPage");
			ExtentTestManager.getTest().fail("navigation unsuccessful on new Account page", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/NotNewAccountPage.png")
					.build());
		}
		Thread.sleep(1000);
		// Select the Status
		WebElement Status = driver.findElement(By.xpath("//span[text()='Status']/following::a[1]"));

		Status.click();
		driver.findElement(By.xpath(
				"//div[@class='select-options']/ul/li/a[@role='menuitemradio'][(text()='" + AccountStatus + "')]"))
				.click();
		test.pass("Account Status selected sucessfully");
		Thread.sleep(1000);
		// Enter the Account Name
		driver.findElement(By.xpath("(//label[@data-aura-class='uiLabel']//span[text()='Account Name']//following::input)[1]")).sendKeys(AccountHolder);
		Thread.sleep(1000);
		// Select the Customer Type
		WebElement MPCustomerType = driver.findElement(By.xpath("//span[text()='MP Customer Type']/following::a[1]"));

		MPCustomerType.click();
		driver.findElement(By.xpath(
				"//div[@class='select-options']/ul/li/a[@role='menuitemradio'][(text()='" + CustomerType + "')]"))
				.click();
		test.pass("MP Customer type selected sucessfully");
		Thread.sleep(1000);
		// Click on save button

		driver.findElement(By.xpath("//button[@title='Save']")).click();
		Thread.sleep(5000);
	}

}

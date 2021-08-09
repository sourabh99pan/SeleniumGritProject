package Generic_TestClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vsysq.utilities.ExcelUtils;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.vsysq.base.ExtentTestManager;
import com.vsysq.base.TestBase;

public class CreateContact extends TestBase {

	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeClass
	public void setUp() {
		driver = getDriver();

	}

	@Test(groups = { "functest" })

	public void TC_CreateContact(String ContactType,
			String ContactSalutn, String Firstname, String LastName, String PhoneNumber, String MobileNumber,
			String EmailId, String Accountname, String businessUnit, String ProductSpecialist)
			throws InterruptedException, IOException {
		Actions Builder = new Actions(driver);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		ExtentTest test = ExtentTestManager.getTest();
		Thread.sleep(5000);
		// wait function
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// click on radio button
		driver.findElement(By.xpath("//span[text()='" + ContactType + "']//preceding::span[@class='slds-radio--faux'][1]"))
				.click();
		Thread.sleep(2000);
		// click on next button
		driver.findElement(
				By.xpath("//button[@class='slds-button slds-button--neutral slds-button slds-button_brand uiButton']"))
				.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//span[@class='test-id__section-header-title section-header-title slds-p-horizontal--small slds-truncate'][text()='Contact Information']")));
		ExtentTestManager.getTest().pass("Successfully navigated to New Contacts '" + ContactType + "' page");

		// select contact Salutation name
		WebElement ContactSalutation = driver.findElement(By.xpath("//span[text()='Salutation']/following::a[1]"));

		ContactSalutation.click();
		driver.findElement(By.xpath(
				"//div[@class='select-options']/ul/li/a[@role='menuitemradio'][(text()='" + ContactSalutn + "')]"))
				.click();
		test.pass("Contact salutation selected sucessfully");

		// enter first name
		System.out.println("Hello");
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(Firstname);
		Thread.sleep(1000);
		// last name
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(LastName);
		Thread.sleep(1000);

		// phone
		driver.findElement(By.xpath("(//span[text()='Phone'])[3]//following::input[1]")).sendKeys(PhoneNumber);
		
		Thread.sleep(1000);

		// mobile number
		driver.findElement(By.xpath("(//span[text()='Mobile']//following::input)[1]")).sendKeys(MobileNumber);
		Thread.sleep(1000);

		// emailid
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(EmailId);
		Thread.sleep(1000);
		
		// Business Unit
		WebElement BusinessUnit = driver.findElement(By.xpath("(//span[text()='Business Unit']//following::a[@class='select'])[1]"));
		Actions BusinessUnitSelect = Builder.moveToElement(BusinessUnit).click().sendKeys(BusinessUnit, businessUnit);
		BusinessUnitSelect.perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//div[@class='select-options']/ul/li/a[@role='menuitemradio'][(text()='" + businessUnit + "')]"))
				.click();
		// BusinessUnit.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		// Contact roles
		/*
		 * WebElement ContactRole =
		 * driver.findElement(By.xpath("//ul[@role='listbox']//span[text()='Warranty']")
		 * ); WebElement ConButtonToMove = driver.findElement(By.
		 * xpath("(//button[@title='Move selection to Chosen'])[1]"));
		 * Thread.sleep(7000); ContactRole.click(); Thread.sleep(2000);
		 * ConButtonToMove.click();
		 */
		Thread.sleep(2000);
		// Communication type

		WebElement CommunicationType = driver.findElement(By.xpath("//ul[@role='listbox']//span[text()='Marketing']"));
		executor.executeScript("arguments[0].scrollIntoView(true);", CommunicationType);
		executor.executeScript("arguments[0].click();", CommunicationType);
		WebElement CommButtonToMove = driver.findElement(By.xpath("(//button[@title='Move selection to Chosen'])[2]"));
		executor.executeScript("arguments[0].scrollIntoView(true);", CommButtonToMove);
		executor.executeScript("arguments[0].click();", CommButtonToMove);
		Thread.sleep(7000);

		// TPSP Buying Role

		WebElement BuyingRole = driver.findElement(By.xpath("//ul[@role='listbox']//span[text()='Contact']"));
		executor.executeScript("arguments[0].scrollIntoView(true);", BuyingRole);
		executor.executeScript("arguments[0].click();", BuyingRole);

		WebElement BuyButtonToMove = driver.findElement(By.xpath("(//button[@title='Move selection to Chosen'])[3]"));
		executor.executeScript("arguments[0].scrollIntoView(true);", BuyButtonToMove);
		executor.executeScript("arguments[0].click();", BuyButtonToMove);
		Thread.sleep(7000);
		// product Specialist
		// ProductSpecialist
		WebElement ProductSpecial = driver.findElement(By.xpath("//span[text()='Product Specialist']/following::a[1]"));
		ProductSpecial.click();
		driver.findElement(By.xpath(
				"//div[@class='select-options']/ul/li/a[@role='menuitemradio'][(text()='" + ProductSpecialist + "')]"))
				.click();
		test.pass("Product specialist selected");

		// Click on save button
		driver.findElement(By.xpath("//button[@title='Save']")).click();
		Thread.sleep(20000);

		ExtentTestManager.getTest().pass("Successfully entered relevent Contact details and clicked on save button");

		if (driver.findElements(By.xpath("//span[@class='genericError uiOutputText']")).size() != 0) {
			Thread.sleep(300);
			captureScreen(driver, "reviewElementError");
			ExtentTestManager.getTest().fail("Review Element Error present", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/reviewElementError.png")
					.build());

		}

	}

	
}

package Generic_TestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentTest;
import com.vsysq.base.ExtentTestManager;
import com.vsysq.base.TestBase;
import com.vsysq.pages.TPLICreation;

public class InspectionReportsubmitTest extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, 60);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	  ExtentTest test = ExtentTestManager.getTest();
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	public void InspectionReportSubmission() throws InterruptedException {
		String TMSid=TPLICreation.TMSid;
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Pending inspections']")));
		// need to place the home menu click code
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Pending inspections']")).click();
		
		test.pass("Navigated to pending inspection page successfully");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search']")));
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(TMSid);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='btn UEQListButton btn-genie'][contains(text(),'Open Inspection')]")));
		driver.findElement(By.xpath("//a[@class='btn UEQListButton btn-genie'][contains(text(),'Open Inspection')]"))
				.click();
		// Q1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//label[contains(text(),'Does the machine start and stop?')]//following::input[@name='a5BR00000001QA6MAM'][@value='YES']")));
		
		driver.findElement(By
				.xpath("//label[contains(text(),'Does the machine start and stop?')]//following::input[@name='a5BR00000001QA6MAM'][@value='YES']"))
				.click();
		
		test.pass("Does the machine start and stop answered successfully");
		Thread.sleep(5000);
		// Q2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//label[contains(text(),'Does the machine move in all directions F/R, L/R?')]//following::input[@name='a5BR00000001QA7MAM'][@value='YES']")));
		
		driver.findElement(By
				.xpath("//label[contains(text(),'Does the machine move in all directions F/R, L/R?')]//following::input[@name='a5BR00000001QA7MAM'][@value='YES']"))
				.click();
		test.pass("Does the machine move in all directions F/R, L/R? answered successfully");
		Thread.sleep(5000);
		// Q3
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//label[contains(text(),'Does the machine raise and lower?')]//following::input[@name='a5BR00000001QA8MAM'][@value='YES']")));
		
		driver.findElement(By
				.xpath("//label[contains(text(),'Does the machine raise and lower?')]//following::input[@name='a5BR00000001QA8MAM'][@value='YES']"))
				.click();
		test.pass("Does the machine raise and lower? answered successfully");
		Thread.sleep(5000);
		
		// Q4
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//label[contains(text(),'Does the machine swing left and right?')]//following::input[@name='a5BR00000001QA9MAM'][@value='YES']")));
		driver.findElement(By
				.xpath("//label[contains(text(),'Does the machine swing left and right?')]//following::input[@name='a5BR00000001QA9MAM'][@value='YES']"))
				.click();
		test.pass("Does the machine swing left and right? answered successfully");
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//label[contains(text(),'On a scale 1-4, how would you rate the overall condition of this equipment?')]//following::i[5]")));

		// overall
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By
				.xpath("//label[contains(text(),'On a scale 1-4, how would you rate the overall condition of this equipment?')]//following::i[5]")))
				.click().build().perform();
		Thread.sleep(5000);

		test.pass("how would you rate the overall condition of this equipment? Rating successfully");
		// visual inspection
		act.moveToElement(driver.findElement(By
				.xpath("//label[contains(text(),'Inspect machine for any damage (Covers, panels, controls etc)')]//following::i[5]")))
				.click().build().perform();
		test.pass("Inspect machine for any damage Rating successfully");
		Thread.sleep(5000);
		act.moveToElement(driver.findElement(By
				.xpath("//label[contains(text(),'Inspect paint condition (fading, flaking paint, customer colours)')]//following::i[5]")))
				.click().build().perform();

		test.pass("Inspect paint condition Rating successfully");
		Thread.sleep(5000);
		act.moveToElement(driver.findElement(By
				.xpath("//label[contains(text(),'Inspect decals condition (Identify missing or damaged)')]//following::i[5]")))
				.click().build().perform();

		test.pass("Inspect decals condition Rating successfully");
		Thread.sleep(5000);
		act.moveToElement(driver.findElement(By
				.xpath("//label[contains(text(),'Inspect for significant oils leaks and identify source')]//following::i[5]")))
				.click().build().perform();

		test.pass("Inspect for significant oils leaks and identify source Rating successfully");
		Thread.sleep(5000);
		// Q5
		driver.findElement(By
				.xpath("//label[contains(text(),'Does the machine have any options (Generator etc)')]//following::input[@name='a5BR00000001QAEMA2'][@value='YES']"))
				.click();
		test.pass("Does the machine have any options Rating successfully");
		Thread.sleep(5000);
		// safety inspection
		// Q1
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//label[contains(text(),'Inspect operators and safety & responsibility manuals are in place')]//following::input[@name='a5BR00000001QAFMA2'][@value='YES']")));
		driver.findElement(By
				.xpath("//label[contains(text(),'Inspect operators and safety & responsibility manuals are in place')]//following::input[@name='a5BR00000001QAFMA2'][@value='YES']"))
				.click();
		test.pass("Inspect operators and safety & responsibility manuals are in place Rating successfully");
		Thread.sleep(5000);
		// Q2
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//label[contains(text(),'All open bulletins addressed')]//following::input[@name='a5BR00000001QAGMA2'][@value='YES']")));
		driver.findElement(By
				.xpath("//label[contains(text(),'All open bulletins addressed')]//following::input[@name='a5BR00000001QAGMA2'][@value='YES']"))
				.click();
		Thread.sleep(5000);
		test.pass("All open bulletins addressed Rating successfully");
		
		// STRUCTURE INSPECTION
		act.moveToElement(driver.findElement(
				By.xpath("//label[contains(text(),'Inspect tires and wheel for damage and wear')]//following::i[5]")))
				.click().build().perform();
		test.pass("Inspect tires and wheel for damage and wear Rating successfully");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//label[contains(text(),'Inspect axles for corrosion, damage or missing parts')]//following::i[5]")));
		
		act.moveToElement(driver.findElement(By
				.xpath("//label[contains(text(),'Inspect axles for corrosion, damage or missing parts')]//following::i[5]")))
				.click().build().perform();
		test.pass("Inspect axles for corrosion, damage or missing parts Rating successfully");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//label[contains(text(),'Inspect turntable or chassis covers for corrosion, damage or missing parts')]//following::i[5]")));
		
		act.moveToElement(driver.findElement(By
				.xpath("//label[contains(text(),'Inspect turntable or chassis covers for corrosion, damage or missing parts')]//following::i[5]")))
				.click().build().perform();
		test.pass("Inspect turntable or chassis covers for corrosion, damage or missing parts Rating successfully");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//label[contains(text(),'Inspect turntable or chassis covers for corrosion, damage or missing parts')]//following::i[5]")));
		
		act.moveToElement(driver.findElement(By
				.xpath("//label[contains(text(),'Inspect link stack for corrosion, damage or missing parts')]//following::i[5]")))
				.click().build().perform();
		test.pass("Inspect link stack for corrosion, damage or missing parts Rating successfully");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//label[contains(text(),'Inspect turntable or chassis covers for corrosion, damage or missing parts')]//following::i[5]")));
		
		act.moveToElement(driver.findElement(By
				.xpath("//label[contains(text(),'Inspect boom assembly for corrosion, damage or missing parts')]//following::i[5]")))
				.click().build().perform();
		
		test.pass("Inspect boom assembly for corrosion, damage or missing parts Rating successfully");
		Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//label[contains(text(),'Inspect turntable or chassis covers for corrosion, damage or missing parts')]//following::i[5]")));
		
		act.moveToElement(driver.findElement(By
				.xpath("//label[contains(text(),'Inspect jib assembly for corrosion, damage and missing parts')]//following::i[5]")))
				.click().build().perform();
		
		test.pass("Inspect jib assembly for corrosion, damage and missing parts Rating successfully");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//label[contains(text(),'Inspect turntable or chassis covers for corrosion, damage or missing parts')]//following::i[5]")));
		
		act.moveToElement(driver.findElement(By
				.xpath("//label[contains(text(),'Inspect platform assemblies for corrosion, damage or missing parts')]//following::i[5]")))
				.click().build().perform();
		test.pass("Inspect platform assemblies for corrosion, damage or missing parts Rating successfully");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//label[contains(text(),'Inspect turntable or chassis covers for corrosion, damage or missing parts')]//following::i[5]")));

		// FUNCTION TESTS
		act.moveToElement(driver.findElement(
				By.xpath("//label[contains(text(),'Are the batteries holding a charge?')]//following::i[5]"))).click()
				.build().perform();
		test.pass("Are the batteries holding a charge? Rating successfully");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//label[contains(text(),'Inspect turntable or chassis covers for corrosion, damage or missing parts')]//following::i[5]")));

		// Q1
		driver.findElement(By
				.xpath("//label[contains(text(),'Are the batteries charged?')]//following::input[@name='a5BR00000001QAaMAM'][@value='YES']"))
				.click();
		test.pass("Are the batteries charged? Rating successfully");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"//label[contains(text(),'Inspect turntable or chassis covers for corrosion, damage or missing parts')]//following::i[5]")));

		// need to work on xpath as its showing some problem
		// ANNUAL INSPECTION CRITERIA
		// Q1
		// wd.findElement(By
		// .xpath("//label[contains(text(),'Would the equipment pass an annual
		// inspection as per manufacturer's maintenance
		// manuals?')]//following::input[@name='a5BR00000001QARMA2'][@value='YES']"))
		// .click();
		// Thread.sleep(5000);

		// OVERALL
		Thread.sleep(5000);
		for (int i = 27; i <= 33; i++) {
			Thread.sleep(5000);
			
			WebElement UploadImg = driver.findElement(By.xpath("(//input[@class='s3upload'])[" + i + "]"));
			UploadImg.sendKeys("d:\\5.png");

			Thread.sleep(5000);
		}
	}
}

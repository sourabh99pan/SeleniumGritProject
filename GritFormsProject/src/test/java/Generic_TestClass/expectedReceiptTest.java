package Generic_TestClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.vsysq.base.ExtentTestManager;
import com.vsysq.base.TestBase;
import com.vsysq.pages.TPLICreation;

public class expectedReceiptTest extends TestBase {
	WebDriverWait wait = new WebDriverWait(driver, 60);
	JavascriptExecutor js = (JavascriptExecutor) driver;
    ExtentTest test = ExtentTestManager.getTest();
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test
	public void ExpectedReceiptCreation(String Communityuser,String yardName) throws InterruptedException, IOException {
		String TMSid=TPLICreation.TMSid;
		
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//input[@Placeholder='Search Trade Packages and more...']")));
		
		// login as community user'
		driver.findElement(By.xpath("//input[@Placeholder='Search Trade Packages and more...']"))
				.sendKeys(Communityuser);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@Placeholder='Search Trade Packages and more...']")).sendKeys(Keys.ENTER);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='" + Communityuser + "']")));
		
		test.pass("Community user Entered successfully"+Communityuser);
		Thread.sleep(5000);
		// button click
		driver.findElement(By.xpath("//a[@title='" + Communityuser + "']")).click();
		Thread.sleep(5000);
		// wait function to see the community user button
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Log in to Community as User']")));

		WebElement CU = driver.findElement(By.xpath("//div[text()='Log in to Community as User']"));
		js.executeScript("arguments[0].click();", CU);
		Thread.sleep(5000);
		test.pass("Login successful as Community User", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/CommunityUser.png")
				.build());
		Assert.assertTrue(true);
		Thread.sleep(5000);
		// wait function to display the yard portal page
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("yardSelector")));
		Thread.sleep(5000);
		// yard value dropdown
		Select dropdown = new Select(driver.findElement(By.id("yardSelector")));
		Thread.sleep(5000);
		// selecting the drop down value
		dropdown.selectByVisibleText(yardName);
		Thread.sleep(5000);
		test.pass("Yard Selected successfully", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/yard.png")
				.build());
		Assert.assertTrue(true);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Expected receipts']")));
		
		driver.findElement(By.xpath("//span[text()='Expected receipts']")).click();
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search']")));

		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(TMSid);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@class='btn UEQListButton btn-genie'][text()='Confirm Receipt']")));

		driver.findElement(By.xpath("//a[@class='btn UEQListButton btn-genie'][text()='Confirm Receipt']")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Confirm']")));
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		
		test.pass("Confirm receipt done", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/ConfirmReceipt.png")
				.build());
		Assert.assertTrue(true);
		Thread.sleep(10000);
		//inventory check
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Inventory']")));
		driver.findElement(By.xpath("//a[text()='Inventory']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(TMSid);
		Thread.sleep(5000);
		String TPLIStatus=driver.findElement(By.xpath("//table[@id='DataTables_Table_0']//td[11]")).getText();
		System.out.println(TPLIStatus);
		
	}
}

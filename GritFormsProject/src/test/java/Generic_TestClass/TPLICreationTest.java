package Generic_TestClass;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.vsysq.base.ExtentTestManager;
import com.vsysq.base.TestBase;
import com.vsysq.pages.TPLICreation;
import com.vsysq.pages.TradePackageCreation;

public class TPLICreationTest extends TestBase{
	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}
	@Test
	public void createTradePackageLineItem(String year,String EQType,String make,String model,String Emake,String SerialNo,String drive,String power,String height,String Auction,String buyPrice, String AccName1) throws Exception {

        ExtentTest test = ExtentTestManager.getTest();
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		TPLICreation createTPLI = new TPLICreation(driver);
		

		
		createTPLI.ClickTPLItemLink();
		captureScreen(driver, "ClickTPLIlink");
		test.pass("More link clicked and entered into Trade Packages tab", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/ClickTPLIlink.png")
				.build());
		Assert.assertTrue(true);
//		
		//Fill machine details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Year']/parent::label/following-sibling::input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Year']/parent::label/following-sibling::input")));
		createTPLI.FillTPLIDetails(year, EQType, make, model, Emake, SerialNo, drive, power, height, Auction);
		captureScreen(driver, "FillTPLIDetails");
		test.pass("Machine details filled", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/FillTPLIDetails.png")
				.build());
		Assert.assertTrue(true);
		
		//Fill Finance Details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Buy Price']/parent::label/following-sibling::input")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Buy Price']/parent::label/following-sibling::input")));
		createTPLI.FinanceDetails(buyPrice);
		captureScreen(driver, "FillFinanceDetails");
		test.pass("Finance details filled", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/FillFinanceDetails.png")
				.build());
		Assert.assertTrue(true);
		
		//Fill location details
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@placeholder='Search Accounts...'])[1]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@placeholder='Search Accounts...'])[1]")));
		createTPLI.LocationDetails(AccName1);
		captureScreen(driver, "FillLocationDetails");
		test.pass("Location details filled", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/FillLocationDetails.png")
				.build());
		Assert.assertTrue(true);
		
		//Save
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Save'])[3]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Save'])[3]")));
		createTPLI.SaveDetails();
		captureScreen(driver, "SaveDetails");
		test.pass("Save Machine Details", MediaEntityBuilder
				.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/SaveDetails.png")
				.build());
		Assert.assertTrue(true);
					
}
}
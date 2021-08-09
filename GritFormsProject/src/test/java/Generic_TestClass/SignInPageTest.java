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
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.vsysq.base.ExtentTestManager;
import com.vsysq.base.TestBase;
import com.vsysq.pages.BasePage;
import com.vsysq.pages.SignInPage;

public class SignInPageTest extends TestBase {

	public static ExtentReports extent;
	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeClass
	public void setUp() {
		driver = getDriver();

	}

	@Test(groups = { "functest" })
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		SignInPage lp = new SignInPage(driver);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		// Entering user Name
		lp.setUserName(user);
		test.pass("user name " + user + " entered successfully");

		// Entering Password
		lp.setPassword(pwd);
		test.pass("password entered successfully");

		// Click on login button
		lp.clickSubmit();

		// capturing Login Error if login failed
		if (driver.findElements(By.xpath("//div[@class='loginError'][@id='error']")).size() != 0) {

			captureScreen(driver, "LoginUnsuccessful");
			test.fail("Not logged into salesforce application refer the screenshot", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/LoginUnsuccessful.png")
					.build());
			Assert.assertTrue(false);

		} else {

			// Dynamic wait to load page objects
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Home']")));
			
			captureScreen(driver, "LoginSuccessful");
			test.pass("successfully logged in and navigated to home page", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/LoginSuccessful.png")
					.build());
			Assert.assertTrue(true);

		}
	}

}

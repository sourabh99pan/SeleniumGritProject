package com.vsysq.base;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;

public class TestBase {

	public static  WebDriver driver;
	
	private static String driverPath = System.getProperty("user.dir") + "/Drivers/";
	public static ExtentReports extent;
	
	
	public WebDriver getDriver() 
	{
		return driver;
	}

	private void setDriver(String browserType, String appURL)
	{		
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			System.out.println("in chrome browser");
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		//DesiredCapabilities caps = new DesiredCapabilities();
		//caps.s
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		//options.
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();		
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	@Parameters({ "browserType", "appURL" })
	@BeforeClass (alwaysRun = true)
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);
			System.out.println("in @beforeClass");

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	@BeforeMethod
	public void funcBeforeMethod()
	{
		System.out.println("i am in @BeforeMethod");
	}

	@BeforeTest
	public void funcBeforeTest()
	{
		System.out.println("i am in @BeforeTest");
	}
	
	@AfterMethod
	public void funcAfterMethod()
	{
		System.out.println("i am in @AfterMethod");
	}
	
	@AfterTest
	public void funcAfterTest()
	{
		System.out.println("i am in @AfterTest");
	}
	
	@AfterClass (alwaysRun = true)
	public void tearDown() throws Exception {
		driver.close();
		System.out.println("i am in @AfterClass"); 
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		
		System.out.println("Screenshot taken");
	}

}
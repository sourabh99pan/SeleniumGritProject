package Generic_TestClass;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import com.vsysq.pages.ElementPage;
import com.vsysq.pages.SignInPage;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class ElementsGeneric extends TestBase {

	public static ExtentReports extent;
	private String sTestCaseName;
	private int iTestCaseRow;
	//ExtentTest test = ExtentTestManager.getTest();
	@BeforeClass
	public void setUp() {
		driver = getDriver();

	}

	public void submitDet(String fullname, String email, String currAddress, String permAddress) throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		ElementPage lp = new ElementPage(driver);

		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
		// Entering fullname
		lp.setFullName(fullname);
		test.pass("user name "+fullname+" entered successfully");

		// Entering email
		lp.setEmail(email);
		test.pass("email "+email+"entered successfully");
		
		// Entering currentAddress
		lp.setCurrAdd(currAddress);
		test.pass("email "+currAddress+"entered successfully");
		
		// Entering permanentAddress
		lp.setPerAdd(permAddress);
		test.pass("email "+permAddress+"entered successfully");
		
		// Click on login button
		lp.clickSubmit();

		// capturing Login Error if login failed
		if (driver.findElements(By.id("output")).size() != 0) {

			captureScreen(driver, "DataSubmitted");
			test.pass("successfully Data submitted ", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/DataSubmitted.png")
					.build());
			Assert.assertTrue(true);

		} else {

			// Dynamic wait to load page objects
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("output")));
			captureScreen(driver, "Data_not_submitted");
			test.fail("Data not submittedn ", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/DataNotSubmitted.png")
					.build());
			Assert.assertTrue(false);

		}
	}
	
	public void radioBtnText(String msg) throws IOException
	{
		ExtentTest test = ExtentTestManager.getTest();
		 String rmsg = driver.findElement(By.className("text-success")).getText();
		 System.out.println("Radio button msg "+rmsg);
		 if(rmsg.equalsIgnoreCase(msg))
		 {	
			 captureScreen(driver, msg+" ButtonClicked");
				test.pass("Button Clicked", MediaEntityBuilder
						.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/"+msg+"ButtonClicked.png")
						.build());
				//Assert.assertTrue(true);
		 }
		 else
		 {
				captureScreen(driver, msg+" Button_not_Clicked");
				test.fail("Button not clicked", MediaEntityBuilder
						.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/"+msg+"ButtonNotClicked.png")
						.build());
				//Assert.assertTrue(false);
		 }
	}
	
    public static void verifyLinks(String linkUrl)
    {
        try
        { 
            URL url = new URL(linkUrl);
 
            //Now we will be creating url connection and getting the response code
            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
            httpURLConnect.setConnectTimeout(5000);
            httpURLConnect.connect();
            if(httpURLConnect.getResponseCode()>=400)
            {
             System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage() + "is a broken link");
            }    
       
            //Fetching and Printing the response code obtained
            else{
                System.out.println("HTTP STATUS - " + httpURLConnect.getResponseMessage());
            }
        }catch (Exception e) {
      }
   }
	public void submitDetonWebTable(String firstName, String lastName, String Age, String email, String Salary, String dept) throws InterruptedException, IOException {

		ExtentTest test = ExtentTestManager.getTest();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		ElementPage lp = new ElementPage(driver);
		
		//click on add
		lp.clickAdd();
		// Entering firstName
		lp.setwName(firstName);
		test.pass("first name "+firstName+" entered successfully");
		
		// Entering lastName
		lp.setwLastName(lastName);
		test.pass("last name "+lastName+" entered successfully");
		
		// Entering age
		//driver.findElement(By.id("age")).sendKeys("30");
		lp.setAge(Age);
		test.pass("Age entered successfully");
		
		// Entering email
		lp.setEmail(email);
		test.pass("email "+email+"entered successfully");
		
		// Entering Salary
		//driver.findElement(By.id("salary")).sendKeys("70000");
		lp.setSalary(Salary);
		test.pass("salary entered successfully");
		
		// Entering Department
		lp.setDept(dept);
		test.pass("Department "+dept+"entered successfully");
		
		Thread.sleep(10000);
		// Click on login button
		lp.clickSubmit();

		driver.findElement(By.id("searchBox")).sendKeys(email);
		// capturing Login Error if login failed
		
		
		if (searchOnWebtable(email)) {

			captureScreen(driver, "WebTable DataSubmitted");
			test.pass("successfully Data submitted ", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/WebTable_DataSubmitted.png")
					.build());
			System.out.println("WebTable DataSubmitted");
			Assert.assertTrue(true);

		} else {

			
			captureScreen(driver, " WebTable Data_not_submitted");
			test.fail("Data not submittedn ", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/WebTable_DataNotSubmitted.png")
					.build());
			System.out.println("WebTable Data not Submitted");
			Assert.assertTrue(false);

		}
	}
    
	public boolean isDiplayed(WebElement ele) throws IOException
	{
		ExtentTest test = ExtentTestManager.getTest();
		
		if(ele.isDisplayed())
		{
			System.out.println("in isDisplayed function");
			captureScreen(driver, "Button is displayed on Dynamic Properties");
			test.pass("Button Displayed ", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/Button_Displayed.png")
					.build());
			System.out.println("Button Displayed");
			Assert.assertTrue(true);
			return true;
		}
		else
		{
			System.out.println("in isDisplayed function");
			captureScreen(driver, "Button is not displayed on Dynamic Properties");
			test.fail("Button not Displayed ", MediaEntityBuilder
					.createScreenCaptureFromPath(System.getProperty("user.dir") + "/Screenshots/Button_Not_Displayed.png")
					.build());
			System.out.println("Button not Displayed");
			Assert.assertTrue(false);
			return false;
		}
		
	}
	public boolean searchOnWebtable(String data)
	{
		boolean datafound = false;
        WebElement webtable = driver.findElement(By.xpath("//div[contains(@class,'ReactTable')]"));
        
        //Get rows which has data
        ArrayList<WebElement>rowsWithData = (ArrayList<WebElement>) webtable.findElements(By.xpath(".//div[contains(@class,'rt-td') and text()]/ancestor::div[contains(@class,'rt-tr-group')]"));
        
        //Print the whole web table
        System.out.println("Table Data is: ");
        outer: for(int rowIndex =0; rowIndex<rowsWithData.size(); rowIndex++) {
         System.out.println("Data of Row " + (rowIndex+1) + " is:");
         ArrayList<WebElement> colsWithData = (ArrayList<WebElement>)rowsWithData.get(rowIndex).findElements(By.xpath(".//div[@class='rt-td'][text()]"));
         
	         for(int colIndex =0; colIndex<colsWithData.size(); colIndex++)
	         {
	        	 System.out.println("Data at Cell with Row "+ (rowIndex+1) + " Column " + (colIndex+1) + " : "+ colsWithData.get(colIndex).getText());
	         		if(colsWithData.get(colIndex).getText().equalsIgnoreCase(data))
	         		{
	         			System.out.println(data+" found");
	         			datafound = true;
	         			break outer;
	         			
	         		}
	         		
	         }
        }
		return datafound;

	}
}

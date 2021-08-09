package MPE2EFlow;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.vsysq.base.ExtentTestManager;
import com.vsysq.base.TestBase;
import com.vsysq.utilities.ExcelUtils;

import Generic_TestClass.AddProductstoOpportunityTest;
import Generic_TestClass.CreateContact;
import Generic_TestClass.CreateProspectAccount;
import Generic_TestClass.E2EOpportunityCreation;
import Generic_TestClass.OpportunityApprovalPageTest;
import Generic_TestClass.SignInPageTest;
import Generic_TestClass.opportunityloginTest;

public class TC_MPMPSAmericasSRSMorCSM extends TestBase {

	private String sTestCaseName;
	private int iTestCaseRow;

	@BeforeClass
	public void setUp() {
		driver = getDriver();

	}

	@Test(dataProvider = "E2EData", groups = { "functest" })

	public void TC_54_MPMPSAmericasSRSMorCSM(String Username, String Password, String LoginUser, String AccountStatus, String AccountHolder,
			String CustomerType, String ContactType, String ContactSalutn, String Firstname, String LastName,
			String PhoneNumber, String MobileNumber, String EmailId, String Accountname, String businessUnit,
			String ProductSpecialist, String OppNameEnter, String PriceBookName, String OppQual, String deal1,
			String OpportunityTerms, String SPARReason, String SPARCommentry,String Opportunityowner, String OpportunityName, String MarginAmount, String DOAPercentage, String Commission, String State,
			String AdditionalDiscPerc, String Product, String ActualDiscPerc, String UltimateApprover,String ApproverNames, String ApproverOpportunityName) throws InterruptedException, IOException {
		//test object
		ExtentTest test = ExtentTestManager.getTest();
		SignInPageTest obj1 = new SignInPageTest();
		opportunityloginTest obj2 = new opportunityloginTest();
		CreateProspectAccount obj3 = new CreateProspectAccount();
		CreateContact obj4 = new CreateContact();
		E2EOpportunityCreation obj5 = new E2EOpportunityCreation();
		AddProductstoOpportunityTest obj6 = new AddProductstoOpportunityTest();
		OpportunityApprovalPageTest obj7 = new OpportunityApprovalPageTest();
		obj1.loginDDT(Username, Password);
		test.pass("Login Successful");
		obj2.OpportunityLogin(LoginUser);
		test.pass("User Login Successful");

		// Create Account
		obj3.ProspectAccount(AccountStatus, AccountHolder, CustomerType);
		test.pass("Account Created Successfully");
		// code to click on Contact Part
		Thread.sleep(6000);
		// Contact Creation

		WebElement RelatedAccountoption = driver.findElement(By.xpath(
				"//a[@class='slds-card__header-link baseCard__header-title-container']//span[@title='Related Contacts']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", RelatedAccountoption);

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[@role='button']//div[text()='New Contact']")).click();

		// Click on Account Link
		obj4.TC_CreateContact(ContactType, ContactSalutn, Firstname, LastName, PhoneNumber, MobileNumber, EmailId,
				Accountname, businessUnit, ProductSpecialist);
		// Opportunity Creation
		test.pass("Contact Created Successfully");
		Thread.sleep(10000);
		
		// click on Account Name
		driver.findElement(By.xpath(
				"//tr[1]//td//span//a[@title='"+ AccountHolder + "']")).click();
		Thread.sleep(3000);
		WebElement Relatedopportunities = driver.findElement(By.xpath(
				"//a[@class='slds-card__header-link baseCard__header-title-container']//span[@title='Opportunities']"));
		js.executeScript("arguments[0].click();", Relatedopportunities);

		Thread.sleep(4000);
		obj5.CreateE2EOpportunity(OppNameEnter, PriceBookName, OppQual, deal1, OpportunityTerms, SPARReason,
				SPARCommentry);
		test.pass("Opportunity created successfully");
		Thread.sleep(30000);
		driver.findElement(By.xpath(
				"//tr[1]//th//span//a[@title='"+OppNameEnter+"']")).click();
		Thread.sleep(3000);
		obj6.AddProducts_Opportunity(Opportunityowner, OpportunityName, MarginAmount, DOAPercentage, Commission, State,
				AdditionalDiscPerc, Product, ActualDiscPerc, UltimateApprover);
		Thread.sleep(3000);
		test.pass("Products added to opportunity successfully");
		

		WebElement TotalStandardDiscountVariance = driver
				.findElement(By.xpath("(//span[contains(text(),'Additional Discount%')]//following::lightning-formatted-number)[1]"));
		String AddDiscount = TotalStandardDiscountVariance.getText();
		String ActualDiscountPercentage=AddDiscount.replaceAll("[^.\\s0-9\\s]", "");
		double AdditionalDiscountPercentage = Math.round(Double.parseDouble(ActualDiscountPercentage) * 100.0) / 100.0;
		if (AdditionalDiscountPercentage>0) {
			test.pass("Additional Discount percentage value is greater then Expected'" + AdditionalDiscountPercentage);
		} else {
			test.fail("Additional Discount percentage value is not greater then Expected'" + AdditionalDiscountPercentage);
		}
		
		WebElement VariancefromRSMThreshold = driver
				.findElement(By.xpath("(//span[contains(text(),'Max Standard Discount Variance')]//following::(//span[contains(text(),'Max Standard Discount Variance')]//following::lightning-formatted-text)[1]"));
		String RSMThreshold = VariancefromRSMThreshold.getText();
		String ActualRSMNumber=RSMThreshold.replaceAll("[^.\\s0-9\\s]", "");
		String ExpectedRSMthreshold="200000.00";
		double num2 = Math.round(Double.parseDouble(ActualRSMNumber) * 100.0) / 100.0;
		double num1= Math.round(Double.parseDouble(ExpectedRSMthreshold)* 100.0) / 100.0;
		if (num2>num1) {
			test.pass("Max Standard Discount Variance greater then expected'" + RSMThreshold);
		} else {
			test.fail("Max Standard Discount Variance not greater then expected'" + RSMThreshold);
		}
		
		
		obj6.SubmitOpportunityForApproval();
		Thread.sleep(1000);
		test.pass("Opportunity submited for approval successfully");
		
		
		obj7.ApproveOpportunity(ApproverNames, ApproverOpportunityName);
		
		test.pass("Approval process completed successfully");
	}

	@DataProvider(name = "E2EData")

public Object[][] Authentication() throws Exception {

		// Setting up the Test Data Excel file

		ExcelUtils.setExcelFile(System.getProperty("user.dir") + "/TestData/E2EMPTestData.xlsx",
				"MPData");
		sTestCaseName = this.toString();
		sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
		iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, 0);

		Object[][] testObjArray = ExcelUtils.getTableArray(
				System.getProperty("user.dir") + "/TestData/E2EMPTestData.xlsx", "MPData",
				iTestCaseRow);

		return (testObjArray);

	}
}


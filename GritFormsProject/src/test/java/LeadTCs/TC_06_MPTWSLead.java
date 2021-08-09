package LeadTCs;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.vsysq.base.ExtentTestManager;
import com.vsysq.base.TestBase;
import com.vsysq.utilities.ExcelUtils;

import Generic_TestClass.ConvertLeadTest;
import Generic_TestClass.CreateLeadTest;
import Generic_TestClass.SignInPageTest;
import Generic_TestClass.opportunityloginTest;

public class TC_06_MPTWSLead extends TestBase {
	
	public static ExtentReports extent;
	private String sTestCaseName;
	private int iTestCaseRow;
	
	@Test(dataProvider = "LeadCreationandConversion", groups = { "functest" })
	
	public void TC06MPTWSLead(String user, String pwd, String LeadOwner,String Salutation_Name, String First_Name,String Last_Name,String Phone,
			 String Company, String EmailId, String CustType, String BUType, String Queue_User, String Lead_Name)throws IOException, InterruptedException{
		
		ExtentTest test = ExtentTestManager.getTest();
		CreateLeadTest obj1= new CreateLeadTest();
		ConvertLeadTest obj2= new ConvertLeadTest();
		obj1.addNewLead(user, pwd, LeadOwner, Salutation_Name, First_Name, Last_Name, Phone, Company, EmailId, CustType, BUType);
		obj2.convertNewLead(Queue_User, Company, Lead_Name);
		
	}
	
	// Excel Data Picker
			@DataProvider(name = "LeadCreationandConversion")
			public Object[][] Authentication() throws Exception {

				// Setting up the Test Data Excel file

				ExcelUtils.setExcelFile(System.getProperty("user.dir") + "/TestData/LeadCreationandConvertion.xlsx", "TCData");

				sTestCaseName = this.toString();
				sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
				iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, 0);

				Object[][] testObjArray = ExcelUtils.getTableArray(
						System.getProperty("user.dir") + "/TestData/LeadCreationandConvertion.xlsx", "TCData", iTestCaseRow);

				return (testObjArray);
			}

}

package UEQ;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.vsysq.base.ExtentTestManager;
import com.vsysq.base.TestBase;
import com.vsysq.utilities.ExcelUtils;

import Generic_TestClass.InspectionReportsubmitTest;
import Generic_TestClass.TPLICreationTest;
import Generic_TestClass.TradePackageCreationTest;
import Generic_TestClass.ValuationTest;
import Generic_TestClass.expectedReceiptTest;

public class PurchaseOnly extends TestBase {
	public static ExtentReports extent;
	private String sTestCaseName;
	private int iTestCaseRow;

	@Test(dataProvider = "LoginData", groups = { "functest" })

	public void PurchaseOnly1(String user, String pwd,String InitialUser,String AccName,String ContactNames, String Type,String year,String EQType,String make,
			String model,String Emake,String SerialNo,String drive,String power,
			String height,String Auction,String buyPrice, String AccName1, String rouseFLV, String rbLatest, String BookValue, String rouseOLV, String rouseFMV, String suggestedRP, String PONumber,String Communityuser, String yardName) throws IOException, Exception {

		ExtentTest test = ExtentTestManager.getTest();

		TradePackageCreationTest obj1=new TradePackageCreationTest();
		TPLICreationTest obj2=new TPLICreationTest();
		ValuationTest obj3=new ValuationTest();
		expectedReceiptTest obj4=new expectedReceiptTest();
		InspectionReportsubmitTest obj5 =new InspectionReportsubmitTest();
		
		obj1.createTradePackage(user,pwd,InitialUser,AccName,ContactNames,Type);
		obj2.createTradePackageLineItem(year,EQType,make,model,Emake,SerialNo,drive,power,height,Auction,buyPrice,AccName1);
		obj3.ValuationandApproval(rouseFLV, rbLatest, BookValue, rouseOLV, rouseFMV, suggestedRP, PONumber);
		obj4.ExpectedReceiptCreation(Communityuser, yardName);
		
		obj5.InspectionReportSubmission();
}		
	// Excel Data Picker
	
			@DataProvider(name = "LoginData")
			public Object[][] Authentication() throws Exception {

				// Setting up the Test Data Excel file

				ExcelUtils.setExcelFile(System.getProperty("user.dir") + "/TestData/UsedEquipment.xlsx", "TCData");
				sTestCaseName = this.toString();
				sTestCaseName = ExcelUtils.getTestCaseName(this.toString());
				iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, 0);

				Object[][] testObjArray = ExcelUtils.getTableArray(System.getProperty("user.dir") + "/TestData/UsedEquipment.xlsx",
						"TCData", iTestCaseRow);

				return (testObjArray);

			}}

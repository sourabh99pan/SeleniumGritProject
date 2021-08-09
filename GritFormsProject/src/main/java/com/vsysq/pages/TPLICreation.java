package com.vsysq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vsysq.base.ExtentTestManager;

public class TPLICreation {
	public static String TPLINO;
	public static String TPNo;
	public static String TMSid;
	WebDriver driver;
	ExtentTest test = ExtentTestManager.getTest();

	public TPLICreation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[text()='Related']")
	WebElement RelatedTab;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[text()='Trade Package Line Items']/parent::a/span[1]")
	WebElement TPLILink;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//div[@title='New'])[3]")
	WebElement New2;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[text()='Year']/parent::label/following-sibling::input")
	WebElement Year;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//a[@class='select'])[2]")
	WebElement EquipmentType;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//a[@class='select'])[3]")
	WebElement Make;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[text()='Model']/parent::label/following-sibling::input")
	WebElement Model;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//a[@class='select'])[4]")
	WebElement EngineMake;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[text()='Serial Number']/parent::label/following-sibling::input")
	WebElement SerialNumber;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//a[@class='select'])[5]")
	WebElement Drive;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//a[@class='select'])[6]")
	WebElement Power;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[text()='Height']/parent::label/following-sibling::input")
	WebElement Height;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//a[@class='select'])[8]")
	WebElement AuctionType;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[text()='Buy Price']/parent::label/following-sibling::input")
	WebElement BuyPrice;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Search Accounts...'])[1]")
	WebElement MachineLocation;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Search Accounts...'])[3]")
	WebElement Yard;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//span[text()='Save'])[3]")
	WebElement Save2;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//table[@data-aura-class='uiVirtualDataTable'])[2]/tbody[1]/tr/th/span/a")
	WebElement TPLINoLink;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//*[text()='Trade Package'])[2]/parent::div/parent::div/div[2]/span/slot/slot/force-lookup/div/force-hoverable-link/div/a")
	WebElement TPNoLink;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//table[@data-aura-class='uiVirtualDataTable'])[2]/tbody[1]/tr/th/span/following::td[1]/span/span")
	WebElement TMSID;

	// Click on Trade Package Line Item Link
	public void ClickTPLItemLink() {
		try {
			Actions act = new Actions(driver);

			Thread.sleep(6000);
			act.moveToElement(TPLILink).click().build().perform();
			Thread.sleep(8000);
			New2.click();
			test.pass("User clicked TPLI link and new button successfully");

		} catch (Exception e) {
			test.fail("Failed to click on TPLI link and new button");

		}
	}

	public void FillTPLIDetails(String year, String EQType, String make, String model, String Emake, String SerialNo,
			String drive, String power, String height, String Auction) {
		try {
			Thread.sleep(6000);
			Year.sendKeys(year);
			Thread.sleep(2000);
			EquipmentType.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='" + EQType + "']")).click();
			Thread.sleep(2000);
			Make.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='" + make + "']")).click();
			Thread.sleep(2000);
			Model.sendKeys(model);
			Thread.sleep(2000);
			EngineMake.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='" + Emake + "']")).click();
			Thread.sleep(2000);
			SerialNumber.sendKeys(SerialNo);
			Thread.sleep(2000);
			Drive.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='" + drive + "']")).click();
			Thread.sleep(2000);
			Power.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='" + power + "']")).click();
			Thread.sleep(2000);
			Height.sendKeys(height);
			Thread.sleep(2000);
			// AuctionType.click();
			Thread.sleep(2000);
			test.pass("User entered all the basic details of the machine successfully");

		} catch (Exception e) {
			test.fail("Failed to enter machine details");

		}
	}

	public void FinanceDetails(String buyPrice) {
		try {
			Thread.sleep(5000);
			BuyPrice.sendKeys(buyPrice);
			test.pass("User entered Buy Price successfully");

		} catch (Exception e) {
			test.fail("Failed to enter buy price");

		}
	}

	public void LocationDetails(String AccName1) {
		try {
			Thread.sleep(5000);
			MachineLocation.sendKeys(AccName1);
			Thread.sleep(5000);
			MachineLocation.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//tr[1]//td[1]//a")).click();
			Thread.sleep(5000);
			Yard.sendKeys(AccName1);
			Thread.sleep(5000);
			Yard.sendKeys(Keys.ENTER);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//tr[1]//td[1]//a")).click();
			test.pass("User entered location details successfully");

		} catch (Exception e) {
			test.fail("Failed to enter location details");

		}

	}

	public void SaveDetails() {
		try {

			Actions act = new Actions(driver);

			Thread.sleep(10000);
			Save2.click();
			Thread.sleep(10000);
			TPLINO = TPLINoLink.getText();
			TMSid = TMSID.getText();
			System.out.println(TMSid);
			act.moveToElement(TPLINoLink).click().build().perform();
			Thread.sleep(5000);
			TPNo = TPNoLink.getText();

			act.moveToElement(TPNoLink).click().build().perform();
			test.pass("User clicked on Save button successfully and reached TP page successfully");

		} catch (Exception e) {
			test.fail("Failed to click on Save button");

		}

	}
}

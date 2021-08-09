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

public class CreateAccountPage {

	WebDriver driver;
	

	@FindBy(how = How.XPATH, using = "//one-app-nav-bar-item-root[@data-id='home']")
	@CacheLookup
	WebElement HomeMenu;

	@FindBy(how = How.XPATH, using = "//one-app-nav-bar-item-root[@data-id='Account']")
	@CacheLookup
	WebElement AccountsMenu;

	@FindBy(how = How.XPATH, using = "//a[@class='forceActionLink']//div[@title='New']")
	@CacheLookup
	WebElement newAccountButton;

	@FindBy(how = How.XPATH, using = "//h2[text()='New Account']")
	@CacheLookup
	WebElement NewAccountPageheader;

	@FindBy(how = How.XPATH, using = "//span[@class='slds-form-element__label'][text()='Part Account']")
	@CacheLookup
	WebElement PartAccountRadioButton;

	@FindBy(how = How.XPATH, using = "//span[text()='Parent Account']//preceding::input[2]")
	@CacheLookup
	WebElement ParentAccountName;

	@FindBy(how = How.XPATH, using = "//span[text()='Regional Sales Manager']//following::input[1]")
	@CacheLookup
	WebElement objRegionalSalesManager;

	@FindBy(how = How.XPATH, using = "//span[text()='Next']")
	@CacheLookup
	WebElement nextButton;

	@FindBy(how = How.XPATH, using = "//span[text()='Equipment Territory Sales Manager']//following::input[1]")
	@CacheLookup
	WebElement objETSalesManager;

	@FindBy(how = How.XPATH, using = "//span[text()='Service Territory Sales Manager']//following::input[1]")
	@CacheLookup
	WebElement objSTSalesManager;

	@FindBy(how = How.XPATH, using = "//a[@data-interactive-lib-uid='17']")
	@CacheLookup
	WebElement CustomerType;

	@FindBy(how = How.XPATH, using = "//a[@data-interactive-lib-uid='34']")
	@CacheLookup
	WebElement Customersegment;

	@FindBy(how = How.XPATH, using = "//a[@data-interactive-lib-uid='37']")
	@CacheLookup
	WebElement Taxtype;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[@title='Save']")
	WebElement SaveButton;

	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "Target Growth")
	WebElement CustomerTypedata;

	@CacheLookup
	@FindBy(how = How.LINK_TEXT, using = "International")
	WebElement CustomerSegmentdata;
	
	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	
	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public boolean verifyPageTitle() {
		String pageTitle = "Create your Google Account";
		return getPageTitle().contains(pageTitle);
	}

	public void ClickHomeMenu() {
		HomeMenu.click();
	}

	public void ClickAccountsMenu() {
		AccountsMenu.click();

	}

	public void ClicknewAccountButton() {
		newAccountButton.click();

	}

	public void PartAccountRadioButtonClick() {
		PartAccountRadioButton.click();
	}

	public void NextButtonClick() {
		nextButton.click();
	}

	public void ParentAccountName(String AccountHolderName) {
		ParentAccountName.sendKeys(AccountHolderName);
	}

	public void RegionalSalesManager(String ReginalSalesManagerName) throws InterruptedException {
		WebElement RSmanager = objRegionalSalesManager;
		Actions builder = new Actions(driver);
		Actions seriesOfActions = builder.moveToElement(RSmanager).click().sendKeys(RSmanager, ReginalSalesManagerName);
		seriesOfActions.perform();
		Thread.sleep(300);
		objRegionalSalesManager.sendKeys(Keys.ENTER);
	}

	public void addManager(String Name) {

		int rowCount = driver
				.findElements(
						By.xpath("//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']/tbody/tr"))
				.size();
		System.out.println(rowCount);
		for (int i = 1; i <= rowCount; i++) {
			String sCellValue = driver.findElement(
					By.xpath("//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']/tbody/tr[" + i
							+ "]/td[1]"))
					.getText();

			if (sCellValue.equalsIgnoreCase(Name)) {
				driver.findElement(
						By.xpath("//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']/tbody/tr["
								+ i + "]/td[1]/div/div[@class='name']/div/a"))
						.click();
			}
		}

	}

	public void EquipmentTerritorySalesManager(String EquipmentSalesManagerName) throws InterruptedException {
		WebElement ETmanager = objETSalesManager;
		Actions builder = new Actions(driver);
		Actions seriesOfActions = builder.moveToElement(ETmanager).click().sendKeys(ETmanager,EquipmentSalesManagerName);
		seriesOfActions.perform();
		Thread.sleep(300);

		objETSalesManager.sendKeys(Keys.ENTER);
	}

	public void ServiceTerritorySalesManager(String ServicesalesManager) throws InterruptedException {

		WebElement STmanager = objSTSalesManager;
		Actions builder = new Actions(driver);
		Actions seriesOfActions = builder.moveToElement(STmanager).click().sendKeys(STmanager, ServicesalesManager);
		seriesOfActions.perform();
		Thread.sleep(300);

		objSTSalesManager.sendKeys(Keys.ENTER);

	}

	public void customerType() throws InterruptedException {
		CustomerType.click();

	}

	public void customerSegment() {
		Customersegment.click();

	}

	public void taxtype() {
		Taxtype.click();

	}

	public void saveButton() {
		SaveButton.click();
	}
}
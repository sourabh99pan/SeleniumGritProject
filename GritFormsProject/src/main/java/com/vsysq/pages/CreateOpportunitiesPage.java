package com.vsysq.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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


public class CreateOpportunitiesPage

{
	WebDriver driver;
	ExtentTest test = ExtentTestManager.getTest();
	
	public CreateOpportunitiesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//one-app-nav-bar-item-root[@data-id='Opportunity']")
	WebElement OpportunityTab;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[@class='forceActionLink']//div[@title='New']")
	WebElement NewButton;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[@class='slds-form-element__label'][text()='MP Opportunity']")
	WebElement MPOpportunity;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button/span[text()='Next']")
	WebElement NextButton;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[text()='Opportunity Information']/following::input[1]")
	WebElement OppName;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@title='Search Accounts']")
	WebElement AccName;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//div[@title='MOVITEC S.R.L.']")
	WebElement AccNameEnter;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//input[@title='Search Price Books']")
	WebElement PriceBook;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//div[@title='MP-Franna 2019'and @class='primaryLabel slds-truncate slds-lookup__result-text']")
	WebElement PriceBookName;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "((//span[text()='Est. Close Date'])[2]//following::input)[1]")
	WebElement close;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//table[@class='calGrid']//button[text()='Today']")
	WebElement closedate;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "((//span[contains(text(),'Anticipated Ship Date')])//following::input)[1]")
	WebElement ship;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//table[@class='calGrid']//button[text()='Today']")
	WebElement shipdate;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//div[@data-aura-class='uiMenu uiInput uiInputSelect forceInputPicklist uiInput--default uiInput--select']//a[text()='--None--']")
	WebElement Stage;

	/*
	 * @CacheLookup
	 * 
	 * @FindBy(how = How.XPATH, using =
	 * "//a[@title='1 - Opportunity Quantification']") WebElement OppQual;
	 */

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[text()='Deal Likelihood %']/following::a[1]")
	WebElement DealLikehoood;

	/*
	 * @CacheLookup
	 * 
	 * @FindBy(how = How.XPATH, using =
	 * "//div[@class='select-options']/ul/li/a[@role='menuitemradio'][(text()='10')]")
	 * WebElement deal1;
	 */

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//ul[@role='listbox']//span[text()='TFS']")
	WebElement TFS;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[text()='Probability (%)']/preceding::button[2]")
	WebElement TFSRightClick;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//button[@title='Save']")
	WebElement Save;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']/tbody/tr/td[1]")
	WebElement AccountEnter;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']/tbody/tr/td/a[@title='MP-Franna 2019']")
	WebElement PriceBookEnter;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[text()='SPAR Reason']/following::a[1]")
	WebElement SPARReason;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//span[text()='SPAR Commentary']/following::textarea[1]")
	WebElement SPARComment;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "(//span[text()='Terms'])[2]/following::a[1]")
	WebElement OpportunityTerms;
	
	public void ClickOpportunityTab() throws InterruptedException {
		try{
			OpportunityTab.click();
			test.pass("User clicked Opportunities tab successfully");
		}
		catch(Exception e){
			test.fail("Failed to click on Opportunity Tab");		
		}
	}

	public void ClickNewButton() throws InterruptedException {
		try{
			NewButton.click();
			Thread.sleep(3000);	
			test.pass("User clicked New Opportunity button successfully");
		}
		catch(Exception e){
			test.fail("Failed to click on New button on Opportunity page");
		}
	}

	public void ClickMPOpportunity() throws InterruptedException {
		try{
			MPOpportunity.click();
			test.pass("User selected Opportunity type 'MP Opportunity' successfully");
		}
		catch(Exception e){
			test.fail("Failed to select record type as 'MP Opportunity'");
		}
	}

	public void ClickNextButton() {
		try{
			NextButton.click();
			test.pass("User clicked Next button successfully");	
		}
		catch(Exception e){
			test.fail("Failed to click Next button on select record type page");
		}
	}

	public void sendOppoName(String OppNameEnter) {
		try{
			OppName.sendKeys(OppNameEnter);
			test.pass("User entered Opportunity name as '"+ OppNameEnter +"' successfully");
		}
		catch(Exception e){
			test.fail("Failed to enter Opportunity Name on Opportunity page");
		}		
	}

	public void AccountName(String AccNameEnter) throws InterruptedException {
		try{
			WebElement location = AccName;
			Actions builder = new Actions(driver);
			Actions seriesOfActions = builder.moveToElement(location).click().sendKeys(location, AccNameEnter);
			seriesOfActions.perform();
			Thread.sleep(3000);
			AccName.sendKeys(Keys.ENTER);
			Thread.sleep(6000);		
			AccountEnter.click();	
			test.pass("User entered Account name as '" +AccNameEnter+ "' successfully");
		}
		catch(Exception e){
			test.fail("Failed to enter Account Name on Opportunity page");
		}
	}

	public void PriceName(String PriceBookName) throws InterruptedException {
		try{
			WebElement location_1 = PriceBook;
			Actions builder = new Actions(driver);
			Actions seriesOfActions = builder.moveToElement(location_1).click().sendKeys(location_1, PriceBookName);
			seriesOfActions.perform();
			Thread.sleep(3000);
			PriceBook.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataGrid--default uiVirtualDataGrid']/tbody/tr/td/a[@title='"+ PriceBookName +"']")).click();
			Thread.sleep(1000);
			test.pass("User entered Price book name as '" +PriceBookName+ "' successfully");
		}
		catch(Exception e){
			test.fail("Failed to enter Price Book Name on Opportunity page");
		}
	}

	public void CloseDateClick() throws InterruptedException {
		try{
			Thread.sleep(5000);
			close.click();		
		}
		catch(Exception e){
			test.fail("Failed to enter Close date on Opportunity page");
		}
	}

	public void CloseDateEnter() {
		try{
			closedate.click();	
			test.pass("User entered Est. close Date as Current Date successfully");
		}
		catch(Exception e){
			test.fail("Failed to enter Close date on Opportunity page");
		}		
	}

	public void ShipDateClick() throws InterruptedException {
		try{
			Thread.sleep(5000);
			ship.click();			
		}
		catch(Exception e){
			test.fail("Failed to enter ship date on Opportunity page");
		}
	}

	public void ShipDateEnter() {
		try{
			shipdate.click();
			test.pass("User entered Est. Ship Date as Current Date successfully");
		}
		catch(Exception e){
			test.fail("Failed to enter ship date on Opportunity page");
		}		
	}

	public void StageClick(String OppQual) {
		try{
			Stage.click();
			driver.findElement(
					By.xpath("//div[@class='select-options']/ul/li/a[@role='menuitemradio'][(text()='" + OppQual + "')]"))
					.click();	
			test.pass("User entered Stage successfully");
		}
		catch(Exception e){
			test.fail("Failed to enter Stage on Opportunity page");
		}
	}

	public void DealLikehooodClick(String deal1) {
		try{
			DealLikehoood.click();
			driver.findElement(
					By.xpath("//div[@class='select-options']/ul/li/a[@role='menuitemradio'][(text()='" + deal1 + "')]"))
					.click();	
			test.pass("User selected Deal likehood as '"+ deal1 +"%' successfully");
		}
		catch(Exception e){
			test.fail("Failed to enter Deal likehood on Opportunity page");
		}
	}

	public void TFSAction() throws InterruptedException {
		try{
			Thread.sleep(7000);
			TFS.click();
			Thread.sleep(2000);
			TFSRightClick.click();
			Thread.sleep(2000);			
		}
		catch(Exception e){
			test.fail("Failed to enter TFS action on Opportunity page");
		}
	}

	public void SPARReasonClick(String SPARReasonValue) throws InterruptedException {
		try{
			Thread.sleep(4000);
			SPARReason.click();
			Thread.sleep(1000);
			driver.findElement(
					By.xpath("//div[@class='select-options']/ul/li/a[@role='menuitemradio'][(text()='" + SPARReasonValue + "')]"))
					.click();	
			test.pass("User selected SPAR reason as '" +SPARReasonValue+ "' successfully");
		}
		catch(Exception e){
			test.fail("Failed to enter SPAR Reason on Opportunity page");
		}	
	}
	
	public void SPARCommentryClick(String SPARCommentry) throws InterruptedException {
		try{
			Thread.sleep(2000);
			SPARComment.click();
			driver.findElement(
					By.xpath("//span[text()='SPAR Commentary']/following::textarea[1]")).sendKeys(SPARCommentry);	
			test.pass("User entered SPAR commentry as '" +SPARCommentry+ "' successfully");
		}
		catch(Exception e){
			test.fail("Failed to enter SPAR Commentry on Opportunity page");
		}	
	}
	
	public void SaveClick() throws InterruptedException {
		try{
			Thread.sleep(2000);
			Save.click();			
		}
		catch(Exception e){
			test.fail("Failed to click Save Opportunity button");
		}
	}
	
	public void OpportunityTerms(String OpportunityTermsValue) throws InterruptedException{
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
			try{
			    //Select Product checkbox
			    WebElement terms = driver.findElement(By.xpath("//span[text()='Terms']/following::a[1]"));
			    executor.executeScript("arguments[0].scrollIntoView(true);", terms);
				executor.executeScript("arguments[0].click();", terms); 
				test.pass("Clicked on Terms successfully");
				
				WebElement termsvalue = driver.findElement(By.xpath("//div[@class='select-options']/ul/li/a[@role='menuitemradio'][(text()='" + OpportunityTermsValue + "')]"));
				executor.executeScript("arguments[0].click();", termsvalue); 
				test.pass("User entered opportunity terms as '" +OpportunityTerms+ "' successfully");				
			}
			catch(Exception e){
				test.fail("Failed to select Opportunity Terms on Opportunity page");
			}		
	}

}

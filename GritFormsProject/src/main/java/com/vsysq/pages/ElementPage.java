package com.vsysq.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vsysq.base.ExtentTestManager;


public class ElementPage {

	WebDriver driver;
	ExtentTest test = ExtentTestManager.getTest();

	public ElementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
  
	}

	@FindBy(id="userName")
	@CacheLookup
	WebElement txtFirstName;
	
	@FindBy(id="userEmail")
	@CacheLookup
	WebElement txtUserEmail;
	
	@FindBy(id="currentAddress")
	@CacheLookup
	WebElement txtCurrAdd;
	
	@FindBy(id="permanentAddress")
	@CacheLookup
	WebElement txtPerAdd;
	
	@FindBy(id="submit")
	@CacheLookup
	WebElement btnSubmit;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//div[@class='loginError'][@id='error']")
	WebElement loginError;
	
	//webtable webElements
	@FindBy(id="addNewRecordButton")
	WebElement waddButton;
	
	@FindBy(id="firstName")
	WebElement wFirstName;
	
	@FindBy(id="lastName")
	WebElement wLastName;
	
	@FindBy(id="age")
	WebElement wage;
	
	@FindBy(id="salary")
	WebElement wsalary;
	
	@FindBy(id="department")
	WebElement wdepartment;
	
	public void setFullName(String fname)
	{
		try{
			txtFirstName.sendKeys(fname);
		}
		catch(Exception e){
			test.fail("Failed to enter user name");
			driver.quit();
		}		
	}
	
	public void setEmail(String email)
	{
		try{
			txtUserEmail.sendKeys(email);
		}
		catch(Exception e){
			test.fail("Failed to enter user email");
			driver.quit();
		}		
	}
	
	public void setCurrAdd(String cadd)
	{
		try{
			txtCurrAdd.sendKeys(cadd);
		}
		catch(Exception e){
			test.fail("Failed to enter current address");
			driver.quit();
		}		
	}
	
	public void setPerAdd(String padd)
	{
		try{
			txtPerAdd.sendKeys(padd);			
		}
		catch(Exception e){
			test.fail("Failed to enter permanent address");
			driver.quit();
		}		
	}
	
	public void setwName(String fname)
	{
		try{
			wFirstName.sendKeys(fname);
		}
		catch(Exception e){
			test.fail("Failed to enter first name on webTable");
			driver.quit();
		}		
	}
	
	public void setwLastName(String lname)
	{
		try{
			wLastName.sendKeys(lname);
		}
		catch(Exception e){
			test.fail("Failed to enter last name on webTable");
			driver.quit();
		}		
	}
	
	public void setAge(String age)
	{
		try{
			wage.sendKeys(age);
		}
		catch(Exception e){
			test.fail("Failed to enter age on webTable");
			driver.quit();
		}		
	}
	
	public void setSalary(String salary)
	{
		try{
			wsalary.sendKeys(salary);
		}
		catch(Exception e){
			test.fail("Failed to enter salary on webTable");
			driver.quit();
		}		
	}
	
	public void setDept(String dept)
	{
		try{
			wdepartment.sendKeys(dept);
		}
		catch(Exception e){
			test.fail("Failed to enter department on webTable");
			driver.quit();
		}		
	}
	
	public void clickAdd()
	{
		try{
			waddButton.click();
		}
		catch(Exception e){
			test.fail("Failed to click on add button");
			driver.quit();
		}
		
	}	
	
	public void clickSubmit()
	{
		try{
			
			btnSubmit.click();
		}
		catch(Exception e){
			test.fail("Failed to click on submit button");
			driver.quit();
		}
		
	}	
	
	
}
package com.vsysq.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.vsysq.base.ExtentTestManager;


public class SignInPage {

	WebDriver driver;
	ExtentTest test = ExtentTestManager.getTest();

	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
  
	}

	@FindBy(id="username")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(id="Login")
	@CacheLookup
	WebElement btnLogin;
	
	@CacheLookup
	@FindBy(how = How.XPATH, using = "//div[@class='loginError'][@id='error']")
	WebElement loginError;
	
	
	public void setUserName(String uname)
	{
		try{
			txtUserName.sendKeys(uname);
		}
		catch(Exception e){
			test.fail("Failed to enter user name");
			driver.quit();
		}		
	}
	
	public void setPassword(String pwd)
	{
		try{
			txtPassword.sendKeys(pwd);			
		}
		catch(Exception e){
			test.fail("Failed to enter password");
			driver.quit();
		}		
	}
	
	public void clickSubmit()
	{
		try{
			btnLogin.click();
		}
		catch(Exception e){
			test.fail("Failed to click login button");
			driver.quit();
		}
		
	}	
	
	
}
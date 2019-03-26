package com.planitdemo.facebook.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.planitdemo.facebook.pom.base.BasePage;
import com.planitdemo.facebook.pom.util.FBConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LaunchPage extends BasePage{
	
	public LaunchPage(WebDriver driver,ExtentTest test){
		super(driver,test);	
	}
	
	public LoginPage gotoLoginPage(){
		test.log(LogStatus.INFO, "Opening the url - "+FBConstants.HOMEPAGE_URL);
		driver.get(FBConstants.HOMEPAGE_URL);
		test.log(LogStatus.PASS, "URL Opened - "+FBConstants.HOMEPAGE_URL);
		LoginPage loginPage = new LoginPage(driver,test);
		PageFactory.initElements(driver, loginPage);
		return loginPage;
	}
}

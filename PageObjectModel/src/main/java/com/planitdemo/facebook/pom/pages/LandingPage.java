package com.planitdemo.facebook.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.planitdemo.facebook.pom.base.BasePage;
import com.planitdemo.facebook.pom.util.FBConstants;
import com.relevantcodes.extentreports.ExtentTest;

public class LandingPage extends BasePage{
	
	
	@FindBy(how=How.CSS, using=FBConstants.LANDING_PAGE_CONFIRM_YOUR_MAIL_TITLE)
	public WebElement confirm_your_mail_title;
	
	@FindBy(how=How.ID, using= FBConstants.LANDING_PAGE_USER_NAVIGATION_LABLE)
	public WebElement user_nevigation_lable;

	public LandingPage(WebDriver driver,ExtentTest test){
		super(driver,test);
	}
}

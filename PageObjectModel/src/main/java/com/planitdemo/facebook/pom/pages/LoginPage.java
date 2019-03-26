package com.planitdemo.facebook.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import com.planitdemo.facebook.pom.base.BasePage;
import com.planitdemo.facebook.pom.util.FBConstants;
import com.relevantcodes.extentreports.ExtentTest;

public class LoginPage extends BasePage{
	
	@FindBy(how=How.CSS, using = FBConstants.SIGN_UP_FIRST_NAME)
	public WebElement first_name;
	
	@FindBy(how=How.CSS, using= FBConstants.SIGN_UP_LAST_NAME)
	public WebElement last_name;
	
	@FindBy(how=How.CSS, using= FBConstants.SIGN_UP_MOBILE_OR_EMAIL)
	public WebElement mobile_or_email;
	
	@FindBy(how=How.CSS, using= FBConstants.SIGN_UP_RE_ENTER_EMAIL)
	public WebElement re_enter_email;
	
	@FindBy(how=How.CSS, using= FBConstants.SIGN_UP_NEW_PASSWORD)
	public WebElement new_password;

	
	@FindBy(how=How.CSS, using= FBConstants.SIGN_UP_DAY)
	public WebElement sday;
	public Select selectDay() {
		return new Select(sday);
	}

	@FindBy(how=How.CSS, using= FBConstants.SIGN_UP_MONTH)
	public WebElement smonth;
	public Select selectMonth() {
		return new Select(smonth);
	}
	
	@FindBy(how=How.CSS, using= FBConstants.SIGN_UP_YEAR)
	public WebElement syear;
	public Select selectYear() {
		return new Select(syear);
	}

	@FindBy(how=How.CSS, using= FBConstants.SIGN_UP_GENDER_MALE)
	public WebElement gender_male;
	
	@FindBy(how=How.CSS, using= FBConstants.SIGN_UP_GENDER_FEMALE)
	public  WebElement gender_female;
	
	@FindBy(how=How.CSS, using= FBConstants.SIGN_UP_BUTTON)
	public WebElement signUp_button;
	
	@FindBy(how=How.XPATH, using= FBConstants.SIGN_UP_ERROR)
	public WebElement error_js;
	
	
	//constructor
	public LoginPage(WebDriver driver, ExtentTest test){
		super(driver,test);
	}
}

package com.planitdemo.facebook.pom.testcases;

import java.util.Hashtable;

import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.planitdemo.facebook.pom.pages.LaunchPage;
import com.planitdemo.facebook.pom.pages.LoginPage;
import com.planitdemo.facebook.pom.pages.LandingPage;
import com.planitdemo.facebook.pom.base.BaseTest;
import com.planitdemo.facebook.pom.util.DataUtil;
import com.planitdemo.facebook.pom.util.FBConstants;
import com.relevantcodes.extentreports.LogStatus;

public class SignUpTest extends BaseTest{
	String testCaseName="Sign_Up_Test";
	
	@Test(dataProvider="getData")
	public void doSignUp(Hashtable<String,String> data){
		test = extent.startTest("Sign_Up_Test");
		
		if(!DataUtil.isTestExecutable(xls, testCaseName) ||  data.get(FBConstants.RUNMODE_COL).equals("N")){
			test.log(LogStatus.SKIP, "Skipping the test as Rnumode is N");
			throw new SkipException("Skipping the test as Rnumode is N");
		}
		
		test.log(LogStatus.INFO, "Starting Sign Up Test");
		init(data.get("Browser"));
		
		LaunchPage launchPage =new LaunchPage(driver,test);
		PageFactory.initElements(driver, launchPage);
		
		LoginPage loginPage = launchPage.gotoLoginPage();		
		loginPage.first_name.sendKeys(data.get("FirstName"));
		loginPage.last_name.sendKeys(data.get("LastName"));
		if(!data.get("MobileOrEmail").equals("NULL")) {
			loginPage.mobile_or_email.sendKeys(data.get("MobileOrEmail"));
		}
		loginPage.re_enter_email.sendKeys(data.get("Re-enterEmail"));
		loginPage.new_password.sendKeys(data.get("NewPassword"));

		//select DOB
		loginPage.selectDay().selectByVisibleText(data.get("Day"));
		loginPage.selectMonth().selectByVisibleText(data.get("Month"));
		loginPage.selectYear().selectByVisibleText(data.get("Year"));
		
		//select gender
		switch (data.get("Gender")) {
		
			case "Male":
				loginPage.gender_male.click();
				break;
			case "Female":
				loginPage.gender_female.click();
				break;
			case "":
				break;
			default: 
				loginPage.gender_male.click();
	            break;   
		}
		//Click on Sign Up
		loginPage.signUp_button.click();
		loginPage.takeScreenShot();
		loginPage.wait(3);
	
		if (!data.get("Error Message").equals("")) {
			if (loginPage.error_js.getText().equals(data.get("Error Message"))) {
				loginPage.reportPass("Error message validated successfully as:-"+"Expected-->["+data.get("Error Message")+"]...and Actual-->["+loginPage.error_js.getText()+"]");
				
			}else {
				
				loginPage.reportFailure("Failed to validate error message:-"+"Expected-->["+data.get("Error Message")+"]...and Actual-->["+loginPage.error_js.getText()+"]");
			}	
		}else {
				
			test.log(LogStatus.PASS, "No Error messages as all inputs are valid, signing in...");
			//Landing Page
			LandingPage landingPage = new LandingPage(driver,test);
			PageFactory.initElements(driver, landingPage);
			
			landingPage.waitForVisibilityOf(landingPage.confirm_your_mail_title);
			
				if (landingPage.confirm_your_mail_title.getText().equals("Confirm your email address")) {
					
					loginPage.reportPass("Signed in successfully by user-->"+data.get("FirstName"));
					
					}else {
						
						loginPage.reportFailure("Failed to sign in by user-->"+data.get("FirstName"));
					}
				}
	}
@DataProvider
	public Object[][] getData(){
		return DataUtil.getData(xls, testCaseName);
	}
}

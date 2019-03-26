package com.planitdemo.facebook.pom.util;

public class FBConstants {
	public static final boolean GRID_RUN=false;
	
	//paths
	public static final String CHROME_DRIVER_EXE=System.getProperty("user.dir")+"\\data\\drivers\\chromedriver.exe";
	// URLs
	public static final String HOMEPAGE_URL = "http://facebook.com";
	//paths
	public static final String REPORTS_PATH = System.getProperty("user.dir")+"\\reports\\";
	public static final String DATA_XLS_PATH = System.getProperty("user.dir")+"\\data\\Data.xlsx";
	public static final String TESTDATA_SHEET = "TestData";
	public static final Object RUNMODE_COL = "Runmode";
	public static final String TESTCASES_SHEET = "TestCases";
	
	// locators Login Page
	public static final String SIGN_UP_FIRST_NAME = "input[name=firstname]";
	public static final String SIGN_UP_LAST_NAME = "input[name=lastname]";
	public static final String SIGN_UP_MOBILE_OR_EMAIL = "input[name=reg_email__]";
	public static final String SIGN_UP_RE_ENTER_EMAIL = "input[name=reg_email_confirmation__]";
	public static final String SIGN_UP_NEW_PASSWORD = "input[name=reg_passwd__]";
	public static final String SIGN_UP_DAY = "select[name=birthday_day]";
	public static final String SIGN_UP_MONTH = "select[name=birthday_month]";
	public static final String SIGN_UP_YEAR = "select[name=birthday_year]";
	public static final String SIGN_UP_GENDER_MALE = "input[type=radio][value='1']";
	public static final String SIGN_UP_GENDER_FEMALE = "input[type=radio][value='2']";;
	public static final String SIGN_UP_BUTTON = "button[name=websubmit]";
	public static final String SIGN_UP_ERROR = ".//div[@class='_5633 _5634 _53ij']";
	
	// locators Landing Page
	public static final String LANDING_PAGE_CONFIRM_YOUR_MAIL_TITLE = "h2.uiHeaderTitle";
	public static final String LANDING_PAGE_USER_NAVIGATION_LABLE= "userNavigationLabel";

	

	



	


	


	




	



	

}

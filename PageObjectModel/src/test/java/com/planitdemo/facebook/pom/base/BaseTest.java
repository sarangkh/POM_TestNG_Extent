package com.planitdemo.facebook.pom.base;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

import com.planitdemo.facebook.pom.util.ExtentManager;
import com.planitdemo.facebook.pom.util.FBConstants;
import com.planitdemo.facebook.pom.util.Xls_Reader;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest {
	public ExtentReports extent = ExtentManager.getInstance();
	public ExtentTest test;
	public Xls_Reader xls = new Xls_Reader(FBConstants.DATA_XLS_PATH);

	
	public WebDriver driver;
	public void init(String bType){
		test.log(LogStatus.INFO, "Opening browser - "+ bType);
		if(!FBConstants.GRID_RUN){
			// local machine
			if(bType.equals("Mozilla"))
				driver= new FirefoxDriver();
			else if(bType.equals("Chrome")){
				System.setProperty("webdriver.chrome.driver", FBConstants.CHROME_DRIVER_EXE);
				
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				driver = new ChromeDriver(options);
			}
		}else{
			// grid
			DesiredCapabilities cap=null;
			if(bType.equals("Mozilla")){
				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setJavascriptEnabled(true);
				cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				
			}else if(bType.equals("Chrome")){
				 cap = DesiredCapabilities.chrome();
				 cap.setBrowserName("chrome");
				 cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			}
			
			try {
				driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Opened browser successfully - "+ bType);

	}
	
@AfterMethod
public void quit(){
	if(extent!=null){
		extent.endTest(test);
		extent.flush();
		}
if(driver!=null)
	driver.quit();
}
}
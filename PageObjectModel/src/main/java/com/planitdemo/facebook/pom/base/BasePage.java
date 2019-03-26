package com.planitdemo.facebook.pom.base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.planitdemo.facebook.pom.util.FBConstants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasePage {

	public WebDriver driver;
	public ExtentTest test;

	
	public BasePage(){}
	
	public BasePage(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
	}
	
	public boolean isElementPresent(String locator){
		test.log(LogStatus.INFO, "Trying to find element -> "+locator);
		int s = driver.findElements(By.xpath(locator)).size();
		if(s==0){
			test.log(LogStatus.INFO, "Element not found");
			return false;
		}
		else{
			test.log(LogStatus.INFO, "Element found");
			return true;
		}
			
	}
	
    public void waitForVisibilityOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

	public void takeScreenShot(){
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		String filePath=FBConstants.REPORTS_PATH+"screenshots//"+screenshotFile;
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(scrFile, new File(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.INFO,test.addScreenCapture(filePath));
	}
	
	//Reporting functions
    public void reportPass(String passMsg){
    	takeScreenShot();
        test.log(LogStatus.PASS, passMsg);

    }
	public void reportFailure(String failureMessage){
		test.log(LogStatus.FAIL, failureMessage);
		takeScreenShot();
		Assert.fail(failureMessage);
	}
	
	
	public void waitForPageToLoad() throws InterruptedException {
		wait(1);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String state = (String)js.executeScript("return document.readyState");
		
		while(!state.equals("complete")){
			wait(2);
			state = (String)js.executeScript("return document.readyState");
		}
	}

	public void wait(int timeToWaitInSec){
		try {
			Thread.sleep(timeToWaitInSec * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

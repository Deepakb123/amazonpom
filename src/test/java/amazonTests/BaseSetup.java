package amazonTests;

import org.testng.Assert;
import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class BaseSetup {
	
	public static WebDriver driver = null;
	public StringBuffer verificationErrors = new StringBuffer();
	public boolean acceptNextAlert = true;
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	
	public void LaunchBrowser(String browserName) throws IOException 
	{
	
		driver = BrowserFactory.getDriver(browserName);
		 System.out.println("==============Opening" + browserName + "Browser===========");
	    //To open 
	    driver.get("https://www.amazon.in/");
	}
	
	
	@AfterClass(alwaysRun = true)
	public void CloseBrowser() throws Exception{
		BaseSetup.driver.manage().deleteAllCookies();
		BaseSetup.driver.quit();
		System.out.println("1st time");
		String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      Assert.fail(verificationErrorString);
	    }
	   
		
	}
	
	private boolean isElementPresent(By by) {
	    try {
	    	BaseSetup.driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	  }

	  private boolean isAlertPresent() {
	    try {
	    	BaseSetup.driver.switchTo().alert();
	      return true;
	    } catch (NoAlertPresentException e) {
	      return false;
	    }
	  }

	  private String closeAlertAndGetItsText() {
	    try {
	      Alert alert = BaseSetup.driver.switchTo().alert();
	      String alertText = alert.getText();
	      if (acceptNextAlert) {
	        alert.accept();
	      } else {
	        alert.dismiss();
	      }
	      return alertText;
	    } finally {
	      acceptNextAlert = true;
	    }
	  }
	

}

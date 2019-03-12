package amazonTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.ExcelDataConfig;

public class WordpressloginExcel {
	
	WebDriver driver;
	@Test(dataProvider="wordpressData")
	public void loginToWordPress(String username,String password) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demosite.center/wordpress/wp-login.php");
		driver.findElement(By.id("user_login")).sendKeys(username);
		driver.findElement(By.id("user_pass")).sendKeys(password);
		driver.findElement(By.xpath(".//*[@id='wp-submit']")).click();
		Thread.sleep(5000);
		Assert.assertTrue(driver.getTitle().contains("Dashboard"),"User is not able to login - Invalid credentials");
		System.out.println("Page title verified - user is able to login successfully");
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name="wordpressData")
	public Object[][] passData()
	{
		ExcelDataConfig config=new ExcelDataConfig("src/test/resources/inputData.xlsx");
		int rows=config.getRowCount(0);
		Object[][] data=new Object[rows][2];
		for (int i=0;i<rows;i++) {
		
				data[i][0] = config.getData(0, i, 0);
				data[i][1] = config.getData(0, i, 1);
		
		}
		
		return data;
		
	}
		
		
}



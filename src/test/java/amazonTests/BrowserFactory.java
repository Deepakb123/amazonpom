package amazonTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory extends BaseSetup{
	public static WebDriver getDriver(String browser) {
	WebDriver driver;
	switch (browser) {
	case "chrome":
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		break;

	case "firefox":
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		driver = new FirefoxDriver();
		break;	
		
	default:
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		driver = new ChromeDriver();
		break;
	}
	//To maximize browser
    driver.manage().window().maximize();
    //Implicit wait
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	return driver;
}

}

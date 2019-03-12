package amazonPages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AmazonSearchResultsPage {
	
	WebDriver driver;
	 
    public AmazonSearchResultsPage(WebDriver driver){ 
             this.driver=driver; 
    }
    
    @FindBy(how=How.ID, using="add-to-cart-button")  
    WebElement addToCartButton;
    
    @FindBy(how=How.ID, using="priceblock_ourprice")
    WebElement priceValue;
    
    private By priceVal = By.id("priceblock_ourprice");
    
    public void clickonIteminResultsPageandaddtoCart(String itemtobeOpened) {
    	String parentHandle=driver.getWindowHandle();
    	driver.findElement(By.linkText(itemtobeOpened)).click();
    	
    	Set<String> allWindows=driver.getWindowHandles();
    	ArrayList<String> tabs = new ArrayList<>(allWindows);
    	driver.switchTo().window(tabs.get(1));
    	addToCartButton.click();
    	driver.close();
       	driver.switchTo().window(tabs.get(0));
    	
    	
    }
    
    
    public String getPageTitle() {
	   	String currentTitle = driver.getTitle();
	   	return currentTitle;
   }
    
    public String fetchItemPriceValuefromResultsPage() {
    	waitforVisibilityof(priceVal,10);
    	String currentPrice=priceValue.getText();
    	return currentPrice;
    	
    }
    
    protected void waitforVisibilityof(By locator,Integer... timeOutInSeconds) {
		int attempts = 0;
		while(attempts < 2){
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(locator),(timeOutInSeconds.length > 0 ? timeOutInSeconds[0] :null));
				break;
			} catch (StaleElementReferenceException e) {
				// TODO: handle exception
			}
			attempts++;
					}
	}

	private void waitFor(ExpectedCondition<WebElement> condition,Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		WebDriverWait wait = new WebDriverWait(driver,timeOutInSeconds);
		wait.until(condition);
	}
    
    
    

}

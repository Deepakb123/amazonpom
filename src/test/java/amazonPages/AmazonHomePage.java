package amazonPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

public class AmazonHomePage {
	
	WebDriver driver;
	
	 public AmazonHomePage(WebDriver driver){ 
         this.driver=driver; 
	 }
	 
	//"Hello. <UserName> Your Orders" drop down 
	   @FindBy(how=How.XPATH, using="//a[@id='nav-link-yourAccount']/span[1]")  
	   WebElement usernNameDropwdown;
	   
	//Sign out in the drop down menu
	   @FindBy(how=How.XPATH, using="//a[@id='nav-item-signout-sa']/span")  
	   WebElement signOut; 
	   
	   @FindBy(how=How.ID, using="twotabsearchtextbox")
	   WebElement searchBox;
	
	public void hoverOnSignedInDropDown() {
		
		Actions action = new Actions(driver);
		action.moveToElement(usernNameDropwdown).perform();
	}
	
	public void signOutofAmazon() {
				signOut.click();
	}
	
	public void searchinAmazon(String item) {
		searchBox.sendKeys(item + Keys.ENTER);
		
	}

}

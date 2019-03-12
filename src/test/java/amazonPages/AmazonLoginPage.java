package amazonPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AmazonLoginPage {
	
	WebDriver driver;
	 
    public AmazonLoginPage(WebDriver driver){ 
             this.driver=driver; 
    }
    
  //Using FindBy for locating elements
    
   //"Hello. Sign in Your Orders" drop down select Sign In
   @FindBy(how=How.XPATH, using="//a[@id='nav-link-yourAccount']/span[2]")  
   WebElement signIn;
   
   @FindBy(how=How.ID, using="ap_email") 
   WebElement emailTextBox;
   
   @FindBy(how=How.ID, using="continue") 
   WebElement proceedtocontinue;
   
   
   @FindBy(how=How.ID, using="ap_password") 
   WebElement passwordTextBox; 
   
   @FindBy(how=How.ID, using="signInSubmit") 
   WebElement submittoSignIn;
   
   @FindBy(how=How.XPATH, using="//a[@id='nav-link-yourAccount']/span")  
   WebElement loggedInUserName;
   
   @FindBy(how=How.XPATH, using="//*[@class='a-list-item']")
   WebElement emailError;
   
   public String getPageTitle() {
	   	String currentTitle = driver.getTitle();
	   	return currentTitle;
   }
   
   public String getErrorLoginInfo() {
	   String errorInfo=emailError.getText();
	   return errorInfo;
   }
   
   public void clickOnHelloSignInDroopDown() {
	   signIn.click();
   }
   
   public void enterEmail(String emailID) {
	   emailTextBox.sendKeys(emailID);
   }
   
   public void clickContinue() {
	   proceedtocontinue.click();
   }
   
   public void enterPassword(String password) {
	   passwordTextBox.sendKeys(password);
   }
   
   public void submit() {
	   submittoSignIn.click();
   } 
   
   public boolean verifyEmailIDtextBoxPresent() {
	 boolean flag =  emailTextBox.isDisplayed();
	return flag;
	   
   }
   
   public boolean verifyPasswordtextBoxPresent() {
		 boolean flag =  passwordTextBox.isDisplayed();
		return flag;
		   
	   }
   
   
   public String getLoggedInUserName() {
	   String userName=loggedInUserName.getText();
	   return userName;
   }

}

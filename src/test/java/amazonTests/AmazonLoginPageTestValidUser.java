package amazonTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import amazonPages.AmazonHomePage;
import amazonPages.AmazonLoginPage;

public class AmazonLoginPageTestValidUser extends BaseSetup{	
	@Test
	 public void validUsersignInsignOutTest() throws Exception{
	
		AmazonLoginPage loginPage = PageFactory.initElements(driver, AmazonLoginPage.class);
	String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	//After Successfull launch of Amazon site verify page Title
	String currentTitle=loginPage.getPageTitle();
	Assert.assertEquals(expectedTitle, currentTitle);
	
	//Click on Sign In Dropdownmenu
	loginPage.clickOnHelloSignInDroopDown();
	
	//Enter EMail Id
	loginPage.enterEmail("dipakbcatchme@gmail.com");
	
	//Click on Continue Button
	loginPage.clickContinue();

	//Verify Password textbox field is displayed or not
	Assert.assertEquals(loginPage.verifyPasswordtextBoxPresent(),true);
	
	//Enter Password
	loginPage.enterPassword("Rachana@12345");
	
	//Click on submit to login
	loginPage.submit();
	
	//verify for successfull login
	String loggedinUserName = loginPage.getLoggedInUserName();
	Assert.assertEquals(loggedinUserName,"Hello, deepak");
	
	
	AmazonHomePage homePage = PageFactory.initElements(driver, AmazonHomePage.class);
	//Hover on UserName dropwdown and click on signout 
	homePage.hoverOnSignedInDropDown();
	homePage.signOutofAmazon();
	
	//Verify that SignOut is succesfull
	Assert.assertTrue(loginPage.verifyEmailIDtextBoxPresent());
	
	
	}
	
	
}

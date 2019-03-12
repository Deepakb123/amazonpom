package amazonTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import amazonPages.AmazonHomePage;
import amazonPages.AmazonLoginPage;
import amazonPages.AmazonSearchResultsPage;

public class AmazonAddItemtoCart extends BaseSetup{
	
	public String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
	public String itemtoSearch = "Iphone 6";
	@Test
	 public void addItemtocart() throws Exception{
	AmazonLoginPage loginPage = PageFactory.initElements(driver, AmazonLoginPage.class);
	
	//After Successfull launch of Amazon site verify page Title
	String currentTitle=loginPage.getPageTitle();
	Assert.assertEquals(expectedTitle, currentTitle);
	
	//Click on Sign In Dropdownmenu
	loginPage.clickOnHelloSignInDroopDown();
	
	//Enter EMail Id
	loginPage.enterEmail("dipakbcatchme@gmail.com");
	
	//Click on Continue Button
	loginPage.clickContinue();
	
	//Enter Password
	loginPage.enterPassword("qwer@12345");
	
	//Click on submit to login
	loginPage.submit();
	
	//verify for successfull login
	String loggedinUserName = loginPage.getLoggedInUserName();
	Assert.assertEquals(loggedinUserName,"Hello, deepak");
	
	AmazonHomePage homePage = PageFactory.initElements(driver, AmazonHomePage.class);
	
	//Search for "itemtoSearch" on Amazon
	homePage.searchinAmazon(itemtoSearch);
	
	//Pick an item from results page
	//click on Add to Cart
	AmazonSearchResultsPage resultsPage = PageFactory.initElements(driver, AmazonSearchResultsPage.class);
	resultsPage.clickonIteminResultsPageandaddtoCart("Apple iPhone 6 (Space Grey, 32GB)");
	
	//String priceofItem=resultsPage.fetchItemPriceValuefromResultsPage();
	System.out.println("***********************");
	
	System.out.println(resultsPage.getPageTitle());
	System.out.println(loginPage.getLoggedInUserName());
		
	
	//Hover on UserName dropwdown and click on signout 
	homePage.hoverOnSignedInDropDown();
	homePage.signOutofAmazon();
	
	//Verify that SignOut is succesfull
	Assert.assertTrue(loginPage.verifyEmailIDtextBoxPresent());
	
	
	}


}

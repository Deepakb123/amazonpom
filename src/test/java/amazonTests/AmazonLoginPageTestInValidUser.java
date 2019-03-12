package amazonTests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import amazonPages.AmazonLoginPage;
import utility.ExcelDataConfig;

public class AmazonLoginPageTestInValidUser extends BaseSetup{
	
	AmazonLoginPage loginPage = PageFactory.initElements(driver, AmazonLoginPage.class);
	@Test(dataProvider="amazonLoginData")
	 public void invalidUsersignInsignOutTest(String username,String password) throws Exception{ 
		
		
		//AmazonLoginPage loginPage1 = PageFactory.initElements(driver, AmazonLoginPage.class);
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		//After Successfull launch of Amazon site verify page Title
		//String currentTitle=loginPage.getPageTitle();
		//Assert.assertEquals(expectedTitle, currentTitle);
		
		//Click on Sign In Dropdownmenu
		loginPage.clickOnHelloSignInDroopDown();
		
		//Enter EMail Id
		loginPage.enterEmail(username);
		
		//Click on Continue Button
		loginPage.clickContinue();
		System.out.println(username);
		//Assert.assertEquals(loginPage.getErrorLoginInfo(),"We cannot find an account with that email address");
		
	}
	
	@DataProvider(name="amazonLoginData")
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

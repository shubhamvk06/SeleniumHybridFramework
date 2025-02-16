package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class, groups="DataDriven")
	public void verify_loginDDT(String email, String pass, String exp) {
		try {
		logger.info("******* Starting Data provider test *****" );
		
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clikyMyAccount();
		hp.clickLogin();
		
		
		//Login
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setpass(pass);
		lp.clickLogin();
		
		
		MyAccountPage ap = new MyAccountPage(driver);
		boolean targetPage = ap.isMyAccountPageExists();
		
		if(exp.equalsIgnoreCase("Valid")) {
			if(targetPage==true) {
				Assert.assertTrue(true);
				ap.clickLogout();
			}else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("Invalid")) {
			if(targetPage==true) {
				Assert.assertTrue(false);
				ap.clickLogout();
			}else {
				Assert.assertTrue(true);
			}
		}}catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("******* data driven test ended *****" );
	}

}

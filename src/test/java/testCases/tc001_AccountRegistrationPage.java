package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.AccountRegistrationPage;
import pageObject.HomePage;
import testBase.BaseClass;

public class tc001_AccountRegistrationPage extends BaseClass {
	
	
	
	@Test(groups="Regression")
	void verify_account_regirtration() {
		
		try {
		logger.info("******* Starting verify_account_regirtration *****" );
		HomePage hp = new HomePage(driver);
		hp.clikyMyAccount();
		
		hp.clikRegister();
		
		
		logger.info("******* Providing customer details *****" );
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		regpage.setFirstName("Shubha");
		regpage.setLastName("v");
		regpage.setEmail("s12388273@gmail.com");
		regpage.setTelephone("12837648");
		regpage.setPassword("test1234");
		regpage.setConfirmpassword("test1234");
		
		regpage.clickAgree();
		regpage.clickContinue();
		
		String conmessage = regpage.getConfirmationMsg();
		
		logger.info("******* Validating expected Message*****" );
		Assert.assertEquals(conmessage, "Congratulations! Your new account has been successfully created!");
	}catch(Exception e) {
		logger.error("test failed");
		logger.debug("debug logs..");
		Assert.fail();
	}
		}
}

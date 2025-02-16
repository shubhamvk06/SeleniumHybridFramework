package testCases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.LoginPage;
import pageObject.MyAccountPage;
import testBase.BaseClass;



public class LoginTest extends BaseClass{
	
	@Test(groups={"sanity","Master"})
	public void verifyLogin() {
		
	logger.info("******* Starting test 2 *****");
	HomePage hp = new HomePage(driver);
	hp.clikyMyAccount();
	hp.clickLogin();
	
	logger.info("******* Entering login details *****");
	LoginPage lp = new LoginPage(driver);
	//WebDriverWait wait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
	lp.setEmail(p.getProperty("email"));
	lp.setpass(p.getProperty("pass"));
	lp.clickLogin();
	
	logger.info("******* Verificatio of login *****");
	MyAccountPage ap = new MyAccountPage(driver);
	boolean msg = ap.isMyAccountPageExists();
	Assert.assertEquals(msg, true);
	
	

	}

}

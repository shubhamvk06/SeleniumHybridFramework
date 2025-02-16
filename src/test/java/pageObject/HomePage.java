package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;

	@FindBy(xpath="//div[@id=\"top-links\"]//ul[@class='dropdown-menu dropdown-menu-right']/li[1]/a")
	WebElement lnkRegister;
	
	@FindBy(xpath="//div[@id=\"top-links\"]//ul[@class='dropdown-menu dropdown-menu-right']/li[2]/a")
	WebElement lnkLogin;

	
	//Actions Methods
	public void clikyMyAccount() {
		lnkMyAccount.click();
	}
	public void clikRegister() {
		lnkRegister.click();
	}
	
	public void clickLogin() {
		lnkLogin.click();
	}
	
}

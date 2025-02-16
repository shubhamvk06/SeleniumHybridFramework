package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//div[@id=\"content\"]/h2[1]")
	WebElement msgHeading;
	
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Logout']")
	WebElement btnLogout;
	
	public boolean isMyAccountPageExists() {
		try{
			return (msgHeading.isDisplayed());
		}catch(Exception e) {
			
		}
		return false;
	}
	
	public void clickLogout() {
		btnLogout.click();
	}
	
}

package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	
	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement txtFisrtname;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement txtLastname;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtemail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement txtphone;
	
	
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement btnAgree;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement txtcnfPassword;
	
	
	
	@FindBy(xpath="//div[@id='content']/p[1]")
	WebElement cnfMessage;
	
	

	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement btnContinue;
	
	
	
	public void setFirstName(String fname) {
		txtFisrtname.sendKeys(fname);
	}
	public void setLastName(String lname) {
		txtLastname.sendKeys(lname);
	}
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	public void setTelephone(String telephone) {
		txtphone.sendKeys(telephone);
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void setConfirmpassword(String cnfpassword) {
		txtcnfPassword.sendKeys(cnfpassword);
	}
	
	
	public void clickAgree() {
		
		btnAgree.click();
		
	}
	public void clickContinue() {
		btnContinue.click();
	}
	
	
	public String getConfirmationMsg() {
		try {
			return(cnfMessage.getText());
		}catch(Exception e) {
			
		
		return (e.getMessage());
		}
	}
	
}

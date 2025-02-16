package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	
	WebDriver driver;
	protected JavascriptExecutor jsExecutor;
	public BasePage(WebDriver driver) {
		
		this.driver= driver;
		this.jsExecutor = (JavascriptExecutor) driver;
		PageFactory.initElements(driver,this);
	}
	
	protected void clickElementWithJS(WebElement element) {
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    // Use JavaScript to send keys to an element
    protected void sendKeysWithJS(WebElement element, String value) {
        jsExecutor.executeScript("arguments[0].value=arguments[1];", element, value);
    }

    // Scroll element into view
    protected void scrollIntoView(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}

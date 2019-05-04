package utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilityClass {

	WebDriverWait wait;
	final static Logger log = Logger.getLogger(WaitUtilityClass.class);
	public WaitUtilityClass(WebDriver driver) {
		log.info("Initialize your wait object");
		wait = new WebDriverWait(driver, 30);
	}

	public void waitForElementToBeClickable(WebElement element) {
		log.info("Wait for element to be clickable");
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementToBeVisible(WebElement element) {
		log.info("Wat for element to be visible");
		wait.until(ExpectedConditions.visibilityOf(element));
	}
}

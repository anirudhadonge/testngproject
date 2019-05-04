package PageModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Inbox extends BasePageModel {

	String inbox="//a[@title='Inbox']";
	//WebElement inboxLabel ;
	public Inbox(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver,Inbox.class);
	}

	public void validateInbox() {
		log.info("Validate the inbox page");
		WebElement inboxlabel = driver.findElement(By.xpath(inbox));
		Assert.assertTrue(inboxlabel.isDisplayed(), "Inbox label is not displayed");
		//Assert.assertTrue("Inbox label is not displayed",inboxlabel.isDisplayed());
	}
}

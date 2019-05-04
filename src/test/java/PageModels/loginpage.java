package PageModels;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginpage extends BasePageModel {

	String loginName = "#identifierId";
	//public WebElement loginName;

	String nextButton ="#identifierNext";
//	public WebElement nextButton;
	
	String password = "//input[@type='password']";
	//public WebElement password;

	String passwordNext ="#passwordNext";
	//public WebElement passwordNext;
	
	public loginpage(WebDriver driver) {
		super(driver);

		//PageFactory.initElements(driver,loginpage.class);
	}
	
	public void enterUserName(String username) {
		WebElement loginN = driver.findElement(By.cssSelector(loginName));
		waitUtil.waitForElementToBeVisible(loginN);
		loginN.sendKeys(username);
	}
	
	public void clickNextButton() {
		WebElement nextBt = driver.findElement(By.cssSelector(nextButton));
		waitUtil.waitForElementToBeClickable(nextBt);
		nextBt.click();
	}
	
	public void enterPassword(String password1) {
//		try {
//			//Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		WebElement nextBt = driver.findElement(By.cssSelector(passwordNext));
		waitUtil.waitForElementToBeClickable(nextBt);
		WebElement passwd = driver.findElement(By.xpath(password));
		waitUtil.waitForElementToBeVisible(passwd);
		passwd.sendKeys(password1);
	}
	
	public void loginToApp() {
		WebElement nextBt = driver.findElement(By.cssSelector(passwordNext));
		waitUtil.waitForElementToBeClickable(nextBt);
		nextBt.click();
	}

}

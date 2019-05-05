package testclass;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageModels.Inbox;
import PageModels.loginpage;
import utility.ConfigFileReader;
import utility.WebDriverClass;

public class LoginToAccount {
	loginpage loginPage;
	Inbox inbox;
	WebDriver driver;
	Properties prop;
	ConfigFileReader config ;
	
	final static Logger log = Logger.getLogger(LoginToAccount.class);
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethod(String browser) {
		try {
			WebDriverClass webDriverClass = new WebDriverClass(browser);
			driver = webDriverClass.getWebDriver();
			loginPage = new loginpage(driver);
			inbox = new Inbox(driver);
			config = new ConfigFileReader();
			//String env = prop.getProperty("env");
			driver.get(config.getEnvironmentProperty("env"));
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

	@Test
	public void loginAndValidate() {
		try{
		loginPage.enterUserName(config.getEnvironmentProperty("username"));
		loginPage.clickNextButton();
		loginPage.enterPassword(config.getEnvironmentProperty("password"));
		loginPage.loginToApp();
		inbox.validateInbox();
		}catch(Exception e){
		log.info("Test Failed :"+e.getMessage());
		}
	}
	
	@AfterMethod
	public void cleanup() {
		driver.quit();
	}

}

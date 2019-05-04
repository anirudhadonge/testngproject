package testclass;

import java.io.FileInputStream;
import java.util.Properties;

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
		loginPage.enterUserName(prop.getProperty("username"));
		loginPage.clickNextButton();
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.loginToApp();
		inbox.validateInbox();
	}
	
	@AfterMethod
	public void cleanup() {
		driver.quit();
	}

}

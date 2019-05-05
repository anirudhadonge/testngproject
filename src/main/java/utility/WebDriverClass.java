package utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverClass {
	private static Logger log = Logger.getLogger(WebDriverClass.class);
	String log4jConfPath = System.getProperty("user.dir")+"/log4j.properties";
	
	//PropertyConfigurator.configure(log4jConfPath);
	public WebDriver driver;

	public WebDriverClass(String browser) {
		
		PropertyConfigurator.configure(log4jConfPath);
		String str = browser;
		String Systemdir = System.getProperty("user.dir");
		log.info("-----------"+Systemdir+"----------------------");
		switch (str) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/test/resources/firefoxdriver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
			this.driver = new ChromeDriver();
			break;
		case "grid":
			DesiredCapabilities capibility = new DesiredCapabilities().firefox();
			capibility.setPlatform(Platform.WIN10);
			URL url = null;
			try {

				url = new URL("http://192.168.1.7:5469/wd/hub");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			driver = new RemoteWebDriver(url,capibility);
					
		default:
			log.info("No Browser selected");
			//log.info("no browser invoked");
		}
		driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
}
	public WebDriver getWebDriver() {
		return this.driver;
	}
}

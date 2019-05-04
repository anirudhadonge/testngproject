package PageModels;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import utility.WaitUtilityClass;

//protect static Logger Log 
public abstract class BasePageModel {
	public static Logger log = Logger.getLogger(BasePageModel.class);
	WaitUtilityClass waitUtil;
	WebDriver driver;

	public BasePageModel(WebDriver driver) {
		//PropertyConfigurator.configure("log4j.properties");
		log.info("Base class getting invoked");
		waitUtil = new WaitUtilityClass(driver);
		this.driver = driver;
	}

}

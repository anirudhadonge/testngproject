package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigFileReader {
	Properties properties;
	private static Logger log = Logger.getLogger(ConfigFileReader.class);

	public ConfigFileReader() {

		FileInputStream fl1;
		try {
			fl1 = new FileInputStream("src/test/resources/prod.properties");
			properties = new Properties();
			properties.load(fl1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info(e.getMessage());
		}
	}
	public String getEnvironmentProperty(String property){
		return properties.getProperty(property);
	}
}
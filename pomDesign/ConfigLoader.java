package pomDesign;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
	private static Properties prop;
	static { 
		prop = new Properties();
		try {
			FileReader fis = new FileReader("config.properties");
			prop.load(fis);
			fis.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	      }
	public String getMyValue(String key) {
		return prop.getProperty(key);
	}
}

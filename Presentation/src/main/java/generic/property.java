package generic;

import java.io.FileInputStream;
import java.util.Properties;

public class property implements auto_constant{
	
	static String value;
	public static String getData(String data) {
		try {
			Properties p = new Properties();
			FileInputStream input = new FileInputStream(siteData);
			p.load(input);
			value = p.getProperty(data);
			System.out.println(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}

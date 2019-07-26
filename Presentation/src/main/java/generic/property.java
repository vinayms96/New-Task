package generic;

import java.io.FileInputStream;
import java.util.Properties;

public class property implements auto_constant{
	static Properties p;
	static String value;
	public static String getData(String data) {
		try {
			p.load(new FileInputStream(siteData));
			value = p.getProperty(data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}
}

package generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {
	
	public String getProp(String path, String key) {
		String result = "";
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(path);
			prop.load(fis);
			result = prop.getProperty(key);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
//	public String get(String path, String key) {
//		String result = "";
//		Properties prop = new Properties();
//		try {
//			FileInputStream fis = new FileInputStream(path);
//			prop.load(fis);
//			result = prop.
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//	}
}

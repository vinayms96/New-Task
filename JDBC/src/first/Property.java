package first;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Property {
    public static void getProperty(){
        Properties prop = new Properties();
        try {
            FileInputStream fi = new FileInputStream("./src/first/studentData.properties");
            prop.load(fi);
            String name = prop.getProperty("sname");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

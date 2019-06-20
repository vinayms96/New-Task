package demo;

import java.io.FileInputStream;
import java.util.Properties;

public class Property {
    public static String getProperty(String data){
        String name="";
        Properties prop = new Properties();
        try {
            FileInputStream fi = new FileInputStream("./src/demo/employeesData.properties");
            prop.load(fi);
            name = prop.getProperty(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return name;
    }
}

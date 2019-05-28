package com.mmt.generic;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Property implements auto_constant{
    String data;
    public static String getData(String data){
        try {
            Properties prop = new Properties();
            InputStream fi = new FileInputStream(propPath);
            prop.load(fi);
            data = prop.getProperty(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}

package com.github.common;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	public String getProperties(String key) throws IOException{
		Properties properties = new Properties();
		InputStream in = null;
		try{
			in = new FileInputStream("src/test/resources/config.properties");
			properties.load(in); 
			String value = properties.getProperty(key);    
	        return value;    
	   
	       } catch (IOException e) {    
	           e.printStackTrace();    
	           return null;    
	   
	       } finally {    
	           if (null != in)    
	               in.close();    
	       }    ///���������б�	
	}
	
}

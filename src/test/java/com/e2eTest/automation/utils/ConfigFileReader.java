package com.e2eTest.automation.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private String proprietyFilePath ="src/test/resources/configs/configFile.properties";
	
	/**
	 * Instantiation of the config reader
	 **/
	public ConfigFileReader() {
		
		BufferedReader reader = null;
		try {
			
			reader = new BufferedReader(new FileReader(proprietyFilePath));
			properties = new Properties();
			try {
				
				properties.load(reader);
				reader.close();
			}catch(IOException e) {
				System.out.println("Exception: "+e);
			}
		}catch (FileNotFoundException e) {
		System.out.println("Exception: "+e);
		throw new RuntimeException("Configuration.properties not found at "+proprietyFilePath);
		
	}finally {
		//This block will be executed in every case,success or caught exception
	}
		if(reader !=null) {
			try {
				reader.close();
				
			}catch(IOException e) {
				System.out.println("Exception: "+e);
			}
		}
	}
/**
 * Access the attribute driver path
 * @return driver path
 **/
public String getDriverPath() {
	String driverPath = properties.getProperty("driverPath");
	if(driverPath !=null)
		return driverPath;
	else 
		throw new RuntimeException("driverPath is not specified in the Configuration.properties file.");
}
/**
 * Access the attribute of the driver url
 * 
 * @param address application url
 * @return application url
 */
public String getProperties(String prop) {
	String param = properties.getProperty(prop);
	if(param !=null) 
		return param;
		else
			throw new RuntimeException("url not specified in the Configuration.preperties file.");
	
	}
}


package com.finalproject.qa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "configs//Configuration.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getDriverPathChrome(){
		String driverPath = properties.getProperty("driverPathChrome");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPathChrome not specified in the Configuration.properties file.");		
	}
	
	public String getDriverPathEdge(){
		String driverPath = properties.getProperty("driverPathEdge");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPathEdge not specified in the Configuration.properties file.");		
	}
	
	public String getDriverPathFirefox(){
		String driverPath = properties.getProperty("driverPathFirefox");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPathFirefox not specified in the Configuration.properties file.");		
	}
	
	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the Configuration.properties file.");		
	}
	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
}

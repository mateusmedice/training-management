package br.com.cavy.training.management.smtp.util;

import java.util.Properties;

public class PropertisUtil {
	
	private static Properties properties;

	public static String getMessage(String key) {
		
		try {
			
			if (key == null || key.isEmpty()) {
				throw new IllegalArgumentException("Key value cant be null.");
			}
			
			if (properties == null) {
				properties = new Properties();
			}
			
			if (properties.isEmpty()) {
				loadPropertiesFile("smtpConfig.properties");
			}
			
			return properties.getProperty(key);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	private static void loadPropertiesFile(String fileName) {
		
		try {
		
			if (properties == null) {
				properties = new Properties();
			}
			
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

			properties.load(classLoader.getResourceAsStream(fileName));
			
		} catch (Exception e) {
			throw new RuntimeException("Failed to load properties file, verify its configurations.", e);
		}
		
	}
	
}

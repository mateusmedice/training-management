package br.com.cavy.training.management.util;

import java.util.Properties;

public class PropertiesUtil {
	
	private static Properties properties;

	public static final String PROPERTIES_MESSAGES_NAME = "messages.properties";

	public static String getMessage(String key, String fileName) {

		try {
			
			if (key == null || key.isEmpty()) {
				throw new IllegalArgumentException("Key value cant be null.");
			}

			if (fileName != null) {
				loadPropertiesFile(fileName);
			}
			
			return properties.getProperty(key);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String getMessagesValue(String key) {
		return getMessage(key, PROPERTIES_MESSAGES_NAME);
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

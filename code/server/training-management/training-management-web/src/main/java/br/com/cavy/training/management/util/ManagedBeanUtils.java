package br.com.cavy.training.management.util;

import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class ManagedBeanUtils {

	public static Object getRequestParam(String key) {
		
		ExternalContext externalContext = getFacesExternalContext();
		
		if (externalContext == null) {
			throw new RuntimeException("External Context is null.");
		}
		
		Map<String, String> requestParameterMap = externalContext.getRequestParameterMap();
		
		if (requestParameterMap == null) {
			throw new RuntimeException("Request Parameter Map is null.");
		}
		
		Object object = requestParameterMap.get(key);
		
		if (object == null) {
			throw new RuntimeException("Parameter is null.");
		}
		
		return object;
	}
	
	public static void setRequestParam(String key, String value) {
		
		getFacesExternalContext().getRequestMap().put(key, value);
	}
	
	public static void setSessionParam(String key, Object value) {
		
		getFacesExternalContext().getSessionMap().put(key, value);
	}

	private static ExternalContext getFacesExternalContext() {

		return FacesContext.getCurrentInstance().getExternalContext();
	}
	
}

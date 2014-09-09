package br.com.progol.training.management.webservice.util;

import com.google.gson.Gson;

public class WebServiceUtil {

	public static String toJson(Object object) {
		
		Gson gson = new Gson();
		
		return gson.toJson(object);
	}
	
}

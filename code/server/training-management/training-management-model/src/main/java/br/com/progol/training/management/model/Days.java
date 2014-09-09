package br.com.progol.training.management.model;


public enum Days {

	MONDAY("Segunda"), 
	TUESDAY("Terça"), 
	WEDNESDAY("Quarta"), 
	THURSDAY("Quinta"), 
	FRIDAY("Sexta");

	private String value;
	
	private Days(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
}
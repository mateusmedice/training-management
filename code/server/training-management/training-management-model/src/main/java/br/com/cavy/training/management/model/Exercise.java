package br.com.cavy.training.management.model;

import org.springframework.data.annotation.Id;

public class Exercise {

	@Id
	private String id;
	
	private String part;

	private String exercise;
	
	public Exercise() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getExercise() {
		return exercise;
	}

	public void setExercise(String exercise) {
		this.exercise = exercise;
	}
	
}

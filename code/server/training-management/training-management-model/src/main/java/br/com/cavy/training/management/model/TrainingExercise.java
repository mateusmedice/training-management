package br.com.cavy.training.management.model;

import org.springframework.data.annotation.Id;

public class TrainingExercise {

	@Id
	private String id;
	
	private Integer series;

	private Integer repetition;
	
	private Exercise exercise;

	public TrainingExercise() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getSeries() {
		return series;
	}

	public void setSeries(Integer series) {
		this.series = series;
	}

	public Integer getRepetition() {
		return repetition;
	}

	public void setRepetition(Integer repetition) {
		this.repetition = repetition;
	}

	public Exercise getExercise() {
		return exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}
	
}

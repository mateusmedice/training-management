package br.com.cavy.training.management.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class DayTraining {

	@Id
	private String id;
	
	private String day;
	
	private List<TrainingExercise> trainingExercise = new ArrayList<TrainingExercise>();
	
	public DayTraining() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public List<TrainingExercise> getTrainingExercise() {
		return trainingExercise;
	}

	public void setTrainingExercise(List<TrainingExercise> trainingExercise) {
		this.trainingExercise = trainingExercise;
	}
	
}

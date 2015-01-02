package br.com.cavy.training.management.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Training {

	@Id
	private String id;
	
	private String description;
	
	private List<DayTraining> dayTrainingList = new ArrayList<DayTraining>();

	public Training() {

	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String trainingDescription) {
		this.description = trainingDescription;
	}

	public List<DayTraining> getDayTrainingList() {
		return dayTrainingList;
	}

	public void setDayTrainingList(List<DayTraining> dayTrainingList) {
		this.dayTrainingList = dayTrainingList;
	}

}

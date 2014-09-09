package br.com.progol.training.management.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Embeddable
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Training implements Serializable {
		
	@Basic
	private String description;
	
	@ElementCollection
	private List<DayTraining> dayTrainingList = new ArrayList<DayTraining>();
	
	public Training() {
	
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
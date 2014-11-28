package br.com.progol.training.management.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class DayTraining implements Serializable {

	@Id
	@GeneratedValue
    @Field(name="_id")
	private String _id;
	
	@Basic
	private String day;
	
	@ElementCollection
	private List<TrainingExercise> trainingExercise = new ArrayList<TrainingExercise>();
	
	public DayTraining() {
		
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

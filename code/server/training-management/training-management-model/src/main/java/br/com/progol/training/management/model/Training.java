package br.com.progol.training.management.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Training implements Serializable {

	@Id
	@GeneratedValue
    @Field(name="_id")
	private String _id;
	
	@Basic
	private String description;
	
	@ElementCollection
	private List<DayTraining> dayTrainingList = new ArrayList<DayTraining>();
	
	public Training() {
	
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

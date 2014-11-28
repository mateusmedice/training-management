package br.com.cavy.training.management.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class TrainingExercise implements Serializable {

	@Id
	@GeneratedValue
    @Field(name="_id")
	private String _id;
	
	@Basic
	private Integer series;

	@Basic
	private Integer repetition;
	
	private Exercise exercise;

	public TrainingExercise() {
		
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
}

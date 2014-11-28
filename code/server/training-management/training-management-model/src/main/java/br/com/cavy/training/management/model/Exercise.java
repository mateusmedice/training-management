package br.com.cavy.training.management.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Exercise implements Serializable {

	@Id
	@GeneratedValue
    @Field(name="_id")
	private String _id;
	
	@Basic
	private String part;

	@Basic
	private String exercise;
	
	public Exercise() {
		
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

package br.com.progol.training.management.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.Field;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class PlanOwner implements Serializable {

	@Id
	@GeneratedValue
    @Field(name="_id")
	private String _id;
	
	@Basic
	private String name;

	@Basic
	private String nickName;

    @ManyToOne(fetch=FetchType.LAZY)
	private Address address = new Address();
	
    @ElementCollection
	private List<Athlete> athleteList = new ArrayList<Athlete>();
	
	public PlanOwner() {
		
	}
	
}

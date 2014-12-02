package br.com.cavy.training.management.webservice;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cavy.training.management.business.ExerciseBusiness;
import br.com.cavy.training.management.model.Exercise;

@Path("/exercise")
public class ExerciseWebService {

	@Autowired
	private ExerciseBusiness exerciseBusiness;

	@POST
	@Path("/save")
	public void save(Exercise exercise) {
		
		this.exerciseBusiness.save(exercise);		
	}
	
}

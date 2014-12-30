package br.com.cavy.training.management.business;

import java.util.List;

import br.com.cavy.training.management.model.Exercise;

public interface ExerciseBusiness {

	void save(Exercise exercise);
	
	List<Exercise> getAll();	
}

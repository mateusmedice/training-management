package br.com.cavy.training.management.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cavy.training.management.business.ExerciseBusiness;
import br.com.cavy.training.management.dao.ExerciseRepository;
import br.com.cavy.training.management.model.Exercise;

@Service
public class ExerciseBusinessImpl implements ExerciseBusiness {

	@Autowired
	private ExerciseRepository exerciseDAO;

	public void save(Exercise exercise) {

		if (exercise == null) {
			throw new IllegalArgumentException("");
		}
		
		this.exerciseDAO.save(exercise);
	}
	
	public List<Exercise> getAll() {
		
		return this.exerciseDAO.findAll();
	}
	
}

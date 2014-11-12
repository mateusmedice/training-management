package br.com.progol.training.management.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.progol.training.management.business.ExerciseBusiness;
import br.com.progol.training.management.dao.ExerciseDAO;
import br.com.progol.training.management.model.Exercise;

@Service
public class ExerciseBusinessImpl implements ExerciseBusiness {

	@Autowired
	private ExerciseDAO exerciseDAO;

	public void save(Exercise exercise) {

		if (exercise == null) {
			throw new IllegalArgumentException("");
		}
		
		this.exerciseDAO.merge(exercise);
	}
	
}

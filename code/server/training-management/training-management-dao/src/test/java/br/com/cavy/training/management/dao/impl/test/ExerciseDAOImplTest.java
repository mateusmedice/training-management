package br.com.cavy.training.management.dao.impl.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cavy.training.management.dao.ExerciseDAO;
import br.com.cavy.training.management.model.Exercise;

public class ExerciseDAOImplTest extends TestUtil {
	
	@Autowired
	private ExerciseDAO exerciseDAO;
	
	@Test
	public void d() {
		
	}
	
	//@Test
	public void saveSuccessTest() {
		
		Exercise exercise = new Exercise();

		exercise.setPart("Braço");
		exercise.setExercise("Supino");
		
		exerciseDAO.persist(exercise);
	}
	
}

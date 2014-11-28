package br.com.cavy.training.management.dao.impl.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.cavy.training.management.dao.DayTrainingDAO;
import br.com.cavy.training.management.dao.ExerciseDAO;
import br.com.cavy.training.management.model.DayTraining;
import br.com.cavy.training.management.model.Days;
import br.com.cavy.training.management.model.TrainingExercise;

public class DayTrainingDAOImplTest extends TestUtil {

	@Autowired
	private DayTrainingDAO dayTrainingDAO;

	@Autowired
	private ExerciseDAO exerciseDAO;
	
	private DayTraining dayTraining;
	
	private DayTraining dayTrainingMerged;
	
	@Before
	public void setUp() {

		dayTraining = new DayTraining();
		
		dayTraining.setDay(Days.MONDAY.getValue());
		
		TrainingExercise exercise = new TrainingExercise();

	}
	
	@Test
	public void saveSuccessTest() {
		
		this.dayTrainingDAO.merge(dayTraining);
	}
	
	public void findSuccessTest() {
		
		DayTraining dayTraining = this.dayTrainingDAO.getById(DayTraining.class, this.dayTrainingMerged.get_id());
		
		org.junit.Assert.assertEquals(this.dayTrainingMerged, dayTraining);
		
	}
}

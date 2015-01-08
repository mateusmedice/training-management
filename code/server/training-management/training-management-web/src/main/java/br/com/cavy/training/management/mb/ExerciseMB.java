package br.com.cavy.training.management.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.cavy.training.management.business.ExerciseBusiness;
import br.com.cavy.training.management.model.Exercise;

@Component
@ManagedBean(name="exerciseMB")
@SessionScoped
public class ExerciseMB extends BaseMB {

	private static final long serialVersionUID = -479056843711179884L;

	@Autowired
	private ExerciseBusiness exerciseBusiness;
	
	private List<Exercise> exerciseList;

	public void save() {
		
		Exercise exercise = new Exercise();

		exercise.setExercise("teste");
		exercise.setPart("teste");
		
		this.exerciseBusiness.save(exercise);
		
		this.exerciseList = this.exerciseBusiness.getAll();
		
	}

	public List<Exercise> getExerciseList() {
		return exerciseList;
	}

	public void setExerciseList(List<Exercise> exerciseList) {
		this.exerciseList = exerciseList;
	}
	
}

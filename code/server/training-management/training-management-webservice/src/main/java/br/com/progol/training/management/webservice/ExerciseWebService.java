package br.com.progol.training.management.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.progol.training.management.business.ExerciseBusiness;
import br.com.progol.training.management.model.Exercise;

@RestController
@RequestMapping("/exercise")
public class ExerciseWebService {

	@Autowired
	private ExerciseBusiness exerciseBusiness;

	@RequestMapping("/save")
	public String save(@RequestParam(value="exercise", required=true) Exercise exercise) {
		
		this.exerciseBusiness.save(exercise);
		
		return "Exercise saved successfully";
	}
	
}

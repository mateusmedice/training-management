package br.com.cavy.training.management.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.progol.training.management.business.ExerciseBusiness;

@Controller
public class ExerciseController implements Serializable {

	@Autowired
	private ExerciseBusiness exerciseBusiness;

	@Autowired
	private Result result;
	
	@Get("/exerciseRegister")
	public String manutencaoExercicio() {
		
		return "exerciseRegister";
	}
	
	@Post
	public String save() {
		
		return null;
	}

}

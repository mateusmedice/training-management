package br.com.cavy.training.management.controller;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.cavy.training.management.business.ExerciseBusiness;

public class ExerciseController {

	@Autowired
	private ExerciseBusiness exerciseBusiness;

	public String manutencaoExercicio() {
		
		return "exerciseRegister";
	}
	
	public String save() {
		
		return null;
	}

	public void cadastrarUsuario(String nome, Integer idade) {
		
		
		
	}
	
}

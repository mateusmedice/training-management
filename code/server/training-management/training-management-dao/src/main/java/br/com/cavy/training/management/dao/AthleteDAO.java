package br.com.cavy.training.management.dao;

import java.util.List;

import br.com.cavy.training.management.model.Athlete;

public interface AthleteDAO extends DAO<Athlete, String> {

	Athlete findByCPF(String cpf);
	
	List<Athlete> findByName(String name);
	
}

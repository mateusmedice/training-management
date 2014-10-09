package br.com.progol.training.management.dao;

import java.util.List;

import br.com.progol.training.management.model.Athlete;

public interface AthleteDAO extends DAO<Athlete, String> {

	Athlete findByCPF(String cpf);
	
	List<Athlete> findByName(String name);
	
}

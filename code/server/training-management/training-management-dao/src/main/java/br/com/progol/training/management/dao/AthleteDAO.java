package br.com.progol.training.management.dao;

import br.com.progol.training.management.model.Athlete;

public interface AthleteDAO extends DAO<Athlete, String> {

	Athlete findByCPF(String cpf);
	
}

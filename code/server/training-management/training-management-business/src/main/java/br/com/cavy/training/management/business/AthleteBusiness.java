package br.com.cavy.training.management.business;

import java.util.List;

import br.com.cavy.training.management.model.Athlete;

public interface AthleteBusiness {

	Athlete findByCPF(String cpf);

	List<Athlete> findByName(String name);	
	
	List<Athlete> getAll();	

}

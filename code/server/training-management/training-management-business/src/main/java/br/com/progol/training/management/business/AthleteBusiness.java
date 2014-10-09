package br.com.progol.training.management.business;

import java.util.List;

import br.com.progol.training.management.model.Athlete;

public interface AthleteBusiness {

	Athlete findByCPF(String cpf);

	List<Athlete> findByName(String name);	
}

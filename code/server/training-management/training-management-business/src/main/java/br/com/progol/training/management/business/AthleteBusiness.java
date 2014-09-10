package br.com.progol.training.management.business;

import br.com.progol.training.management.model.Athlete;

public interface AthleteBusiness {

	Athlete findByCPF(String cpf);
	
}

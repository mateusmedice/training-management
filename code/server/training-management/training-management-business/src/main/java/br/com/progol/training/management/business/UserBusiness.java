package br.com.progol.training.management.business;

import br.com.progol.training.management.model.User;

public interface UserBusiness {

	User findUserByCPF(String cpf);
	
}

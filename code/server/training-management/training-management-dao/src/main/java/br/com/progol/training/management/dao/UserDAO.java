package br.com.progol.training.management.dao;

import br.com.progol.training.management.model.User;

public interface UserDAO extends DAO<User, String> {

	User findUserByCPF(String cpf);
	
}

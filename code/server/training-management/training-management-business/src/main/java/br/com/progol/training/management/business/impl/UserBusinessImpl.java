package br.com.progol.training.management.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.progol.training.management.business.UserBusiness;
import br.com.progol.training.management.dao.UserDAO;
import br.com.progol.training.management.model.User;

@Service
public class UserBusinessImpl implements UserBusiness {

	@Autowired
	private UserDAO userDAO;
		
	public User findUserByCPF(String cpf) {

		if (cpf == null || cpf.isEmpty()) {
			throw new IllegalArgumentException("cpf can't be null.");
		}
		
		return this.userDAO.findUserByCPF(cpf);
	}

}

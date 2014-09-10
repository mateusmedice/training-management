package br.com.progol.training.management.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.progol.training.management.business.AthleteBusiness;
import br.com.progol.training.management.dao.AthleteDAO;
import br.com.progol.training.management.model.Athlete;

@Service
public class AthleteBusinessImpl implements AthleteBusiness {

	@Autowired
	private AthleteDAO userDAO;
		
	public Athlete findUserByCPF(String cpf) {

		if (cpf == null || cpf.isEmpty()) {
			throw new IllegalArgumentException("cpf can't be null.");
		}
		
		return this.userDAO.findUserByCPF(cpf);
	}

}

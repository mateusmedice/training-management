package br.com.progol.training.management.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.progol.training.management.business.AthleteBusiness;
import br.com.progol.training.management.dao.AthleteDAO;
import br.com.progol.training.management.model.Athlete;

@Service
public class AthleteBusinessImpl implements AthleteBusiness {

	@Autowired
	private AthleteDAO athleteDAO;
		
	public Athlete findByCPF(String cpf) {

		if (cpf == null || cpf.isEmpty()) {
			throw new IllegalArgumentException("cpf can't be null.");
		}
		
		return this.athleteDAO.findByCPF(cpf);
	}

	public List<Athlete> findByName(String name) {
		
		return this.athleteDAO.findByName(name);
	}

	public List<Athlete> getAll() {

		return this.athleteDAO.getAll(Athlete.class);
	}

}

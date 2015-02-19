package br.com.cavy.training.management.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cavy.training.management.business.AthleteBusiness;
import br.com.cavy.training.management.dao.AthleteRepository;
import br.com.cavy.training.management.model.Athlete;

@Service
public class AthleteBusinessImpl implements AthleteBusiness {

	@Autowired
	private AthleteRepository athleteRepository;
		
	public Athlete findByCPF(String cpf) {

		if (cpf == null || cpf.isEmpty()) {
			throw new IllegalArgumentException("cpf can't be null.");
		}
		
		return null;
	}

	public Athlete findByName(String name) {
		
		return this.athleteRepository.findBy(name);
	}

	public List<Athlete> getAll() {

		return this.athleteRepository.findAll();
	}

	@Override
	public void save(Athlete athlete) {

		this.athleteRepository.save(athlete);
	}

}

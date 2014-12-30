package br.com.cavy.training.management.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cavy.training.management.business.PlanOwnerBusiness;
import br.com.cavy.training.management.dao.PlanOwnerRepository;
import br.com.cavy.training.management.model.PlanOwner;

@Service
public class PlanOwnerBusinessImpl implements PlanOwnerBusiness {

	@Autowired
	private PlanOwnerRepository planOwnerDAO;
	
	public PlanOwner findBy(String email, String password) {

		return null;
	}

}

package br.com.progol.training.management.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.progol.training.management.business.PlanOwnerBusiness;
import br.com.progol.training.management.dao.PlanOwnerDAO;
import br.com.progol.training.management.model.PlanOwner;

@Service
public class PlanOwnerBusinessImpl implements PlanOwnerBusiness {

	@Autowired
	private PlanOwnerDAO planOwnerDAO;
	
	public PlanOwner findBy(String email, String password) {

		return this.planOwnerDAO.findBy(email, password);
	}

}

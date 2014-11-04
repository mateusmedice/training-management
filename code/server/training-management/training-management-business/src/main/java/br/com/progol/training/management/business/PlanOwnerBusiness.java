package br.com.progol.training.management.business;

import br.com.progol.training.management.model.PlanOwner;

public interface PlanOwnerBusiness {
	
	PlanOwner findBy(String email, String password);
}

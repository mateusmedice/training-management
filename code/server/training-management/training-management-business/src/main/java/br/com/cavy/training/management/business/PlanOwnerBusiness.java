package br.com.cavy.training.management.business;

import br.com.cavy.training.management.model.PlanOwner;

public interface PlanOwnerBusiness {
	
	PlanOwner findBy(String email, String password);

	PlanOwner saveAndFind(PlanOwner planOwner);
	
	void save(PlanOwner planOwner);
	
}

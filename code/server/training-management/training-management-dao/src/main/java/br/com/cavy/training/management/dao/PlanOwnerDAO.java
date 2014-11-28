package br.com.cavy.training.management.dao;

import br.com.cavy.training.management.model.PlanOwner;

public interface PlanOwnerDAO extends DAO<PlanOwner, String> {

	PlanOwner findBy(String email, String password);
	
}

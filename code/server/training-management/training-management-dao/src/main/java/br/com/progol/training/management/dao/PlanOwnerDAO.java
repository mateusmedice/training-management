package br.com.progol.training.management.dao;

import br.com.progol.training.management.model.PlanOwner;

public interface PlanOwnerDAO extends DAO<PlanOwner, String> {

	PlanOwner findBy(String email, String password);
	
}

package br.com.cavy.training.management.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cavy.training.management.model.PlanOwner;

@Repository
public interface PlanOwnerRepository extends MongoRepository<PlanOwner, String> {

	@Query("{ 'email' : ?0 }")
	PlanOwner findBy(String email);
	
	@Query("{ 'email' : ?0, 'password' : ?1 }")
	PlanOwner findBy(String email, String password);
	
}

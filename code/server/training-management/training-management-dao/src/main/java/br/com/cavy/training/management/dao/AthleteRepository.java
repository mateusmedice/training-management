package br.com.cavy.training.management.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.cavy.training.management.model.Athlete;

@Repository
public interface AthleteRepository extends MongoRepository<Athlete, String> {

	@Query("{ 'name' : ?0 }")
	Athlete findBy(String name);

}

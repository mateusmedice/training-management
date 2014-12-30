package br.com.cavy.training.management.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.cavy.training.management.model.Athlete;

@Repository
public interface AthleteDAO extends MongoRepository<Athlete, String> {
	
}

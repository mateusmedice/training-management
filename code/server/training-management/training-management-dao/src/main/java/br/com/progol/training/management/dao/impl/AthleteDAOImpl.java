package br.com.progol.training.management.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.progol.training.management.dao.AthleteDAO;
import br.com.progol.training.management.model.Athlete;

@Repository
public class AthleteDAOImpl extends DAOImpl<Athlete, String> implements AthleteDAO {

	public Athlete findByCPF(String cpf) {

		String jpql = "select u from Athlete u ";
		jpql += " where u.cpf = :cpf";
		
		Query query = getEntityManager().createQuery(jpql);
		
		query.setParameter("cpf", cpf);
		
		return (Athlete) query.getSingleResult();
	}

}

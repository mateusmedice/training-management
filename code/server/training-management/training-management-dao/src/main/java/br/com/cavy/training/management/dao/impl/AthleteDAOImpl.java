package br.com.cavy.training.management.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cavy.training.management.dao.AthleteDAO;
import br.com.cavy.training.management.model.Athlete;

@Repository
public class AthleteDAOImpl extends DAOImpl<Athlete, String> implements AthleteDAO {

	public Athlete findByCPF(String cpf) {

		String jpql = "select u from Athlete u ";
		jpql += " where u.cpf = :cpf";
		
		Query query = getEntityManager().createQuery(jpql);
		
		query.setParameter("cpf", cpf);
		
		List resultList = query.getResultList();
		
		if (resultList != null && !resultList.isEmpty()) {
			
			return (Athlete) resultList.get(0);
		}
		
		return null;
	}

	public List<Athlete> findByName(String name) {

		String jpql = "select a from Athlete a ";
		
		if (name != null && !name.isEmpty()) {
			jpql += " where a.name like :name ";
		}
		
		jpql += " order by a.name ";
		
		Query query = getEntityManager().createQuery(jpql);
		
		if (name != null && !name.isEmpty()) {
			query.setParameter("name", "%" + name.toUpperCase() + "%");
		}
		
		return query.getResultList();
	}

}

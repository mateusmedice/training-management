package br.com.cavy.training.management.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.cavy.training.management.dao.PlanOwnerDAO;
import br.com.cavy.training.management.model.PlanOwner;

@Repository
public class PlanOwnerDAOImpl extends DAOImpl<PlanOwner, String> implements PlanOwnerDAO {

	public PlanOwner findBy(String email, String password) {
		
		String jpql = "select p from PlanOwner p ";
		jpql += "where p.email = :email ";
		jpql += "and p.password = :password ";
		
		Query query = getEntityManager().createQuery(jpql);

		query.setParameter("email", email);
		query.setParameter("password", password);
		
		List resultList = query.getResultList();
		
		if (resultList != null && !resultList.isEmpty()) {
			return (PlanOwner) resultList.get(0);
		}
		
		return (PlanOwner) null;
	}

}

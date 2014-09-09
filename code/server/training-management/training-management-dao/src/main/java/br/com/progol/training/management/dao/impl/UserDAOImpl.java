package br.com.progol.training.management.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.progol.training.management.dao.UserDAO;
import br.com.progol.training.management.model.User;

@Repository
public class UserDAOImpl extends DAOImpl<User, String> implements UserDAO {

	public User findUserByCPF(String cpf) {

		String jpql = "select u from User u ";
		jpql += " where u.cpf = :cpf";
		
		Query query = getEntityManager().createQuery(jpql);
		
		query.setParameter("cpf", cpf);
		
		return (User) query.getSingleResult();
	}

}

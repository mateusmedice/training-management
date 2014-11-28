package br.com.cavy.training.management.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.cavy.training.management.dao.DAO;

public class DAOImpl <T, PK extends Serializable> implements DAO<T, PK> {

	private EntityManager entityManager;
	
	public DAOImpl() {
		
		if (this.entityManager == null) {
			this.entityManager = getEntityManager();
		}
	}
	
	public void persist(T t) {
		
		try {
			
			this.begin();
			
			this.entityManager.persist(t);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.commit();
		}
	}

	public T merge(T t) {

		try {
			
			this.begin();
			
			return this.entityManager.merge(t);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.commit();
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T getById(Class clazz, PK pk) {

		try {
			
			this.begin();
			
			return (T) this.entityManager.find(clazz, pk);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.commit();
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> getAll(Class clazz) {

		try {
			
			this.begin();
			
			String jpql = "select o from " + clazz.getCanonicalName() + " o ";
			
			return this.entityManager.createQuery(jpql).getResultList();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.commit();
		}
	}

	public void remove(T t) {

		try {
			
			this.begin();
			
			this.entityManager.remove(t);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			this.commit();
		}
	}

	public void begin() {
		this.entityManager.getTransaction().begin();
	}

	public void commit() {
		this.entityManager.getTransaction().commit();
	}
	
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("TrainingManagementPU").createEntityManager();
	}

}

package br.com.progol.training.management.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface DAO <T, PK> {

	void persist(T t);
	
	T merge(T t);
	
	@SuppressWarnings("rawtypes")
	T getById(Class clazz, PK pk);
	
	@SuppressWarnings("rawtypes")
	List<T> getAll(Class clazz);
	
	void remove(T t);
	
	EntityManager getEntityManager();
		
	void begin();
	
	void commit();
	
}

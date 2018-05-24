package com.consultorioapi.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.consultorioapi.repositories.interfaces.RepsitorioGenericoInterface;
import com.consultorioapi.util.JPAUtil;

public class RepositorioGenerico<T> implements RepsitorioGenericoInterface {
	private Class<T> type;
	EntityManager em = new JPAUtil().getEntityManager();
	
	public RepositorioGenerico() {
		
	}
	
	public RepositorioGenerico(Class<T> type) {
		this.type = type;
	}	

	@Override
	public <T> List<T> getAll() {
		em.getTransaction().begin();
		
		String sql = "select t from " + type.getName() + " t";		
		Query query = em.createQuery(sql);	
		List<T> entityList = query.getResultList();
		
		em.getTransaction().commit();
		
		return entityList;
	}

	@Override
	public <T> T getById(int id) {
		em.getTransaction().begin();		
		T entity = (T) em.find(type, id);		
		em.getTransaction().commit();
		
		return entity;
	}

	@Override
	public <T> void insert(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();		
	}

	@Override
	public <T> void update(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	@Override
	public <T> void delete(T entity) {
		em.getTransaction().begin();
		em.remove(em.contains(entity) ? entity : em.merge(entity));
		em.getTransaction().commit();
	}

}

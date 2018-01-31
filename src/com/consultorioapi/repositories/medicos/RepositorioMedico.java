package com.consultorioapi.repositories.medicos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.consultorioapi.models.Medicos;
import com.consultorioapi.util.JPAUtil;

public class RepositorioMedico {
	EntityManager em = new JPAUtil().getEntityManager();
	
	@SuppressWarnings("unchecked")
	public List<Medicos> getAll() {
		em.getTransaction().begin();
		
		String sql = "select m from Medicos m";
		
		//String sql = "select m from" + Medicos + "m";
		
		Query query = em.createQuery(sql);
		
		em.getTransaction().commit();
		
		return (List<Medicos>) query.getResultList();
	}
	
	public Medicos getById(int id) {
		em.getTransaction().begin();
		
		Medicos medico = em.find(Medicos.class, id);
		
		em.getTransaction().commit();
		
		return medico;
	}
	
	public void insert(Medicos medico) {
		em.getTransaction().begin();
		em.persist(medico);
		em.getTransaction().commit();
	}
}

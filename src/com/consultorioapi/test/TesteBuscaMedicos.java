package com.consultorioapi.test;

import javax.persistence.EntityManager;

import com.consultorioapi.models.Medicos;
import com.consultorioapi.util.JPAUtil;

public class TesteBuscaMedicos {
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		
		Medicos medico = em.find(Medicos.class, 1);
		
		medico.setNome("Jonas");
		
		System.out.println(medico.getNome());
		
		em.getTransaction().commit();
	}
}

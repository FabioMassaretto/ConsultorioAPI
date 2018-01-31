package com.consultorioapi.test;

import javax.persistence.EntityManager;

import com.consultorioapi.models.Medicos;
import com.consultorioapi.util.JPAUtil;

public class Teste {
	public static void main(String[] args) {
		Medicos medico = new Medicos();
		medico.setNome("João");
		medico.setCRM("CRM1234");
		medico.setIdade(30);
		
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(medico);
		em.getTransaction().commit();
		
		em.close();
	}
}

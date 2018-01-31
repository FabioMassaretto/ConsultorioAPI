package com.consultorioapi.util;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import com.consultorioapi.models.Consultas;
import com.consultorioapi.models.Consultorios;
import com.consultorioapi.models.Medicos;

public class PopulaMedicos {
		
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		
		Medicos medico1 = new Medicos();
		Medicos medico2 = new Medicos();
		Medicos medico3 = new Medicos();
		Medicos medico4 = new Medicos();
		Medicos medico5 = new Medicos();
		
		Consultorios consultorio1 = new Consultorios();
		Consultorios consultorio2 = new Consultorios();
		Consultorios consultorio3 = new Consultorios();
		
		Consultas consulta1 = new Consultas();
		Consultas consulta2 = new Consultas();
		
		medico1.setNome("Fabio Alvez");
		medico1.setCRM("CRM234234");
		medico1.setIdade(30);
		
		medico2.setNome("MAnuela Ferreira");
		medico2.setCRM("CRM67856875");
		medico2.setIdade(45);
		
		medico3.setNome("Luiz da Silva");
		medico3.setCRM("CRM88776");
		medico3.setIdade(32);
		
		medico4.setNome("Paulo Souza");
		medico4.setCRM("CRM455667");
		medico4.setIdade(39);
		
		medico5.setNome("Fernando Whilmen");
		medico5.setCRM("CRM3434523");
		medico5.setIdade(50);
		
		consultorio1.setNumero(12);
		consultorio2.setNumero(34);
		consultorio3.setNumero(16);
		
		consulta1.setNomePaciente("Julia da Silva");
		consulta1.setEspecialidade(EspecialidadeMedica.Dermatologia);
		consulta1.setDataHora(Calendar.getInstance());
		consulta1.setMedicos(Arrays.asList(medico1));
		consulta1.setConsultorios(consultorio2);
		
		consulta2.setNomePaciente("Bruno Souza");
		consulta2.setEspecialidade(EspecialidadeMedica.Dermatologia);
		consulta2.setDataHora(Calendar.getInstance());
		consulta2.setMedicos(Arrays.asList(medico4));
		consulta2.setConsultorios(consultorio1);
		
		em.getTransaction().begin();
		em.persist(medico1);
		em.persist(medico2);
		em.persist(medico3);
		em.persist(medico4);
		em.persist(medico5);
		
		em.persist(consultorio1);
		em.persist(consultorio2);
		em.persist(consultorio3);
		
		em.persist(consulta1);
		em.persist(consulta2);
		
		em.getTransaction().commit();
		
		em.close();
		
	}
}

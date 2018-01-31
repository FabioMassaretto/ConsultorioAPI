package com.consultorioapi.models;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.consultorioapi.util.EspecialidadeMedica;

@Entity
public class Consultas {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nomePaciente;
	
	@Enumerated(EnumType.STRING)
	private EspecialidadeMedica especialidade;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataHora;
	
	@OneToMany
	private List<Medicos> medicos;
	
	@JoinColumn(unique=true)
	@OneToOne
	private Consultorios consultorios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public EspecialidadeMedica getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(EspecialidadeMedica especialidade) {
		this.especialidade = especialidade;
	}

	public Calendar getDataHora() {
		return dataHora;
	}

	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}

	public List<Medicos> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medicos> medicos) {
		this.medicos = medicos;
	}

	public Consultorios getConsultorios() {
		return consultorios;
	}

	public void setConsultorios(Consultorios consultorios) {
		this.consultorios = consultorios;
	}
	
}

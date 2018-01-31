package com.consultorioapi.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

@Entity
public class Medicos {
	
	@javax.persistence.Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String Nome;
	private String CRM;
	private Integer Idade;
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getCRM() {
		return CRM;
	}
	public void setCRM(String cRM) {
		CRM = cRM;
	}
	public Integer getIdade() {
		return Idade;
	}
	public void setIdade(Integer idade) {
		Idade = idade;
	}
	
	public String toXML() {
		return new XStream().toXML(this);
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}
	
}

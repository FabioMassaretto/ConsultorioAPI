package com.consultorioapi.util;

public enum EspecialidadeMedica {
	CirugiaGeral ("Cirurgia Geral"), 
	ClinicaMedica ("Clínica Médica"), 
	Dermatologia ("Dermatologia"), 
	Geriatria ("Geriatria"), 
	Infectologia ("Infectologia");
	
	private final String descricao;
	
	EspecialidadeMedica(String desc) {
		this.descricao = desc;
	}

	public String getDescricao() {
		return descricao;
	}
}

package com.consultorioapi.repositories.medicos;

import com.consultorioapi.models.Medicos;
import com.consultorioapi.repositories.RepositorioGenerico;

public class MedicosRepositorio extends RepositorioGenerico<Medicos>{
	static Medicos medicos = new Medicos();
	public MedicosRepositorio() {
		super(Medicos.class);
	}
}

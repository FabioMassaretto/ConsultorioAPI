package com.consultorioapi.controllers;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.consultorioapi.models.Medicos;
import com.consultorioapi.repositories.medicos.MedicosRepositorio;
import com.google.gson.Gson;

@Path("/medicos")
public class MedicosController {
	MedicosRepositorio repoMedico = new MedicosRepositorio();
	Gson gson = new Gson();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAll() {
		List<Medicos> medicos = repoMedico.getAll();
		//String toXML = new XStream().toXML(medicos);
		String toJson = gson.toJson(medicos);
		return toJson;
	}
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("id") int id) {
		//return new XStream().toXML(repoMedico.getById(id));
		return gson.toJson(repoMedico.getById(id));
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response save(String medicoJson) {
		System.out.println(medicoJson);
		Medicos medico = gson.fromJson(medicoJson, Medicos.class);
		System.out.println(medico.getNome());
		repoMedico.insert(medico);
		URI uri = URI.create("/medicos/");
		return Response.created(uri).build();
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response delete(String medicoJson) {
		Medicos medico = gson.fromJson(medicoJson, Medicos.class);
		repoMedico.delete(medico);
		URI uri = URI.create("/medicos/");
		return Response.ok().build();		
	}
}

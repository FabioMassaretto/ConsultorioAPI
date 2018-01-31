package com.consultorioapi.repositories.interfaces;

import java.util.List;

public interface RepsitorioGenericoInterface {
	public <T> List<T> getAll();
	public <T> T getById(int id);
	public <T> void insert(T entity);
	public <T> void update(T entity);
	public <T> void delete(T entity);
}

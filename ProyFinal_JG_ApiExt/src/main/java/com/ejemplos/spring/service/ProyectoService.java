package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import com.ejemplos.spring.model.Proyecto;

public interface ProyectoService {

	// Metodo que muestra un listado de los proyectos de la empresa
	public List<Proyecto> listarProyectos();

	// Metodo para dar de alta un nuevo proyecto
	public void altaProyecto(Proyecto proyecto);

	// Metodo para actualizar un proyecto desde su id
	public void actualizarProyecto(Proyecto proyecto);

	// Metodo para eliminar un proyecto desde su id
	public void eliminarProyecto(int id);
	
	
	public Proyecto proyectoPorId(int id);

}

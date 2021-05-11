package com.ejemplos.spring.service;

import java.util.List;

import com.ejemplos.spring.model.Empleado;


public interface EmpleadoService {

	//Metodo que muestra un listado de los integrantes del equipo de la empresa al Gestor
	public List<Empleado> listarEquipoAdmin();
	
	//Metodo que muestra un listado de los integrantes del equipo de la empresa al Usuario
	public List<Empleado> listarEquipo();
}

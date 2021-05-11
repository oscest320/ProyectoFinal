package com.ejemplos.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Empleado;
import com.ejemplos.spring.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	EmpleadoRepository empleadoRepo;
	
	/*
	 * Metodo para mostrar un listado de los integrantes de la empresa al Gestor
	 */
	@Override
	public List<Empleado> listarEquipo() {
		return empleadoRepo.findAll();
	}

	/*
	 * Metodo para mostrar un listado de los integrantes de la empresa al Usuario
	 */
	@Override
	public List<Empleado> listarEquipoAdmin() {
		return empleadoRepo.findAll();
	}

}

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
	
	//Metodo para guardar un nuevo empleado
		@Override
		public void guardarEmpleado(Empleado empleado) {
			empleadoRepo.save(empleado);	
		}

	//Metodo para editar un empleado
		@Override
		public Empleado editarEmpleado(int id) {
			return empleadoRepo.getOne(id);
		}

	//Metodo para eliminar un empleado por id
		@Override
		public void eliminarEmpleado(int id) {
			empleadoRepo.deleteById(id);
		}

}

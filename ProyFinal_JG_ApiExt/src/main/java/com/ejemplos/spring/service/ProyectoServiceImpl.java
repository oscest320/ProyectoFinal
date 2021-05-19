package com.ejemplos.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Proyecto;
import com.ejemplos.spring.repository.ProyectoRepository;

@Service
public class ProyectoServiceImpl implements ProyectoService {

	@Autowired
	ProyectoRepository proyectoRepo;
	
	//Metodo que muestra un listado de los proyectos de la empresa
	 
	@Override
	public List<Proyecto> listarProyectos() {
		return proyectoRepo.findAll();
	}

	//Metodo para guardar un nuevo proyecto
	
	@Override
	public void altaProyecto(Proyecto proyecto) {
		proyectoRepo.save(proyecto);
		
	}

	// Metodo para actualizar un proyecto desde su id
	
	@Override
	public void actualizarProyecto(Proyecto proyecto) {
		proyectoRepo.save(proyecto);
	}

	// Metodo para eliminar un proyecto desde su id
	
	@Override
	public void eliminarProyecto(int id) {
		//id= (Intenger) id;
		proyectoRepo.deleteById(id);
	}
	
	
	@Override
	public Proyecto proyectoPorId(int id) {
		Proyecto noencontrado = null;
		List<Proyecto> proyectos = proyectoRepo.findAll();
		for (Proyecto proyecto : proyectos) {
			if(proyecto.getId()== id) {
				return proyecto;
			}
		}
		return noencontrado;
	}
	
	
	
	
	

	

	

}

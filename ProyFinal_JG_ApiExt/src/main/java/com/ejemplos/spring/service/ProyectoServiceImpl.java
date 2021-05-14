package com.ejemplos.spring.service;

import java.util.List;

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
	
	
	

	

	

}

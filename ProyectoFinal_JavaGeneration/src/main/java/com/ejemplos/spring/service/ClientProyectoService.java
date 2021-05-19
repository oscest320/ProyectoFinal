package com.ejemplos.spring.service;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ejemplos.spring.model.Cliente;
import com.ejemplos.spring.model.Empleado;
import com.ejemplos.spring.model.Proyecto;
import com.ejemplos.spring.repository.EmpleadoRepository;


@Service
public class ClientProyectoService /*implements ClientProyectoServiceInterfaz*/ {
	
	/*@Autowired
	ProyectoRepository proyectoRepo;*/
	
		//este metodo invoca la url de /proyectos y devuelve la listaProyectos
		public Collection<Proyecto> leerProyectosCollection() {
			RestTemplate plantilla = new RestTemplate();
			Proyecto[] proyecto = plantilla.getForObject("http://localhost:5000/proyectos", Proyecto[].class);
			List<Proyecto> listaProyectos = Arrays.asList(proyecto);
			return listaProyectos;
		}
		
		//este metodo coge un proyecto (el que se pasa por parametro) y lo envia a esta url
		public void enviarProyectos(Proyecto proyecto){
			RestTemplate plantilla = new RestTemplate();
			plantilla.postForObject("http://localhost:5000/proyectos", proyecto, Proyecto.class);
		}
		
		/*
		//Metodo para editar un proyecto
		@Override
		public Proyecto editarProyecto(int id) {
			return proyectoRepo.getOne(id);
		}

		@Override
		public void eliminarProyecto(int id) {
			proyectoRepo.deleteById(id);
		}*/
		
		


}
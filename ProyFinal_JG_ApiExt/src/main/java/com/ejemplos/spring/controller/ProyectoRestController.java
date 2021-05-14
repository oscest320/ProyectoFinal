package com.ejemplos.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.spring.model.Proyecto;
import com.ejemplos.spring.service.ProyectoService;

@RestController
@RequestMapping("/proyectos")

public class ProyectoRestController {

	@Autowired
	ProyectoService service;
		
	
	@GetMapping()
	public List<Proyecto> listarProyectos() {
		return service.listarProyectos();
	}
	
	
	
	@PostMapping
	public void altaProyecto(@RequestBody Proyecto proyecto) {
		service.altaProyecto(proyecto);
	}	
	
}

package com.ejemplos.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ejemplos.spring.service.EmpleadoService;

/**
 * Clase EmpleadoController. Intercepta la llamada del navegador para que entre
 * por el control.
 * 
 * @author Javier, Noemí, Óscar, Silvia, Usoa
 * @version 1.0
 * @see EmpleadoService
 * @see
 */

@Controller
public class EmpleadoController {

	@Autowired
	EmpleadoService service;

	private static final Logger log = LoggerFactory.getLogger(EmpleadoController.class);

	/*
	 * Metodo para mostrar un listado de los integrantes de la empresa al Gestor
	 */
	@GetMapping("/admin/equipo")
	public String listarEquipoAdmin(Model m) {
		log.info("----- Entrando en listarEquipo");
		m.addAttribute("equipoList", service.listarEquipoAdmin());
		
		log.info("------" + service.listarEquipoAdmin());
		return "adminEquipo";
	}
	
	/*
	 * Metodo para mostrar un listado de los integrantes de la empresa al Usuario
	 */
	@GetMapping("/equipo")
	public String listarEquipo(Model m) {
		log.info("----- Entrando en listarEquipo");
		m.addAttribute("equipoList", service.listarEquipo());
		log.info("------" + service.listarEquipo());
		return "equipo";
	}

}

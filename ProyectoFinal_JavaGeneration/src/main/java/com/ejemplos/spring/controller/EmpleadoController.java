package com.ejemplos.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ejemplos.spring.model.Empleado;
import com.ejemplos.spring.model.EmpleadoFalso;
import com.ejemplos.spring.service.CargoService;

import com.ejemplos.spring.service.ClientEmpleadosFalsosService;

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
	@Autowired
	CargoService cargos;

	@Autowired
	ClientEmpleadosFalsosService serv;


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
		//este metodo invoca la url de /random/persons y devuelve la listaEmplFalso [eF1, eF2, etc]
		List<EmpleadoFalso> listaEmplFalsos = new ArrayList<>();
		listaEmplFalsos.addAll(serv.leerEmplFalsosCollection());
		m.addAttribute("listaEmpFalsos", listaEmplFalsos);
			
		return "equipo";
	}

//Metodo para dar de alta nuevos empleados
	
	@GetMapping("/admin/equipo/alta")
	public String altaEmpleado(Empleado empleado, Model m) {
		log.info("----- Entrando en altaEmpleado");
		m.addAttribute("cargos", cargos.listarCargos());
		return "adminEquipoAlta";
	}
	
//Metodo para guardar un nuevo empleado
	
	@PostMapping("/guardarEmpleado")
	public ModelAndView guardarEmpleado(Empleado empleado) {
		log.info("----- Entrando en guardaEmpleado");	
		service.guardarEmpleado(empleado);
		return new ModelAndView("redirect:/admin/equipo");
	}
}

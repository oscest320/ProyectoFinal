package com.ejemplos.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ejemplos.spring.model.Cargo;
import com.ejemplos.spring.model.Cliente;
import com.ejemplos.spring.model.Proyecto;
import com.ejemplos.spring.service.ClientClienteService;
import com.ejemplos.spring.service.ClientProyectoService;


/**
 * Clase EmpleadoController. Intercepta la llamada del navegador para que entre
 * por el control.
 * 
 * @author Javier, Noemí, Óscar, Silvia, Usoa
 * @version 1.0
 * @see ClientProyectoService
 * @see
 */

@Controller
public class ProyectoController {

	@Autowired
	ClientProyectoService service;
	
	@Autowired
	ClientClienteService clienteService;
	


	private static final Logger log = LoggerFactory.getLogger(ProyectoController.class);

	/*
	 * Metodo para mostrar un listado de los proyectos de la empresa al Gestor
	 */
	@GetMapping("/admin/proyectos")
	public String listarProyectosAdmin(Model m) {
		log.info("----- Entrando en listarProyectos");
		
		List<Proyecto> proyectos = new ArrayList<>();
		proyectos.addAll(service.leerProyectosCollection());
		

		for (Proyecto proyecto : proyectos) {
			if(proyecto.getCliente() == null) {
				proyecto.setCliente(new Cliente());
				proyecto.getCliente().setNombre("No asignado");
			}
		}
		
		m.addAttribute("proyectos", proyectos);
		
		log.info("------" + service.leerProyectosCollection());
		return "adminProyectos";
	}
	
	/*
	 * Metodo para mostrar un listado de los proyectos de la empresa al Usuario
	 */
	@GetMapping("/proyectos")
	public String listarProyectos(Model m) {
		log.info("----- Entrando en listarProyectos");
		
		List<Proyecto> proyectos = new ArrayList<>();
		proyectos.addAll(service.leerProyectosCollection());
		
		for (Proyecto proyecto : proyectos) {
			if(proyecto.getCliente() == null) {
				proyecto.setCliente(new Cliente());
				proyecto.getCliente().setNombre("No asignado");
			}
		}
		
		m.addAttribute("proyectos", proyectos);
		
		log.info("------" + service.leerProyectosCollection());
		return "proyectos";
	}
		
	
//Metodo para dar de alta nuevos proyectos
	
	@GetMapping("/admin/proyectos/alta")
	public String altaProyecto(Proyecto proyecto, Model m) {
		log.info("----- Entrando en altaProyecto");
		List<Cliente> clientes = new ArrayList<>();
		clientes.addAll(clienteService.leerClientesCollection());
		m.addAttribute("clientes", clientes);
		return "adminProyectosAlta";
	}
	
//Metodo para guardar un nuevo proyecto
	
	@PostMapping("/guardarProyecto")
	public ModelAndView guardarProyecto(Proyecto proyecto, BindingResult br, String cliente) {
		log.info("----- Entrando en guardaProyecto");
		List<Cliente> clientes = new ArrayList<>();
		clientes.addAll(clienteService.leerClientesCollection());
		for (Cliente objetoCliente : clientes) {
			if(objetoCliente.toString().equals(cliente)) {
				proyecto.setCliente(objetoCliente);
			}
		}
		service.enviarProyectos(proyecto);
		return new ModelAndView("redirect:/admin/proyectos");
	}
	
	
	//Metodo para editar un proyecto
	@GetMapping("/admin/proyectos/editar")
	public String editarProyecto(@RequestParam("id") int id, Model m) {
			log.info("----- Entrando en editarProyecto");
			Proyecto proyectoSeleccionado = service.proyectoPorId(id);
			m.addAttribute("proyecto", proyectoSeleccionado);
			List<Cliente> listaClientes = new ArrayList<>();
			List<Cliente> listaClientesOrdenados = new ArrayList<>();
			listaClientes = clienteService.leerClientesCollection();
			for (Cliente cliente : listaClientes) {
				if (cliente.getId()==proyectoSeleccionado.getCliente().getId()) {
					listaClientesOrdenados.add(0, cliente);
				} else {
					listaClientesOrdenados.add(cliente);
				}
			}
			m.addAttribute("clientes", listaClientesOrdenados);
			return "adminProyectosAlta";
	}
	
	
	//Metodo para eliminar un proyecto
	@GetMapping("/admin/proyectos/eliminar")
	public ModelAndView eliminarProyecto(@RequestParam("id") int id) {
		log.info("----- Entrando en eliminarProyecto");
		service.eliminarProyecto(id);
		return new ModelAndView("redirect:/admin/proyectos");
	}
	
}
		
	



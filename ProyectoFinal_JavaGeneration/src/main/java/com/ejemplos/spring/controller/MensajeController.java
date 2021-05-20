package com.ejemplos.spring.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ejemplos.spring.model.Empleado;
import com.ejemplos.spring.model.Mensaje;
import com.ejemplos.spring.service.MensajeService;

/**
 * Clase MensajeController. Intercepta la llamada del navegador para que entre
 * por el control.
 * 
 * @author Javier, Noemí, Óscar, Silvia, Usoa
 * @version 1.0
 * @see MensajeService
 * @see
 */

@Controller
public class MensajeController {

	@Autowired
	MensajeService service;
	

	private static final Logger log = LoggerFactory.getLogger(MensajeController.class);

	
	@GetMapping("/contacto")
	public String viewContacto (Model m) {
		m.addAttribute("mensaje", new Mensaje());
		return "contacto";
	}
	
	/*
	 * Metodo para mostrar un listado de los mensajes recibidos en el Gestor
	 */
	
	@GetMapping("/admin/mensajes")
	public String listarMensajes(Model m) {
		log.info("----- Entrando en listarMensajes");
		m.addAttribute("mensajesList", service.listarMensajes());
		log.info("------" + service.listarMensajes());
		return "adminMensajes";
	}
	
	//Metodo para almacenar un nuevo mensaje
	
	@PostMapping("/guardarMensaje")
	public ModelAndView guardarMensaje(String mensaje, String nombre, String asunto) {
		log.info("----- Entrando en guardaMensaje");
		
		// Date java.util.Date
		// Date java.sql.Date
		
		// Calendar Java 5 o 7
		
		// LocalDate LocalTimeDate Java 8 (timezone)
		java.util.Date now = new java.util.Date();
		
		//java.sql.Date date = new java.sql.Date(now.getTime());
		
		
		Mensaje mensajeRequest = new Mensaje();
		mensajeRequest.setAsunto(asunto);
		mensajeRequest.setFecha(now);
		mensajeRequest.setMensaje(mensaje);
		mensajeRequest.setNombre(nombre);
		service.guardarMensaje(mensajeRequest);
		return new ModelAndView("redirect:/contacto");
	}
	
	//Metodo para guardar respuesta del mensjae
		@PostMapping("/admin/mensajes/responder")
		public ModelAndView guardarMensaje(@RequestParam("id")int id) {
			log.info("----- Entrando en guardaRespuesta");
			List<Mensaje> mensajes = service.listarMensajes();
			Mensaje mensaje = null;
			for(Mensaje msn : mensajes) {
				if(msn.getId()== id) {
					mensaje=msn;
				}
			}
			service.guardarMensaje(mensaje);
			return new ModelAndView("redirect:/admin/mensajes");
		}
	
}

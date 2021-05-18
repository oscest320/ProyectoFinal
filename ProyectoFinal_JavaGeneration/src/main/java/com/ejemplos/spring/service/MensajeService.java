package com.ejemplos.spring.service;

import java.util.List;

import com.ejemplos.spring.model.Mensaje;


public interface MensajeService {

	//Metodo que muestra un listado de los mensajes recibidos en el Gestor
	public List<Mensaje> listarMensajes();
	
	//Metodo para guardar un nuevo empleado
	public void guardarMensaje(Mensaje mensaje);
}

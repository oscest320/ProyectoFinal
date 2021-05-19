package com.ejemplos.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class ProyectoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProyectoNotFoundException() {
		super("No existe el proyecto");
	}
	public ProyectoNotFoundException(int id) {
		super("No existe el proyecto "+id);
	}	
}

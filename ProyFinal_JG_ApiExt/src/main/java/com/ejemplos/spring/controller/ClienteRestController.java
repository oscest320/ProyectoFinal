package com.ejemplos.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.spring.model.Cliente;
import com.ejemplos.spring.service.ClienteService;

@RestController
@RequestMapping("/clientes")

public class ClienteRestController {

	@Autowired
	ClienteService service;
		
	
	@GetMapping()
	public List<Cliente> listarClientes() {
		return service.listarClientes();
	}
	
	
}

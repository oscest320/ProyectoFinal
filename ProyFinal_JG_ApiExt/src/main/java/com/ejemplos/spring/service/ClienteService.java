package com.ejemplos.spring.service;

import java.util.List;

import com.ejemplos.spring.model.Cliente;


public interface ClienteService {

	//Metodo que muestra un listado de los clientes guardados en la BBDD
	public List<Cliente> listarClientes();
	
}

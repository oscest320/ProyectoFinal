package com.ejemplos.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplos.spring.model.Cliente;
import com.ejemplos.spring.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepo;

	//Metodo para mostrar un listado de los clientes guardados en la BBDD
	 
	@Override
	public List<Cliente> listarClientes() {
		return clienteRepo.findAll();
	}
	
	
	

}

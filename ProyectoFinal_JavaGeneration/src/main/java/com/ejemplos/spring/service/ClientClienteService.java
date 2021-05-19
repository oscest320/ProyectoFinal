package com.ejemplos.spring.service;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ejemplos.spring.model.Cliente;


@Service
public class ClientClienteService {
	//este metodo invoca la url de /clientes y devuelve la listaClientes
		public List<Cliente> leerClientesCollection() {
			RestTemplate plantilla = new RestTemplate();
			Cliente[] cliente = plantilla.getForObject("http://localhost:5000/clientes", Cliente[].class);
			List<Cliente> listaClientes = Arrays.asList(cliente);
			return listaClientes;
		}
}

package com.ejemplos.spring.service;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.ejemplos.spring.model.Empleado;


@Service
public class ClientEmpleadosFalsosService {
	//este metodo invoca la url de /random/persons y devuelve la listaEmplFalso [eF1, eF2, etc]
		public Collection<Empleado> leerEmplFalsosCollection() {
			RestTemplate plantilla = new RestTemplate();
			Empleado[] emplFalso = plantilla.getForObject("http://localhost:5000/persons", Empleado[].class);
			List<Empleado> listaEmplFalso = Arrays.asList(emplFalso);
			return listaEmplFalso;
		}
}
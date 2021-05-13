package com.ejemplos.spring.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.javafaker.Faker;
import com.ejemplos.spring.model.Empleado;

@RestController
//@RequestMapping("/random")
/**
 * Clase controlador "Empleados Falsos", el método
 * sirve para mostrar en pantalla una serie de falsos
 * trabajadores de la empresa
 *
 * @author Javier Jimenez, Óscar Estrada, Noemí De la Mata, Usoa Larrate, Silvia Lopez.
 * Fecha: 12-5-2021
 */
public class EmpleadosFalsosController {
	
	/*@Autowired
    private ObjectMapper objectMapper;*/
	
    @GetMapping("/persons")
    public List<Empleado> getRandomPersons() {
    	Faker faker = new Faker(new Locale("es"));   //importante, linea clave
        List<Empleado> empl = new ArrayList<>();
        for(int i = 0; i < 21; i++) {
        	empl.add(new Empleado(i+1,faker.name().firstName(), faker.name().lastName(), faker.job().keySkills(), faker.internet().avatar()));
        }
        
        return empl;
  
    }
}

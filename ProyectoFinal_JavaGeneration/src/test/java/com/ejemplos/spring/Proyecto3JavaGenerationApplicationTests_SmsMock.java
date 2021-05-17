package com.ejemplos.spring;


import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.ejemplos.spring.controller.EmpleadoController;
import com.ejemplos.spring.service.CargoService;
import com.ejemplos.spring.service.ClientEmpleadosFalsosService;
import com.ejemplos.spring.service.EmpleadoService;



@ExtendWith(SpringExtension.class)
@WebMvcTest(EmpleadoController.class) //le estoy inyectado el objeto

public class Proyecto3JavaGenerationApplicationTests_SmsMock {

	
	//este test comprueba le peticion get, que este bien hecha y que ademas me devuelva un objeto de tipo string que dice  "hola mundo"
	
	@Autowired
	private MockMvc mockMvc; // un objeto mock es una prueba de algo muy "a medida"
	
	@MockBean
	EmpleadoService service;
	@MockBean
	CargoService cargos;

	@MockBean
	ClientEmpleadosFalsosService serv;
	
	
	@Test
	void contextLoads() throws Exception {
		mockMvc.perform(get("/admin/equipo"))
			   .andDo(print())
			   .andExpect(status().isOk())
			   .andExpect(content().string(containsString("Listado de empleados")));
	}
	



}

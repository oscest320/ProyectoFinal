package com.ejemplos.spring;


import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.ejemplos.spring.model.Cliente;
import com.ejemplos.spring.model.Proyecto;
import com.ejemplos.spring.service.ProyectoService;

@ExtendWith(SpringExtension.class)
//@WebMvcTest(ProyectoRestController.class) //le estoy inyectado el objeto
@SpringBootTest()
@AutoConfigureMockMvc
public class ProyectoFinalJavaGenerationRestTemplateApplicationTests {

	
	//este test comprueba le peticion get, que este bien hecha y que ademas me devuelva un objeto de tipo string que dice "proyecto1"
	
	@Autowired
	private MockMvc mockMvc; // un objeto mock es una prueba de algo muy "a medida"
	
	@MockBean
	private ProyectoService serv;
	
	@Test
	void contextLoads() throws Exception {
		
		Proyecto proyectoMockito = new Proyecto();
		proyectoMockito.setProyecto("Proyecto Mockito");
		proyectoMockito.setFechafin("17-05-2021");
		proyectoMockito.setCliente(new Cliente());
		
		//when(serv.altaProyecto(proyectoMockito));
		//verify(proyectoMockito).altaProyecto();
	
		mockMvc.perform(post("/proyectos"))
			   .andDo(print())
			   .andExpect(status().isOk())
			   .andExpect(content().string(containsString("Proyecto Mockito")));
	}
	



}


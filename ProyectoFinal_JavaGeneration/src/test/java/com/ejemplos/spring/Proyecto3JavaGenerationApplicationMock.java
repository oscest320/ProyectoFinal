package com.ejemplos.spring;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.ejemplos.spring.model.Cargo;
import com.ejemplos.spring.model.Empleado;
import com.ejemplos.spring.service.EmpleadoService;

@ExtendWith(SpringExtension.class)
//@WebMvcTest(EmpleadoController.class)//Esta sintaxis no funciona, en su defecto hemos implementado la linea 
@SpringBootTest()
@AutoConfigureMockMvc
public class Proyecto3JavaGenerationApplicationMock {
	
	@Autowired 
	private MockMvc mockMvc;
	
	@MockBean 
	private EmpleadoService serv;
	
	@Test
	void contextLoads() throws Exception {
		List<Empleado> empleadoMvc = new ArrayList<>();
		Empleado empleadoMockito = new Empleado();
		empleadoMockito.setNombre("Mockito");
		empleadoMockito.setApellidos("Pruebas unitarias");
		empleadoMockito.setCargo(new Cargo());
		empleadoMvc.add(empleadoMockito);
		
		when(serv.listarEquipoAdmin()).thenReturn(empleadoMvc);
		
		mockMvc.perform(get("/admin/equipo"))
		   .andDo(print())
		   .andExpect(status().isOk())
		   .andExpect(content().string(containsString("Mockito")));
	}
	
}

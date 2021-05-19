package com.ejemplos.spring.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String viewHome () {
		
		return "home";
	}
	
	@GetMapping("/proyectos/movieflix")
	public String viewMovieFlix() {
		return "movieflix";
	}
	
	@GetMapping("/proyectos/landing")
	public String viewLanding() {
		return "landing";
	}
	
	@GetMapping("/empleo")
	public String viewEmpleo() {
		return "empleo";
	}
	
	
	
		
	
	
}

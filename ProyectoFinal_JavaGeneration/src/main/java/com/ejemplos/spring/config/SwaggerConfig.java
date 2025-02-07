package com.ejemplos.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//The configuration of Swagger mainly centers around the Docket bean.
//Swagger 2 is enabled through the @EnableSwagger2 annotation.

//After the Docket bean is defined, its select() method returns an instance of ApiSelectorBuilder, 
//which provides a way to control the endpoints exposed by Swagger.

/*
 * Una vez ejecutados ambos proyectos, escribir el siguiente codigo en la barra de navegacion
 * localhost:8080/v2/api-docs
 * En otra pestaña escribir esto
 * localhost:8080/swagger-ui-html 
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.any())              
          .paths(PathSelectors.any())                          
          .build();                                           
    }

}


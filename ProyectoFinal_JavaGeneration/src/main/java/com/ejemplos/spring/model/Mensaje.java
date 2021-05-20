package com.ejemplos.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "mensajes")
public class Mensaje {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idmensaje")
	private int id;
	
	@Column(name = "`from`")
	private String nombre;
	
	private Date fecha;
	
	@Column(name = "`subject`")
	private String asunto;
	
	private String mensaje;
	private String respuesta;
	private Boolean respondido;
	
	public Mensaje() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Boolean getRespondido() {
		return respondido;
	}

	public void setRespondido(Boolean respondido) {
		this.respondido = respondido;
	}

	@Override
	public String toString() {
		return "Mensaje [id=" + id + ", nombre=" + nombre + ", fecha=" + fecha + ", asunto=" + asunto + ", mensaje="
				+ mensaje + ", respuesta=" + respuesta + ", respondido=" + respondido + "]";
	}

}
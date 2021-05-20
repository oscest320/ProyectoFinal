package com.ejemplos.spring.model;

import javax.persistence.Entity;
import com.ejemplos.spring.model.Cliente;



public class Proyecto {
		
	private int id;
	private String proyecto;
	private String fechafin;
	private String resumen;
	private String descripcion;
	private String link;
	private String imagen;
    private Cliente cliente;
	
	public Proyecto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProyecto() {
		return proyecto;
	}

	public void setProyecto(String proyecto) {
		this.proyecto = proyecto;
	}

	public String getFechafin() {
		return fechafin;
	}

	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Proyecto [id=" + id + ", proyecto=" + proyecto + ", fechafin=" + fechafin + ", resumen=" + resumen
				+ ", descripcion=" + descripcion + ", link=" + link + ", imagen=" + imagen + ", cliente=" + cliente
				+ "]";
	}
	
}

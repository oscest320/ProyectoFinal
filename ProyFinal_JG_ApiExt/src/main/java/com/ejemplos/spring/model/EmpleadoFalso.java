package com.ejemplos.spring.model;


public class EmpleadoFalso {

	private int id;
	private String nombre;
	private String apellidos;
	private String resumen;
	private String foto;
	private String cargo;
	private String prefijo;
	private String foto2;

	public EmpleadoFalso() {
	}

	

	public EmpleadoFalso(int id, String nombre, String apellidos, String resumen, String foto, String cargo,
			String prefijo) {
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.resumen = resumen;
		this.foto = foto;
		this.cargo = cargo;
		this.prefijo = prefijo;
		this.foto2 = asignarFoto();
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getPrefijo() {
		return prefijo;
	}

	public void setPrefijo(String prefijo) {
		this.prefijo = prefijo;
	}

	

	public String getFoto2() {
		return foto2;
	}



	public void setFoto2(String foto2) {
		this.foto2 = foto2;
	}



	public String asignarFoto() {
		char fin = this.nombre.substring(this.nombre.length()-1).charAt(0);
		if(fin =='a') {
			return "https://randomuser.me/api/portraits/women/" + id +".jpg";
		}else{
			return "https://randomuser.me/api/portraits/men/" + id +".jpg";
		}
	}



	@Override
	public String toString() {
		return "EmpleadoFalso [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", resumen=" + resumen
				+ ", foto=" + foto + ", cargo=" + cargo + ", prefijo=" + prefijo + ", foto2=" + foto2 + "]";
	}


	
	

}

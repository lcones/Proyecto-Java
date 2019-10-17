package com.proyecto.spring.Model;

import com.proyecto.spring.Entity.Usuario;

public class UsuarioModel {

	private int id;

	private String nombres;

	private String apellidos;

	private String celular;

	private String contrasena;
	
	
public UsuarioModel(Usuario usuario) {
		
		this.id = usuario.getId();
		this.nombres = usuario.getNombres();
		this.apellidos = usuario.getApellidos();
		this.celular = usuario.getCelular();
		this.contrasena = usuario.getContrasena();
	}
	
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public UsuarioModel(int id, String nombres, String apellidos, String celular, String contrasena) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.celular = celular;
		this.contrasena = contrasena;
	}

	public UsuarioModel() {
		
	}

	@Override
	public String toString() {
		return "UsuarioModel [id=" + id + ", nombres=" + nombres + ", apellidos=" + apellidos + ", celular=" + celular
				+ ", contrasena=" + contrasena + "]";
	}

	

}

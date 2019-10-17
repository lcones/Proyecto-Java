package com.proyecto.spring.services;

import java.util.List;

import com.proyecto.spring.Entity.Usuario;
import com.proyecto.spring.Model.UsuarioModel;

public interface UsuarioService {
	
	
	public abstract List<UsuarioModel> listAllUsuarios();
	public abstract UsuarioModel addUsuario(UsuarioModel usuarioModel);
	public abstract Usuario findUsuarioById(int id);
	public abstract void removeUsuario(int id);
	public abstract Usuario findByNombresAndContrasena(String nombres,  String contrasena);
	
	public  abstract UsuarioModel findUsuarioByIdModel(int id);
	
}

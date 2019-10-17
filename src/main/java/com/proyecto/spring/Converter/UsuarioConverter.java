package com.proyecto.spring.Converter;

import org.springframework.stereotype.Component;

import com.proyecto.spring.Entity.Usuario;
import com.proyecto.spring.Model.UsuarioModel;

@Component("usuarioConverter")
public class UsuarioConverter {
	
	public Usuario toEntity(UsuarioModel usuarioModel) {
		
		Usuario usuario = new Usuario();
		
		usuario.setId(usuarioModel.getId());
		usuario.setNombres(usuarioModel.getNombres());
		usuario.setApellidos(usuarioModel.getApellidos());
		usuario.setCelular(usuarioModel.getCelular());
		usuario.setContrasena(usuarioModel.getContrasena());
		
		return  usuario;
	}
	
	public UsuarioModel toModel(Usuario usuario) {
		
		UsuarioModel usuarioModel = new UsuarioModel();
		
		usuarioModel.setId(usuario.getId());
		usuarioModel.setNombres(usuario.getNombres());
		usuarioModel.setApellidos(usuario.getApellidos());
		usuarioModel.setCelular(usuario.getCelular());
		usuarioModel.setContrasena(usuario.getContrasena());
		
		return usuarioModel;
	}

}

package com.proyecto.spring.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.spring.Converter.UsuarioConverter;
import com.proyecto.spring.Entity.Usuario;
import com.proyecto.spring.Model.UsuarioModel;
import com.proyecto.spring.Repository.UsuarioRepository;
import com.proyecto.spring.services.UsuarioService;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService {
	
	
	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	
	@Override
	public UsuarioModel addUsuario(UsuarioModel usuarioModel) {
		
		Usuario usuario = usuarioRepository.save(usuarioConverter.toEntity(usuarioModel));
		
		return usuarioConverter.toModel(usuario);
	}

	@Override
	public List<UsuarioModel> listAllUsuarios() {
		
		List<Usuario> usuarios = usuarioRepository.findAll();
		
		List<UsuarioModel> usuarioModel = new ArrayList<UsuarioModel>();
		
		for(Usuario usuario : usuarios) {
			
			usuarioModel.add(usuarioConverter.toModel(usuario));	
			
		}
		
		return usuarioModel;
	}

	@Override
	public Usuario findUsuarioById(int id) {
		 return usuarioRepository.findById(id);
	}
	
	//IMPLEMENTACION DE Usuario entity a UsuarioModel//
	
	@Override
	public UsuarioModel findUsuarioByIdModel(int id) {
		
		return usuarioConverter.toModel(findUsuarioById(id));
	}
		
	

	@Override
	public void removeUsuario(int id) {
		
		Usuario usuario = findUsuarioById(id);
		
		if(null != usuario) {
			
			usuarioRepository.delete(usuario);
		}
		
	}

	@Override
	public Usuario findByNombresAndContrasena(String nombres, String contrasena) {
		
		return usuarioRepository.findByNombresAndContrasena(nombres, contrasena);
	}

}

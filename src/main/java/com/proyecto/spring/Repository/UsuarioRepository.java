package com.proyecto.spring.Repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.spring.Entity.Usuario;

@Repository("usuarioRepository")

public interface UsuarioRepository extends JpaRepository<Usuario, Serializable>{
	
	
	public abstract Usuario findById(int id);
	
	public abstract Usuario findByNombresAndContrasena(String nombres, String contrasena );
	
	

}

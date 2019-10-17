package com.proyecto.spring.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.spring.Converter.UsuarioConverter;
import com.proyecto.spring.Model.UsuarioModel;
import com.proyecto.spring.services.UsuarioService;


@RestController
@RequestMapping("/pv1")
public class UsuarioRestController {
	
	@Autowired
	@Qualifier("usuarioServiceImpl")
	private UsuarioService usuarioService;
	
	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;
	
	//METODO PARA MOSTRAR LISTA DE USUARIOS
	@GetMapping("/mostrartodos" )
	public   ResponseEntity<List<UsuarioModel>>   mostrartodos(){
		
		List<UsuarioModel> usuarios= new ArrayList<>();
		usuarios=usuarioService.listAllUsuarios();
		return new ResponseEntity<List<UsuarioModel>>(usuarios,HttpStatus.OK) ;
	}
	
	//METODO PARA AGREGAR  USUARIOS
	@PutMapping("/agregar")
	public ResponseEntity<UsuarioModel>  registrar(@RequestBody UsuarioModel usuarioModel)
	{
		UsuarioModel usuarios = new UsuarioModel();
		usuarios = usuarioService.addUsuario(usuarioModel);
		return new ResponseEntity<UsuarioModel>(usuarios,HttpStatus.OK);
		
	}
	
	//METODO PARA ACTUALIZAR DATOS USUARIOS
	
	@PostMapping("/agregar")
	public ResponseEntity<UsuarioModel>  actualizar(@RequestBody UsuarioModel usuarioModel)
	{
		UsuarioModel usuarios = new UsuarioModel();
		usuarios = usuarioService.addUsuario(usuarioModel);
		return new ResponseEntity<UsuarioModel>(usuarios,HttpStatus.OK);
		
	}
	
	
	//METODO PARA ELEIMINAR USUARIOS DE LA BD
	
	@DeleteMapping("/eliminar/{id}/{nombres}")
	public void borrarUsuario(@PathVariable("id") int id,
			@PathVariable("nombres" )String nombres) {
		
		usuarioService.removeUsuario(id);
		
	}
	
	//BUSCAR POR ID
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<UsuarioModel> buscarUsuario(@PathVariable("id") int id) {
	   UsuarioModel usuario = usuarioConverter.toModel(usuarioService.findUsuarioById(id));
		return new ResponseEntity<UsuarioModel>(usuario,HttpStatus.OK);
	}

}


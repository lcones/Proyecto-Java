package com.proyecto.spring.Controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.spring.Constant.ViewUsuario;
import com.proyecto.spring.Model.UsuarioModel;
import com.proyecto.spring.services.UsuarioService;


@Controller
public class LoginController {
	
	@Autowired
	@Qualifier("usuarioServiceImpl")
	private UsuarioService usuarioService;
	
	
	
	private static final Log LOG = LogFactory.getLog(LoginController.class);
	
	
    @GetMapping("/login")
	public String ShowLoginForm(Model model,
			@RequestParam(name="error", required = false) String error,
			@RequestParam(name="logout", required = false) String logout) {
    	
    	LOG.info("METHOD: ShowLoginForm() -- PARAMS: error=" + error + ", logout:" + logout);
    	
    	model.addAttribute("logout", logout);
    	model.addAttribute("error", error);
    	LOG.info("Returnning to  login view");
		return ViewUsuario.LOGIN;
	}
    
    @GetMapping({"/loginsuccess", "/"})
    public String loginCheck() {
    	LOG.info("METHOD: loginCheck() -- PARAMS: ");
    	LOG.info("Returnning to  login view " );
    		return ("redirect:/usuarios/showusuarios");
    	
    	
    }
    
    

}

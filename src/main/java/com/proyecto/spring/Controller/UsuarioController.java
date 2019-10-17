package com.proyecto.spring.Controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.proyecto.spring.Constant.ViewUsuario;
import com.proyecto.spring.Entity.Usuario;
import com.proyecto.spring.Model.UsuarioModel;
import com.proyecto.spring.services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	@Qualifier("usuarioServiceImpl")
	private UsuarioService usuarioService;

	private static final Log LOG = LogFactory.getLog(UsuarioController.class);

	@GetMapping("/cancel")

	public String cancelar() {
		return "redirect:/usuarios/showusuarios";
	}

	@PreAuthorize("hasRole('ROLE_USER')")
	@GetMapping("/usuarioform")
	public String viewUsuarioForm(@RequestParam(name = "id", required = false) int id, Model model) {

		UsuarioModel usuario = new UsuarioModel();
		if (id != 0) {

			usuario = usuarioService.findUsuarioByIdModel(id);
		}

		model.addAttribute("usuarioModel", usuario);

		return ViewUsuario.USUARIO_FORM;

	}

	@PostMapping("/addusuarios2")
	public String AddUsuario2(@ModelAttribute(name = "usuarioModel") UsuarioModel usuarioModel, Model model) {

		if (null != usuarioService.addUsuario(usuarioModel)) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}

		return "redirect:/usuarios/showusuarios";
	}

	@PostMapping("/addusuario")

	public String addUsuario(@ModelAttribute(name = "usuarioModel") UsuarioModel usuarioModel, Model model) {

		LOG.info("METHOD: addUsuario() -- PARAMS: " + usuarioModel.toString());

		if (null != usuarioService.addUsuario(usuarioModel)) {

			model.addAttribute("result", 1);

		} else {
			model.addAttribute("result", 0);
		}

		return "redirect:/usuarios/showusuarios";
	}

	@GetMapping("/showusuarios")

	public ModelAndView showUsuarios() {
		ModelAndView mav = new ModelAndView(ViewUsuario.USUARIO);

		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		mav.addObject("username", user.getUsername());
		mav.addObject("usuarios", usuarioService.listAllUsuarios());

		return mav;
	}

	@GetMapping("/removeusuarios")

	public ModelAndView removeUsuarios(@RequestParam(name = "id", required = true) int id) {

		usuarioService.removeUsuario(id);

		return showUsuarios();
	}

}

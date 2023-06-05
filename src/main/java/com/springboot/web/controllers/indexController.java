package com.springboot.web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.springboot.web.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app")
public class indexController {

	@GetMapping({"", "/", "/index", "/home"})
	public String index(Model model) {
		model.addAttribute("titulo", "Hola Spring Framework con Model!");
		return "index";
	}

	@GetMapping("/perfil")
	public String perfil(Model model){
		Usuario user = new Usuario();
		user.setNombre("Jonathan");
		user.setApellido("Ibarra");
		user.setEmail("jonnymartinez.pzl1@gmail.com");
		model.addAttribute("usuario", user);
		model.addAttribute("titulo", "Perfil del usuario");
		return "perfil";
	}

	@GetMapping("/listar")
	public String listar(Model model){
		/*List<Usuario> usuarios = Arrays.asList(
				new Usuario("Jona", "Edu", "jonnym@adda.com"),
				new Usuario("Lup", "Ana", "lup@asd.com")
		);*/
		model.addAttribute("titulo", "Listado de usuarios");
		//model.addAttribute("usuarios", usuarios);
		return "listar";
	}

	/**
	 * La anotación ModelAttribute hace que cualquier vista pueda acceder a los datos.
	 *
	 * @return
	 */
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Jona", "Edu", "jonnym@adda.com"),
				new Usuario("Lup", "Ana", "lup@asd.com")
		);
		return usuarios;
	}
}

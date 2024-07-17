package com.ipartek.formacion.spring.ipartektube.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.ipartektube.entidades.Video;
import com.ipartek.formacion.spring.ipartektube.servicios.UsuarioService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/usuarios-registrados")
public class UsuarioController {
	private static final String VISTA_FORMULARIO = "formulario";
	private UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable Long id) {
		usuarioService.borrar(id);
		return "redirect:/";
	}
	
	@GetMapping("/formulario")
	public String formulario(Video video) {
		return VISTA_FORMULARIO;
	}
	
	@GetMapping("/formulario/{id}")
	public String modificar(@PathVariable Long id, Model modelo) {
		Video video = usuarioService.verVideo(id);
		modelo.addAttribute("video", video);
		return VISTA_FORMULARIO;
	}
	
	@PostMapping("/formulario")
	public String formularioPost(@Valid Video video, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return VISTA_FORMULARIO;
		}
		
		if(video.getId() != null) {
			usuarioService.modificar(video);
		} else {
			usuarioService.crear(video);
		}
		
		return "redirect:/";
	}
}

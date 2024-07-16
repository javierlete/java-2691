package com.ipartek.formacion.spring.ipartektube.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.spring.ipartektube.servicios.AnonimoService;

@Controller
@RequestMapping("/")
public class IndexController {
	private AnonimoService anonimoService;
	
	public IndexController(AnonimoService anonimoService) {
		this.anonimoService = anonimoService;
	}
	
	@GetMapping({"/", "/videos"})
	public String index(Model modelo) {
		modelo.addAttribute("videos", anonimoService.listarVideos());
		return "videos";
	}
	
	@GetMapping("/videos/{id}")
	public String video(Model modelo, @PathVariable Long id) {
		modelo.addAttribute("video", anonimoService.verVideo(id));
		return "video";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}

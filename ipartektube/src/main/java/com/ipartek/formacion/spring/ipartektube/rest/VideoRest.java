package com.ipartek.formacion.spring.ipartektube.rest;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.spring.ipartektube.entidades.Video;
import com.ipartek.formacion.spring.ipartektube.servicios.AnonimoService;
import com.ipartek.formacion.spring.ipartektube.servicios.UsuarioService;

@RestController
@RequestMapping("/api")
public class VideoRest {
	private UsuarioService usuarioService;
	private AnonimoService anonimoService;
	
	public VideoRest(UsuarioService usuarioService, AnonimoService anonimoService) {
		this.usuarioService = usuarioService;
		this.anonimoService = anonimoService;
	}
	
	@GetMapping({"/anonimo/videos", "/anonimo/videos/"})
	public Iterable<Video> listarVideos() {
		return anonimoService.listarVideos();
	}
	
	@GetMapping("/anonimo/videos/{id}")
	public Video verVideo(@PathVariable Long id) {
		var video = anonimoService.verVideo(id);
		
		if(video == null) {
			throw new ResourceNotFoundException();
		}
		
		return video;
	}
	
	@PostMapping("/usuario/videos")
	@ResponseStatus(HttpStatus.CREATED)
	public Video insertarVideo(@RequestBody Video video) {
		return usuarioService.crear(video);
	}
	
	@PutMapping("/usuario/videos/{id}")
	public Video insertarVideo(@PathVariable Long id, @RequestBody Video video) {
		return usuarioService.modificar(video);
	}
	
	@DeleteMapping("/usuario/videos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarVideo(@PathVariable Long id) {
		usuarioService.borrar(id);
	}
	
}

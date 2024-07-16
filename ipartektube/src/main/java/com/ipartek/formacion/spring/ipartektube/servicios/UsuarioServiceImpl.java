package com.ipartek.formacion.spring.ipartektube.servicios;

import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.ipartektube.entidades.Video;
import com.ipartek.formacion.spring.ipartektube.repositorios.VideoRepository;

@Service
public class UsuarioServiceImpl extends AnonimoServiceImpl implements UsuarioService {

	public UsuarioServiceImpl(VideoRepository videoRepository) {
		super(videoRepository);
	}

	@Override
	public Video crear(Video video) {
		return videoRepository.save(video);
	}

	@Override
	public Video modificar(Video video) {
		return videoRepository.save(video);
	}

	@Override
	public void borrar(Long id) {
		videoRepository.deleteById(id);		
	}

}

package com.ipartek.formacion.spring.ipartektube.servicios;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.spring.ipartektube.entidades.Video;
import com.ipartek.formacion.spring.ipartektube.repositorios.VideoRepository;

@Service
@Primary
public class AnonimoServiceImpl implements AnonimoService {
	protected VideoRepository videoRepository;
	
	public AnonimoServiceImpl(VideoRepository videoRepository) {
		this.videoRepository = videoRepository;
	}
	
	@Override
	public Iterable<Video> listarVideos() {
		return videoRepository.findAll();
	}

	@Override
	public Video verVideo(Long id) {
		return videoRepository.findById(id).orElse(null);
	}

}

package com.ipartek.formacion.spring.ipartektube.servicios;

import com.ipartek.formacion.spring.ipartektube.entidades.Video;

public interface AnonimoService {
	Iterable<Video> listarVideos();
	Video verVideo(Long id);
	
}

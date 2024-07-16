package com.ipartek.formacion.spring.ipartektube.servicios;

import com.ipartek.formacion.spring.ipartektube.entidades.Video;

public interface UsuarioService extends AnonimoService {
	Video crear(Video video);
	Video modificar(Video video);
	void borrar(Long id);
}

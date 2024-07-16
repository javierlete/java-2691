package com.ipartek.formacion.spring.ipartektube.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.spring.ipartektube.entidades.Video;

@RepositoryRestResource(path = "videos", collectionResourceRel = "videos")
public interface VideoRepository extends JpaRepository<Video, Long> {

}

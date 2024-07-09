package com.ipartek.formacion.spring.webservidorspring;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.spring.webservidorspring.entidades.Categoria;
import com.ipartek.formacion.spring.webservidorspring.entidades.Empleado;
import com.ipartek.formacion.spring.webservidorspring.entidades.Producto;
import com.ipartek.formacion.spring.webservidorspring.repositorios.CategoriaRepository;
import com.ipartek.formacion.spring.webservidorspring.repositorios.EmpleadoRepository;
import com.ipartek.formacion.spring.webservidorspring.repositorios.ProductoRepository;

@SpringBootApplication
public class WebservidorspringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WebservidorspringApplication.class, args);
	}

	@Autowired
	private EmpleadoRepository empleadoRepo;
	
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Autowired
	private ProductoRepository productoRepo;
	
	@Override
	public void run(String... args) throws Exception {
		empleadoRepo.save(Empleado.builder().id(1L).nombre("pepe").apellidos("perez").nif("12345678Z").nss("12345123451").sueldoMensual(new BigDecimal(12345.12)).build());

		System.out.println(empleadoRepo.findByNif("12345678Z"));
		
		categoriaRepo.save(Categoria.builder().id(1L).nombre("Prueba").build());
		
		productoRepo.save(Producto.builder().id(1L).nombre("Producto1").precio(new BigDecimal(1234.12)).categoria(Categoria.builder().id(1L).build()).build());
		productoRepo.save(Producto.builder().id(2L).nombre("Producto2").precio(new BigDecimal(123.12)).categoria(Categoria.builder().id(1L).build()).build());
		
		Categoria cat = categoriaRepo.obtenerPorIdConProductos(1L);
		
		System.out.println(cat);
		System.out.println(cat.getProductos());
		
		System.out.println(productoRepo.count());
	}

}

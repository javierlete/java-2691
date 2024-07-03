package com.ipartek.formacion.veterinario.jpa;

import java.util.List;

import com.ipartek.formacion.veterinario.accesodatos.DaoJpa;
import com.ipartek.formacion.veterinario.entidades.Categoria;
import com.ipartek.formacion.veterinario.entidades.Producto;

class UnoAVarios extends DaoJpa {
	
	public static void main(String[] args) {
		enTransaccionActualizacion(em -> {
//			Categoria c = Categoria.builder().nombre("Electrónica").build();
//			em.persist(c);
//			
//			Producto p1 = new Producto();
//			p1.setNombre("Cocina");
//			p1.setPrecio(new BigDecimal(100));
//			p1.setStock(10);
//			p1.setCategoria(c);
//			em.persist(p1);
//			
//			Producto p2 = new Producto();
//			p2.setNombre("Lavadora");
//			p2.setPrecio(new BigDecimal(200));
//			p2.setStock(20);
//			p2.setCategoria(c);
//			em.persist(p2);
//			
//			em.flush();
			
			List<Producto> productos = em.createQuery("select p from Producto p join fetch p.categoria", Producto.class).getResultList();
			
			productos.forEach(p -> System.out.println(p.getCategoria().getNombre()));
			
			Categoria categoria = em.find(Categoria.class, 1L);
			
			System.out.println(categoria);
			
			productos = em.createQuery("select p from Producto p join fetch p.categoria where p.categoria.id = 1", Producto.class).getResultList();
			
			System.out.println(productos);
			
			productos.forEach(p -> System.out.println(p));
		});
	}
}

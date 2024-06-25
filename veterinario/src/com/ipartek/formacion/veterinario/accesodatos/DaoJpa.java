package com.ipartek.formacion.veterinario.accesodatos;

import java.util.function.Consumer;
import java.util.function.Function;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DaoJpa {
	private static final EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("com.ipartek.formacion.veterinario.entidades");

	protected static <T> T enTransaccionConsulta(Function<EntityManager, T> codigoAEjecutar) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			T resultado = codigoAEjecutar.apply(em);
			t.commit();
			
			return resultado;
		} catch (Exception e) {
			if (t.isActive()) {
				t.rollback();
			}
			throw e;
		} finally {
			em.close();
		}
	}
	
	protected static void enTransaccionActualizacion(Consumer<EntityManager> codigoAEjecutar) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		try {
			t.begin();
			codigoAEjecutar.accept(em);
			t.commit();
		} catch (Exception e) {
			if (t.isActive()) {
				t.rollback();
			}
			throw e;
		} finally {
			em.close();
		}
	}

}

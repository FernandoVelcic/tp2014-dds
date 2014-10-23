package com.grupo10.test;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.grupo10.db.*;
import com.grupo10.juego.Administrador;
import com.grupo10.juego.Partido;

public class TestConexionSQL {

	@Test
	public void contextUp() {
		EntityManagerHelper.getEntityManager();
	}

	@Test
	public void contextUpWithTransaction() throws Exception {
		EntityManagerHelper.withTransaction(() -> {
		});
	}
	
	@Before
	public void begin() throws Exception {
		EntityManagerHelper.beginTransaction();
	}
		
	@After
	public void tearDown() throws Exception {
		EntityManagerHelper.rollback();
	}
	
	@Test
	public void partido() throws Exception {
		Partido partido = new Partido(LocalDate.now(), new Administrador());

		EntityManagerHelper.getEntityManager().persist(partido);
	}
}

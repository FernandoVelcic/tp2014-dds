package com.grupo10.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

import com.group10.db.*;
import com.grupo10.juego.Administrador;
import com.grupo10.juego.Partido;
import com.group10.db.EntityManagerHelper;

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
	
	@Test
	public void partido() throws Exception {
		Partido partido = new Partido(LocalDate.now(), new Administrador());

		EntityManagerHelper.getEntityManager().persist(partido);
	}
}

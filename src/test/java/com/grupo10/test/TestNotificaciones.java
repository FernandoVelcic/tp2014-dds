package com.grupo10.test;

import static org.junit.Assert.*;

import java.util.Date;


import org.junit.Before;
import org.junit.Test;

import com.grupo10.Administrador;
import com.grupo10.Participante;
import com.grupo10.Partido;

public class TestNotificaciones {

	Administrador admin;
	Participante martin;
	Partido partido;
	
	@Before
	public void setUp() throws Exception {
		admin = new Administrador();
		martin = new Participante();
		partido = new Partido(new Date(),admin);
	}

	@Test
	public void testSeConfirmaPartidoYSeNotificaAadministrador(){
		for (int i=1;i<=10;i++){
			partido.inscribirJugador(martin);
		}
		partido.generarJugadores();
		partido.isPartidoConfirmadoYnotificar();
		assertTrue(admin.notificaciones.contains("El partido esta confirmado"));
	}
	
	@Test
	public void testElPartidoDejaDeTenerALos10Confirmados(){
		for (int i=1;i<=10;i++){
			partido.inscribirJugador(martin);
		}
		partido.generarJugadores();
		partido.darBajaJugador(martin);
		partido.isPartidoConfirmadoYnotificar();
		assertTrue(admin.notificaciones.contains("Faltan Jugadores"));
	}
}

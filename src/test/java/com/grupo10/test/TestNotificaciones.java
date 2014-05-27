package com.grupo10.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Modalidades.Estandar;

import com.grupo10.Administrador;
import com.grupo10.Participante;
import com.grupo10.Partido;

public class TestNotificaciones {

	Administrador admin;
	Participante martin;
	Participante carlos;
	Partido partido;
	
	@Before
	public void setUp() throws Exception {
		admin = new Administrador();
		martin = new Participante();
		carlos = new Participante();
		martin.setModalidad(new Estandar());
		partido = new Partido(new Date(),admin);
	}

	@Test
	public void testSeConfirmaPartidoYSeNotificaAlAdministrador(){
		for (int i=1;i<=10;i++){
			partido.inscribirJugador(martin);
		}
		partido.generarJugadores();
		partido.isPartidoConfirmadoYnotificar();
		assertTrue(admin.notificaciones.contains("El partido está confirmado"));
	}
	
	@Test
	public void testElPartidoDejaDeTenerALos10ConfirmadosYSeNotificaAlAdministrador(){
		for (int i=1;i<=10;i++){
			partido.inscribirJugador(martin);
		}
		partido.generarJugadores();
		partido.darBajaJugador(martin);
		partido.isPartidoConfirmadoYnotificar();
		assertTrue(admin.notificaciones.contains("Faltan Jugadores"));
	}
	
	@Test
	public void testSeRechazaPropuestaDeJuegoDeMartinYSeLeNotifica(){
		admin.proponerJugador(martin);
		admin.rechazarPropuesta(martin, "Jugar mal");
		assertTrue(martin.notificaciones.contains("Rechazaron tu solicitud por: Jugar mal"));
	}
	
	@Test
	public void testMartinSeInscribeAPartidoYSeNotificaASuAmigoCarlos(){
		martin.agregarAmigo(carlos);
		partido.inscribirJugador(martin);
		assertTrue(carlos.notificaciones.contains(martin +" se inscribió"));
	}
}

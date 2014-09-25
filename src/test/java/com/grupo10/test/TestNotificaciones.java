package com.grupo10.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import com.grupo10.juego.Administrador;
import com.grupo10.juego.Participante;
import com.grupo10.juego.Partido;
import com.grupo10.modalidades.Estandar;

public class TestNotificaciones {

	Administrador admin;
	Participante martin;
	Participante carlos;
	Participante tomas;
	Participante juan;
	Partido partido;
	Estandar estandar;
	
	@Before
	public void setUp() throws Exception {
		estandar = new Estandar();
		admin = new Administrador();
		martin = new Participante();
		carlos = new Participante();
		tomas = new Participante();
		juan = new Participante();
		martin.setModalidad(estandar);
		carlos.setModalidad(estandar);
		tomas.setModalidad(estandar);
		juan.setModalidad(estandar);
		partido = new Partido(LocalDate.now(),admin);
	}

	@Test
	public void testSeConfirmaPartidoYSeNotificaAlAdministrador(){
		for (int i=1;i<=10;i++){
			partido.inscribirJugador(martin);
		}
		partido.generarJugadores();
		partido.notificarPartidoConfirmado();
		assertTrue(admin.notificaciones.contains("El partido está confirmado"));
	}
	
	@Test
	public void testElPartidoDejaDeTenerALos10ConfirmadosYSeNotificaAlAdministrador(){
		for (int i=1;i<=10;i++){
			partido.inscribirJugador(martin);
		}
		partido.generarJugadores();
		partido.darBajaJugador(martin);
		partido.notificarPartidoConfirmado();
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
	
	@Test
	public void testMartinSeInscribeAPartidoYSeNotificaATodosSusAmigos(){
		martin.agregarAmigo(carlos);
		martin.agregarAmigo(tomas);
		martin.agregarAmigo(juan);
		partido.inscribirJugador(martin);
		assertTrue(carlos.notificaciones.contains(martin +" se inscribió"));
		assertTrue(tomas.notificaciones.contains(martin +" se inscribió"));
		assertTrue(juan.notificaciones.contains(martin +" se inscribió"));
	}
}

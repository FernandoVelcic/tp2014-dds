package com.grupo10.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

import com.grupo10.Administrador;
import com.grupo10.Jugador;
import com.grupo10.Partido;

import Modalidades.*;

public class TestPartido 
    extends TestCase
{
	Partido partido;
	Administrador alberto;
	Jugador martin;
	Jugador carlos;
	Jugador susana;
	Modalidad estandar;
	Modalidad condicional;
	Modalidad solidario;
	
	@Before
	public void setUp() throws Exception {
		alberto = new Administrador();
		martin = new Jugador();
		carlos = new Jugador();
		susana = new Jugador();
		partido = new Partido(new Date(), alberto);
		estandar = new Estandar();
		condicional = new Condicional();
		solidario = new Solidario();
	}
	@Test
	public void testCarlosNoPuedeInscribirseDadoQueYaHay10JugadoresEnLaLista(){
		for (int i = 0 ; i < 10; i++){
			partido.inscribirJugador(susana, estandar);
		}
		assertFalse(partido.inscribirJugador(carlos, condicional));
	}
	@Test
	public void testSusanaEsCondicionalYSePuedeInscribirALaListaPorqueHay9Jugadores(){
		for (int i = 0 ; i < 9; i++){
			partido.inscribirJugador(martin, estandar);
		}
		assertTrue(partido.inscribirJugador(susana, condicional));
	}
	
	@Test
	public void testElJugadorEstandarTieneMayorPrioridadQueElCondicional(){
		assertTrue(estandar.getPrioridad() < condicional.getPrioridad());
	}
	
	@Test
	public void testElJugadorEstandarTieneMayorPrioridadQueElSolidario(){
		assertTrue(estandar.getPrioridad() < solidario.getPrioridad());
	}
}

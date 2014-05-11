package com.grupo10.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

import com.grupo10.Jugador;
import com.grupo10.Partido;

import Modalidades.*;

public class TestPartido 
    extends TestCase
{
	Partido partido;
	Jugador martin;
	Jugador carlos;
	Jugador susana;
	Modalidad estandar;
	Modalidad condicional;
	
	@Before
	public void setUp() throws Exception {
		martin = new Jugador();
		carlos = new Jugador();
		susana = new Jugador();
		partido = new Partido(new Date());
		estandar = new Estandar();
		
	}
	@Test
	public void testCarlosNoPuedeInscribirseDadoQueYaHay10JugadoresEnLaLista(){
		for (int i = 0 ; i < 10; i++){
			susana.inscribirmeAPartido(partido, estandar);
		}
		assertFalse(carlos.inscribirmeAPartido(partido, condicional));
	}
	@Test
	public void testSusanaEsCondicionalYSePuedeInscribirALaListaPorqueHay9Jugadores(){
		for (int i = 0 ; i < 9; i++){
			martin.inscribirmeAPartido(partido, estandar);
		}
		assertTrue(susana.inscribirmeAPartido(partido, condicional));
	}
}

package com.grupo10.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Modalidades.Estandar;

import com.grupo10.Participante;
import com.grupo10.Partido;
import com.grupo10.Administrador;

public class TestInfracciones {

	Participante martin;
	Participante tomas;
	Partido partido;
	
	@Before
	public void setUp() throws Exception {
		martin = new Participante();
		martin.setModalidad(new Estandar());
		tomas = new Participante();
		tomas.setModalidad(new Estandar());
		partido = new Partido(new Date(),new Administrador());
	}

	@Test
	public void testMartinSeDaDeBajaDelPartidoSinProponerReemplazoYSeLeGeneraUnaInfraccion() {
		partido.inscribirJugador(martin);
		partido.generarJugadores();
		partido.darBajaJugador(martin);
		assertTrue(martin.infracciones.size() == 1);
	}
	
	@Test
	public void testMartinSeDaDeBajaDelPartidoYProponerReemplazoNoSeLeGeneraUnaInfraccion() {
		partido.inscribirJugador(martin);
		partido.generarJugadores();
		partido.darBajaJugadorYProponerReemplazo(martin, tomas);
		assertTrue(martin.infracciones.size() == 0);
	}
}

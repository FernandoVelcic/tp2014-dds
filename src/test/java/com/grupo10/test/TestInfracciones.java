package com.grupo10.test;

import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import com.grupo10.juego.Administrador;
import com.grupo10.juego.Participante;
import com.grupo10.juego.Partido;
import com.grupo10.modalidades.Estandar;

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
		partido = new Partido(LocalDate.now(),new Administrador());
		
		partido.inscribirJugador(martin);
		partido.generarJugadores();
	}

	@Test
	public void testMartinSeDaDeBajaDelPartidoSinProponerReemplazoYSeLeGeneraUnaInfraccion() {
		partido.darBajaJugador(martin);
		assertTrue(martin.infracciones.size() == 1);
	}
	
	@Test
	public void testMartinSeDaDeBajaDelPartidoYProponerReemplazoNoSeLeGeneraUnaInfraccion() {
		partido.darBajaJugadorYProponerReemplazo(martin, tomas);
		assertTrue(martin.infracciones.size() == 0);
	}
}

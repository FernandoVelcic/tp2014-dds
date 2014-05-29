package com.grupo10.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Modalidades.Estandar;

import com.grupo10.Administrador;
import com.grupo10.Calificacion;
import com.grupo10.Participante;
import com.grupo10.Partido;

public class TestCalificaciones {
	
	Participante martin;
	Participante carlos;
	Partido partido1;
	Partido partido2;
	Calificacion calificacion;
	
	
	@Before
	public void setUp() throws Exception {
		martin = new Participante();
		martin.setModalidad(new Estandar());
		carlos = new Participante();
		carlos.setModalidad(new Estandar());
		partido1 = new Partido(new Date(), new Administrador());
		partido2 = new Partido(new Date(), new Administrador());
	}

	@Test
	public void testMartinYCarlosJugaronJuntosYMartinCalificaACarlos(){
		partido1.inscribirJugador(martin);
		partido1.inscribirJugador(carlos);
		partido1.generarJugadores();
		martin.calificarA(carlos, 7, "Jugó bien pero le faltó correr más");
		assertTrue(carlos.calificaciones.size() == 1);	
	}

	@Test
	public void testMartinJugoUnPartidoCarlosOtroYMartinNoPuedeCalificarACarlos(){
		partido1.inscribirJugador(martin);
		partido2.inscribirJugador(carlos);
		partido1.generarJugadores();
		partido2.generarJugadores();
		assertFalse(martin.calificarA(carlos, 7, "Jugó bien pero le faltó correr más"));	
	}
	
	@Test
	public void testMartinNoSePuedeCalificarASiMismo(){
		partido1.inscribirJugador(martin);
		partido1.generarJugadores();
		assertFalse(martin.calificarA(martin, 7, "Jugó bien pero le faltó correr más"));	
	}
}

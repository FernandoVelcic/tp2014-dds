package com.grupo10.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.grupo10.excepciones.CalificacionException;
import com.grupo10.juego.Administrador;
import com.grupo10.juego.Calificacion;
import com.grupo10.juego.Participante;
import com.grupo10.juego.Partido;
import com.grupo10.modalidades.Estandar;

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
		calificacion = new Calificacion(7, "Jugó bien pero le faltó correr más", partido1);
	}

	@Test
	public void testMartinYCarlosJugaronJuntosYMartinCalificaACarlos() throws Exception{
		partido1.inscribirJugador(martin);
		partido1.inscribirJugador(carlos);
		partido1.generarJugadores();
		martin.calificar(carlos, calificacion);
		assertTrue(carlos.calificaciones.size() == 1);	
	}

	@Test (expected = CalificacionException.class)
	public void testMartinJugoUnPartidoCarlosOtroYMartinNoPuedeCalificarACarlos() throws Exception{
		partido1.inscribirJugador(martin);
		partido2.inscribirJugador(carlos);
		partido1.generarJugadores();
		partido2.generarJugadores();
		martin.calificar(carlos, calificacion);
	}
	
	@Test (expected = CalificacionException.class)
	public void testMartinNoSePuedeCalificarASiMismo() throws Exception{
		partido1.inscribirJugador(martin);
		partido1.generarJugadores();
		martin.calificar(martin, calificacion);
	}
}

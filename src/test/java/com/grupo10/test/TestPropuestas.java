package com.grupo10.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.grupo10.juego.Administrador;
import com.grupo10.juego.Participante;
import com.grupo10.juego.Partido;
import com.grupo10.modalidades.Estandar;

public class TestPropuestas {
	
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
	public void testSeProponeAMartinParaJugarYSeLoAgregaALaListaDePropuestas(){
		admin.proponerJugador(martin);
		assertTrue(admin.propuestas.contains(martin));
	}
	
	@Test
	public void testSeProponeAMartinYACarlosYSeAnalizaLaPropuestaDeMartin(){
		admin.proponerJugador(martin);
		admin.proponerJugador(carlos);
		assertTrue(admin.analizarPropuesta() == martin);
	}
	
	@Test
	public void testSeAceptaPropuestaDeJuegoDeMartinYSeLoAgregaALaListaDeParticipantes(){
		admin.proponerJugador(martin);
		admin.aceptarPropuesta(martin);
		assertTrue(partido.participantes.contains(martin));
	}

}

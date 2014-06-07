package com.grupo10.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.grupo10.juego.Administrador;
import com.grupo10.juego.Participante;
import com.grupo10.juego.Partido;
import com.grupo10.modalidades.*;

public class TestInscripciones {

	Partido partido;
	Administrador admin;
	Participante martin;
	Participante carlos;
	Participante tomas;
	Modalidad estandar;
	Modalidad condicional;
	Modalidad solidario;

	@Before
	public void setUp() throws Exception {
		admin = new Administrador();
		martin = new Participante();
		carlos = new Participante();
		tomas = new Participante();
		partido = new Partido(new Date(), admin);
		estandar = new Estandar();
		condicional = new Condicional(true);
		solidario = new Solidario();
		martin.setModalidad(estandar);
		carlos.setModalidad(condicional);
		tomas.setModalidad(solidario);
	}

	public boolean estaInscripto(Participante jugador){
		return partido.jugadores.contains(jugador);
	}

	public void cargarJugadores(int cantidad, Participante participante){
		for (int i = 0 ; i < cantidad; i++){
			partido.inscribirJugador(participante);
		}
	}
	
	@Test
	public void testElJugadorEstandarTieneMayorPrioridadQueElSolidario(){
		assertTrue(estandar.getPrioridad() < solidario.getPrioridad());
	}

	@Test
	public void testElJugadorEstandarTieneMayorPrioridadQueElCondicional(){
		assertTrue(estandar.getPrioridad() < condicional.getPrioridad());
	}

	@Test
	public void testMartinEsEstandarYSeInscribeAPartido() {
		partido.inscribirJugador(martin);
		partido.generarJugadores();
		assertTrue(estaInscripto(martin));
	}

	@Test
	public void testCarlosEsCondicionalYSeInscribeAPartido() {
		carlos.setModalidad(new Condicional(true));
		partido.inscribirJugador(carlos);
		partido.generarJugadores();
		assertTrue(estaInscripto(carlos));
	}
	
	@Test
	public void testTomasEsSolidarioYSeInscribeAPartido() {
		partido.inscribirJugador(tomas);
		partido.generarJugadores();
		assertTrue(estaInscripto(tomas));
	}
	
	@Test
	public void testCarlosJuegaPorqueHay9JugadoresConfirmados() {
		cargarJugadores(9, martin);
		carlos.setModalidad(new Condicional(partido.calcularConfirmados() == 9));
		partido.inscribirJugador(carlos);
		partido.generarJugadores();
		assertTrue(estaInscripto(carlos));
	}

	@Test
	public void testCarlosNoJuegaPorqueNoHay9JugadoresConfirmados() {
		cargarJugadores(8, martin);
		carlos.setModalidad(new Condicional(partido.calcularConfirmados() == 9));
		partido.inscribirJugador(carlos);
		partido.generarJugadores();
		assertFalse(estaInscripto(carlos));
	}

	@Test
	public void testCarlosNoJuegaPorqueNoSeInscribioMartin() {
		carlos.setModalidad(new Condicional(estaInscripto(martin)));
		partido.inscribirJugador(carlos); 
		partido.generarJugadores();
		assertFalse(estaInscripto(carlos));
	}

	@Test
	public void testCarlosJuegaPorqueSeInscribioMartin() {
		partido.inscribirJugador(martin);
		partido.generarJugadores();
		carlos.setModalidad(new Condicional(estaInscripto(martin)));
		partido.inscribirJugador(carlos);
		partido.generarJugadores();
		assertTrue(estaInscripto(carlos));
	}

	@Test
	public void testHay10JugadoresEstandarSeInscribeTomasSolidarioYNoQuedaSeleccionado() {
		cargarJugadores(10, martin);
		partido.inscribirJugador(tomas);
		partido.generarJugadores();
		assertFalse(estaInscripto(tomas));
	}

	@Test
	public void testHay10JugadoresCondicionalesSeAnotaMartinEstandarYQuedaSeleccionado(){
		cargarJugadores(10, carlos);
		partido.inscribirJugador(martin);
		partido.generarJugadores();
		assertTrue(estaInscripto(martin));
	}

	@Test
	public void testHay10JugadoresCondicionalesSeAnotaTomasSolidarioYQuedaSeleccionado(){
		cargarJugadores(10, carlos);
		partido.inscribirJugador(tomas);
		partido.generarJugadores();
		assertTrue(estaInscripto(tomas));
	}
}

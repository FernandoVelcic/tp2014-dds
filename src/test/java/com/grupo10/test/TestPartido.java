package com.grupo10.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Modalidades.*;

import com.grupo10.Administrador;
import com.grupo10.Participante;
import com.grupo10.Partido;

public class TestPartido {

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
		condicional = new Condicional();
		solidario = new Solidario();
		martin.setModalidad(estandar);
		tomas.setModalidad(solidario);
		carlos.setModalidad(condicional);
	}
	
	public boolean estaInscripto (Participante jugador){
		return partido.jugadores.contains(jugador);
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
		carlos.setModalidad(new Condicional() {
			@Override
			public boolean isPuedeJugar(Partido partido) {
	    		return true;
	    	}
		}); 
		partido.inscribirJugador(carlos);
		partido.generarJugadores();
		assertTrue(estaInscripto(carlos));
	}
	
	@Test
	public void testCarlosJuegaPorqueHay9JugadoresConfirmados() {
		for (int i = 0 ; i < 9; i++){
			partido.inscribirJugador(martin);
		}
		carlos.setModalidad(new Condicional() {
			@Override
			public boolean isPuedeJugar(Partido partido) {
	    		return partido.calcularConfirmados() == 9;
	    	}
		});
		partido.inscribirJugador(carlos);
		partido.generarJugadores();
		assertTrue(estaInscripto(carlos));
	}
	
	@Test
	public void testCarlosNoJuegaPorqueNoHay9JugadoresConfirmados() {
		for (int i = 0 ; i < 8; i++){
			partido.inscribirJugador(martin);
		}
		carlos.setModalidad(new Condicional() {
			@Override
			public boolean isPuedeJugar(Partido partido) {
	    		return partido.calcularConfirmados() == 9;
	    	}
		});
		partido.inscribirJugador(carlos);
		partido.generarJugadores();
		assertFalse(estaInscripto(carlos));
	}
	
	@Test
	public void testCarlosNoJuegaPorqueNoSeInscribioMartin() {
		partido.inscribirJugador(tomas);
		carlos.setModalidad(new Condicional() {
			@Override
			public boolean isPuedeJugar(Partido partido) {
	    		return estaInscripto(martin);
	    	}
		});
		partido.inscribirJugador(carlos); 
		partido.generarJugadores();
		assertFalse(estaInscripto(carlos));
	}
	
	@Test
	public void testCarlosJuegaPorqueSeInscribioMartin() {
		partido.inscribirJugador(martin);
		partido.generarJugadores();
		carlos.setModalidad(new Condicional() {
			@Override
			public boolean isPuedeJugar(Partido partido) {
				return estaInscripto(martin);
	    	}
		});
		partido.inscribirJugador(tomas);
		partido.generarJugadores();
		assertTrue(estaInscripto(tomas));
	}
	
	@Test
	public void testTomasEsSolidarioYSeInscribeAPartido() {
		tomas.setModalidad(solidario);
		partido.inscribirJugador(tomas);
		partido.generarJugadores();
		assertTrue(estaInscripto(tomas));
	}
	
	@Test
	public void testHay10JugadoresEstandarSeInscribeTomasSolidarioYNoQuedaSeleccionado() {
		for (int i = 0 ; i < 10; i++){
			partido.inscribirJugador(martin);
		}
		partido.inscribirJugador(tomas);
		partido.generarJugadores();
		assertFalse(estaInscripto(carlos));
	}
	
	@Test
	public void testHay10JugadoresCondicionalesSeAnotaMartinEstandarYQuedaSeleccionado(){
		for (int i = 0 ; i < 10; i++){
			partido.inscribirJugador(carlos);
		}
		partido.inscribirJugador(martin);
		partido.generarJugadores();
		assertTrue(estaInscripto(martin));
	}
	
	@Test
	public void testHay10JugadoresCondicionalesSeAnotaTomasSolidarioYQuedaSeleccionado(){
		for (int i = 0 ; i < 10; i++){
			partido.inscribirJugador(carlos);
		}
		partido.inscribirJugador(tomas);
		partido.generarJugadores();
		assertTrue(estaInscripto(tomas));
	}
}

package com.grupo10.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Modalidades.Condicional;
import Modalidades.Estandar;
import Modalidades.Modalidad;
import Modalidades.Solidario;

import com.grupo10.Administrador;
import com.grupo10.Jugador;
import com.grupo10.Partido;

public class TestPartido {

	Partido partido;
	Administrador admin;
	Jugador martinJ;
	Jugador carlosJ;
	Jugador tomasJ;
	Modalidad estandar;
	Modalidad condicional;
	Modalidad solidario;
	
	@Before
	public void setUp() throws Exception {
		admin = new Administrador();
		martinJ = new Jugador();
		carlosJ = new Jugador();
		tomasJ = new Jugador();
		partido = new Partido(new Date(), admin);
		estandar = new Estandar();
		condicional = new Condicional();
		solidario = new Solidario();
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
		partido.inscribirJugador(martinJ, estandar);
		partido.generarJugadores();
		assertTrue(partido.jugadores.stream().anyMatch(j -> j.getJugador() == martinJ));
	}
	
	@Test
	public void testMartinEsCondicionalYSeInscribeAPartido() {
		partido.inscribirJugador(martinJ, new Condicional() {
			@Override
			public boolean isPuedeJugar(Partido partido) {
	    		return true;
	    	}
		});
		partido.generarJugadores();
		assertTrue(partido.jugadores.stream().anyMatch(j -> j.getJugador() == martinJ));
	}
	
	@Test
	public void testMartinJuegaPorqueHay9JugadoresConfirmados() {
		for (int i = 0 ; i < 9; i++){
			partido.inscribirJugador(carlosJ, estandar);
		}
		partido.inscribirJugador(martinJ, new Condicional() {
			@Override
			public boolean isPuedeJugar(Partido partido) {
	    		return partido.calcularConfirmados() == 9;
	    	}
		});
		partido.generarJugadores();
		assertTrue(partido.jugadores.stream().anyMatch(j -> j.getJugador() == martinJ));
	}
	
	@Test
	public void testMartinNoJuegaPorqueNoHay9JugadoresConfirmados() {
		for (int i = 0 ; i < 8; i++){
			partido.inscribirJugador(carlosJ, estandar);
		}
		partido.inscribirJugador(martinJ, new Condicional() {
			@Override
			public boolean isPuedeJugar(Partido partido) {
	    		return partido.calcularConfirmados() == 9;
	    	}
		});
		partido.generarJugadores();
		assertFalse(partido.jugadores.stream().anyMatch(j -> j.getJugador() == martinJ));
	}
	
	@Test
	public void testMartinNoJuegaPorqueNoSeInscribioCarlos() {
		partido.inscribirJugador(tomasJ, estandar);
		partido.inscribirJugador(martinJ, new Condicional() {
			@Override
			public boolean isPuedeJugar(Partido partido) {
	    		return partido.jugadores.stream().anyMatch(j -> j.getJugador() == carlosJ);
	    	}
		});
		partido.generarJugadores();
		assertFalse(partido.jugadores.stream().anyMatch(j -> j.getJugador() == martinJ));
	}
	
	@Test
	public void testMartinJuegaPorqueSeInscribioCarlos() {
		partido.inscribirJugador(carlosJ, estandar);
		partido.inscribirJugador(tomasJ, estandar);
		partido.generarJugadores();
		partido.inscribirJugador(martinJ, new Condicional() {
			@Override
			public boolean isPuedeJugar(Partido partido) {
				return partido.jugadores.stream().anyMatch(j -> j.getJugador() == carlosJ);
	    	}
		});
		partido.generarJugadores();
		assertTrue(partido.jugadores.stream().anyMatch(j -> j.getJugador() == martinJ));
	}
	
	@Test
	public void testMartinEsSolidarioYSeInscribeAPartido() {
		partido.inscribirJugador(martinJ, solidario);
		partido.generarJugadores();
		assertTrue(partido.jugadores.stream().anyMatch(j -> j.getJugador() == martinJ));
	}
	
	@Test
	public void testHay10JugadoresEstandarSeInscribeCarlosCondicionalYNoQuedaSeleccionado() {
		for (int i = 0 ; i < 10; i++){
			partido.inscribirJugador(martinJ, estandar);
		}
		partido.inscribirJugador(carlosJ, condicional);
		partido.generarJugadores();
		assertFalse(partido.jugadores.stream().anyMatch(j -> j.getJugador() == carlosJ));
	}
	
	@Test
	public void testHay10JugadoresCondicionalesSeAnotaCarlosEstandarYQuedaSeleccionado(){
		for (int i = 0 ; i < 10; i++){
			partido.inscribirJugador(martinJ, condicional);
		}
		partido.inscribirJugador(carlosJ, estandar);
		partido.generarJugadores();
		assertTrue(partido.jugadores.stream().anyMatch(j -> j.getJugador() == carlosJ));
	}
	
	@Test
	public void testHay10JugadoresCondicionalesSeAnotaCarlosSolidarioYQuedaSeleccionado(){
		for (int i = 0 ; i < 10; i++){
			partido.inscribirJugador(martinJ, condicional);
		}
		partido.inscribirJugador(carlosJ, solidario);
		partido.generarJugadores();
		assertTrue(partido.jugadores.stream().anyMatch(j -> j.getJugador() == carlosJ));
	}
}

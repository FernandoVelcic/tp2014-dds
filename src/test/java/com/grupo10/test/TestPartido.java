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
		martin.setModalidad(estandar);
		partido.inscribirJugador(martin);
		partido.generarJugadores();
		assertTrue(partido.jugadores.contains(martin));
	}
	
	@Test
	public void testMartinEsCondicionalYSeInscribeAPartido() {
		martin.setModalidad(new Condicional() {
			@Override
			public boolean isPuedeJugar(Partido partido) {
	    		return true;
	    	}
		}); 
		partido.inscribirJugador(martin);
		partido.generarJugadores();
		assertTrue(partido.jugadores.contains(martin));
	}
	
	@Test
	public void testMartinJuegaPorqueHay9JugadoresConfirmados() {
		for (int i = 0 ; i < 9; i++){
			carlos.setModalidad(estandar);
			partido.inscribirJugador(carlos);
		}
		martin.setModalidad(new Condicional() {
			@Override
			public boolean isPuedeJugar(Partido partido) {
	    		return partido.calcularConfirmados() == 9;
	    	}
		});
		partido.inscribirJugador(martin);
		partido.generarJugadores();
		assertTrue(partido.jugadores.contains(martin));
	}
	
	@Test
	public void testMartinNoJuegaPorqueNoHay9JugadoresConfirmados() {
		for (int i = 0 ; i < 8; i++){
			carlos.setModalidad(estandar);
			partido.inscribirJugador(carlos);
		}
		martin.setModalidad(new Condicional() {
			@Override
			public boolean isPuedeJugar(Partido partido) {
	    		return partido.calcularConfirmados() == 9;
	    	}
		});
		partido.inscribirJugador(martin);
		partido.generarJugadores();
		assertFalse(partido.jugadores.contains(martin));
	}
	
	@Test
	public void testMartinNoJuegaPorqueNoSeInscribioCarlos() {
		tomas.setModalidad(estandar);
		partido.inscribirJugador(tomas);
		martin.setModalidad(new Condicional() {
			@Override
			public boolean isPuedeJugar(Partido partido) {
	    		return partido.jugadores.contains(carlos);
	    	}
		});
		partido.inscribirJugador(martin); 
		partido.generarJugadores();
		assertFalse(partido.jugadores.contains(martin));
	}
	
	@Test
	public void testMartinJuegaPorqueSeInscribioCarlos() {
		carlos.setModalidad(estandar);
		partido.inscribirJugador(carlos);
		partido.generarJugadores();
		tomas.setModalidad(new Condicional() {
			@Override
			public boolean isPuedeJugar(Partido partido) {
				return partido.jugadores.contains(carlos);
	    	}
		});
		partido.inscribirJugador(tomas);
		partido.generarJugadores();
		assertTrue(partido.jugadores.contains(tomas));
	}
	
	@Test
	public void testMartinEsSolidarioYSeInscribeAPartido() {
		martin.setModalidad(solidario);
		partido.inscribirJugador(martin);
		partido.generarJugadores();
		assertTrue(partido.jugadores.contains(martin));
	}
	
	@Test
	public void testHay10JugadoresEstandarSeInscribeCarlosSolidarioYNoQuedaSeleccionado() {
		martin.setModalidad(estandar);
		for (int i = 0 ; i < 10; i++){
			partido.inscribirJugador(martin);
		}
		carlos.setModalidad(solidario);
		partido.inscribirJugador(carlos);
		partido.generarJugadores();
		assertFalse(partido.jugadores.contains(carlos));
	}
	
	@Test
	public void testHay10JugadoresCondicionalesSeAnotaCarlosEstandarYQuedaSeleccionado(){
		martin.setModalidad(condicional);
		for (int i = 0 ; i < 10; i++){
			partido.inscribirJugador(martin);
		}
		carlos.setModalidad(estandar);
		partido.inscribirJugador(carlos);
		partido.generarJugadores();
		assertTrue(partido.jugadores.contains(carlos));
	}
	
	@Test
	public void testHay10JugadoresCondicionalesSeAnotaCarlosSolidarioYQuedaSeleccionado(){
		martin.setModalidad(new Condicional() {
			@Override
			public boolean isPuedeJugar(Partido partido) {
				return true;
	    	}
		});
		for (int i = 0 ; i < 10; i++){
			partido.inscribirJugador(martin);
		}
		carlos.setModalidad(solidario);
		partido.inscribirJugador(carlos);
		partido.generarJugadores();
		assertTrue(partido.jugadores.contains(carlos));
	}
}

package com.grupo10.test;

import static org.junit.Assert.*;

import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.Test;

import com.grupo10.juego.Calificacion;
import com.grupo10.juego.Infraccion;
import com.grupo10.juego.Participante;
import com.grupo10.juego.Partido;
import com.grupo10.modalidades.*;
import com.grupo10.ui.*;

public class TestBusquedaJugadores {

	private Partido partido;
	private List<Participante> jugadores;
	
	private Calificacion calificacion3 = new Calificacion(3,"",partido);
	private Calificacion calificacion4 = new Calificacion(4,"",partido);
	private Calificacion calificacion6 = new Calificacion(6,"",partido);
	private Calificacion calificacion8 = new Calificacion(8,"",partido);
	private Calificacion calificacion9 = new Calificacion(9,"",partido);
	private Calificacion calificacion10 = new Calificacion(10,"",partido);
	
	private Infraccion infraccion1 = new Infraccion("Pelea con contrincante");
	private Infraccion infraccion2 = new Infraccion("Insulto al arbitro");
	private Infraccion infraccion3 = new Infraccion("Pelea con compañero");
	
	CriteriosBusqueda criterios = new CriteriosBusqueda();
	
	Participante martin = new Participante("Martin", "Tincho", new LocalDate(1985, 1, 1), 9, Arrays.asList(calificacion10,calificacion6,calificacion8,calificacion6), Arrays.asList(infraccion1), new Condicional(true));
	Participante oscar = new Participante("Oscar", "Osqui", new LocalDate(1988, 8, 10), 8, Arrays.asList(calificacion10,calificacion9,calificacion9), Arrays.asList(infraccion1), new Estandar());
	Participante franco = new Participante("Franco", "Pancho", new LocalDate(1987, 6, 21), 6, Arrays.asList(calificacion3,calificacion4), Arrays.asList(infraccion1, infraccion2, infraccion3), new Solidario());
	Participante fabian = new Participante("Fabian", "Fabi", new LocalDate(1986, 12, 30), 10, Arrays.asList(calificacion10,calificacion10), Arrays.asList(), new Condicional(false));

	@Before
	public void setUp() throws Exception {
		jugadores = new ArrayList<>();
		jugadores.add(martin);
		jugadores.add(oscar);
		jugadores.add(franco);
		jugadores.add(fabian);
	}
	
	@Test
	public void testNombreDeFrancoComienzaConLaLetraF(){
		criterios.nombre = "f";
		assertTrue(criterios.nombreComienzaCon(franco));	
	}
	
	@Test
	public void testNombreDeFrancoNoComienzaConLaLetraP(){
		criterios.nombre = "p";
		assertFalse(criterios.nombreComienzaCon(franco));	
	}
	
	@Test
	public void testApodoDeFrancoContieneLasLetrasNC(){
		criterios.apodo = "nc";
		assertTrue(criterios.apodoContiene(franco));	
	}
	
	@Test
	public void testApodoDeFrancoNoContieneLasLetrasNO(){
		criterios.apodo = "no";
		assertFalse(criterios.apodoContiene(franco));	
	}
	
	@Test
	public void testFrancoTieneFechaDeNacimientoMenorA1990(){
		criterios.fecha = "1990-02-01";
		assertTrue(criterios.fechaEsMenorA(criterios.fecha, franco.fechaNacimiento));	
	}
	
	@Test
	public void testMartinYFabianYOscarTienenHandicapEntre8Y10(){
		criterios.handicapDesde = 8;
		criterios.handicapHasta = 10;
		assertTrue(criterios.searchJugadores(jugadores).containsAll(Arrays.asList(martin, fabian, oscar)));	
	}
	
	@Test
	public void testOscarNoTienePromedioEntre3Y8(){
		criterios.promedioDesde = 3;
		criterios.promedioHasta = 8;
		assertFalse(criterios.searchJugadores(jugadores).contains(oscar));	
	}
	
	@Test
	public void testMartinOscarYFrancoTienenInfracciones(){
		criterios.tieneInfracciones = true;
		assertTrue(criterios.searchJugadores(jugadores).containsAll(Arrays.asList(martin, oscar, franco)));	
	}
	
	@Test
	public void testMartinComienzaConMTieneInfraccionesYSuApodoContieneLasLetrasCH(){
		criterios.nombre = "m";
		criterios.tieneInfracciones = true;
		criterios.apodo = "cH";
		assertTrue(criterios.searchJugadores(jugadores).contains(martin));	
	}
	
	@Test
	public void testOscarTieneInfraccionesSuNombreComienzaConOPeroSuApodoNoContieneLasLetrasAS(){
		criterios.tieneInfracciones = true;
		criterios.nombre = "o";
		criterios.apodo = "as";
		assertFalse(criterios.searchJugadores(jugadores).contains(oscar));	
	}
}

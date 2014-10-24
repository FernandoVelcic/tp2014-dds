package com.grupo10.test;

import static org.junit.Assert.*;

import org.joda.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import com.grupo10.criteriosdivisionequipos.*;
import com.grupo10.criteriosordenequipos.*;
import com.grupo10.juego.Administrador;
import com.grupo10.juego.Calificacion;
import com.grupo10.juego.Participante;
import com.grupo10.juego.Partido;
import com.grupo10.modalidades.Estandar;

public class TestEquipos{

	Calificaciones criterioCalif;
	Ncalificaciones criterioNcalif;
	Handicap criterioHandicap;
	MixCriterios criterioMix;	
	
	Participante martin;
	Participante carlos;
	Participante tomas;
	Participante juan;
	Participante mariano;
	Participante facundo;
	Participante federico;
	Participante german;
	Participante diego;
	Participante jose;
	
	Administrador admin;
	Partido partido;
	
	Calificacion calificacion1;
	Calificacion calificacion2;
	Calificacion calificacion3;
	Calificacion calificacion4;
	Calificacion calificacion5;
	Calificacion calificacion6;
	Calificacion calificacion7;
	Calificacion calificacion8;
	Calificacion calificacion9;
	Calificacion calificacion10;

	ParImpar parImpar;
	TresUno tresUno;
	
	@Before
	public void setUp() throws Exception {
		
		martin = new Participante();
		carlos = new Participante();
		tomas = new Participante();
		juan = new Participante();
		mariano = new Participante();
		facundo = new Participante();
		federico = new Participante();
		german = new Participante();
		diego = new Participante();
		jose = new Participante();
		
		admin = new Administrador();
		partido = new Partido(LocalDate.now(), admin);
		
		martin.setModalidad(new Estandar());
		carlos.setModalidad(new Estandar());
		tomas.setModalidad(new Estandar());
		juan.setModalidad(new Estandar());
		mariano.setModalidad(new Estandar());
		facundo.setModalidad(new Estandar());
		federico.setModalidad(new Estandar());
		german.setModalidad(new Estandar());
		diego.setModalidad(new Estandar());
		jose.setModalidad(new Estandar());

		partido.inscribirJugador(martin);
		partido.inscribirJugador(carlos);
		partido.inscribirJugador(tomas);
		partido.inscribirJugador(juan);
		partido.inscribirJugador(mariano);
		partido.inscribirJugador(facundo);
		partido.inscribirJugador(federico);
		partido.inscribirJugador(german);
		partido.inscribirJugador(diego);
		partido.inscribirJugador(jose);
		partido.generarJugadores();
		
		calificacion1 = new Calificacion(1,"",partido);
		calificacion2 = new Calificacion(2,"",partido);
		calificacion3 = new Calificacion(3,"",partido);
		calificacion4 = new Calificacion(4,"",partido);
		calificacion5 = new Calificacion(5,"",partido);
		calificacion6 = new Calificacion(6,"",partido);
		calificacion7 = new Calificacion(7,"",partido);
		calificacion8 = new Calificacion(8,"",partido);
		calificacion9 = new Calificacion(9,"",partido);
		calificacion10 = new Calificacion(10,"",partido);
		
		martin.calificaciones = new ArrayList<Calificacion>(Arrays.asList(calificacion10,calificacion6,calificacion8,calificacion6));
		carlos.calificaciones = new ArrayList<Calificacion>(Arrays.asList(calificacion1,calificacion4,calificacion6));
		tomas.calificaciones = new ArrayList<Calificacion>(Arrays.asList(calificacion4,calificacion8));
		juan.calificaciones = new ArrayList<Calificacion>(Arrays.asList(calificacion10,calificacion8,calificacion10,calificacion6,calificacion8));
		mariano.calificaciones = new ArrayList<Calificacion>(Arrays.asList(calificacion5));
		facundo.calificaciones = new ArrayList<Calificacion>(Arrays.asList(calificacion4,calificacion5));
		federico.calificaciones = new ArrayList<Calificacion>(Arrays.asList(calificacion4));
		german.calificaciones = new ArrayList<Calificacion>(Arrays.asList(calificacion10,calificacion4));
		diego.calificaciones = new ArrayList<Calificacion>(Arrays.asList(calificacion1,calificacion3,calificacion4));
		jose.calificaciones = new ArrayList<Calificacion>(Arrays.asList(calificacion3));

		admin.definirHandicap(martin, 5);
		admin.definirHandicap(carlos, 6);
		admin.definirHandicap(tomas, 7);
		admin.definirHandicap(juan, 2);
		admin.definirHandicap(mariano, 10);
		admin.definirHandicap(facundo, 4);
		admin.definirHandicap(federico, 8);
		admin.definirHandicap(german, 9);
		admin.definirHandicap(diego, 1);
		admin.definirHandicap(jose, 3);
		
		criterioCalif = new Calificaciones();
		criterioNcalif = new Ncalificaciones(3);
		criterioHandicap = new Handicap();
		criterioMix = new MixCriterios();
		
		criterioMix.add(criterioCalif);
		criterioMix.add(criterioNcalif);
		
		parImpar = new ParImpar();
		tresUno = new TresUno();
	}

	@Test
	public void testSeOrdenanLosJugadoresPorElPromedioDelUltimoPartidoYseDividenParesEimpares() {
		admin.generarEquiposTentativos(criterioCalif, parImpar);
		assertTrue(partido.equipo1.containsAll(Arrays.asList(martin, tomas, facundo, carlos, diego)));
		assertTrue(partido.equipo2.containsAll(Arrays.asList(juan, german, mariano, federico, jose)));
	}
	
	@Test
	public void testSeOrdenanLosJugadoresPorLasUltimas3CalificacionesYseDividenParesEimpares() {
		admin.generarEquiposTentativos(criterioNcalif, parImpar);
		assertTrue(partido.equipo1.containsAll(Arrays.asList(german, tomas, facundo, carlos, diego)));
		assertTrue(partido.equipo2.containsAll(Arrays.asList(juan, martin, mariano, federico, jose)));
	}
	
	@Test
	public void testSeOrdenanLosJugadoresPorHandicapYseDividenParesEimpares() {
		admin.generarEquiposTentativos(criterioHandicap, parImpar);
		assertTrue(partido.equipo1.containsAll(Arrays.asList(german, tomas, martin, jose, diego)));
		assertTrue(partido.equipo2.containsAll(Arrays.asList(mariano, federico, carlos, facundo, juan)));
	}

	@Test
	public void testSeOrdenanLosJugadoresPorMixUltimoPartidoY3UltimasCalificacionesYseDividenParesEimpares() {
		admin.generarEquiposTentativos(criterioMix, parImpar);
		assertTrue(partido.equipo1.containsAll(Arrays.asList(martin, tomas, facundo, carlos, diego)));
		assertTrue(partido.equipo2.containsAll(Arrays.asList(juan, german, mariano, federico, jose)));
	}
	
	@Test
	public void testSeOrdenanLosJugadoresPorElPromedioDelUltimoPartidoYseDividenConTresUno() {
		admin.generarEquiposTentativos(criterioCalif, tresUno);
		assertTrue(partido.equipo1.containsAll(Arrays.asList(martin, german, facundo, federico, diego)));
		assertTrue(partido.equipo2.containsAll(Arrays.asList(juan, tomas, mariano, carlos, jose)));
	}	
}

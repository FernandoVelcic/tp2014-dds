package com.grupo10.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.grupo10.criterios.*;
import com.grupo10.juego.Calificacion;
import com.grupo10.juego.Participante;
import com.grupo10.juego.Partido;

import static org.mockito.Mockito.*;


public class TestCriterios {
	Calificaciones criterioCalif;
	Ncalificaciones criterioNcalif;
	Handicap criterioHandicap;
	MixCriterios criterioMix;	
	
	Participante participanteNulo;
	Participante participante1;
	

	@Before
	public void setUp() throws Exception {
		criterioCalif = new Calificaciones();
		criterioHandicap = new Handicap();
		criterioMix = new MixCriterios();
		
		participanteNulo = mock(Participante.class);
		when(participanteNulo.getCalificaciones()).thenReturn(new ArrayList<Calificacion>());
		
		participante1 = mock(Participante.class);
		Partido partido1 = null;
		List<Calificacion> lista1 = new ArrayList<Calificacion>();
		lista1.add(new Calificacion(7, "Jugó bien pero le faltó correr más", partido1));
		lista1.add(new Calificacion(10, "Jugó bien pero le faltó correr más", partido1));
		lista1.add(new Calificacion(5, "Jugó bien pero le faltó correr más", partido1));
		lista1.add(new Calificacion(2, "Jugó bien pero le faltó correr más", partido1));
		lista1.add(new Calificacion(7, "Jugó bien pero le faltó correr más", partido1));
		lista1.add(new Calificacion(6, "Jugó bien pero le faltó correr más", partido1));
		lista1.add(new Calificacion(7, "Jugó bien pero le faltó correr más", partido1));
		
		when(participante1.getCalificaciones()).thenReturn(lista1);
		
	}

	@Test
	public void testListNullCalificaciones() throws Exception{
		double valor = criterioCalif.calcularValor(participanteNulo);
		assertEquals(0,valor,0.1);
	}
	
	@Test
	public void testListNullNcalificaciones() throws Exception{
		criterioNcalif = new Ncalificaciones(2);
		double valor = criterioNcalif.calcularValor(participanteNulo);
		assertEquals(0,valor,0.1);
	}
	
	@Test
	public void testListNullMixCriterios() throws Exception{
		criterioMix.add(criterioCalif);
		criterioMix.add(new Ncalificaciones(3));
		double valor = criterioMix.calcularValor(participanteNulo);
		assertEquals(0,valor,0.1);
	}
	
	@Test
	public void testNCalificacionesCon3()
	{
		criterioNcalif = new Ncalificaciones(3);
		double valor = criterioNcalif.calcularValor(participante1);
		assertEquals(6.6,valor,0.1);
	}

}

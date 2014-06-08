package com.grupo10.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.grupo10.criterios.*;
import com.grupo10.juego.Calificacion;
import com.grupo10.juego.Participante;

import static org.mockito.Mockito.*;


public class TestCriterios {
	Calificaciones criterioCalif;
	Ncalificaciones criterioNcalif;
	Handicap criterioHandicap;
	MixCriterios criterioMix;	
	
	Participante participanteNulo;
	

	@Before
	public void setUp() throws Exception {
		criterioCalif = new Calificaciones();
		criterioHandicap = new Handicap();
		criterioMix = new MixCriterios();
		
		participanteNulo = mock(Participante.class);
		when(participanteNulo.getCalificaciones()).thenReturn(new ArrayList<Calificacion>());
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
	

}

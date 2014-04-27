package com.disenodesistemas.tp3.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import com.disenodesistemas.tp3.*;
import com.disenodesistemas.tp3.criterios.*;

public class TestParcial{
	
	NPuntos nPuntos;
	Regla3Simple regla3Simple;
	ConversionPorPuntos conversionPorPuntos;
	
	Parcial parcial;
		
	//Seteamos el parcial con sumaPreguntasCorrectas igual a 10 y sumaPreguntasTotales igual a 12 
	@Before
	public void setUp() throws Exception {
		
		parcial = mock(Parcial.class);
		
		when(parcial.sumaPreguntasCorrectas()).thenReturn(10);
		when(parcial.sumaPreguntasTotales()).thenReturn(12);
	}
	
	// Tests con criterio N Puntos
	@Test
	public void testParcialNPuntosCon10PreguntasCorrectasY12PreguntasTotalesConNigualA2Es8() {
		nPuntos = new NPuntos(2);
		Assert.assertEquals((double) 10 - 2, nPuntos.calcularNota(parcial),0.1);
	}
	@Test
	public void testParcialNPuntosCon10PreguntasCorrectasY12PreguntasTotalesConNigualA0Es10() {
		nPuntos = new NPuntos(0);
		Assert.assertEquals((double) 10 - 0, nPuntos.calcularNota(parcial),0.1);
	}
	@Test
	public void testParcialNPuntosCon10PreguntasCorrectasY12PreguntasTotalesConNigualA11EsMenos1() {
		nPuntos = new NPuntos(11);
		Assert.assertEquals((double) 10 - 11, nPuntos.calcularNota(parcial),0.1);
	}
	
	//Tests con criterio Regla de 3 simple
	@Test
	public void testRegla3SimpleCon10PreguntasCorrectasY12PreguntasTotalesEs8coma33() {
		regla3Simple = new Regla3Simple();
		Assert.assertEquals(8.33, regla3Simple.calcularNota(parcial), 0.1);
	}
	@Test
	public void testRegla3SimpleCon0PreguntasCorrectasY10PreguntasTotalesEs0() {
		regla3Simple = new Regla3Simple();
		when(parcial.sumaPreguntasCorrectas()).thenReturn(0);
		when(parcial.sumaPreguntasTotales()).thenReturn(10);
		Assert.assertEquals(0, regla3Simple.calcularNota(parcial), 0.1);
	}
	@Test
	public void testRegla3SimpleCon0PreguntasCorrectasY0PreguntasTotalesEs0() {
		regla3Simple = new Regla3Simple();
		when(parcial.sumaPreguntasCorrectas()).thenReturn(0);
		when(parcial.sumaPreguntasTotales()).thenReturn(0);
		Assert.assertEquals(0, regla3Simple.calcularNota(parcial), 0.1);
	}
	
	//Tests con criterio Conversion por puntos
	@Test
	public void testConversionPorPuntosCon0PregutnasCorrectasEs0(){
		cpp = new ConversionPorPuntos();
		when(parcial.sumaPreguntasCorrectas()).thenReturn(0);
		Assert.assertEquals(0, cpp.calcularNota(parcial),0.1);
		
	}
	@Test
	public void testConversionPorPuntosCon15PreguntasCorrectasEs10(){
		cpp = new ConversionPorPuntos();
		when(parcial.sumaPreguntasCorrectas()).thenReturn(15);
		Assert.assertEquals(10, cpp.calcularNota(parcial),0.1);
		
	}
	@Test
	public void testConversionPorPuntosCon5PreguntasCorrectasEs5(){
		cpp = new ConversionPorPuntos();
		when(parcial.sumaPreguntasCorrectas()).thenReturn(5);
		Assert.assertEquals(2, cpp.calcularNota(parcial),0.1);
		
	}
	
	
	
}

package com.disenodesistemas.tp3.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import com.disenodesistemas.tp3.*;
import com.disenodesistemas.tp3.criterios.*;

public class TestParcial{
	
	NPuntos np;
	Regla3Simple r3s;
	ConversionPorPuntos cpp;
	
	Parcial p;
		

	@Before
	public void setUp() throws Exception {
		
		p = mock(Parcial.class);
		
		when(p.sumaPreguntasCorrectas()).thenReturn(10);
		when(p.sumaPreguntasTotales()).thenReturn(12);
	}
	
	//Con N Puntos
	@Test
	public void testNPuntosCon2() {
		np = new NPuntos(2);
		Assert.assertEquals((double) 10 - 2, np.calcularNota(p),0.1);
	}
	@Test
	public void testNPuntosCon0() {
		np = new NPuntos(0);
		Assert.assertEquals((double) 10 - 0, np.calcularNota(p),0.1);
	}
	@Test
	public void testNPuntosCon11() {
		np = new NPuntos(11);
		Assert.assertEquals((double) 10 - 11, np.calcularNota(p),0.1);
	}
	
	//Regla de 3 simple
	@Test
	public void testRegla3SimpleCorr10Tot12() {
		r3s = new Regla3Simple();
		Assert.assertEquals(8.33, r3s.calcularNota(p), 0.1);
	}
	@Test
	public void testRegla3SimpleCorr0Tot10() {
		r3s = new Regla3Simple();
		when(p.sumaPreguntasCorrectas()).thenReturn(0);
		when(p.sumaPreguntasTotales()).thenReturn(10);
		Assert.assertEquals(0, r3s.calcularNota(p), 0.1);
	}
	@Test
	public void testRegla3SimpleCorr0Tot0() {
		r3s = new Regla3Simple();
		when(p.sumaPreguntasCorrectas()).thenReturn(0);
		when(p.sumaPreguntasTotales()).thenReturn(0);
		Assert.assertEquals(0, r3s.calcularNota(p), 0.1);
	}
	
	//Conversion por puntos
	@Test
	public void testConversionPorPuntos0(){
		cpp = new ConversionPorPuntos();
		when(p.sumaPreguntasCorrectas()).thenReturn(0);
		Assert.assertEquals(0, cpp.calcularNota(p),0.1);
		
	}
	@Test
	public void testConversionPorPuntos15(){
		cpp = new ConversionPorPuntos();
		when(p.sumaPreguntasCorrectas()).thenReturn(15);
		Assert.assertEquals(10, cpp.calcularNota(p),0.1);
		
	}
	@Test
	public void testConversionPorPuntos5(){
		cpp = new ConversionPorPuntos();
		when(p.sumaPreguntasCorrectas()).thenReturn(5);
		Assert.assertEquals(2, cpp.calcularNota(p),0.1);
		
	}
	
	
	
}

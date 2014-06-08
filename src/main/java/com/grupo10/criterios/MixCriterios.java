package com.grupo10.criterios;

import java.util.ArrayList;
import java.util.List;
import com.grupo10.juego.Participante;

public class MixCriterios implements Criterio 
{

	private List<Criterio> mix = new ArrayList<Criterio>();

	public void add(Criterio c)
	{
		mix.add(c);
	}
	
	public double calcularValor(Participante p) 
	{
		return mix.stream().mapToDouble(c -> c.calcularValor(p)).average().getAsDouble();		
	}
	
	
}

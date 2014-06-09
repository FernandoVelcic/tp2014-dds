package com.grupo10.criteriosordenequipos;

import java.util.ArrayList;
import java.util.List;
import com.grupo10.juego.Participante;

public class MixCriterios implements CriterioOrden 
{

	private List<CriterioOrden> mix = new ArrayList<CriterioOrden>();

	public void add(CriterioOrden c)
	{
		mix.add(c);
	}
	
	public double calcularValor(Participante p) 
	{
		return mix.stream().mapToDouble(c -> c.calcularValor(p)).average().getAsDouble();		
	}
	
	
}

package com.grupo10.criterios;

import java.util.ArrayList;
import java.util.List;
import com.grupo10.juego.Participante;

public class MixCriterios implements Criterio 
{

	public List<Criterio> mix = new ArrayList<Criterio>();

	public void agregarAlMixDeCriterios(Criterio c)
	{
		mix.add(c);
	}
	
	public double calcularValor(Participante p)
	{
		
		double sumaTotalResultadoCriterios = mix.stream()
				.mapToDouble(criterio -> criterio.calcularValor(p))
				.sum();
		
		return  sumaTotalResultadoCriterios / mix.size();
	}
	
}

package com.disenodesistemas.tp3.criterios;

import java.util.Collection;
import java.util.Iterator;
import java.util.stream.*;

import com.disenodesistemas.tp3.Parcial;
import com.disenodesistemas.tp3.TipoCalculoNota;

public class CriteriosPorPromedio implements TipoCalculoNota{

	public Collection <TipoCalculoNota> tipoCalculoNota;
	
	public CriteriosPorPromedio(Collection <TipoCalculoNota> tipoCalculoNota)
	{
		this.tipoCalculoNota = tipoCalculoNota;
	}
	
	@Override
	public float calcularNota(Parcial parcial) 
	{
		float suma = 0;
		float size = tipoCalculoNota.stream().map(tipo -> tipo.calcularNota(parcial)).collect(Collectors.toList()).size();
		Iterator <TipoCalculoNota> it = tipoCalculoNota.iterator();
		while (it.hasNext())
		{
			TipoCalculoNota tpc = it.next();
			suma = suma + tpc.calcularNota(parcial);
		}
		return suma / size;
	}
}

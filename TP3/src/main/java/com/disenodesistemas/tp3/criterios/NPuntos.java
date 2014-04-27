package com.disenodesistemas.tp3.criterios;

import com.disenodesistemas.tp3.Parcial;
import com.disenodesistemas.tp3.TipoCalculoNota;

public class NPuntos implements TipoCalculoNota {

	private int n;
	
	public NPuntos(int n)
	{
		this.n = n;
	}
	
	@Override
	public float calcularNota(Parcial parcial)
	{
		return (parcial.sumaPreguntasCorrectas() - n);
	}
}

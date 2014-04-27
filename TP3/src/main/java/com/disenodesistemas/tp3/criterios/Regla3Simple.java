package com.disenodesistemas.tp3.criterios;

import com.disenodesistemas.tp3.Parcial;
import com.disenodesistemas.tp3.TipoCalculoNota;

public class Regla3Simple implements TipoCalculoNota {

	@Override
	public float calcularNota(Parcial parcial) 
	{
		if(parcial.sumaPreguntasTotales() == 0) return 0;
		
		return ((float)parcial.sumaPreguntasCorrectas() * 10 / (float)parcial.sumaPreguntasTotales());
	}

	
}

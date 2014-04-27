package com.disenodesistemas.tp3.criterios;

import com.disenodesistemas.tp3.Parcial;
import com.disenodesistemas.tp3.TipoCalculoNota;

public class ConversionPorPuntos implements TipoCalculoNota {

	@Override
	public float calcularNota(Parcial parcial) 
	{
		switch (parcial.sumaPreguntasCorrectas())
		{
		case 16: case 15: return 10;
		case 14: case 13: return 9;
		case 12: return 8;
		case 11: return 7;
		case 10: return 6;
		case 9: return 5;
		case 8: return 4;
		case 7: case 6: case 5: case 4: case 3: return 2;
		case 2: case 1: return 1;
		default: break;
		}
		return 0;
	}
	

}

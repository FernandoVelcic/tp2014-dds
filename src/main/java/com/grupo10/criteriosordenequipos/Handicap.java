package com.grupo10.criteriosordenequipos;

import com.grupo10.juego.Participante;

public class Handicap implements CriterioOrden{
		
	public double calcularValor(Participante p)
	{
		return p.handicap;
	}
}
package com.grupo10.criterios;

import com.grupo10.juego.Participante;

public class Handicap implements Criterio{
	
	
	public double calcularValor(Participante p)
	{
		return p.handicup;
	}
}


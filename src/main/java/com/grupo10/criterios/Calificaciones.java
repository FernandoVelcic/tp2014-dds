package com.grupo10.criterios;

import com.grupo10.juego.Participante;

public class Calificaciones implements Criterio
{

	public double calcularValor(Participante p)
	{
		return p.getCalificaciones().stream()
				.filter(c -> c.partidoJugado == p.getPartidoActual())
				.mapToDouble(c -> c.puntaje)
				.average().orElse(0);
	}	
}

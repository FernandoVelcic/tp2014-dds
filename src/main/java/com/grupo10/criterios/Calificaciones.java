package com.grupo10.criterios;

import java.util.OptionalDouble;

import com.grupo10.juego.Participante;

public class Calificaciones implements Criterio
{

	public double calcularValor(Participante p)
	{
		OptionalDouble promedio = p.getCalificaciones().stream()
				.filter(c -> c.partidoJugado == p.getPartidoActual())
				.mapToDouble(c -> c.puntaje)
				.average();		
		
		if( !promedio.isPresent() )	return 0;

		return promedio.getAsDouble();
	}
	
	
}

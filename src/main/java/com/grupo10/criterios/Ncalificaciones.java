package com.grupo10.criterios;

import java.util.OptionalDouble;

import com.grupo10.juego.Participante;

public class Ncalificaciones implements Criterio{

	private int n;
	public Ncalificaciones(int numero)
	{
		n = numero;
	}
	
	public double calcularValor(Participante p)
	{
		try{
			OptionalDouble promedio = p.getCalificaciones().stream()
				.skip(p.getCalificaciones().size()-n)
				.mapToDouble(c -> c.puntaje).average();	
		
			if( !promedio.isPresent() )	return 0;
			return promedio.getAsDouble();
		}
		catch(Exception e)
		{
			return 0;
		}
		
	}
}

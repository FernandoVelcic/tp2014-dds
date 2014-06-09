package com.grupo10.criterios;

import java.util.Collections;
import java.util.List;

import com.grupo10.juego.Calificacion;
import com.grupo10.juego.Participante;

public class Ncalificaciones implements Criterio{

	private int n;
	public Ncalificaciones(int numero)
	{
		n = numero;
	}
	
	public double calcularValor(Participante p)
	{
		List<Calificacion> lista = p.getCalificaciones();
		Collections.reverse(lista);
		
		if(n>lista.size())	return lista.stream().mapToDouble(c -> c.puntaje).sum()/n;
		
		return lista.stream().limit(n).mapToDouble(c -> c.puntaje).average().orElse(0);
	}
}

package com.grupo10.criteriosordenequipos;

import java.util.Collections;
import java.util.List;

import com.grupo10.juego.Calificacion;
import com.grupo10.juego.Participante;

public class Ncalificaciones implements CriterioOrden{

	private int n;
	public Ncalificaciones(int numero)
	{
		n = numero;
	}
	
	public double calcularValor(Participante p)
	{
		List<Calificacion> lista = p.getCalificaciones();
		Collections.reverse(lista);		
		return lista.stream().limit(n).mapToDouble(c -> c.puntaje).average().orElse(0);
	}
}

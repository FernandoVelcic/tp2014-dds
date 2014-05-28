package com.grupo10;

public class Calificacion {
	public int puntaje;
	public String critica;
	public Partido partidoJugado;
	
	public Calificacion(int p, String c, Partido part)
	{
		puntaje = p;
		critica = c;
		partidoJugado = part;
	}
	
}

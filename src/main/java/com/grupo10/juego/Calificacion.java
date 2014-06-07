package com.grupo10.juego;

public class Calificacion {
	public int puntaje;
	public String critica;
	public Partido partidoJugado;
	
	public Calificacion(int puntaje, String critica, Partido partido)
	{
		this.puntaje = puntaje;
		this.critica = critica;
		this.partidoJugado = partido;
	}
	
}

package com.grupo10.juego;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Calificacion {
	@Id @GeneratedValue
	private Long id;
	
	public int puntaje;
	public String critica;
	@ManyToOne
	public Partido partidoJugado;
	
	public Calificacion(int puntaje, String critica, Partido partido)
	{
		this.puntaje = puntaje;
		this.critica = critica;
		this.partidoJugado = partido;
	}
	
}

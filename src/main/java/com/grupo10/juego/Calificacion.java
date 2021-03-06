package com.grupo10.juego;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;

@Entity
public class Calificacion extends PersistentEntity {
	
	public int puntaje;
	public String critica;
	@ManyToOne (cascade = {CascadeType.ALL})
	public Partido partidoJugado;
	
	public Calificacion(int puntaje, String critica, Partido partido)
	{
		this.puntaje = puntaje;
		this.critica = critica;
		this.partidoJugado = partido;
	}
	
}

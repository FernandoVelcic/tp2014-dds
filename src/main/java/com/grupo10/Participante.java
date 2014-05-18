package com.grupo10;

import Modalidades.*;

public class Participante {
	Jugador jugador;
	Modalidad modalidad;
	
	public Participante(Jugador jugador, Modalidad modalidad) {
		this.jugador = jugador;
		this.modalidad = modalidad;
		jugador.participante = this;
	}

	public int getPrioridadModalidad() {
		return modalidad.getPrioridad();
	}
	
	public boolean getPuedeJugar(Partido partido) {
		return modalidad.isPuedeJugar(partido);
	}
	
	public Jugador getJugador()
	{
		return jugador;
	}
}

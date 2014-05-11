package com.grupo10;

import Modalidades.*;

public class Participante {
	Jugador jugador;
	Modalidad modalidad;
	
	public Participante(Jugador jugador, Modalidad modalidad) {
		this.jugador = jugador;
		this.modalidad = modalidad;
	}

	public int getPrioridadModalidad() {
		return modalidad.getPrioridad();
	}
}
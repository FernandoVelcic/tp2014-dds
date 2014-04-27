package com.grupo10;

import com.grupo10.Modalidad.Modalidad;

public class Participante {
	Jugador jugador;
	Modalidad modalidad;
	
	public Participante(Jugador jugador, Modalidad modalidad) {
		this.jugador = jugador;
		this.modalidad = modalidad;
	}
	
	public boolean isConfirmado() {
		return modalidad.isConfirmado();
	}
}

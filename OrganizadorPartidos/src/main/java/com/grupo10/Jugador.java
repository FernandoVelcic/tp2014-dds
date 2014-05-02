package com.grupo10;

import Modalidades.*;

public class Jugador {
	int prioridad;
	int nivel;
	
	public boolean InscribirmeAPartido(Partido partido, Modalidad modalidad) {
		return partido.inscribirJugador(this, modalidad);
	}
}

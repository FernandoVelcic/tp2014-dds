package com.grupo10.ui;

import org.uqbar.commons.utils.Observable;

import com.grupo10.juego.Participante;

@Observable
public class JugadorViewModel {
	Participante jugador;
	
	public JugadorViewModel(Participante jugador) {
		this.jugador = jugador;
	}
	
	public String getNombre() {
		return jugador.getNombre();
	}
	
	public String getApodo() {
		return jugador.getApodo();
	}
}

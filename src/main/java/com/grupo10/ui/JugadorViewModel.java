package com.grupo10.ui;

import java.text.SimpleDateFormat;

import org.uqbar.commons.utils.Observable;

import com.grupo10.juego.Participante;

@Observable
public class JugadorViewModel {
	Participante jugador;
	
	public JugadorViewModel(Participante jugador) {
		this.jugador = jugador;
	}
	
	public Participante getJugador() {
		return jugador;
	}
	
	public String getFechaNacimiento() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(jugador.getFechaNacimiento());
	}
}

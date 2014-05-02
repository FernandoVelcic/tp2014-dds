package com.grupo10;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Partido {
	List<Participante> participantes = new ArrayList<Participante>();
	Date diaYhora;
	
	public Partido(Date diaYhora) {
		this.diaYhora = diaYhora;
	}

	public boolean inscribirJugadorEstandar(Jugador jugador) {
		participantes.add(new Participante(jugador, 1));
		return true;
	}

	public boolean inscribirJugadorCondicional(Jugador jugador) {
		participantes.add(new Participante(jugador, 2));
		return true;
	}
	
	public boolean inscribirJugadorSolidario(Jugador jugador) {
		participantes.add(new Participante(jugador, 3));
		return true;
	}
	
	/*
	public Stream<Participante> obtenerConfirmados() {
		return participantes.stream().filter(p -> p.isConfirmado());
	}

	public int calcularConfirmados() {
		return (int) obtenerConfirmados().count();
	}*/

}

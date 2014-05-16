package com.grupo10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Modalidades.*;

public class Partido {
	private List<Participante> participantes = new ArrayList<Participante>();
	private List<Participante> jugadores = new ArrayList<Participante>();
	private Date diaYhora;
	private Administrador admin;

	public Partido(Date diaYhora, Administrador admin) {
		this.diaYhora = diaYhora;
		this.admin = admin;
	}

	public boolean inscribirJugador(Jugador jugador, Modalidad modalidad) {
		if (calcularConfirmados() >= 10) {
			admin.notificarPartidoConfirmado();
			return false;
		}

		participantes.add(new Participante(jugador, modalidad));

		return true;
	}
	
	public void darBajaJugador(Jugador jugador) {
		jugadores.removeIf(p -> p.getJugador() == jugador);
		jugador.hacerInfraccion("Por no asistir al partido ni proponer un reemplazo");
		admin.notificarFaltanJugadores();
	}
	
	public void darBajaJugador(Jugador jugador, Jugador reemplazo) {
		jugadores.removeIf(p -> p.getJugador() == jugador);
		jugadores.add(new Participante(reemplazo, new Estandar()));
	}

	public void GenerarJugadores() {
		ordenarPorModalidad();
		
		jugadores = quienesPueden().collect(Collectors.toList());
		
		if(jugadores.size() >= 10) {
			jugadores = participantes.subList(0, 10);
		} else {
			jugadores = participantes.subList(0, jugadores.size());
			
			for(int i = jugadores.size(); i <= 10 && obtenerSolidarios().count() > 0; i++)
				jugadores.add(obtenerSolidarios().findFirst().get());
		}
		
		admin.notificarPartidoConfirmado();
	}

	private Stream<Participante> quienesPueden() {
		return participantes.stream().filter(p -> p.getPuedeJugar(this));
	}
	
	public Integer calcularConfirmados() {
		return (int) obtenerConfirmados().count();
	}

	private Stream<Participante> obtenerConfirmados() {
		return participantes.stream().filter(p -> p.getPrioridadModalidad() == Prioridad.ESTANDAR.ordinal());
	}
	
	private Stream<Participante> obtenerSolidarios() {
		return participantes.stream().filter(p -> p.getPrioridadModalidad() == Prioridad.SOLIDARIO.ordinal());
	}
	
	private void ordenarPorModalidad()
	{
		participantes = participantes.stream().sorted((p1,p2) -> Integer.compare(p1.getPrioridadModalidad(), p2.getPrioridadModalidad())).collect(Collectors.toList());
	}
}

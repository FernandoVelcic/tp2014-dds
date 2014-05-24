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
	public List<Participante> participantes = new ArrayList<Participante>();
	public List<Participante> jugadores = new ArrayList<Participante>();
	private List<Observador> observadores = new ArrayList<Observador>();
	private Date diaYhora;

	public Partido(Date diaYhora, Administrador admin) {
		this.diaYhora = diaYhora;
		addObservador(admin);
	}

	public boolean inscribirJugador(Participante jugador) {
		if( isPartidoConfirmadoYnotificar() )
			return false;

		participantes.add(jugador);
		jugador.notificarAamigos();
		
		return true;
	}
	
	private void removeJugador(Participante jugador)
	{
		jugadores.removeIf(p -> p == jugador);
	}
	
	public void darBajaJugador(Participante jugador) {
		removeJugador(jugador);
		jugador.hacerInfraccion("Por no asistir al partido ni proponer un reemplazo");
		observadores.forEach(o -> o.notificarFaltanJugadores());
	}
	
	public void darBajaJugadorYreemplazar(Participante jugador, Participante reemplazo) {
		removeJugador(jugador);
		reemplazo.setModalidad(jugador.modalidad);
		jugadores.add(reemplazo);
	}

	public void generarJugadores() {
		jugadores = participantes.stream()
			.filter(p -> p.getPuedeJugar(this))
			.sorted((p1,p2) -> Integer.compare(p1.getPrioridadModalidad(), p2.getPrioridadModalidad()))
			.limit(10)
			.collect(Collectors.toList());
		
		isPartidoConfirmadoYnotificar();
	}
	
	public boolean isPartidoConfirmadoYnotificar()
	{
		if( jugadores.size() != 10 )
			return false;
		
		observadores.forEach(o -> o.notificarPartidoConfirmado());
		
		return true;
	}
	
	public Integer calcularConfirmados() {
		return (int) obtenerConfirmados().count();
	}

	private Stream<Participante> obtenerConfirmados() {
		return participantes.stream().filter(p -> p.getPrioridadModalidad() == Prioridad.ESTANDAR.ordinal());
	}
	
	public void addObservador(Observador obs)
	{
		observadores.add(obs);
	}
}

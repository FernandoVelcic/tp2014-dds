package com.grupo10;

import java.util.ArrayList;
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
		admin.setPartido(this);
	}

	public void inscribirJugador(Participante participante) {
		participantes.add(participante);
		participante.notificarAamigos();
	}
	
	private void removeJugador(Participante participante){
		jugadores.remove(participante);
		participantes.remove(participante);
	}
	
	public void darBajaJugador(Participante participante) {
		removeJugador(participante);
		participante.hacerInfraccion("Por no asistir al partido ni proponer un reemplazo");
		observadores.forEach(observador -> observador.notificarFaltanJugadores());
	}
	
	public void darBajaJugadorYProponerReemplazo(Participante participante, Participante reemplazo) {
		removeJugador(participante);
		reemplazo.setModalidad(participante.modalidad);
		participantes.add(reemplazo);
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
		if(jugadores.size() != 10)
			return false;
		
		observadores.forEach(observador -> observador.notificarPartidoConfirmado());
		
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

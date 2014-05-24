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
	public List<Participante> propuestas = new ArrayList<Participante>();
	
	private List<Observador> observadores = new ArrayList<Observador>();
	private Date diaYhora;

	public Partido(Date diaYhora, Administrador admin) {
		this.diaYhora = diaYhora;
		addObservador(admin);
	}

	public boolean inscribirJugador(Participante participante) {
		if( isPartidoConfirmadoYnotificar() )
			return false;

		participantes.add(participante);
		participante.notificarAamigos();
		
		return true;
	}
	
	public void proponerJugador(Participante participante)
	{
		propuestas.add(participante);
	}
	
	public Participante analizarPropuesta()
	{
		Participante participante = propuestas.iterator().next();
		propuestas.remove(participante);
		
		return participante;
	}
	
	public void rechazarPropuesta(Participante participante)
	{
		participante.notificarRechazo();
	}
	
	public void aceptarPropuesta(Participante participante)
	{
		inscribirJugador(participante);
	}
	
	private void removeJugador(Participante participante)
	{
		jugadores.remove(participante);
	}
	
	public void darBajaJugador(Participante participante) {
		removeJugador(participante);
		participante.hacerInfraccion("Por no asistir al partido ni proponer un reemplazo");
		observadores.forEach(o -> o.notificarFaltanJugadores());
	}
	
	public void darBajaJugadorYreemplazar(Participante participante, Participante reemplazo) {
		removeJugador(participante);
		reemplazo.setModalidad(participante.modalidad);
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

package com.grupo10.juego;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.grupo10.criteriosdivisionequipos.CriterioDivision;
import com.grupo10.criteriosordenequipos.CriterioOrden;

public class Administrador implements Observador {
	public List<Participante> propuestas = new ArrayList<Participante>();
	public List<Rechazo> propuestasRechazadas = new ArrayList<Rechazo>();
	public List<String> notificaciones = new ArrayList<String>();
	private Partido partido;
	
	@Override
	public void notificarPartidoConfirmado()
	{
		notificaciones.add("El partido está confirmado");
	}
	
	@Override
	public void notificarFaltanJugadores()
	{
		notificaciones.add("Faltan Jugadores");
	}

	@Override
	public void notificarAamigos() {
		
	}

	@Override
	public void notificarRechazo(String motivo) {

	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}
	
	public void proponerJugador(Participante participante)
	{
		propuestas.add(participante);
	}
	
	public Participante analizarPropuesta()
	{
		return propuestas.iterator().next();
	}
	
	public void rechazarPropuesta(Participante participante, String motivo)
	{
		propuestas.remove(participante);
		propuestasRechazadas.add(new Rechazo(participante, motivo));
		participante.notificarRechazo(motivo);
	}
	
	public void aceptarPropuesta(Participante participante)
	{
		propuestas.remove(participante);
		partido.inscribirJugador(participante);
	}
	
	public void generarEquiposTentativos(CriterioOrden criterioOrden, CriterioDivision criterioDivision)
	{
		List<Participante> jugadoresOrdenados = partido.jugadores.stream()
			.sorted((j1,j2) -> Double.compare(criterioOrden.calcularValor(j1), criterioOrden.calcularValor(j2)))
			.collect(Collectors.toList());
		criterioDivision.dividirEquipos(jugadoresOrdenados, partido);
	}
	
	public void definirHandicap(Participante jugador, int handicap){
		jugador.handicap = handicap;
	}
}

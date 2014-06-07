package com.grupo10.juego;

import java.util.ArrayList;
import java.util.List;

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
		Participante participante = propuestas.iterator().next();
		propuestas.remove(participante);
		
		return participante;
	}
	
	public void rechazarPropuesta(Participante participante, String motivo)
	{
		propuestasRechazadas.add(new Rechazo(participante, motivo));
		participante.notificarRechazo(motivo);
	}
	
	public void aceptarPropuesta(Participante participante)
	{
		partido.inscribirJugador(participante);
	}
}

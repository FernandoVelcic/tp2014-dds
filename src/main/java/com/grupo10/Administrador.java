package com.grupo10;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Administrador implements Observador {
	public List<Participante> propuestas = new ArrayList<Participante>();
	public List<Rechazo> propuestasRechazadas = new ArrayList<Rechazo>();
	
	Notificaciones emails = new Notificaciones();
	private Partido partido;
	
	@Override
	public void notificarPartidoConfirmado()
	{
		emails.notificar("Partido confirmado");
	}
	
	@Override
	public void notificarFaltanJugadores()
	{
		emails.notificar("Faltan jugadores");
	}

	@Override
	public void notificarJuegaAmigo() {
		
	}

	@Override
	public void notificarRechazo() {

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
		participante.notificarRechazo();
	}
	
	public void aceptarPropuesta(Participante participante)
	{
		partido.inscribirJugador(participante);
	}
}
